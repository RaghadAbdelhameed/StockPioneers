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

	// Order management

	// Buy Stock Order
	/*
	 * public void buyStockOrder(String label, String company, double maxPrice, int
	 * amount) {
	 * 
	 * 
	 * // Check if the label and company are valid
	 * if (label == null || label.isEmpty() || company == null || company.isEmpty()
	 * || maxPrice <= 0 || amount <= 0) {
	 * System.out.println(" Invalid data ");
	 * return;
	 * }
	 * // Search for the stock existence in the market
	 * Stock stockToBuy = null;
	 * for (Stock stock : Stocks) {
	 * if (stock.getLabel().equals(label) && stock.getCompany().equals(company)) {
	 * stockToBuy = stock; // stock to buy located successfully
	 * break;
	 * }
	 * // failed to find the stock searched for
	 * System.out.println(" There's no such a stock with the provided data ");
	 * return;
	 * }
	 * // Check if the user has enough balance
	 * if (maxPrice * amount > getAccountBalance()) {
	 * System.out.println(" The requested budget exceeds your current limit! ");
	 * return;
	 * }
	 * if (stockToBuy != null) {
	 * int stockCounter = 0;
	 * for (Stock stock : Stocks) {
	 * if (stock == stockToBuy) {
	 * stockCounter++;
	 * }
	 * }
	 * if (amount > stockCounter) {
	 * System.out.
	 * println(" Sorry, This stock is not available with the required amount ");
	 * System.out.println(" The available amount of this stock = " + stockCounter);
	 * System.out.println(" Do you want to proceed with the available amount ??");
	 * String decision = input.nextLine(); // exception handling needed
	 * if (decision.equals("yes") || decision.equals("YES")) {
	 * amount = stockCounter;
	 * } else {
	 * return;
	 * }
	 * }
	 * }
	 * if (stockToBuy != null) { // if it's actually located in the Stocks list ,
	 * then this was a real try to buy
	 * // that stock
	 * // Add transaction to Transactions map
	 * Transaction transaction = new Transaction(getID(), label, Operation.buy,
	 * amount,
	 * stockToBuy.getTradingPrice());
	 * // list real tries to buy the stock
	 * for (int i = 0; i < amount; i++) {
	 * listStockOrders(label, transaction);
	 * }
	 * 
	 * if (stockToBuy.getTradingPrice() <= maxPrice) { // Check if the price is
	 * within the user's budget
	 * double totalPrice = maxPrice * amount;
	 * setAccountBalance(getAccountBalance() - totalPrice);
	 * haveStocks.add(stockToBuy);
	 * 
	 * // updating the available stocks in the market
	 * stockToBuy.setAvailableStocks(stockToBuy.getAvailableStocks() - amount);
	 * if(stockToBuy.getAvailableStocks() == 0)
	 * {
	 * Stocks.remove(stockToBuy);
	 * }
	 * System.out.println(" Stock bought successfully ");
	 * // Update stock price history
	 * LocalDateTime currentTime = LocalDateTime.now();
	 * stockToBuy.updateStockPrice(maxPrice, maxPrice, maxPrice, maxPrice, 0.0, 0.0,
	 * 0.0, currentTime);
	 * // Add transaction to Transactions map
	 * // Transaction transaction = new Transaction(getID(), label, Operation.buy,
	 * 1,
	 * // stockToBuy.getTradingPrice());
	 * listOrderTransactions(label, transaction);
	 * } else {
	 * System.out.println(" Stock is not available at or below the requested price "
	 * );
	 * // Option to automatically execute buy order if stock is available at or
	 * below
	 * // requested price
	 * if (autoExecuteBuyOrder(stockToBuy, maxPrice)) {
	 * System.out.println(" Executing buy order... ");
	 * setAccountBalance(getAccountBalance() - stockToBuy.getTradingPrice());
	 * // updating the available stocks in the market
	 * stockToBuy.setAvailableStocks(stockToBuy.getAvailableStocks() - amount);
	 * haveStocks.add(stockToBuy); // Add the stock to the user's portfolio
	 * Stocks.remove(stockToBuy); // Remove the bought stock from the market
	 * System.out.println(" Stock bought successfully ");
	 * // Update stock price history
	 * LocalDateTime currentTime = LocalDateTime.now();
	 * stockToBuy.updateStockPrice(maxPrice, maxPrice, maxPrice, maxPrice, 0.0, 0.0,
	 * 0.0, currentTime);
	 * // Add transaction to Transactions map
	 * // Transaction transaction = new Transaction(getID(), label, Operation.buy,
	 * 1,
	 * // stockToBuy.getTradingPrice());
	 * listOrderTransactions(label, transaction);
	 * }
	 * }
	 * } else {
	 * System.out.println(" No available stocks in the market ");
	 * }
	 * }
	 *//*
		 * public void buyStockOrder(String label, String company, double maxPrice, int
		 * amount,int index) {
		 * List<Stock> stocks=CSV.getStocks();
		 * List<RegularUser>users=CSV.getUsers();
		 * List<StockPrice>stockprices=CSV.getStockPrices();
		 * List<Transaction>transactions=CSV.getTransactionHistory();
		 * List<BoughtStock> boughtstocks=CSV.getHaveStocks();
		 * if(amount<=stocks.get(index).getAvailableStocks()) {
		 * if(users.get(zUserController.index).accountbalance>=amount*maxPrice) {
		 * if(boughtstocks.get)
		 * BoughtStock stock= new BoughtStock(ID,label,amount);
		 * Transaction transaction= new
		 * Transaction(ID,label,Operation.buy,amount,amount*maxPrice);
		 * users.get(zUserController.index).setAccountBalance(accountbalance-amount*
		 * maxPrice);
		 * boughtstocks.add(stock);
		 * stocks.get(index).setAvailableStocks(stocks.get(index).getAvailableStocks()-
		 * amount);
		 * transactions.add(transaction);
		 * CSV.writeStockHistory(stocks, stockprices);
		 * CSV.writeHaveStocks(boughtstocks);
		 * CSV.writeTransactionHistory(transactions);
		 * CSV.writeData(users);
		 * zOrderManageController.availableStocks.setText(String.valueOf(stocks.get(
		 * index).getAvailableStocks()));
		 * 
		 * }
		 * else
		 * System.out.println("not possible");
		 * }
		 * else
		 * System.out.println("not avaliable this amount");
		 * }
		 */
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

	/*
	 * public void buyStockOrder(String label, String company, double maxPrice, int
	 * amount, int index) {
	 * List<Stock> stocks = CSV.getStocks();
	 * List<RegularUser> users = CSV.getUsers();
	 * List<StockPrice> stockprices = CSV.getStockPrices();
	 * List<Transaction> transactions = CSV.getTransactionHistory();
	 * Map<String, BoughtStock> boughtstocks = new HashMap<>();
	 * 
	 * // Convert the list of BoughtStock objects to a Map for faster lookups
	 * for (BoughtStock stock : CSV.getHaveStocks()) {
	 * boughtstocks.put(stock.getLabel() + "-" + stock.getUserID(), stock);
	 * }
	 * if (amount <= stocks.get(index).getAvailableStocks()) {
	 * if (users.get(zUserController.index).accountbalance >= amount * maxPrice) {
	 * BoughtStock existingStock = boughtstocks.get(label + "-" +
	 * zUserController.index);
	 * if (existingStock != null) {
	 * // If the user has already bought a stock with the same label, update the
	 * amount
	 * existingStock.setAmount(existingStock.getAmount() + amount);
	 * users.get(zUserController.index).setAccountBalance(users.get(zUserController.
	 * index).accountbalance - amount * maxPrice);
	 * transactions.add(new Transaction(ID, label, Operation.buy, amount, amount *
	 * maxPrice));
	 * } else {
	 * // If the user hasn't bought a stock with the same label, create a new
	 * BoughtStock object
	 * BoughtStock stock = new BoughtStock(ID, label, amount);
	 * users.get(zUserController.index).setAccountBalance(users.get(zUserController.
	 * index).accountbalance - amount * maxPrice);
	 * boughtstocks.put(label + "-" + zUserController.index, stock);
	 * transactions.add(new Transaction(ID, label, Operation.buy, amount, amount *
	 * maxPrice));
	 * }
	 * 
	 * stocks.get(index).setAvailableStocks(stocks.get(index).getAvailableStocks() -
	 * amount);
	 * CSV.writeStockHistory(stocks, stockprices);
	 * CSV.writeHaveStocks(new ArrayList<>(boughtstocks.values()));
	 * CSV.writeTransactionHistory(transactions);
	 * CSV.writeData(users);
	 * zOrderManageController.availableStocks.setText(String.valueOf(stocks.get(
	 * index).getAvailableStocks()));
	 * }
	 * }
	 * }
	 */
	// Method to automatically execute buy order if stock is available at or below
	// requested price
	private boolean autoExecuteBuyOrder(Stock stock, double maxPrice) {
		if (stock.getTradingPrice() <= maxPrice) {
			return true;
		}
		return false;
	}

	// method to get the number of stocks in user's current portfolio
	public int getStocksinPortfolio() {
		int stocksInPortfolio = haveStocks.size();
		return stocksInPortfolio;
	}

	// Sell Stock Order
	/*
	 * public void sellStockOrder(String label, String company, double minPrice, int
	 * amount) {
	 * // Check if the label and company are valid
	 * if (label == null || label.isEmpty() || company == null || company.isEmpty()
	 * || minPrice <= 0 || amount <= 0
	 * || amount > getStocksinPortfolio()) {
	 * System.out.println(" Invalid data ");
	 * return;
	 * }
	 * if (haveStocks.isEmpty()) {
	 * System.out.println(" No stocks to be sold ");
	 * return;
	 * }
	 * // Search for the stock existence in the user's stocks
	 * Stock stockToSell = null;
	 * for (Stock stock : haveStocks) {
	 * if (stock.getLabel().equals(label) && stock.getCompany().equals(company)) {
	 * stockToSell = stock; // stock to be sold located successfully
	 * break;
	 * }
	 * // failed to find the stock searched for
	 * System.out.println(" There's no such a stock with the provided data ");
	 * return;
	 * }
	 * if (stockToSell != null) { // if it's actually located in the user's Stocks
	 * list , then this was a real try
	 * // to sell that stock
	 * Transaction transaction = new Transaction(getID(), label, Operation.sell,
	 * amount,
	 * stockToSell.getTradingPrice());
	 * // list real tries to buy the stock
	 * for (int i = 0; i < amount; i++) {
	 * listStockOrders(label, transaction);
	 * }
	 * if (stockToSell.getTradingPrice() >= minPrice) { // condition to sell that
	 * stock
	 * double totalPrice = stockToSell.getTradingPrice() * amount;
	 * setAccountBalance(getAccountBalance() + totalPrice);
	 * // updating the available stocks in the market
	 * stockToSell.setAvailableStocks(stockToSell.getAvailableStocks() - amount);
	 * haveStocks.remove(stockToSell);
	 * Stocks.add(stockToSell); // making it available in the market again
	 * System.out.println(" Stock sold successfully ");
	 * // Update stock price history
	 * LocalDateTime currentTime = LocalDateTime.now();
	 * stockToSell.updateStockPrice(minPrice, minPrice, minPrice, minPrice, 0.0,
	 * 0.0, 0.0, currentTime);
	 * // Add transaction to Transactions map
	 * // Transaction transaction = new Transaction(getID(), label, Operation.sell,
	 * // amount, stockToSell.getTradingPrice());
	 * listOrderTransactions(label, transaction);
	 * return;
	 * 
	 * }
	 * }
	 * }
	 */
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
