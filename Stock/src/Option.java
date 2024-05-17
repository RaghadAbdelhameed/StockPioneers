import java.time.LocalDate;

public class Option extends Security {
    public enum OptionType {
        CALL, PUT
    }

    private OptionType optionType;
    private double strikePrice;
    private LocalDate expirationDate;
    private String underlyingAssetSymbol;

    // Constructor
    public Option(double price, OptionType optionType, double strikePrice, LocalDate expirationDate, String underlyingAssetSymbol) {
        super(price);
        this.optionType = optionType;
        this.strikePrice = strikePrice;
        this.expirationDate = expirationDate;
        this.underlyingAssetSymbol = underlyingAssetSymbol;
    }

    // Getters and setters
    public OptionType getOptionType() {
        return optionType;
    }

    public void setOptionType(OptionType optionType) {
        this.optionType = optionType;
    }

    public double getStrikePrice() {
        return strikePrice;
    }

    public void setStrikePrice(double strikePrice) {
        this.strikePrice = strikePrice;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getUnderlyingAssetSymbol() {
        return underlyingAssetSymbol;
    }

    public void setUnderlyingAssetSymbol(String underlyingAssetSymbol) {
        this.underlyingAssetSymbol = underlyingAssetSymbol;
    }

    // Implementation of abstract method to get current price
    @Override
    public double getCurrentPrice() {
        return getPrice(); // For simplicity, the current price of an option is its market price
    }

    // Implementation of abstract method to place an order
    @Override
    public void placeOrder(Transaction transaction) {
        // Implementation specific to placing orders for options can be added here if needed
        // For example, validation of option-specific transaction details
        System.out.println("Placing order for option: " + transaction.toString());
    }

    // Implementation of abstract method to calculate profit percentage
    @Override
    public double calculateProfitPercentage() {
        // Profit/Loss calculation for options depends on various factors including the option type, strike price, and market price of the underlying asset
        // We can implement a simplified version considering only the difference between the strike price and the current price of the underlying asset
        return (getPrice() - strikePrice) / strikePrice * 100;
    
}

}