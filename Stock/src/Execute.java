
public class Execute {
	public static void main(String[] args) {

<<<<<<< HEAD
		TradingManager td = new TradingManager();
		Admin admin = Admin.getInstance("Zeyad" , "Zeyad74" , gender.male , td);
		RegularUser regUser1 = new RegularUser("loly" , "loly711" , gender.female);
		Transaction t1 = new Transaction(1 , Operation.deposit , 120);
		Transaction t2 = new Transaction(4 , "Heart" , Operation.withdrawal , 3 , 5000);
		regUser1.setAccountBalance(90000000);
		regUser1.deposit(5000);
		admin.approveDeposit(regUser1, 5000, t1);
		System.out.println(regUser1.getAccountBalance());
		RegularUser regUser2 = new RegularUser("sara" , "sara" , gender.female);
		regUser1.createUser(regUser1);
		admin.createUser(regUser2);
		Stock s1 = new Stock("abas" ,500 , "APPL", 4, "DUKES", 50 , 50, 20, 6 , 500);
		Stock s2 = new Stock("abas" ,500 , "COFF", 7,  "STARBUCKS", 50 , 50, 20, 6 , 500);
		admin.createStock(s1);
		admin.createStock(s2);
		System.out.println("****");
		regUser1.buyStockOrder("APPL", "DUKES", 5000, 1);
	//	System.out.println(regUser1.getAccountBalance());
	//	regUser1.buyStockOrder("APPL", "DUKES", 600, 100);
		//regUser1.buyStockOrder("APPL", "DUKES", 600, 3);

		
		
		//admin.deleteUser(regUser1);
	//	regUser1.getID();
		//admin.accessUser(1);
		//regUser1.createUser(regUser2);
		//regUser2.createUser(null);

		


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		//System.out.println("gg");
//		
//		//	Transaction t1 = new Transaction(4 , "APPL" , Operation.deposit , 5 , 120);
//		//	System.out.println(t1.toString());
//			
//			Transaction t1 = new Transaction(4 , "Heart" , Operation.deposit , 5 , 120);
//			Transaction t2 = new Transaction(4 , "Heart" , Operation.withdrawal , 3 , 120);
//			Stock s1 = new Stock("APPL", 1, "DUKES", 50 , 50, 20, 6 , 500);
//			Stock s2 = new Stock("COFF", 1,  "STARBUCKS", 50 , 50, 20, 6 , 500);
//
//			//Stock s2 = new Stock("jdfks", "DUKES", 20 , 20, 20, 6 , 500);
//			TradingManager td = new TradingManager();
//			Admin admin = Admin.getInstance("Zeyad" , "Zeyad74" , 7 , 100 , gender.male , td);
//			RegularUser regUser1 = new RegularUser("loly" , "loly711" , 1 , 1000 , gender.female);
//		
//			regUser1.deposit(120);
//			admin.approveDeposit(regUser1, 250, t1);
//			regUser1.withdrawal(100);
//			admin.approveWithdrawal(regUser1, 50, t2);
//			System.out.println("******");
//			regUser1.getFinancialTransactions();
//			regUser1.listAllTransactions();
//		//	regUser1.deposit(0);
//			admin.createStock(s1);
//			admin.createStock(s2);
//			regUser1.buyStockOrder("APPL", "DUKES", 200 , 2);
//			regUser1.listAllTransactions();
//			System.out.println("******");
//			regUser1.setAccountBalance(300);
//			regUser1.listAllTransactions();
//			System.out.println("******");
//			System.out.println(MarketPerformanceTracker.calculateAggregateMarketPerformance());
//		//	regUser1.trackMarket();
//		//	regUser1.sellStockOrder("dsf", "tesla", 10);
//		
//}


	

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
	}
=======
		// System.out.println("gg");

		// Transaction t1 = new Transaction(4 , "APPL" , Operation.deposit , 5 , 120);
		// System.out.println(t1.toString());

		Transaction t1 = new Transaction(4, "Heart", Operation.deposit, 5, 120);
		Transaction t2 = new Transaction(4, "Heart", Operation.withdrawal, 3, 120);
		Stock s1 = new Stock("APPL", "DUKES", 20, 20, 20, 6, 500);
		Stock s2 = new Stock("jdfks", "DUKES", 20, 20, 20, 6, 500);
		TradingManager td = new TradingManager();
		Admin admin = new Admin("Zeyad", "Zeyad74", 7, 100, gender.male, td);
		RegularUser regUser1 = new RegularUser("loly", "loly711", 14, 500, gender.female);
		// regUser1.trackMarket();
		regUser1.deposit(120);
		admin.approveDeposit(regUser1, 250, t1);
		regUser1.withdrawal(100);
		admin.approveWithdrawal(regUser1, 50, t2);
		System.out.println("******");
		regUser1.getFinancialTransactions();
		regUser1.listAllTransactions();
		// regUser1.deposit(0);
		admin.createStock(s1);
		admin.createStock(s2);
		regUser1.buyStockOrder(300, "APPL", "DUKES");

	}

}
>>>>>>> 7c3d53f130befb0b8408cdebfedb468eb416c169
