import java.util.*;

public class PremiumUser extends RegularUser implements Observer {

	
	public PremiumUser(String username, String password, gender gender) {
        super(username, password, gender);
    }

	
    @Override
    public void update(User user) {
        System.out.println(" Updating user: " + user.getUserName());
//        show
    }
//    // Subscribe for Notifications on Stock Price Changes
//    public void subscribeForNotifications() {
//        MarketPerformanceTracker.subscribe(this);        // Subscribe to the market performance tracker
//        System.out.println("Subscribed for notifications on stock price changes.");
//    }
//
//    // Unsubscribe from Notifications on Stock Price Changes
//    public void unsubscribeFromNotifications() {
//        MarketPerformanceTracker.unsubscribe(this);        // Unsubscribe from the market performance tracker
//        System.out.println("Unsubscribed from notifications on stock price changes.");
//    }

    // Method to show line charts for specific stocks
    public void showLineChart(String stockLabel, Map<String, List<StockPrice>> stockPrices) {
        List<StockPrice> priceHistory = stockPrices.get(stockLabel);
        if (priceHistory == null || priceHistory.isEmpty()) {
            System.out.println(" No price history found for stock with label: " + stockLabel);
            return;
        }

        // Display line chart for the specified stock
        System.out.println(" Line chart for stock with label: " + stockLabel);
        for (StockPrice price : priceHistory) {
            // Draw a simple line chart representation
            System.out.println(price.getDateTime() + " - " + price.getTradingPrice());
        }
    }

//    // Implement update method from Observer interface
//    @Override
//    public void update(String username) {
//        // This method will be called when there's a notification about stock price changes
//        System.out.println( username +" Received notification: Stock price has changed ");
//        // Add code here to handle the notification, such as updating line charts
//    }

    
}
