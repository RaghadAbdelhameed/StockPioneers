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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainController {

    @FXML
    private Button adminButton;

    @FXML
    private Button userButton;

    @FXML
    private Button backButton;

    @FXML
    private Button loginButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Hyperlink signupLink;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private DatePicker birthPicker;

    @FXML
    private Button loginUserButton;

    @FXML
    private Button logoutUserButton;

    @FXML
    private Button userManageButton;

    @FXML
    private Button createUserButton;

    @FXML
    private ComboBox<String> genderCombobox;

    public void initialize(URL location, ResourceBundle resources) {
        // Initialize gender ComboBox items
        genderCombobox.getItems().addAll("Male", "Female");
    }

    @FXML
    void handleEmailInput() {
        String email = emailField.getText();
        if (!email.endsWith("@gmail.com")) {
            emailField.setText("");
            showAlert("Invalid Email", "Email should end with @gmail.com");
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
    void logoutButtonClicked(ActionEvent event) {
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
            loadFXML("AdminLogin.fxml", logoutButton, "Admin Login");
        }
    }

    @FXML
    void handlePasswordInput(ActionEvent event) {
        String password = passwordField.getText();
        System.out.println("Password entered: " + password);
    }

    @FXML
    void handleUsernamInput(ActionEvent event) {
        String username = usernameField.getText();
        System.out.println("Username entered: " + username);
    }

    @FXML
    void loginButtonClicked(ActionEvent event) {
        loadFXML("AdminUI.fxml", loginButton, "Admin Dashboard");
    }

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

    @FXML
    void backButtonClicked() {
        System.out.println("Going Back to Login Page...");
        loadFXML("NewLogin.fxml", backButton, "Login Page");
    }

    @FXML
    void userManageClicked(ActionEvent event) {
        loadFXML("UserManage.fxml", userManageButton, "User Management");

    }

    @FXML
    void createUserClicked(ActionEvent event) {
        loadFXML("CreateUser.fxm", createUserButton, "Create User");
    }

    @FXML
    void handleSignupClicked(ActionEvent event) {
        loadFXML("UserSignup.fxml", signupLink, "User Signup");

    }

    @FXML
    void loginUserClicked(ActionEvent event) {
        loadFXML("UserFeatures.fxml", loginUserButton, "User Dashboard");
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

    // Create User
    @FXML
    private TextField cUEmailField;

    @FXML
    private PasswordField cUPasswordField;

    @FXML
    private Button cUSaveButton;

    @FXML
    private TextField cUUsernameField;

    @FXML
    private TextField cUUsernameField1;

    @FXML
    private ChoiceBox<?> cUgender;

    @FXML
    private TextField cUid;

    @FXML
    void CUsaveClicked(ActionEvent event) {

    }

    @FXML
    void handlCUUsernamInput(ActionEvent event) {
            
    }

    @FXML
    void handleCUEmailInput(ActionEvent event) {

    }

    @FXML
    void handleCUPasswordInput(ActionEvent event) {
           
    }

    @FXML
    void handleCUUsernamInput(ActionEvent event) {

    }

    @FXML
    void handleCUidInput(ActionEvent event) {

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