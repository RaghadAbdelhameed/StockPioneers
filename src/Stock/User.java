package Stock;

public class User {

	private String username;
	private String password;
	private int ID;
	private double accountbalance;
	//private boolean isAdmin;
	
	public User()
	{}
	
	public User(String username , String password, int ID, double accountbalance)
	{
		this.username = username;
		this.password = password;
		this.accountbalance = accountbalance;
		this.ID = ID;
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

	
}
