package Stock;
import java.util.*;

public class RegularUser extends User {

	   private boolean isDepositApproved;
	   private boolean isWithdrawalApproved;
	   
	    private List<Transaction> pendingTransactions; // List to store pending deposit and withdrawal requests
	   
	    public RegularUser(String username, String password, int ID, double accountbalance, gender gender){
	        super(username, password, ID, accountbalance, gender);
	        this.isDepositApproved = false; // Admin doesnot approved by default
	        this.isWithdrawalApproved = false;
	        pendingTransactions = new ArrayList<>();
	    }
	
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
