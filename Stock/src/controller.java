import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class controller {

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
    void logoutButtonClicked(ActionEvent event) {
        if (adminButton == null) {
            // Attempt to initialize adminButton
            adminButton = new Button();
            adminButton.setId("adminButton"); // Set button ID if needed
        }
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

            returnAdminLogin();

        }
    }

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    void handlePasswordInput(ActionEvent event) {
        String password = passwordField.getText();
        System.out.println("Username entered: " + password);
    }

    @FXML
    void handleUsernamInput(ActionEvent event) {
        String username = usernameField.getText();
        System.out.println("Username entered: " + username);
    }

    @FXML
    void loginButtonClicked(ActionEvent event) {
        loadAdminUI();
    }

    @FXML
    void adminButtonClicked() {
        // Handle admin button click
        System.out.println("Logging in as Admin.... ");
        loadAdminLogin();
    }

    @FXML
    void userButtonClicked() {
        // Handle user button click
        System.out.println("Logging in as User.... ");
    }

    @FXML
    void backButtonClicked() {
        System.out.println("Going Back to Login Page...");
        loadLogin();
    }

    private void loadAdminLogin() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
            Stage stage = (Stage) adminButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Admin Login");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void returnAdminLogin() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
            Stage stage = (Stage) logoutButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Admin Login");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadAdminUI() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AdminUI.fxml"));
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Admin Dashboard");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadLogin() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("NewLogin.fxml"));
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Login Page");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
