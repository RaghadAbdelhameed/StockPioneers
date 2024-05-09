
//package Stock;
import java.util.*;

public class Admin extends User {

	List<User> Users = User.getUsers();
	// private List<User> Users;
	// private List<Stock> Stocks;
	// private Map<String, List<Transaction>> Transactions; // Map to store stock
	// orders by stock label
	// private Map<String, List<StockPrice>> Prices; // Map to store stock price by
	// stock label
	private TradingManager tradingmanager; // instance from "TradingManager" class

	Admin(String username, String password, int id, double accountbalance, gender gender,
			TradingManager tradingmanager) {
		super(username, password, id, accountbalance, gender);
		// this.Users = new ArrayList<>();
		// this.Stocks = new ArrayList<>();
		// this.Transactions = new HashMap<>();
		// this.Prices = new HashMap<>();
		this.tradingmanager = tradingmanager; // unary association admin -> TM
	}

	// Admin features

	// Deleting User
	public void deleteUser(int ID) // to delete a user , its enough to take his ID not a complete User object that
									// will not benefits us
	{
		Users.removeIf(user -> user.getID() == ID);
	}

	// retrieving user is to access a specific User
	public User accessUser(int ID) {
		for (User user : Users) {
			if (user.getID() == ID) {
				return user; // return a new User object
			}
		}
		System.out.println(" User Not Found ");
		return null; // return nothing
	}

	// Updating user data
	public void updateUser(User updatedUser) { // updated user with new data to be updated
		boolean userFound = false;
		for (User user : Users) {
			if (user.getID() == updatedUser.getID()) // this guarantees that user will not be updated if it has an
														// invalid ID
			{
				user.setUserName(updatedUser.getUserName());
				// user.setPassword(updatedUser.getPassword()); illegal due to user privacy
				user.setAccountBalance(updatedUser.getAccountBalance());
				System.out.println(" User updated successfully ");
				userFound = true;
				break;
			}
		}
		System.out.println(" User with ID ( " + updatedUser.getID() + " ) not found for update ");
	}

	// 2- Stock Management

	// create stock to be traded in the market
	public void createStock(Stock stock) {
		if (stock != null) {
			if (!Stocks.contains(stock)) { // check thats its not already added before
				Stocks.add(stock);
				System.out.println(" Stock created successfully ");
			} else {
				System.out.println(" Stock already exist ");
			}
		} else {
			System.out.println(" Invalid stock provided ");
		}
	}

	// Delete stock
	public void deleteStock(String label) // to delete a stock , its enough to take its label not a complete Stock
											// object that will not benefits us
	{
		Stocks.removeIf(stock -> stock.getLabel().equals(label)); // when comparing strings we don't use (==) operator
	}

	// retrieve stocks
	public Stock accessStock(String label) {
		for (Stock stock : Stocks) {
			if (stock.getLabel().equals(label)) {
				return stock; // return a new Stock object
			}
		}
		System.out.println(" Stock Not Found "); // unreachable code when (return stock)
		return null; // return nothing
	}

	// Updating Stock data
	public void updateStock(Stock updatedStock) { // updatedStock with new data to be updated
		boolean stockFound = false;
		for (Stock stock : Stocks) {
			if (stock.getLabel().equals(updatedStock.getLabel())) // this guarantees that stock will not be updated if
																	// it has an invalid Label
			{
				stock.setCompany(updatedStock.getCompany());
				stock.setInitialPrice(updatedStock.getInitialPrice());
				stock.setTradingPrice(updatedStock.getTradingPrice());
				stock.setDividends(updatedStock.getDividends());
				stock.setAvailableStocks(updatedStock.getAvailableStocks());
				stock.setProfitPercentage(updatedStock.getProfitPercentage());
				System.out.println(" Stock updated successfully ");
				stockFound = true;
				break;
			}
		}
		System.out.println(" Stock with label " + updatedStock.getLabel() + " not found for update ");
	}

	// stock listed by label
	public void listByLabel(String label) // admin can search for a specific label for monitoring the market
	{
		if (Transactions.containsKey(label)) {
			System.out.println(" Stock orders with label: " + label + " ");
			for (Transaction transaction : Transactions.get(label)) {
				System.out.println(transaction.toString());
			}
		} else {
			System.out.println(label + " not found in stock order list ");
		}
	}

	// stock price management

	// add prices for each stock
	public void addStockPrice(String label, StockPrice price) // define the stock price using the stock label
	{
		if (!getPrices().containsKey(label)) // check label existence
		{
			// If the label doesn't exist in the map, create a new list for that label
			getPrices().put(label, new ArrayList<>());
		}
		// Store the price of the stock in a list
		getPrices().get(label).add(price);
	}

	// Approval System --> this occurs when the trading session is closed

	// Deposit approval
	public void approveDeposit(RegularUser user, double amount, Transaction transaction) {
		if (!tradingmanager.isTradingSessionOpen()) {
			double newAccountBalance = user.getAccountBalance() + amount;
			user.setAccountBalance(newAccountBalance);
			user.markDepositApproval(); // Mark the deposit request as approved
			user.removePendingTransaction(transaction);
			user.addFinancialTransactions().add(transaction);
			System.out.println(" Deposit request approved for " + user.getUserName());
			System.out.println(" " + user.getUserName() + "'s" + " Updated balance = " + user.getAccountBalance());

		} else {
			System.out.println(" Cannot approve deposit request during a trading session ");
		}
	}

	// Withdrawal approval
	public void approveWithdrawal(RegularUser user, double amount, Transaction transaction) {
		if (!tradingmanager.isTradingSessionOpen()) {
			double newAccountBalance = user.getAccountBalance() - amount;
			user.setAccountBalance(newAccountBalance);
			user.markWithdrawalApproval(); // Mark the deposit request as approved
			user.removePendingTransaction(transaction);
			user.addFinancialTransactions().add(transaction);
			System.out.println(" withdrawal request approved for " + user.getUserName());
			System.out.println(" " + user.getUserName() + "'s" + " Updated balance = " + user.getAccountBalance());
		} else {
			System.out.println(" Cannot approve withdrawal request during a trading session ");
		}
	}

	// Trading sessions management

	// Note: in this design pattern" dependency injection " we inject an instance
	// from "TradingManager" class to the admin class , that makes the admin class
	// doesn't know details about those methods implemented,it simply delegates
	// those responsibilities to the TradingManager.
	// this is for more flexibility

	// opening trading session
	public void initiateTradingSession() {
		tradingmanager.openTradingSession();
	}

	// close trading session
	public void closeTradingSession() {
		tradingmanager.closeTradingSession();
	}

	// check if trading session is open
	public boolean isTradingSessionOpen() {
		return tradingmanager.isTradingSessionOpen();
	}

}
