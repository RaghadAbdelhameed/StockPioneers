import java.time.LocalDate;

public class Bond extends Security {
    private double couponRate; // Annual coupon rate
    private LocalDate maturityDate; // Date when the bond matures
    private double faceValue; // Face value of the bond

    // Constructor
    public Bond(double price, double couponRate, LocalDate maturityDate, double faceValue) {
        super(price);
        this.couponRate = couponRate;
        this.maturityDate = maturityDate;
        this.faceValue = faceValue;
    }

    // Getters and setters for additional properties
    public double getCouponRate() {
        return couponRate;
    }

    public void setCouponRate(double couponRate) {
        this.couponRate = couponRate;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(LocalDate maturityDate) {
        this.maturityDate = maturityDate;
    }

    public double getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(double faceValue) {
        this.faceValue = faceValue;
    }

    // Implementation of abstract method to get current price
    @Override
    public double getCurrentPrice() {
        return getPrice(); // For simplicity, the current price of a bond is its market price
    }

    // Implementation of abstract method to place an order
    @Override
    public void placeOrder(Transaction transaction) {
        // Implementation specific to placing orders for bonds can be added here if
        // needed
        // For example, validation of bond-specific transaction details
        System.out.println("Placing order for bond: " + transaction.toString());
    }

    // Implementation of abstract method to calculate profit percentage
    @Override
    public double calculateProfitPercentage() {
        // For bonds, profit/loss calculation may be complex and depends on various
        // factors such as current market interest rates
        // Here, we can implement a simplified version considering only the difference
        // between face value and current price
        return (getPrice() - faceValue) / faceValue * 100;
    }

}