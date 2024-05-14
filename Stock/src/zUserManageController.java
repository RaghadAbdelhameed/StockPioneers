
// import javafx.beans.property.SimpleDoubleProperty;
// import javafx.beans.property.SimpleObjectProperty;
// import javafx.collections.FXCollections;
// import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
// import javafx.fxml.FXMLLoader;
// import javafx.fxml.Initializable;
// import javafx.scene.Parent;
// import javafx.scene.Scene;
// import javafx.scene.control.Alert;
// import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
// import javafx.scene.control.ButtonType;
// import javafx.scene.control.ChoiceBox;
// import javafx.scene.control.ComboBox;
// import javafx.scene.control.DatePicker;
// import javafx.scene.control.Hyperlink;
// import javafx.scene.control.Label;
// import javafx.scene.control.Labeled;
import javafx.scene.control.PasswordField;
// import javafx.scene.control.TableColumn;
// import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
// import javafx.scene.paint.Color;
// import javafx.scene.text.Font;
// import javafx.stage.Stage;
// import java.io.IOException;
//import java.lang.classfile.Label;
// import java.net.URL;
// import java.time.LocalDateTime;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;
// import java.util.ResourceBundle;

public class zUserManageController extends MainController{
    
    // private User user;
    // private RegularUser regularUser;
    private Admin admin; 
    private RegularUser currentUser; 
    //  public void setUser(RegularUser user) {
    //      this.currentUser = user; // Reference to the Admin instance
    //  }
 
    //  public void setAdmin(Admin admin) {
    //      this.admin = admin; // Reference to the Admin instance
    //  }

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
         admin.createUser(currentUser);
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
 
             // Create a new User object with the updated information
             // RegularUser updatedUser = new RegularUser(username, password, id,
             // accountBalance,
             // gender);
             // // Call the updateUser method of the Admin class
             // admin.updateUser(updatedUser);
         }
     }
 
     // delete user
 
     @FXML
     private Button deleteButton;
 
     @FXML
     private TextField searchIDfield;
 
     // @FXML
     // private Label searchResult;
 
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
         // admin.accessUser(searchid);
         // for (User user : Users) {
         // if (user.getID() == searchid) {
         // return currentUser; // return a new User object
         // }
         // }
         // System.out.println(" User Not Found ");
         // return null; // return nothing
     }
 
     // Retrive User
}
