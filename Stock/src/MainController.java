import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Labeled;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainController  {

    // New Login
    @FXML
    private Button adminButton;

    @FXML
    private Button userButton;

    @FXML
    void adminButtonClicked() {
        // Handle admin button click
        System.out.println("Logging in as Admin.... ");
        loadFXML("AdminLogin.fxml", adminButton, "Admin Login");
    }

    @FXML
    void userButtonClicked() {
        // Handle user button click
        System.out.println("Logging in as User.... ");
        loadFXML("UserLogin.fxml", userButton, "User Login");
    }

    // Admin Login
    @FXML
    private PasswordField adminPasswordField;

    @FXML
    private TextField adminUsernameField;

    @FXML
    private Button backButton;

    @FXML
    private Button adminLoginButton;

    @FXML
    void handleAdminPasswordInput(ActionEvent event) {
        String password = adminPasswordField.getText();
        System.out.println("Password entered: " + password);
    }

    @FXML
    void handleAdminUsernamInput(ActionEvent event) {
        String username = adminUsernameField.getText();
        System.out.println("Username entered: " + username);
    }

    @FXML
    void adminLoginButtonClicked(ActionEvent event) {
        loadFXML("AdminUI.fxml", adminLoginButton, "Admin Dashboard");
    }

    @FXML
    void backButtonClicked() {
        System.out.println("Going Back to Login Page...");
        loadFXML("NewLogin.fxml", backButton, "Login Page");
    }

    // Admin UI
    @FXML
    private Button adminLogoutButton;

    @FXML
    private Button userManageButton;

    @FXML
    void adminLogoutButtonClicked(ActionEvent event) {
        // Create a confirmation alert
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure that you want to Logout?");

        // Customize the buttons
        ButtonType yesButton = new ButtonType("Yes");
        ButtonType noButton = new ButtonType("No");

        alert.getButtonTypes().setAll(yesButton, noButton);

        // Show the alert and wait for user response
        Optional<ButtonType> result = alert.showAndWait();

        // Check which button the user clicked
        if (result.isPresent() && result.get() == yesButton) {
            loadFXML("AdminLogin.fxml", adminLogoutButton, "Admin Login");
        }
    }

    @FXML
    void userManageClicked(ActionEvent event) {
        loadFXML("UserManage.fxml", userManageButton, "User Management");
    }

    // User Management
    @FXML
    private Button createUserButton;

    @FXML
    private Button updateUserButton;

    @FXML
    void createUserClicked(ActionEvent event) {
        loadFXML("CreateUser.fxml", createUserButton, "Create User");
    }

    @FXML
    void updateUserClicked(ActionEvent event) {
        loadFXML("UpdateUser.fxml", updateUserButton, "Update User");
    }

    // Create User
    private User user;
    private RegularUser regularUser;

    public MainController(){
      //  regularUser = new RegularUser();
    }

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
            String id = createIDfiled.getText();
           // String gender = createGenderBox.getValue(); // Assuming you've populated the choice box with appropriate values
            String balance = createAccountBalancefiled.getText();
            System.out.println(username+"  "+password+"  "+id+"  "+balance);
            // User createUser = new RegularUser(username, password, id,
            // balance,gender);
            // // Call the updateUser method of the Admin class
            // RegularUser.createUser(createUser);
    
}

    // Update User
    private Admin admin; // Admin instance to interact with business logic
    private RegularUser currentUser; // User object for creating or updating users

    public void setUser(RegularUser user) {
        this.currentUser = user; // Reference to the Admin instance
    }

    public void setAdmin(Admin admin) {
        this.admin = admin; // Reference to the Admin instance
    }

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
            String password = UpdatePasswordfield.getText();
            double accountBalance = Double.parseDouble(UpdateAccountBalancefield.getText());
            int id = Integer.parseInt(UpdateIDfield.getText());
            // gender gender = currentUser.gender();

            System.out.println(username + "  " + password + "  " + accountBalance + "  " + id);
            // Create a new User object with the updated information
            // RegularUser updatedUser = new RegularUser(username, password, id,
            // accountBalance,
            // gender);
            // // Call the updateUser method of the Admin class
            // admin.updateUser(updatedUser);
        }
    }

    // User Login
    @FXML
    private Button loginUserButton;
    
    @FXML
    private Hyperlink signupLink;

    @FXML
    void loginUserClicked(ActionEvent event) {
        loadFXML("UserFeatures.fxml", loginUserButton, "User Dashboard");
    }
    
    @FXML
    void handleSignupClicked(ActionEvent event) {
        loadFXML("UserSignup.fxml", signupLink, "User Signup");
    }


   // Signup

    @FXML
    private TextField emailField;

    // @FXML
    // private DatePicker birthPicker;

    @FXML
    private Button logoutUserButton;

    @FXML
    private ComboBox<String> genderCombobox;

    public void initialize(URL location, ResourceBundle resources) {
        // Initialize gender ComboBox items
        genderCombobox.getItems().addAll("Male", "Female");
    }

    @FXML
    void handleEmailInput() {
        String email = emailField.getText();
        if (!email.endsWith("@gmail.com") && !email.endsWith("@yahoo.com") && !email.endsWith("@hotmail.com")
                && !email.endsWith("@outlook.com")) {
            emailField.setText("");
            showAlert("Invalid Email", "Email should end with @example.com");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }



    @FXML
    void logoutUserClicked(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure that you want to Logout?");

        // Customize the buttons
        ButtonType yesButton = new ButtonType("Yes");
        ButtonType noButton = new ButtonType("No");

        alert.getButtonTypes().setAll(yesButton, noButton);

        // Show the alert and wait for user response
        Optional<ButtonType> result = alert.showAndWait();

        // Check which button the user clicked
        if (result.isPresent() && result.get() == yesButton) {
            loadFXML("UserLogin.fxml", logoutUserButton, "User Login");
        }
    }

    private void loadFXML(String fxmlFileName, Hyperlink link, String title) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFileName));
            Stage stage = (Stage) link.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFXML(String fxmlFileName, Button button, String title) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFileName));
            Stage stage = (Stage) button.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}