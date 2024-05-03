package Stock;
import java.util.*;

enum gender  {male , female};

public abstract class User {

	protected String username;
	protected String password;
	protected int ID;
	protected double accountbalance;
	private gender gender;
	protected static List<User> Users = new ArrayList<>();
	
	public User()
	{}
	
	public User(String username , String password, int ID, double accountbalance , gender gender)
	{
		this.username = username;
		this.password = password;
		this.accountbalance = accountbalance;
		this.ID = ID;
		this.gender = gender;
	}
	
	
	public void setUserName(String username)
	{
		this.username = username;
	}
	
	public String getUserName()
	{
		return username;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setID(int ID)
	{
		this.ID = ID;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public void setAccountBalance(double accountbalance)
	{
		this.accountbalance = accountbalance;
	}
	
	public double getAccountBalance()
	{
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
	
    
	// create a user 	
	public void createUser(User user)
	{
		if(user != null){ // user account cannot be null
			if(!Users.contains(user)) { // check thats its not already added before
		Users.add(user);
		System.out.println(" User created successfully ");
		}
			else{
				System.out.println(" User already exist ");}
		}
		System.out.println(" Invalid user provided "); // null user 
		}	
	
	
}
