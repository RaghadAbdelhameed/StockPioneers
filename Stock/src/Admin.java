import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;


public class Admin extends User{ 

    private TradingManager tradingmanager; // instance from "TradingManager" class
    private static volatile Admin Instance;
    private LocalDateTime dateTime;
	
	List<RegularUser> Users = User.getUsers();
	void ReadData(){
	String[][]data=CSV.readData("Stock\\src\\csvfiles\\UserData.csv");
	for(int i=1;i<data.length;i++) {
		try {
			RegularUser user1= new RegularUser(data[i][0],data[i][1]/*,Integer.parseInt(data[i][2])
					,Double.parseDouble(data[i][3])*/,data[i][4]);
			user1.setAccountBalance(Double.parseDouble(data[i][3]));
			Users.add(user1);
		} catch (NumberFormatException e) {
			System.out.println("Error reading data from CSV file: " + e.getMessage());
		}
	}
	}

    private Admin(String username , String password)
	{
		super(username , password);
		tradingmanager = new TradingManager(); 
		}
	
	// Singleton design pattern
	public static Admin getInstance(String username , String password){
		Admin result = Instance;
		if(result == null){
		synchronized(Admin.class) {
		if(result == null){
			result = new Admin( username ,  password);
			return result;
			}		
		}
	}
		return result;
	}
	
