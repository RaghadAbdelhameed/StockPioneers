
import java.util.*;

public class RegularUser extends User {

	private boolean isDepositApproved;
	private boolean isWithdrawalApproved;

	private List<Transaction> pendingTransactions; // List to store pending deposit and withdrawal requests
	private List<Stock> requestedStocks;
    private List<Stock> haveStocks;
    private List<Stock> Stocks;


	public RegularUser(String username, String password, int ID, double accountbalance, gender gender) {
		super(username, password, ID, accountbalance, gender);
		this.isDepositApproved = false; // Admin doesnot approved by default
		this.isWithdrawalApproved = false;
		this.requestedStocks = new ArrayList<>(); // list for the requested stocks
        this.haveStocks = new ArrayList<>(); // list for the stocks that User have
        this.Stocks = new ArrayList<>();
		pendingTransactions = new ArrayList<>();
	}
 // 2-Order Mangement

    // Add Stocks Order
    public void addStocksOrder(String label, String company, double maxPrice) {
        for (Stock stock : Stocks) {
            if (stock.getLabel().equals(label) && stock.getCompany().equals(company)) {
                requestedStocks.add(stock);
                System.out.println(" Stock order added ");
                buyStocksOrder(maxPrice);
            }
        }
        System.out.println(" Stock Not Found "); // unreachable code when (return stock)
    }

    // Delete Stocks Order
    public void delelteStocksOrder(String label, String company) {
        requestedStocks.removeIf(stock -> stock.getLabel().equals(label) && stock.getCompany().equals(company));
    }

    // Buy Stocks Order
    public void buyStocksOrder(double maxPrice) {
        for (Stock stock : requestedStocks) {
            if (stock.getTradingPrice() <= maxPrice) { // Option to automatically execute buy Stock if it's
                                                       // available
                setAccountBalance(getAccountBalance() - stock.getTradingPrice());
                haveStocks.add(stock);
                requestedStocks.remove(stock);
                System.out.println(" Stock bought successfully");
            }
            System.out.println(" Stock is not available at or below the requested price ");
        }
    }

    // Sell Stocks Order
    public void sellStocksOrder(String label, String company, double minPrice) {// adding prices
        for (Stock stock : haveStocks) {
            if (stock.getLabel().equals(label) && stock.getCompany().equals(company)) {
                if (stock.getTradingPrice() >= minPrice) {
                    setAccountBalance(getAccountBalance() + stock.getTradingPrice());
                    haveStocks.remove(stock);
                    System.out.println(" Stock sold successfully");
                }
            }
        }
    }


	//3- Deposit/Withdrawal
	// Method to deposit funds (pending admin approval)
	public void deposit(double amount) { // deposit request
		if (amount > 0) { // to be valid
			Transaction depositTransaction = new Transaction(Operation.deposit, amount);
			pendingTransactions.add(depositTransaction);
			System.out.println(" Deposit request submitted for approval ");
		} else {
			System.out.println(" Invalid deposit amount ");
		}
	}

	// Method to withdraw funds (pending admin approval)
	public void withdrawal(double amount) {
		if (amount > 0 && amount <= accountbalance) {
			Transaction withdrawalTransaction = new Transaction(Operation.withdrawal, amount);
			pendingTransactions.add(withdrawalTransaction);
			System.out.println(" Withdrawal request submitted for approval ");
		} else {
			System.out.println(" Invalid withdrawal amount or insufficient funds ");
		}
	}

	// Method to mark the deposit request as approved
	public void markDepositApproval() {
		this.isDepositApproved = true;
	}

	// Method to mark the withdrawal request as approved
	public void markWithdrawalApproval() {
		this.isWithdrawalApproved = true;
	}

}
