package Stock;
import java.util.*;

public class Admin extends User{

	private List<User> Users;
	private List<Stock> Stocks; 

	
	Admin(String username , String password, int id, double accountbalance,boolean isAdmin)
	{
		super(username , password, id ,accountbalance);
		this.Users = new ArrayList<>();
		this.Stocks = new ArrayList<>();
	}
	
	// Admin features
	
	// 1- User Managment
	
		// create a user 
	// when the user want to create an account, The admin does that for him
		public void createUser(User user)
		{
			if(user != null){
				if(!Users.contains(user)) { // check thats its not already added before
			Users.add(user);
			System.out.println(" User created successfully ");
			}
				else{
					System.out.println(" User already exist ");}
			}
			System.out.println(" Invalid user provided ");}
		
		// Deleting User ( not preferred method ) 
		/*
		public void deleteUser(User user) // this method works but not for program optimization
		{
			Users.remove(user);
		}****/
		
		// Deleting User
		public void deleteUser(int ID) // to delete a user , its enough to take his ID not a complete User object that will not benefits us
		{
	        Users.removeIf(user -> user.getID() == ID);
		}
	
		// retrieving user is to access a specific User
		public User accessUser(int ID)
		{
			for(User user : Users){
				if(user.getID() == ID){
					return user; // return a new User object
				}
			}
				System.out.println(" User Not Found ");
				return null; // return nothing
		}
			
		// Updating user data
		public void updateUser(User updatedUser) { // updated user with new data to be updated 
			boolean userFound = false;
			for(User user : Users)
			{
				if(user.getID() == updatedUser.getID()) // this guarantees that user will not be updated if it has an invalid ID
				{
					user.setUserName(updatedUser.getUserName());
					user.setPassword(updatedUser.getPassword());
					user.setAccountBalance(updatedUser.getAccountBalance());
					System.out.println(" Stock updated successfully ");
					userFound = true;
					break;
				}	
			}
			System.out.println(" User with ID " + updatedUser.getID() + " not found for update ");
		}
		
		
		// 2- Stock Management
		
		// create stock
		public void createStock(Stock stock)
		{
			if(stock != null){
				if(!Stocks.contains(stock)) { // check thats its not already added before
			Stocks.add(stock);
			System.out.println(" Stock created successfully ");
			}
				else{
					System.out.println(" Stock already exist ");}
			}
			System.out.println(" Invalid stock provided ");}
		
		
		// Delete stock
		public void deleteStock(String label) // to delete a stock , its enough to take its label not a complete Stock object that will not benefits us
		{
	        Stocks.removeIf(stock -> stock.getLabel() .equals(label)); // when comparing strings we don't use (==) operator
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
		
		
		// Updating Stock data
		public void updateStock(Stock updatedStock) { // updatedStock with new data to be updated 
			boolean stockFound = false;
			for(Stock stock : Stocks)
			{
				if(stock.getLabel() .equals(updatedStock.getLabel())) // this guarantees that stock will not be updated if it has an invalid Label
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
		
		
}
