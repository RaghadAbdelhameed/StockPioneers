import java.util.*;

public class RegularUser extends User {
	Scanner input = new Scanner(System.in);
	private boolean isDepositApproved;
	private boolean isWithdrawalApproved;
	private List<Transaction> pendingTransactions = CSV.getPendingTransaction(); // List to store pending deposit and
																					// withdrawal requests
	private List<Transaction> financialTransactions;
	private List<Stock> haveStocks;

	public RegularUser(String username, String password, String gender) {
		super(username, password, gender);
		this.isDepositApproved = false; // Admin doesnot approved by default
		this.isWithdrawalApproved = false;
		pendingTransactions = new ArrayList<>();
		this.haveStocks = new ArrayList<>(); // list for the stocks that User have
		this.financialTransactions = new ArrayList<>();
	}

	// for csv data
	public RegularUser(String username, String password, int id, double accountbalance, String gender) {
		super(username, password, gender);
		this.ID = id;
		this.accountbalance = accountbalance;
		this.isDepositApproved = false; // Admin doesnot approved by default
		this.isWithdrawalApproved = false;
		this.pendingTransactions = new ArrayList<>();
		this.haveStocks = new ArrayList<>(); // list for the stocks that User have
		this.financialTransactions = new ArrayList<>();
	}

	// financial actions
	public void deposit(double amount) {
		if (amount > 0) {
			pendingTransactions = CSV.getPendingTransaction();
			Transaction depositTransaction = new Transaction(this.ID, amount, Operation.deposit);
			pendingTransactions.add(depositTransaction);
			System.out.println("Deposit request submitted for approval.");
			CSV.writePendingTransactions(pendingTransactions);
			// wait for transaction to be approved
			while (!this.isDepositApproved) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// update the user's account balance
			this.accountbalance += amount;
			// update the Users list
			int index = Users.indexOf(this);
			Users.set(index, this);
			// write the updated Users list to the CSV file
			CSV.writeData(Users);
			System.out.println("Deposit successful. New balance: " + this.accountbalance);
		} else {
			System.out.println("Invalid deposit amount.");
		}
	}

	// Method to withdraw funds (pending admin approval)
	public void withdrawal(double amount) {
		if (amount > 0 && amount <= accountbalance) {
			pendingTransactions = CSV.getPendingTransaction();
			Transaction withdrawalTransaction = new Transaction(getID(), amount, Operation.withdrawal);
			pendingTransactions.add(withdrawalTransaction);
			CSV.writePendingTransactions(pendingTransactions);
			System.out.println(" Withdrawal request submitted for approval ");
		} else {
			System.out.println(" Invalid withdrawal amount or insufficient funds ");
		}
	}

	// access pending transactions( if needed )
	public List<Transaction> getPendingTransactions() {
		return pendingTransactions;
	}

	// access financialTransactions
	public List<Transaction> addFinancialTransactions() {
		return financialTransactions;
	}

	// delete the pending transaction if its approved by admin
	public void removePendingTransaction(Transaction transactoin) {
		pendingTransactions.remove(transactoin);
	}

	// Method to mark the deposit request as approved
	public void markDepositApproval() {
		this.isDepositApproved = true;
	}

	// Method to mark the withdrawal request as approved
	public void markWithdrawalApproval() {
		this.isWithdrawalApproved = true;
	}

	public boolean getDepositApproved() {
		return isDepositApproved;
	}

	public boolean getWithdrawalApproved() {
		return isWithdrawalApproved;
	}
	// Order Managment

	public void buyStockOrder(String label, String company, double maxPrice, int amount, int index) {
		List<Stock> stocks = CSV.getStocks();
		List<RegularUser> users = CSV.getUsers();
		List<StockPrice> stockprices = CSV.getStockPrices();
		List<Transaction> transactions = CSV.getTransactionHistory();
		List<BoughtStock> boughtstocks = CSV.getHaveStocks();
		if (amount <= stocks.get(index).getAvailableStocks()) {
			if (users.get(zUserController.index).accountbalance >= amount * maxPrice) {
				BoughtStock existingStock = null;
				for (BoughtStock stock : boughtstocks) {
					if (stock.getLabel().equals(label) && stock.getUserID() == ID) {
						existingStock = stock;
						break;
					}
				}
				if (existingStock != null) {
					// If the user has already bought a stock with the same label, update the amount
					existingStock.setAmount(existingStock.getAmount() + amount);
					users.get(zUserController.index)
							.setAccountBalance(users.get(zUserController.index).accountbalance - amount * maxPrice);
					transactions.add(new Transaction(ID, label, Operation.buy, amount, amount * maxPrice));
				} else {
					// If the user hasn't bought a stock with the same label, create a new
					// BoughtStock object
					BoughtStock stock = new BoughtStock(ID, label, amount);
					users.get(zUserController.index)
							.setAccountBalance(users.get(zUserController.index).accountbalance - amount * maxPrice);
					boughtstocks.add(stock);
					transactions.add(new Transaction(ID, label, Operation.buy, amount, amount * maxPrice));
					// System.out.println(existingStock.getAmount());
				}
				stocks.get(index).setAvailableStocks(stocks.get(index).getAvailableStocks() - amount);
				CSV.writeStockHistory(stocks, stockprices);
				CSV.writeHaveStocks(boughtstocks);
				CSV.writeTransactionHistory(transactions);
				CSV.writeData(users);
				zOrderManageController.bought = true;
			}
		}
	}

