import java.time.LocalDateTime; // for transaction date
import java.time.format.DateTimeFormatter;

enum Operation {
	sell, buy, deposit, withdrawal
}; // transaction type

public class Transaction {
	private static int nextId = 0; // Static variable to generate unique transaction IDs
	private int transactionId; // each transaction has a specific id
	private int userID;
	private String stockLabel;
	private Operation opType;
	private double amount;
	private double price;
	private LocalDateTime Transactiontime; // record transaction time

	Transaction(int transactionId, int userID, String stockLabel, Operation opType, double amount, double price,
			LocalDateTime Transactiontime) {
		this.transactionId = transactionId;
		this.userID = userID;
		this.stockLabel = stockLabel;
		this.opType = opType;
		this.amount = amount;
		this.price = price;
		this.Transactiontime = Transactiontime; // Set current timing
	}

	Transaction(int userID, String stockLabel, Operation opType, double amount, double price) {
		this.userID = userID;
		this.stockLabel = stockLabel;
		this.opType = opType;
		this.amount = amount;
		this.price = price;
		this.transactionId = nextId++;
		this.Transactiontime = LocalDateTime.now(); // Set current timing
	}

	Transaction(int userID, Operation opType, double price) {
		this.userID = userID;
		this.opType = opType;
		this.price = price;
		this.transactionId = nextId++;
		this.Transactiontime = LocalDateTime.now(); // Set current timing
	}

	public Transaction(Operation opType, double amount) {
		this.opType = opType;
		this.amount = amount;
		this.transactionId = nextId++;
		this.Transactiontime = LocalDateTime.now(); // Set current timing
	}

	Transaction(int transactionId, Operation opType, double amount, LocalDateTime Transactiontime) {
		this.transactionId = transactionId;
		this.opType = opType;
		this.amount = amount;
		this.Transactiontime = Transactiontime; // Set current timing
	}

	public int getUserId() {
		return userID;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setUserId(int userID) {
		this.userID = userID;
	}

	public String getLabel() {
		return stockLabel;
	}

	public void setLabel(String stockLabel) {
		this.stockLabel = stockLabel;
	}

	public Operation getOpType() {
		return opType;
	}

	public void setOpType(Operation opType) {
		this.opType = opType;
	}

	public double getAmount() {
		return amount;
	}

	public void setQuantity(double amount) {
		this.amount = amount;
	}

	public String getTransactionTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS");
		String formattedDateTime = Transactiontime.format(formatter);
		return formattedDateTime;
	}

	public void setTransactionTime(LocalDateTime Transactiontime) {
		this.Transactiontime = Transactiontime;
	}

	public double getPrice() { // retrieve stock price
		return price;
	}

	public void setPrice(double price) { // set stock price
		this.price = price;
	}

	public void displayTransactionHistory() {

	}

	// Override toString method for printing transaction details
	@Override
	public String toString() {
		String operation = opType == Operation.deposit ? "Deposit"
				: opType == Operation.withdrawal ? "Withdrawal"
						: opType == Operation.buy ? "Buy" : opType == Operation.sell ? "Sell" : "Unknown";

		return " Transaction { " + "transactionId = " + transactionId + ", Transactiontime = " + Transactiontime
				+ ", type = " + operation + ", amount = " + amount + ", userID = '" + userID + '\''
				+ (opType == Operation.buy || opType == Operation.sell
						? ", stockLabel = '" + stockLabel + '\'' + ", amount = " + amount
						: "")
				+ " }";
	}

}
