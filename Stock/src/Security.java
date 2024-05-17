import java.time.LocalDateTime;

public abstract class Security {
    private double price;
    private LocalDateTime lastUpdate;

    // Constructor
    public Security( double price) {
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