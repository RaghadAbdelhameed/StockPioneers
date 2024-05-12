
//package Stock;
import java.util.*;
<<<<<<< HEAD
import java.util.Scanner;

public class RegularUser extends User {
		Scanner input =new Scanner(System.in);	
	   private boolean isDepositApproved;
	   private boolean isWithdrawalApproved;
	    private List<Stock> haveStocks;
	    private List<Transaction> pendingTransactions; // List to store pending deposit and withdrawal requests
	    private List<Transaction> financialTransactions;	   	   
//	    private Map<String, List<Transaction>> orderTransactions; // Map to store stock orders by stock label
	   
	    public RegularUser(String username, String password,/* double accountbalance, */gender gender){
	        super(username, password,/* accountbalance, */gender);
	        this.isDepositApproved = false; // Admin doesnot approved by default
	        this.isWithdrawalApproved = false;
	        pendingTransactions = new ArrayList<>();
	        this.haveStocks = new ArrayList<>(); // list for the stocks that User have
	        this.financialTransactions = new ArrayList<>();
//	        this.orderTransactions = new HashMap<>();
	        }
	
	    
	    
	    //financial actions
	    
	    // Method to deposit funds (pending admin approval)
	    public void deposit(double amount) { // deposit request 
	        if (amount > 0) { // to be valid
	        	Transaction depositTransaction = new Transaction(Operation.deposit, amount);
	        	pendingTransactions.add(depositTransaction);
	            System.out.println(" Deposit request submitted for approval ");
	        } else {
	            System.out.println(" Invalid deposit amount ");
	        }
	    }

	    // Method to withdraw funds (pending admin approval)
	    public void withdrawal(double amount) {
	        if (amount > 0 && amount <= accountbalance) {
	            Transaction withdrawalTransaction = new Transaction(Operation.withdrawal, amount);
	            pendingTransactions.add(withdrawalTransaction);
	            System.out.println(" Withdrawal request submitted for approval ");
	        } else {
	            System.out.println(" Invalid withdrawal amount or insufficient funds ");
	        }
	    }
	    
	    //access pending transactions( if needed )
	    public  List<Transaction> getPendingTransactions(){
	    	return pendingTransactions;
	    }
	    
