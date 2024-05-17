import java.time.LocalDateTime;
import java.util.*;

public class Execute {
    public static void main(String[] args) {
    	Admin admin = Admin.getInstance("ahmed", "ahmed54");
    	RegularUser user1 = new RegularUser("mostafa" , "fdhfds" , "male");
    	admin.createUser(user1);
    	admin.createUser(user1);
    	admin.deleteUser(user1);
    	admin.initiateTradingSession();
    	admin.initiateTradingSession();

    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
//        // Create a MarketPerformanceTracker
//        MarketPerformanceTracker marketTracker = new MarketPerformanceTracker();
//
//        // Create a PremiumUser
//        PremiumUser premiumUser = new PremiumUser("John", "password123", gender.male);
//
//        // Subscribe premiumUser to market updates
//        marketTracker.subscribe(premiumUser);
//
//        // Simulate market update
//        marketTracker.notifyObservers();
//
//        // Show line chart for a specific stock (e.g., "AAPL")
//        premiumUser.showLineChart("AAPL", marketTracker.getPrices());
//
//        // Unsubscribe premiumUser
//        marketTracker.unsubscribe(premiumUser);
    }
}

    	
//        // Create some sample stock data
//       // List<Stock> Stocks = new ArrayList<>();
//        TradingManager td = new TradingManager();
//		Transaction t1 = new Transaction(1 , Operation.deposit , 500000000);
//        Admin admin = Admin.getInstance("Zeyad" , "Zeyad74" , gender.male , td);
//		//RegularUser loly = new RegularUser("loly" , "loly711" , gender.female);
//		admin.initiateTradingSession();
//		//loly.setAccountBalance(10000000);
//		//loly.deposit(500000000);
//	//	admin.approveDeposit(loly, 1000000, t1);
//        // Create a new Stock object
//        //    public Stock(String symbol, double price, String label, int amount, String company, int availableStocks) {
//
//        Stock appleStock = new Stock("AAPL", 150.0, "Apple Inc.", 100 , "company", 100);
//        Stock st = new Stock("AAPL", 150.0, "Apple Inc.", 100 , "company", 100);
//      //  loly.buyStockOrder("AAPL", "company", 5000, 2);
//        
//     //   StockPrice stp = new StockPrice();
//     //   Stocks.add(appleStock);
//        admin.createStock(appleStock);
//        admin.updateStock(appleStock, 30, 0, 0, 0, 0, 0, 0);
//        admin.displayPriceHistory(appleStock);
        
       
      //  System.out.println(admin.getStocks());
        
        

//        // Add price history for the stock
//        appleStock.updateStockPrice(150.0, 150.0, 160.0, 145.0, 155.0, 0.0, 0.0, LocalDateTime.now());
//        appleStock.updateStockPrice(155.0, 155.0, 165.0, 150.0, 160.0, 0.0, 0.0, LocalDateTime.now());
//
//        // Add the stock to the Stocks list
//        // Create a new Admin object
//        // Display price history for the stock with label "AAPL"
      //  admin.displayPriceHistory("AAPL");


//import java.time.LocalDateTime;
//
//public class Execute {
//    public static void main(String[] args) {
//        // Creating a new stock
//        Stock stock = new Stock("AAPL", 150.0, "AAPL", 100, "Apple Inc.", 1000);
//        
//        // Adding some price history
//        LocalDateTime currentTime = LocalDateTime.now();
//        StockPrice price1 = new StockPrice(150.0, 160.0, 165.0, 163.0, 162.0, 0.0, 0.05, currentTime.minusDays(3));
//        StockPrice price2 = new StockPrice(165.0, 163.0, 162.0, 166.0, 168.0, 0.0, 0.02, currentTime.minusDays(2));
//        StockPrice price3 = new StockPrice(162.0, 166.0, 168.0, 164.0, 170.0, 0.0, 0.04, currentTime.minusDays(1));
//        
//        // Add the price history to the stock
//        stock.getPriceHistory().add(price1);
//        stock.getPriceHistory().add(price2);
//        stock.getPriceHistory().add(price3);
//        TradingManager td = new TradingManager();
//     // Create a new Stock object
//        Stock appleStock = new Stock("AAPL", 150.0, "Apple Inc.", 100, 100);
//
//        // Add price history for the stock
//        appleStock.updateStockPrice(150.0, 150.0, 160.0, 145.0, 155.0, 0.0, 0.0, LocalDateTime.now());
//        appleStock.updateStockPrice(155.0, 155.0, 165.0, 150.0, 160.0, 0.0, 0.0, LocalDateTime.now());
//
//        // Add the stock to the Stocks list
//        Stocks.add(appleStock);
//
//        // Creating an admin
//        Admin admin = Admin.getInstance("Zeyad" , "Zeyad74" , gender.male , td);
//        
//        // Displaying price history for the stock
//        admin.displayPriceHistory("AAPL");
//    }
//}