	// Admin features	
	public void createUser(RegularUser user)
	{
		try {
		String [][]data=CSV.readData("src\\csvfiles\\UserData.csv");
		for(int i=1;i<data.length;i++) {
			try {
				RegularUser user1= new RegularUser(data[i][0],data[i][1]/*,Integer.parseInt(data[i][2])
						,Double.parseDouble(data[i][3])*/,data[i][4]);
				user1.setAccountBalance(Double.parseDouble(data[i][3]));
				Users.add(user1);
			} catch (NumberFormatException e) {
				System.out.println("Error reading data from CSV file: " + e.getMessage());
			}
		}
		if(user != null){ // user account cannot be null
			if(!checkUserExists(user.getUserName(),user.getPassword())) { // check thats its not already added before
				Users.add(user);
				CSV.writeData(Users);
		System.out.println(" User created successfully ");
			}
			else{
				System.out.println(" This User " + "( " + user.getUserName() + " ) already exist ");
				}
		}else {
		System.out.println(" Invalid user provided "); // null user 
		}	
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public static boolean checkUserExists(String userName, String password) {
        String filePath = "Stock\\src\\csvfiles\\UserData.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(userName + "," + password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
		public void deleteUser(RegularUser user,int index){		
			try {
			List<RegularUser> users = CSV.getUsers();		
				 if (user != null) {
				        	users.remove((index));
				            System.out.println(users.get(index).getUserName());
				            CSV.writeData(users);
				            System.out.println(" User deleted successfully ");			        
				    } 
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		// retrieving user is to access a specific User
		public User accessUser(int ID){
			for(User user : Users){
				if(user.getID() == ID){
					return user;
				}
			}
		return null;
		}
			
	// Updating user data
	public void updateUser(RegularUser updatedUser) { // updated user with new data to be updated
		boolean userFound = false;
		ReadData();
		for (User user : Users) {
			if (user.getID() == updatedUser.getID()) // this guarantees that user will not be updated if it has an invalid ID
			{
				user.setUserName(updatedUser.getUserName());
				user.setPassword(updatedUser.getPassword());
				CSV.writeData(Users);
				System.out.println(" User updated successfully ");
				userFound = true;
				break;
			}
		}
		System.out.println(" User with ID ( " + updatedUser.getID() + " ) not found for update ");
	}
	
	// 2- Stock Management

	// create a new stock to be traded in the market
	public void createStock(Stock stock,StockPrice stockp) {
		List<StockPrice> stockprices = CSV.getStockPrices();
    	List<Stock> stocks = CSV.getStocks();
		if (stock != null) {
			if (!stocks.contains(stock)) { // check thats its not already added before
				stocks.add(stock);
				 stockprices.add(stockp);
				CSV.writeStockHistory(stocks,stockprices);
				System.out.println(" Stock created successfully ");
				//getPrices().get(stock.getLabel()).add(stock.getTradingPrice()); // Store the price of the stock in a list

				
			} else {
				System.out.println(" Stock already exist ");
			}
		} else {
			System.out.println(" Invalid stock provided ");
		}
	}

	// // method to access the stocks prices
	 public static List<Stock> getStocks() {
		 return Stocks;
	 	}
	
		// Delete stock from market
		public void deleteStock(Stock stock,StockPrice stockprice,int index){	
			List<StockPrice> stockprices = CSV.getStockPrices();
	    	List<Stock> stocks = CSV.getStocks();
			if(stock != null){ // stock cannot be null
				//if(stocks.contains(stock)) { // check thats its not already added before
					stocks.remove(index);
					stockprices.remove(index);
					CSV.writeStockHistory(stocks,stockprices);
			System.out.println(" stock deleted successfully ");
		//	}
		//		else{
			//		System.out.println(" This Stock " + "( " + stock.getLabel() + " ) does not exist ");}
			}
			else {
			System.out.println(" Invalid Stock provided "); // null stock 
			}
		}
	
		// retrieve stocks
		public Stock accessStock(String label)
		{
			for(Stock stock : Stocks){
				if(stock.getLabel() .equals(label)){
					return stock; // return a new Stock object
				}
			}
				System.out.println(" Stock Not Found "); // unreachable code when (return stock)
				return null; // return nothing
		}
		
		
		// Method to update stock price and other details
		public void updateStock(Stock stock, double initialPrice, double openingPrice, double finalPrice,
		                        double closingPrice, double tradingPrice, double dividends,
		                        double profitPercentage) {
		    // Get the current timestamp
		    LocalDateTime dateTime = LocalDateTime.now();
		    List<StockPrice> stockprices = CSV.getStockPrices();
	    	List<Stock> stocks = CSV.getStocks();
		    // Flag to indicate if the stock is found
		    boolean stockFound = false;

		    // Iterate over the list of stocks
		    for (Stock s : stocks) {
		        if (s.getLabel().equals(stock.getLabel())) {
		            // Update the stock with the provided data and timestamp
		            s.updateStockPrice(initialPrice, openingPrice, finalPrice, closingPrice, tradingPrice,
		                               dividends, profitPercentage, dateTime);
		            // Set the flag to true
		            stockFound = true;
		            CSV.writeStockHistory(stocks,stockprices);
		            // Print a success message
		            System.out.println("Stock updated successfully.");
		            break; // No need to continue iterating
		        }
		    }
		    // If the stock is not found, print an error message
		    if (!stockFound) {
		        System.out.println("Stock not found.");
		    }
		}

		
	// stock price management

	// define a stock price
	public void addStockPrice(String label, StockPrice price){ // define the stock price using the stock label
		if (!getPrices().containsKey(label)){ // check label existence
			getPrices().put(label, new ArrayList<>()); // If the label doesn't exist in the map, create a new list for that label
		}
		getPrices().get(label).add(price); // Store the price of the stock in a list
	}

	// Approval System --> this occurs when the trading session is closed

	// Deposit approval
	public void approveDeposit(RegularUser user, double amount, Transaction transaction) {
		if (tradingmanager.isTradingSessionOpen()) { // admin can only approve or even refuse the user's requests only during the session , not after closed
			double newAccountBalance = user.getAccountBalance() + amount; // setting the new budget
			user.setAccountBalance(newAccountBalance);
			user.markDepositApproval(); // Mark the deposit request as approved     >> // just for coherence
			user.removePendingTransaction(transaction);   // the request is not pending anymore , it's approved actually , so it should be removed from the pending transactions
			user.addFinancialTransactions().add(transaction); // and now its added to the user's financial transactions list
			System.out.println(" Deposit request approved for " + user.getUserName());
			System.out.println(" " + user.getUserName() + "'s" + " Updated balance = " + user.getAccountBalance());

		} else {
			System.out.println(" Cannot approve deposit request during a trading session ");
		}
	}

	// Withdrawal approval
	public void approveWithdrawal(RegularUser user, double amount, Transaction transaction) {
		if (tradingmanager.isTradingSessionOpen()) {
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

	// Note: in this design pattern" dependency injection " we inject an instance from "TradingManager" class to the admin class , that makes the admin class doesn't know details about those methods implemented,it simply delegates those responsibilities to the TradingManager.
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
