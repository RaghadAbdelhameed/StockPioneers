import java.time.LocalDateTime;

public abstract class Security {
    private String symbol;
    private double price;
    private LocalDateTime lastUpdate;

    // Constructor
    public Security(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
        this.lastUpdate = LocalDateTime.now();
    }

    // Getters and setters
    private String label; // security label
    private String name; // security name

    Security() {

    }

    public Security(String label, String name) {
        this.label = label;
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        this.lastUpdate = LocalDateTime.now(); // Update last update time when price changes
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }
    // abstract methods to be implemented in all subclasses , each subclass has its
    // own implementation for them
    public abstract double getCurrentPrice();

    public abstract void placeOrder(Transaction transaction);

    // Abstract method to be implemented by subclasses
    public abstract double calculateProfitPercentage();
}