//
//public class Execute {
//	public static void main(String[] args) {
//
//		TradingManager td = new TradingManager();
//		Admin admin = Admin.getInstance("Zeyad" , "Zeyad74" , gender.male , td);
//		RegularUser regUser1 = new RegularUser("loly" , "loly711" , gender.female);
//		Transaction t1 = new Transaction(1 , Operation.deposit , 120);
//		Transaction t2 = new Transaction(4 , "Heart" , Operation.withdrawal , 3 , 5000);
//		regUser1.setAccountBalance(90000);
//		regUser1.deposit(5000);
//		admin.closeTradingSession();
//		admin.approveDeposit(regUser1, 5000, t1);
//		admin.initiateTradingSession();
//		admin.approveDeposit(regUser1, 5000, t1);
//		System.out.println(regUser1.getAccountBalance());
//		RegularUser regUser2 = new RegularUser("sara" , "sara" , gender.female);
//		regUser1.createUser(regUser1);
//		admin.createUser(regUser2);
//		//     public Stock(String symbol, double price, String label, int amount, String company, int availableStocks) {
//		Stock s1 = new Stock("abas" ,500 , "APPL", 4, "DUKES", 3);
//		Stock s2 = new Stock("abas" ,500 , "iphone", 4, "Appel", 3);
//		admin.createStock(s1);
//		admin.createStock(s2);
//		System.out.println("****");
//		regUser1.buyStockOrder("APPL", "DUKES", 5000, 2);
//		System.out.println("****");
//		//admin.getStockDetails(s1);
//		admin.displayPriceHistoryForStock("APPL");
//		//admin.addStockPrice("APPL", 20);
//		//admin.initiateTradingSession();
//	//	System.out.println(regUser1.getAccountBalance());
//	//	regUser1.buyStockOrder("APPL", "DUKES", 600, 100);
//		//regUser1.buyStockOrder("APPL", "DUKES", 600, 3);
//
//		
//		
//		//admin.deleteUser(regUser1);
//	//	regUser1.getID();
//		//admin.accessUser(1);
//		//regUser1.createUser(regUser2);
//		//regUser2.createUser(null);
//
//		
//
//
//	}
//}	
//		
//		
//////		//System.out.println("gg");
//////		
//////		//	Transaction t1 = new Transaction(4 , "APPL" , Operation.deposit , 5 , 120);
//////		//	System.out.println(t1.toString());
//////			
//////			Transaction t1 = new Transaction(4 , "Heart" , Operation.deposit , 5 , 120);
//////			Transaction t2 = new Transaction(4 , "Heart" , Operation.withdrawal , 3 , 120);
//////			Stock s1 = new Stock("APPL", 1, "DUKES", 50 , 50, 20, 6 , 500);
//////			Stock s2 = new Stock("COFF", 1,  "STARBUCKS", 50 , 50, 20, 6 , 500);
//////
//////			//Stock s2 = new Stock("jdfks", "DUKES", 20 , 20, 20, 6 , 500);
//////			TradingManager td = new TradingManager();
//////			Admin admin = Admin.getInstance("Zeyad" , "Zeyad74" , 7 , 100 , gender.male , td);
//////			RegularUser regUser1 = new RegularUser("loly" , "loly711" , 1 , 1000 , gender.female);
//////		
//////			regUser1.deposit(120);
//////			admin.approveDeposit(regUser1, 250, t1);
//////			regUser1.withdrawal(100);
//////			admin.approveWithdrawal(regUser1, 50, t2);
//////			System.out.println("******");
//////			regUser1.getFinancialTransactions();
//////			regUser1.listAllTransactions();
//////		//	regUser1.deposit(0);
//////			admin.createStock(s1);
//////			admin.createStock(s2);
//////			regUser1.buyStockOrder("APPL", "DUKES", 200 , 2);
//////			regUser1.listAllTransactions();
//////			System.out.println("******");
//////			regUser1.setAccountBalance(300);
//////			regUser1.listAllTransactions();
//////			System.out.println("******");
//////			System.out.println(MarketPerformanceTracker.calculateAggregateMarketPerformance());
//////		//	regUser1.trackMarket();
//////		//	regUser1.sellStockOrder("dsf", "tesla", 10);
//////		
//////}
////
////
////	
////
////		
////		
////		
////		
////		
////		
////		
////		
////		
////		
////		
////		
////		
////		
////		
////		
////		
////		
////		
////		
////		
////		
////		
////		
////		
////		
////		
////}
////	}
////=======
////		// System.out.println("gg");
////
////		// Transaction t1 = new Transaction(4 , "APPL" , Operation.deposit , 5 , 120);
////		// System.out.println(t1.toString());
////
////		Transaction t1 = new Transaction(4, "Heart", Operation.deposit, 5, 120);
////		Transaction t2 = new Transaction(4, "Heart", Operation.withdrawal, 3, 120);
////		Stock s1 = new Stock("APPL", "DUKES", 20, 20, 20, 6, 500);
////		Stock s2 = new Stock("jdfks", "DUKES", 20, 20, 20, 6, 500);
////		TradingManager td = new TradingManager();
////		Admin admin = new Admin("Zeyad", "Zeyad74", 7, 100, gender.male, td);
////		RegularUser regUser1 = new RegularUser("loly", "loly711", 14, 500, gender.female);
////		// regUser1.trackMarket();
////		regUser1.deposit(120);
////		admin.approveDeposit(regUser1, 250, t1);
////		regUser1.withdrawal(100);
////		admin.approveWithdrawal(regUser1, 50, t2);
////		System.out.println("******");
////		regUser1.getFinancialTransactions();
////		regUser1.listAllTransactions();
////		// regUser1.deposit(0);
////		admin.createStock(s1);
////		admin.createStock(s2);
////		regUser1.buyStockOrder(300, "APPL", "DUKES");
////
////	}
////
////}
