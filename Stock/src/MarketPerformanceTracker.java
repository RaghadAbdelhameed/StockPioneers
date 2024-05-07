//package Stock;

import java.util.List;

public class MarketPerformanceTracker {
    
    // Method to calculate aggregate profit/loss percentage of all stocks in the market
    public static double calculateAggregateMarketPerformance() {
        List<Stock> stocks = User.getStocks();
        double totalProfitLoss = 0.0;
        for (Stock stock : stocks) {
            totalProfitLoss += stock.getProfitPercentage();
        }
        return totalProfitLoss / stocks.size();
    }
}
