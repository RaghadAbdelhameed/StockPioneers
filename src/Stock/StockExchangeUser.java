package Stock;

public class StockExchangeUser extends Person {

    private boolean isAdminApproved;

    public StockExchangeUser(String username, String password, int ID, double accountbalance, String gender) {
        super(username, password, ID, accountbalance, gender);
        this.isAdminApproved = false; // Admin doesnot approved by default
    }

    public boolean isAdminApproved() {
        return isAdminApproved;
    }

    public void setAdminApproved(boolean isAdminApproved) {
        this.isAdminApproved = isAdminApproved;
    }

    // 1- User Creation

    public void printUserInfo() {
        System.out.println("User Information:");
        System.out.println("Username: " + getUserName());
        System.out.println("Password: " + getPassword());
        System.out.println("ID: " + getID());
        System.out.println("Account Balance: " + getAccountBalance());
        System.out.println("Gender: " + getGender());
    }

    // 3- Deposit and Withdrawal

    public void depositFunds(double amount) {
        // Add logic to deposit funds
        if (isAdminApproved) {
            setAccountBalance(getAccountBalance() + amount);
            System.out.println(amount + " funds deposited successfully.");
        } else {
            System.out.println("Deposit pending admin approval.");
        }
    }

    public void withdrawFunds(double amount) {
        // Add logic to withdraw funds
        if (isAdminApproved) {
            if (getAccountBalance() >= amount) {
                setAccountBalance(getAccountBalance() - amount);
                System.out.println(amount + " funds withdrawn successfully.");
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Withdrawal pending admin approval.");
        }
    }
}
