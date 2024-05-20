public class BoughtStock {
	private int UserID;
	private String Label;
	private double Amount;

	public BoughtStock(int userID, String label, double amount) {
		this.UserID = userID;
		this.Label = label;
		this.Amount = amount;
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		this.UserID = userID;
	}

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		this.Label = label;
	}

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double d) {
		this.Amount = d;
	}

}
