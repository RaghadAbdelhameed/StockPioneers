import java.util.*;

public class PremiumUser extends RegularUser implements Observer {

    public PremiumUser(String username, String password, String gender) {
        super(username, password, gender);
    }

    @Override
    public void update(User user) {
        System.out.println(" Updating user: " + user.getUserName());
    }

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

}