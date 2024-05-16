import java.util.*;
import java.time.LocalDateTime; // for price history

enum gender {male, female};
public abstract class User {

	protected String username;
	protected String password;
    private static int nextID = 0;
	protected int ID;
	protected double accountbalance;
	private gender gender;
	protected static List<User> Users;
	protected static List<Stock> Stocks = new ArrayList<>();
	//protected static List<StockPrice> stockPrices = new ArrayList<>();
	protected static Map<String, List<StockPrice>> stockPrices = new HashMap<>(); // Map to store stock price by stock label
	protected static Map<String, List<Stock>> Prices = new HashMap<>(); // Map to store stock price by stock label
	protected static Map<String, List<Transaction>> orderedTransactions = new HashMap<>(); // for real orders that user tries to make 
	protected static Map<String, List<Transaction>> orderTransactions = new HashMap<>(); // for orders that already done
	//protected static Map<String, List<Stock>> Prices = new HashMap<>(); // Map to store stock price by stock label
	private MarketPerformanceTracker marketTracker;	  
	//protected static Map<String, List<Transaction>> Transactions = new HashMap<>(); // Map to store stock orders by stock label

	
	// 3ayz azbot l klam a5li l admin y2dr y7dd l balance 
	public User(String username , String password, /*double accountbalance , */gender gender) {
		this.username = username;
		this.password = password;
		accountbalance = 0; // updated after creating an account
		this.ID = ++nextID; // self-updated on the system to make all users have a unique ID
		this.gender = gender;
		Users = new ArrayList<>();
		//this.orderedTransactions = new ArrayList<>();
		//pendingTransactions = new ArrayList<>();
		//this.financialTransactions = new ArrayList<>();
		//this.orderTransactions = new HashMap<>();
	}

//	// for admin
//	public User(String username, String password, int ID, double accountbalance, gender gender,MarketPerformanceTracker marketTracker) {
//		this.username = username;
//		this.password = password;
//		this.accountbalance = accountbalance;
//		this.ID = nextID++;
//		this.gender = gender;
//		this.marketTracker = marketTracker;
//	}
	
	public void setUserName(String username) {
		this.username = username;
	}

	public String getUserName() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setID(int ID) {
		this.ID = ID;
	}	
	public int getID()
	{
		return ID;
	}
	
	// 3ayz a5liha only allowable for the admin
	public void setAccountBalance(double accountbalance) {
		this.accountbalance = accountbalance;
	}

	public double getAccountBalance() {
		return accountbalance;
	}
	
	public gender getGender() {
		return gender;
	}

	public void setGender(gender gender) {
	        this.gender = gender;
	    }
	
	   // method to access the Users list for other classes
    public static List<User> getUsers() {
        return Users;
    }
  
  public static Map<String, List<StockPrice>> getPrices() {
    return stockPrices;
}
 
// public static Map<String, List<Transaction>> getTransactions() {
//	    return Transactions;
//	}
 
// public static Map<String, List<Stock>> getPrices() {
//	    return Prices;
//	}
 
// // method to access the stocks prices
// public static List<Stock> getPrices() {
//	 return stockPrices;
// 	}
  
// method to access the stocks prices
public static List<Stock> getStocks() {
	 return Stocks;
	}
 
	// create a user 	
	public void createUser(User user)
	{
		if(user != null){ // user account cannot be null
			if(!Users.contains(user)) { // check thats its not already added before
		Users.add(user);
		System.out.println(" User created successfully ");
		}
			else{
				System.out.println(" This User " + "( " + user.getUserName() + " ) already exist ");}
		}
		else {
		System.out.println(" Invalid user provided "); // null user 
		}	
	}
	
	
    // Method to retrieve the price history of a stock by its label
    public List<StockPrice> retrieveStockPriceHistory(String label) {
        return stockPrices.getOrDefault(label, new ArrayList<>());
    }
	
//    // Method to retrieve the price history of a stock by its label
//    public List<Stock> retrieveStockPriceHistory(String label) {
//        return Prices.getOrDefault(label, new ArrayList<>());
//    }
	
    // Method to display the price history of a stock by its label
    public void displayPriceHistory(String label) {
        List<StockPrice> priceHistory = retrieveStockPriceHistory(label); // calling the method with the specified label
        System.out.println(" Price history for stock with label " + label + ": ");
        for (StockPrice price : priceHistory) {
            System.out.println(price.toString()); // Assuming Price class has a toString() method
        }
    }
    
//    // Method to display the price history of a stock by its label
//    public void displayPriceHistory(String label) {
//        List<Stock> stockPrices = retrieveStockPriceHistory(label); // calling the method with the specified label
//        System.out.println(" Price history for stock with label " + label + ": ");
//        for (Stock price : stockPrices) {
//            System.out.println(price.toString()); // Assuming Price class has a toString() method
//        }
//    }

    // track market performance
    public static void trackMarket() {
    	double trackMarket = MarketPerformanceTracker.calculateAggregateMarketPerformance();
    	System.out.println(" Aggregate Market Performance: " + trackMarket);
    }    

}
