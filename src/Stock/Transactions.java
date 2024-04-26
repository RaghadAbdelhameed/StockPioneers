package Stock;
import java.time.LocalDateTime; // for transaction date

enum Operation{sell , buy}; // transaction type

public class Transactions {
	private int userID;
	private String stockLabel;
	private Operation opType;
	private int quantity;
	private double price;
	private LocalDateTime time; // record transaction time
	
    public Transactions(int userID, String stockLabel, Operation opType, int quantity, double price) {
        this.userID = userID;
        this.stockLabel = stockLabel;
        this.opType = opType;
        this.quantity = quantity;
        this.price = price;
        this.time = LocalDateTime.now(); // Set current timing
    }
	
	
    public int getUserId() {
        return userID;
    }

    public void setUserId(int userID) {
        this.userID = userID;
    }

    public String getStockLabel() {
        return stockLabel;
    }

    public void setStockLabel(String stockLabel) {
        this.stockLabel = stockLabel;
    }

    public Operation getOpType() {
        return opType;
    }

    public void setOpType(Operation opType) {
        this.opType = opType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    
    
}
