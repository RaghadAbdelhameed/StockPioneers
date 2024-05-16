import java.util.*;

public class MarketPerformanceTracker {

	private static List<Observer> observers;
    private Map<String, List<StockPrice>> stockPrices; // Map to store stock price by stock label
	private User user;
	
	public MarketPerformanceTracker(Map<String, List<StockPrice>> stockPrices) {
        this.observers = new ArrayList<>();
        this.stockPrices = stockPrices;
	}
	
    public MarketPerformanceTracker(User user) {
        this.user = user;
        this.observers = new ArrayList<>();
    }
	
    // subscribe an observer
    public static void subscribe(Observer observer) {
        observers.add(observer);
        System.out.println( observer.getUserName() + " Subscribed successfully ");
    }

    // unsubscribe an observer
    public static void unsubscribe(Observer observer) {
        observers.remove(observer);
        System.out.println( observer.getUserName() + " Unubscribed successfully ");
    }

//    // notify observers of changes
//    public static void notifyObservers() {
//        System.out.println(" Notifying all subscribers about market updates...");
//        for (Observer observer : observers) {
//            observer.update();
//        }
//    }
    
    // Notify observers of changes
    public void notifyObservers() {
        System.out.println(" Notifying all subscribers about market updates...");
        for (Observer observer : observers) {
            observer.update(user); // Pass the User object to the update method
        }
    }

// calculate aggregate profit/loss percentage of all stocks in the market
public static double calculateAggregateMarketPerformance() {
   List<Stock> stocks = User.getStocks();
   double totalProfitLoss = 0.0;
   for (Stock stock : stocks) {
       totalProfitLoss += stock.calculateProfitPercentage();
   }
   return totalProfitLoss / stocks.size();
	}

// Method to retrieve stock prices
public Map<String, List<StockPrice>> getPrices() {
    return stockPrices;
}


}

