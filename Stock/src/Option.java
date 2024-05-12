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
    public Option(String symbol, double price, OptionType optionType, double strikePrice, LocalDate expirationDate, String underlyingAssetSymbol) {
        super(symbol, price);
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

    // Implementation of abstract method
    @Override
    public double calculateProfitLoss() {
        // Profit/Loss calculation for options depends on various factors including the option type, strike price, and market price of the underlying asset
        // We can implement a simplified version considering only the difference between the strike price and the current price of the underlying asset
        return getPrice() - strikePrice;
    }
}
