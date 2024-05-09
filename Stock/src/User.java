
//package Stock;
import java.util.*;

enum gender {
	male, female
};

public abstract class User {

	protected String username;
	protected String password;
	private static int nextID = 1;
	protected int ID;
	protected double accountbalance;
	private gender gender;
	protected static List<User> Users = new ArrayList<>();
	protected static List<Stock> Stocks = new ArrayList<>();
	protected static Map<String, List<Transaction>> Transactions = new HashMap<>(); // Map to store stock orders by
																					// stock label
	protected static Map<String, List<StockPrice>> Prices = new HashMap<>(); // Map to store stock price by stock label
	private MarketPerformanceTracker marketTracker;

	public User(String username, String password, int ID, double accountbalance, gender gender) {
		this.username = username;
		this.password = password;
		this.accountbalance = accountbalance;
		this.ID = nextID++;
		this.gender = gender;
	}

	public User(String username, String password, int ID, double accountbalance, gender gender,
			MarketPerformanceTracker marketTracker) {
		this.username = username;
		this.password = password;
		this.accountbalance = accountbalance;
		this.ID = nextID++;
		this.gender = gender;
		this.marketTracker = marketTracker;
	}

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

	public int getID() {
		return ID;
	}

	public void setAccountBalance(double accountbalance) {
		this.accountbalance = accountbalance;
	}

	public double getAccountBalance() {
		return accountbalance;
	}

	public gender gender() {
		return gender;
	}

	public void setOpType(gender gender) {
		this.gender = gender;
	}

	// method to access the Users list
	public static List<User> getUsers() {
		return Users;
	}

	// method to access the stocks list
	public static List<Stock> getStocks() {
		return Stocks;
	}

	public static Map<String, List<Transaction>> getTransactions() {
		return Transactions;
	}

	public static Map<String, List<StockPrice>> getPrices() {
		return Prices;
	}

	// create a user
	public void createUser(User user) {
		if (user != null) { // user account cannot be null
			if (!Users.contains(user)) { // check thats its not already added before
				Users.add(user);
				System.out.println(" User created successfully ");
			} else {
				System.out.println(" User already exist ");
			}
		}
		System.out.println(" Invalid user provided "); // null user
	}

	// Method to retrieve the price history of a stock by its label
	public List<StockPrice> retrieveStockPriceHistory(String label) {
		return Prices.getOrDefault(label, new ArrayList<>());
	}

	// Method to display the price history of a stock by its label
	public void displayPriceHistory(String label) {
		List<StockPrice> priceHistory = retrieveStockPriceHistory(label); // calling the method with the specified label
		System.out.println(" Price history for stock with label " + label + ": ");
		for (StockPrice price : priceHistory) {
			System.out.println(price.toString()); // Assuming Price class has a toString() method
		}
	}

	// track market performance
	public void trackMarket() {
		marketTracker.calculateAggregateMarketPerformance();
	}

}