	public void sellStockOrder(String label, String company, double maxPrice, int amount, int index) {
		List<Stock> stocks = CSV.getStocks();
		List<RegularUser> users = CSV.getUsers();
		List<StockPrice> stockprices = CSV.getStockPrices();
		List<Transaction> transactions = CSV.getTransactionHistory();
		List<BoughtStock> boughtstocks = CSV.getHaveStocks();
		if (amount <= stocks.get(index).getAvailableStocks()) {
			BoughtStock existingStock = null;
			for (BoughtStock stock : boughtstocks) {
				if (stock.getLabel().equals(label) && stock.getUserID() == ID) {
					existingStock = stock;
					break;
				}
			}
			if (existingStock != null && existingStock.getAmount() >= amount) {
				// If the user has already bought a stock with the same label and has enough
				// shares to sell, update the amount
				existingStock.setAmount(existingStock.getAmount() - amount);
				users.get(zUserController.index)
						.setAccountBalance(users.get(zUserController.index).accountbalance + amount * maxPrice);
				transactions.add(new Transaction(ID, label, Operation.sell, amount, amount * maxPrice));
				stocks.get(index).setAvailableStocks(stocks.get(index).getAvailableStocks() + amount);
				CSV.writeStockHistory(stocks, stockprices);
				CSV.writeHaveStocks(boughtstocks);
				CSV.writeTransactionHistory(transactions);
				CSV.writeData(users);
			} else {
				// If the user doesn't have enough shares to sell, do nothing
				System.out.println("You don't have enough shares to sell.");
			}

		} else {
			// If the user tries to sell more shares than they have, do nothing
			System.out.println("You don't have enough shares to sell.");
		}
	}

	// method to get the number of stocks in user's current portfolio
	public int getStocksinPortfolio() {
		int stocksInPortfolio = haveStocks.size();
		return stocksInPortfolio;
	}

	// Method to add transaction to orderTransactions map
	public void listOrderTransactions(String label, Transaction transaction) {
		List<Transaction> transactions = orderTransactions.getOrDefault(label, new ArrayList<>());
		transactions.add(transaction);
		orderTransactions.put(label, transactions);
	}

	// Method to list all real stock orders tried by user
	public void listStockOrders(String label, Transaction transaction) {
		List<Transaction> stockOrders = orderedTransactions.getOrDefault(label, new ArrayList<>());
		stockOrders.add(transaction);
		orderedTransactions.put(label, stockOrders);
	}

	// List financial actions (deposit and withdrawal)
	public void getFinancialTransactions() {
		System.out.println(" Deposit and Withdrawal history Transactions: ");
		for (Transaction transaction : financialTransactions) {
			System.out.println(transaction);
		}
	}

	// Method to list all user done transactions
	public void listAllTransactions() {
		// list financial actions
		if (!financialTransactions.isEmpty()) {
			System.out.println(" Financial Transactions: ");
			for (Transaction transaction : financialTransactions) {
				System.out.println(transaction);
			}
		}
		// list order actions
		if (!orderTransactions.isEmpty()) {
			System.out.println("\n Order Transactions: ");
			for (Map.Entry<String, List<Transaction>> entry : orderTransactions.entrySet()) {
				String label = entry.getKey();
				List<Transaction> transactions = entry.getValue();
				for (Transaction transaction : transactions) {
					System.out.println(transaction);
				}
			}
		}
	}

	// Method to calculate overall profit/loss percentage of user's stock portfolio
	public double calcPortfolioPerformance() {
		double totalProfitLoss = 0.0;
		for (Stock stock : haveStocks) {
			totalProfitLoss += stock.calculateProfitPercentage();
		}
		return totalProfitLoss / haveStocks.size();
	}

}
