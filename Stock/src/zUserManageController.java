import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class zUserManageController extends MainController{
    
    private User user;
    // private RegularUser regularUser;
    private Admin admin; 
    private RegularUser currentUser; 

     // User Management
     @FXML
     private Button createUserButton;
 
     @FXML
     private Button updateUserButton;
 
     @FXML
     private Button deleteUserButton;
 
     @FXML
     private Button retriveUserButton;
 
     @FXML
     void createUserClicked(ActionEvent event) {
         loadFXML("CreateUser.fxml", createUserButton, "Create User");
     }
 
     @FXML
     void updateUserClicked(ActionEvent event) {
         loadFXML("UpdateUser.fxml", updateUserButton, "Update User");
     }
 
     @FXML
     void deleteUserClicked(ActionEvent event) {
         loadFXML("DeleteUser.fxml", deleteUserButton, "Delete User");
     }
 
     @FXML
     void retriveUserClicked(ActionEvent event) {
         loadFXML("RetriveUser.fxml", retriveUserButton, "Retrive User");
     }
 
     // Create User
 
     @FXML
     private TextField createUsernamefiled;
 
     @FXML
     private PasswordField createPasswordfiled;
 
     @FXML
     private TextField createAccountBalancefiled;
 
     @FXML
     private TextField createIDfiled;
 
     // @FXML
     // private ChoiceBox<?> createGenderBox;
 
     @FXML
     private Button saveCreateButton;
 
     @FXML
     void saveCreateClicked(ActionEvent event) {
         String username = createUsernamefiled.getText();
         String password = createPasswordfiled.getText();
         int id = Integer.parseInt(createIDfiled.getText());
         double balance = Double.parseDouble(createAccountBalancefiled.getText());
         currentUser.setID(id);
         currentUser.setUserName(username);
         currentUser.setPassword(password);
         currentUser.setAccountBalance(balance);
         user.createUser(currentUser);
      //   String gender = genderChoicebox.getValue(); // Assuming you've populated the
         // choice box with appropriate values
         System.out.println(username + "  " + password + "  " + id + "  " + balance);
     }
 
     // Update User
 
     @FXML
     private TextField UpdateAccountBalancefield;
 
     @FXML
     private TextField UpdateIDfield;
 
     @FXML
     private PasswordField UpdatePasswordfield;
 
     @FXML
     private TextField UpdateUsernsamefield;
 
     @FXML
     private Button updateButton;
 
     @FXML
     void updateClicked(ActionEvent event) {
         {
             String username = UpdateUsernsamefield.getText();
             double accountBalance = Double.parseDouble(UpdateAccountBalancefield.getText());
             int id = Integer.parseInt(UpdateIDfield.getText());
             // gender gender = currentUser.gender();
 
             currentUser.setID(id);
             currentUser.setUserName(username);
             currentUser.setAccountBalance(accountBalance);
             admin.updateUser(currentUser);
             System.out.println(id + "  " + username + "  " + accountBalance);
         }
     }
 
     // delete user
 
     @FXML
     private Button deleteButton;
 
     @FXML
     private TextField searchIDfield;
 
     @FXML
     private Button searhButton;
 
     @FXML
     void deleteClicked(ActionEvent event) {
         int searchid = Integer.parseInt(searchIDfield.getText());
         try {
             currentUser.setID(searchid);
             // Call the updateUser method of the Admin class with the retrieved id
             admin.deleteUser(currentUser);
         } catch (NumberFormatException e) {
             System.out.println("Invalid Input. You must enter a digit.");
         }
     }
 
     @FXML
     void searchClicked(ActionEvent event) {
         
     }
 
     // Retrive User
     @FXML
     private TextField searchRetriveIDfield;
 
     @FXML
     private Button searhRetrieveButton;
 
     @FXML
     void searchRetrieveClicked(ActionEvent event) {
        int searchid = Integer.parseInt(searchRetriveIDfield.getText());
        try {
            currentUser.setID(searchid);
            // Call the updateUser method of the Admin class with the retrieved id
            admin.accessUser(searchid);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input. You must enter a digit.");
        }
     }
}