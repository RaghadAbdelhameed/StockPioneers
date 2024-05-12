
//package Stock;
import java.util.*;

public class Stock extends Security {
    private String label; // stock label
    private static int amount;
    private String company;
    private double initialPrice;
    private double finalPrice;
    private double tradingPrice;
    private double dividends;
    private int availableStocks;
    private double profitPercentage;
    private List<StockPrice> priceHistory; // Store historical price data

<<<<<<< HEAD

    public Stock(String symbol, double price, String label, int amount, String company, double initialPrice, double tradingPrice, double dividends, int availableStocks , double profitPercentage) {
       super(symbol, price);
    	this.label = label;
    	this.amount = amount;
=======
    public Stock(String label, String company, double initialPrice, double tradingPrice, double dividends,
            int availableStocks, double profitPercentage) {
        super();
        this.label = label;
>>>>>>> 7c3d53f130befb0b8408cdebfedb468eb416c169
        this.company = company;
        this.initialPrice = initialPrice;
        this.tradingPrice = tradingPrice; // Initially set current price to initial price
        this.dividends = dividends;
        this.availableStocks = availableStocks;
        this.profitPercentage = profitPercentage;
        priceHistory = new ArrayList<>();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    public static int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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
<<<<<<< HEAD
    
    public double  calculateProfitLoss() {
    	if(priceHistory.isEmpty()){
    		return 0;
    	}
         initialPrice = priceHistory.get(0).getPrice(); // Get initial price
         finalPrice = priceHistory.get(priceHistory.size() - 1).getPrice(); // Get final price
=======

    public double calcProfitLossPercentage() {
        if (priceHistory.isEmpty()) {
            return 0;
        }
        initialPrice = priceHistory.get(0).getPrice(); // Get initial price
        finalPrice = priceHistory.get(priceHistory.size() - 1).getPrice(); // Get final price
>>>>>>> 7c3d53f130befb0b8408cdebfedb468eb416c169
        return ((finalPrice - initialPrice) / initialPrice) * 100; // get the profit or loss percentage

    }
<<<<<<< HEAD
    
=======

    @Override
>>>>>>> 7c3d53f130befb0b8408cdebfedb468eb416c169
    public double getCurrentPrice() {
        return tradingPrice;
    }
<<<<<<< HEAD
    
//    @Override
//    public void placeOrder(Transaction transaction) {
//        // Implement place order logic for stock transactions
//    }

    
    
    @Override
    public String toString() {
        return " Stock {" +
                "label='" + label + '\'' +
                ", amount=" + amount +
                ", company='" + company + '\'' +
                ", initialPrice=" + initialPrice +
                ", tradingPrice=" + tradingPrice +
                ", dividends=" + dividends +
                ", availableStocks=" + availableStocks +
                ", profitPercentage=" + profitPercentage +
                " }";
    }
    
    
=======

    @Override
    public void placeOrder(Transaction transaction) {
        // Implement place order logic for stock transactions
    }

>>>>>>> 7c3d53f130befb0b8408cdebfedb468eb416c169
}
