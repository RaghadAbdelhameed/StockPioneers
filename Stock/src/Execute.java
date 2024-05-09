
public class Execute {
	public static void main(String[] args) {

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