	    // delete the pending transaction if its approved by admin
	    public void removePendingTransaction(Transaction transactoin)
	    {
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
	    
	    //access financialTransactions
	    public  List<Transaction> addFinancialTransactions(){
	    	return financialTransactions;
	    }
	    
	    // Order management

	    // Buy Stock Order
	    public void buyStockOrder(String label, String company, double maxPrice , int amount) {
	        // Check if the label and company are valid
	        if (label == null || label.isEmpty() || company == null || company.isEmpty() || maxPrice <= 0 || amount <= 0) {
	            System.out.println(" Invalid data ");
	            return;
	        }
	       
	        // Search for the stock existence in the market
	        Stock stockToBuy = null;
	        for (Stock stock : Stocks) {
	            if (stock.getLabel().equals(label) && stock.getCompany().equals(company)) {
	                stockToBuy = stock; // stock to buy located successfully
	                break;
	            }
	            // failed to find the stock searched for
	            System.out.println(" There's no such a stock with the provided data ");
	            return;
	        }
	        	        
	        // Check if the user has enough balance
	        if (maxPrice * amount> getAccountBalance()) {
	            System.out.println(" The requested budget exceeds your current limit! ");
	            return;
	        }

	        if(stockToBuy != null) {
	        	int stockCounter = 0;
	        	for (Stock stock : Stocks) {
	        		if(stock == stockToBuy) {
	        			stockCounter++;
	        		}
	        	}
	        	if(amount > stockCounter) {
	        		System.out.println(" This stock is not available with the required amount ");
	        		System.out.println(" The available amount of this stock = " + stockCounter);
	        		System.out.println(" Do you want to proceed with the available amount ??");
	    	    	String decision=input.nextLine();
	    	    	if(decision.equals("yes")  || decision.equals("YES")){
	    	    		amount = stockCounter;
	    	    		return;
	    	    		//buyStockOrder(label , company , maxPrice , amount);
	    	    	}
	    	    	else {
	        		return;
	    	    	}
	        	}
	        }
	        
	        
	        if (stockToBuy != null) { // if it's actually located in the Stocks list , then this was a real try to buy that stock	        	
	        	// Add transaction to Transactions map
	        	Transaction transaction = new Transaction(getID(), label, Operation.buy, amount, stockToBuy.getTradingPrice());
	        	// list real tries to buy the stock
	        	for(int i = 0; i < amount; i++){
	        		listStockOrders(label, transaction); 
	        	}
	        	
	        	if (stockToBuy.getTradingPrice() <= maxPrice) {	 // Check if the price is within the user's budget
	            	double totalPrice =  maxPrice * amount;
	            	setAccountBalance(getAccountBalance() - totalPrice);
	                haveStocks.add(stockToBuy);
	                Stocks.remove(stockToBuy);
	                System.out.println(" Stock bought successfully ");
	        	
	                // Add transaction to Transactions map
	               // Transaction transaction = new Transaction(getID(), label, Operation.buy, 1, stockToBuy.getTradingPrice());
                    listOrderTransactions(label, transaction);
	            } else {
	                System.out.println(" Stock is not available at or below the requested price ");
	                // Option to automatically execute buy order if stock is available at or below requested price
	                if (autoExecuteBuyOrder(stockToBuy, maxPrice)) {
	                    System.out.println(" Executing buy order... ");
	                    setAccountBalance(getAccountBalance() - stockToBuy.getTradingPrice());
	                    haveStocks.add(stockToBuy);	// Add the stock to the user's portfolio
	                    Stocks.remove(stockToBuy);  // Remove the bought stock from the market
	                    System.out.println(" Stock bought successfully ");
		                // Add transaction to Transactions map
	                    // Transaction transaction = new Transaction(getID(), label, Operation.buy, 1, stockToBuy.getTradingPrice());
	                    listOrderTransactions(label, transaction);
	                }
	            }
	        } else {
	            System.out.println(" No available stocks in the market ");
	        }
	    }
	    // Method to automatically execute buy order if stock is available at or below requested price
	    private boolean autoExecuteBuyOrder(Stock stock, double maxPrice) {
	        if (stock.getTradingPrice() <= maxPrice) {
	            return true;
	        }
	        return false;
	    }

	    // method to get the number of stocks in user's current portfolio
	    public int getStocksinPortfolio(){
	    	int stocksInPortfolio = haveStocks.size();
	    	return stocksInPortfolio;
	    }
	    
	    // Sell Stock Order
	    public void sellStockOrder(String label, String company, double minPrice , int amount) {
	        // Check if the label and company are valid
	        if (label == null || label.isEmpty() || company == null || company.isEmpty() || minPrice <= 0 || amount <= 0 || amount > getStocksinPortfolio()) {
	            System.out.println(" Invalid data ");
	            return;
	        }
	    	if(haveStocks.isEmpty()){
	    		System.out.println(" No stocks to be sold ");
	    		return;
	    	}
	        // Search for the stock existence in the user's stocks
	        Stock stockToSell = null;
	        for (Stock stock : haveStocks) {
	            if (stock.getLabel().equals(label) && stock.getCompany().equals(company)) {
	            	stockToSell = stock; // stock to be sold located successfully
	                break;
	            }
	            // failed to find the stock searched for
	            System.out.println(" There's no such a stock with the provided data ");
	            return;
	        }
	   
	        if (stockToSell != null) { // if it's actually located in the user's Stocks list , then this was a real try to sell that stock
                Transaction transaction = new Transaction(getID(), label, Operation.sell, amount, stockToSell.getTradingPrice());
	        	// list real tries to buy the stock
                for(int i = 0; i < amount; i++){
	        		listStockOrders(label, transaction); 
	        	}
	                if (stockToSell.getTradingPrice() >= minPrice) { // condition to sell that stock
	                	double totalPrice = stockToSell.getTradingPrice() * amount;
	                    setAccountBalance(getAccountBalance() + totalPrice);
	                    haveStocks.remove(stockToSell);
	                    Stocks.add(stockToSell); // making it available in the market again
	                    System.out.println(" Stock sold successfully ");
	                    // Add transaction to Transactions map
	                    //    Transaction transaction = new Transaction(getID(), label, Operation.sell, amount, stockToSell.getTradingPrice());
	                    listOrderTransactions(label, transaction);
	                    return;
	                
	            }
	        }
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
	    	if(!financialTransactions.isEmpty()) {
	        System.out.println(" Financial Transactions: ");
	        for (Transaction transaction : financialTransactions) {
	            System.out.println(transaction);
	        }
	    }
	        // list order actions
	    	if(!orderTransactions.isEmpty()) {
	        System.out.println("\n Order Transactions: ");
	        for (Map.Entry<String, List<Transaction>> entry : orderTransactions.entrySet()) {
	            String label = entry.getKey();
	            List<Transaction> transactions = entry.getValue();
	            for (Transaction transaction : transactions) {
	                System.out.println(/*" Label: " + label + */  /*" Transaction: " + */transaction);
	            }
	        }
	    }
	}    
	    
	    // Method to calculate overall profit/loss percentage of user's stock portfolio
	    public double calcPortfolioPerformance() {
	        List<Stock> userStocks = User.getStocks(); // each regular user has a list of stocks they own
	        double totalProfitLoss = 0.0;
	        for (Stock stock : userStocks) {
	            totalProfitLoss += stock.calculateProfitLoss();
	        }
	        return totalProfitLoss / userStocks.size();
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
=======

public class RegularUser extends User {

	private boolean isDepositApproved;
	private boolean isWithdrawalApproved;
	private List<Stock> haveStocks;
	private List<Stock> Stocks;
	private List<Transaction> pendingTransactions; // List to store pending deposit and withdrawal requests
	private List<Transaction> financialTransactions;

	private Map<String, List<Transaction>> orderTransactions; // Map to store stock orders by stock label

	public RegularUser(String username, String password, int ID, double accountbalance, gender gender) {
		super(username, password, ID, accountbalance, gender);
		this.isDepositApproved = false; // Admin doesnot approved by default
		this.isWithdrawalApproved = false;
		pendingTransactions = new ArrayList<>();
		this.haveStocks = new ArrayList<>(); // list for the stocks that User have
		this.Stocks = new ArrayList<>();
		this.financialTransactions = new ArrayList<>();
		this.orderTransactions = new HashMap<>();
	}

	// financial actions

	// Method to deposit funds (pending admin approval)
	public void deposit(double amount) { // deposit request
		if (amount > 0) { // to be valid
			Transaction depositTransaction = new Transaction(Operation.deposit, amount);
			pendingTransactions.add(depositTransaction);
			System.out.println(" Deposit request submitted for approval ");
		} else {
			System.out.println(" Invalid deposit amount ");
		}
	}

	// Method to withdraw funds (pending admin approval)
	public void withdrawal(double amount) {
		if (amount > 0 && amount <= accountbalance) {
			Transaction withdrawalTransaction = new Transaction(Operation.withdrawal, amount);
			pendingTransactions.add(withdrawalTransaction);
			System.out.println(" Withdrawal request submitted for approval ");
		} else {
			System.out.println(" Invalid withdrawal amount or insufficient funds ");
		}
	}

	// access pending transactions( if needed )
	public List<Transaction> getPendingTransactions() {
		return pendingTransactions;
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

	// access financialTransactions
	public List<Transaction> addFinancialTransactions() {
		return financialTransactions;
	}

	// Order management

	// Buy Stock Order
	public void buyStockOrder(double maxPrice, String label, String company) {
		// Check if the label and company are valid
		if (label == null || label.isEmpty() || company == null || company.isEmpty() || maxPrice <= 0) {
			System.out.println("Invalid data");
			return;
		}
		if (maxPrice > getAccountBalance()) { // check if already have the desired price in your balance
			System.out.println(" The requested price does not match with your current balance ! "); // m3ksh mylzamak4
			return;
		}
		if (!Stocks.isEmpty()) {
			Iterator<Stock> iterator = Stocks.iterator();
			while (iterator.hasNext()) {
				Stock stock = iterator.next();
				if (stock.getLabel().equals(label) && stock.getCompany().equals(company)) {
					if (stock.getTradingPrice() <= maxPrice) { // once the trading price matches with user desire price
																// , he can buy the stock
						setAccountBalance(getAccountBalance() - stock.getTradingPrice()); // adjust the new balance
						haveStocks.add(stock);
						iterator.remove(); // Remove the bought stock from the Stocks list in order not to be sellable
											// many times
						System.out.println(" Stock bought successfully ");

						// Add transaction to Transactions map
						Transaction transaction = new Transaction(getID(), label, Operation.buy, 1,
								stock.getTradingPrice());
						addTransaction(label, transaction);
						return; // Exit the loop after buying the stock
					} else {
						System.out.println(" Stock is not available at or below the requested price ");
					}
				} else {
					System.out.println(" Invalid label or company ");
				}
			}
		} else {
			System.out.println(" No available stocks in the market ");
		}
	}

	// Sell Stock Order
	public void sellStockOrder(String label, String company, double minPrice) {
		// Check if the label and company are valid
		if (label == null || label.isEmpty() || company == null || company.isEmpty()) {
			System.out.println("Invalid label or company");
			return;
		}
		if (haveStocks.isEmpty()) {
			System.out.println(" No stocks to be sold ");
			return;
		} else {
			for (Stock stock : haveStocks) { // we only can sell the stocks that we already have
				if (stock.getLabel().equals(label) && stock.getCompany().equals(company)) {
					if (stock.getTradingPrice() >= minPrice) {
						setAccountBalance(getAccountBalance() + stock.getTradingPrice());
						haveStocks.remove(stock);
						Stocks.add(stock); // making it available in the market again
						System.out.println(" Stock sold successfully ");
						// Add transaction to Transactions map
						Transaction transaction = new Transaction(getID(), label, Operation.buy, 1,
								stock.getTradingPrice());
						addTransaction(label, transaction);
						return;
					}
				}
			}
		}

	}

	// Method to add transaction to orderTransactions map
	public void addTransaction(String label, Transaction transaction) {
		List<Transaction> transactions = orderTransactions.getOrDefault(label, new ArrayList<>());
		transactions.add(transaction);
		orderTransactions.put(label, transactions);
	}

	// List financial actions (deposit and withdrawal)
	public void getFinancialTransactions() {
		System.out.println(" Deposit and Withdrawal history Transactions: ");
		for (Transaction transaction : financialTransactions) {
			System.out.println(transaction);
		}
	}

	// Method to list all user transactions
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
					System.out.println(" Label: " + label + ", Transaction: " + transaction);
				}
			}
		}
	}

	// Market Performance Tracking:

	// Method to calculate overall profit/loss percentage of user's stock portfolio
	public double calcPortfolioPerformance() {
		List<Stock> userStocks = User.getStocks(); // each regular user has a list of stocks they own
		double totalProfitLoss = 0.0;
		for (Stock stock : userStocks) {
			totalProfitLoss += stock.calcProfitLossPercentage();
		}
		return totalProfitLoss / userStocks.size();
	}

>>>>>>> 7c3d53f130befb0b8408cdebfedb468eb416c169
}
