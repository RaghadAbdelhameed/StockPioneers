
public class Stock {
    private String label;
    private String company;
    private double initialPrice;
    private double tradingPrice;
    private double dividends;
    private int availableStocks;
    private double profitPercentage;

    public Stock(String label, String company, double initialPrice, double tradingPrice, double dividends,
            int availableStocks, double profitPercentage) {
        this.label = label;
        this.company = company;
        this.initialPrice = initialPrice;
        this.tradingPrice = tradingPrice; // Initially set current price to initial price
        this.dividends = dividends;
        this.availableStocks = availableStocks;
        this.profitPercentage = profitPercentage;

    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public double getDividends() {
        return dividends;
    }

    public void setDividends(double dividends) {
        this.dividends = dividends;
    }

    public double getTradingPrice() {
        return tradingPrice;
    }

    public void setTradingPrice(double tradingPrice) {
        this.tradingPrice = tradingPrice;
    }

    public int getAvailableStocks() {
        return availableStocks;
    }

    public void setAvailableStocks(int availableStocks) {
        this.availableStocks = availableStocks;
    }

    public double getProfitPercentage() {
        return profitPercentage;
    }

    public void setProfitPercentage(double profitPercentage) {
        this.profitPercentage = profitPercentage;
    }

}
