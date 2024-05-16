import java.util.*;
import java.time.LocalDateTime;


public class Stock extends Security{
	
    private String label; // stock label
    private String company;
    private int availableStocks;
    protected List<StockPrice> priceHistory; // Store historical price data
  //  private List<Observer> observerList ;

    public Stock(String symbol, double price, String label, int amount, String company, int availableStocks) {
        super(symbol, price);
        this.label = label;
        this.company = company;
        this.availableStocks = availableStocks;
        this.priceHistory = new ArrayList<>();
        // Add initial stock price to the history
        StockPrice initialStockPrice = new StockPrice(price, price, price, price, price, 0.0, 0.0, LocalDateTime.now());
        priceHistory.add(initialStockPrice);
    //    observerList = new ArrayList<>();
    }
    
    
//    @Override
//    public void subscribe(Observer observer)
//    {
//    	observerList.add(observer);
//    }
    
//    private String label; // stock label
//    private static int amount;
//    private String company;
//    private int availableStocks;
//    private List<StockPrice> priceHistory; // Store historical price data

//    public Stock(String symbol, double price, String label, int amount, String company, double initialPrice, double tradingPrice, double dividends, int availableStocks , double profitPercentage) {
//       super(symbol, price);
//    	this.label = label;
//    	this.amount = amount;
//        this.label = label;
//        this.company = company;
//        this.initialPrice = initialPrice;
//        this.tradingPrice = tradingPrice; // Initially set current price to initial price
//        this.dividends = dividends;
//        this.availableStocks = availableStocks;
//        this.profitPercentage = profitPercentage;
//        this.priceHistory = new ArrayList<>();
//    }
    
//    public Stock(String symbol, double price, String label, int amount, String company, int availableStocks) {
//        super(symbol, price);
//        this.label = label;
//        this.amount = amount;
//        this.company = company;
//        this.availableStocks = availableStocks;
//        this.priceHistory = new ArrayList<>();
//    }

      
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
//    public static int getAmount() {
//        return amount;
//    }
//
//    public void setAmount(int amount) {
//        this.amount = amount;
//    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }


    public int getAvailableStocks() {
        return availableStocks;
    }

    public void setAvailableStocks(int availableStocks) {
        this.availableStocks = availableStocks;
    }
 
    public List<StockPrice> getPriceHistory() {
        return priceHistory;
    }
    
    // Method to calculate opening price
    public double calculateOpeningPrice() {
        if (!priceHistory.isEmpty()) {
            return priceHistory.get(0).getOpeningPrice();
        }
        return getPrice(); // If price history is empty, return the current price
    }
    
    // Method to calculate final price
    public double calculateFinalPrice() {
        if (!priceHistory.isEmpty()) {
            return priceHistory.get(priceHistory.size() - 1).getFinalPrice();
        }
        return getPrice(); // If price history is empty, return the current price
    }


    // Method to calculate closing price
    public double calculateClosingPrice() {
        if (!priceHistory.isEmpty()) {
            return priceHistory.get(priceHistory.size() - 1).getClosingPrice();
        }
        return getPrice(); // If price history is empty, return the current price
    }

    // Method to calculate trading price
    public double calculateTradingPrice() {
        if (!priceHistory.isEmpty()) {
            return priceHistory.get(priceHistory.size() - 1).getTradingPrice();
        }
        return getPrice(); // If price history is empty, return the current price
    }

    // Method to calculate dividends
    public double calculateDividends() {
        if (!priceHistory.isEmpty()) {
            return priceHistory.get(priceHistory.size() - 1).getDividends();
        }
        return 0.0; // If price history is empty, return 0 dividends
    }
    
    // Method to update stock price and add to price history
    public void updateStockPrice(double initialPrice, double openingPrice, double finalPrice,
                                 double closingPrice, double tradingPrice, double dividends,
                                 double profitPercentage, LocalDateTime dateTime) {
        // Create new StockPrice object with the provided data
        StockPrice stockPrice = new StockPrice(initialPrice, openingPrice, finalPrice,
                                               closingPrice, tradingPrice, dividends,
                                               profitPercentage, dateTime);
        priceHistory.add(stockPrice); // Add StockPrice object to price history
        setPrice(tradingPrice);       // Update current price in the Security superclass
    }
  
    // Method to calculate profit percentage
    public double calculateProfitPercentage() {
        if (!priceHistory.isEmpty()) {
            return priceHistory.get(priceHistory.size() - 1).getProfitPercentage();
        }
        return 0.0; // If price history is empty, return 0 profit percentage
    }

    @Override
    public double getCurrentPrice() {
        return getPrice(); // Return the current price
    }
    
    // Method to get the latest trading price
    public double getTradingPrice() {
        if (!priceHistory.isEmpty()) {
            StockPrice latestPrice = priceHistory.get(priceHistory.size() - 1);
            return latestPrice.getTradingPrice();
        } else {
            // Handle case when price history is empty
            return 0.0; // Or throw an exception
        }
    }
    
    @Override
    public String toString() {
        return "Stock {" +
                "label='" + label + '\'' +
                ", company='" + company + '\'' +
                ", availableStocks=" + availableStocks +
                "}";
    }
    
    @Override
    public void placeOrder(Transaction transaction) {
        if (transaction.getOpType() == Operation.buy) {
            // Deduct the amount of stocks from available stocks
            int quantity = (int) transaction.getAmount();
            if (quantity <= availableStocks) {
                availableStocks -= quantity;
                System.out.println("Buy order placed successfully for " + quantity + " stocks of " + label);
            } else {
                System.out.println("Insufficient stocks available for purchase.");
            }
        } else if (transaction.getOpType() == Operation.sell) {
            // Add the amount of stocks to available stocks
            int quantity = (int) transaction.getAmount();
            availableStocks += quantity;
            System.out.println("Sell order placed successfully for " + quantity + " stocks of " + label);
        } else {
            System.out.println("Unsupported operation type for stock transaction.");
        }
    }


}
