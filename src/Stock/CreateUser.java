package Stock;

public class CreateUser extends User {

    public CreateUser() {
        super();
    }

    public CreateUser(String username, String password, int ID, double accountbalance, String gender) {
        super(username, password, ID, accountbalance, gender);
    }

    // Method to create a user in the stock exchange application
    public void createUser() {
        System.out.println("User created in the stock exchange application.");
    }
}
