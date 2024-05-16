import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.util.Optional;

public class zAdminController extends MainController {
    private TradingManager tradingManager;

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
        String password = adminPasswordField.getText();
        String username = adminUsernameField.getText();
        String[][] data = CSV.readData("csv files/AdminCredentials.csv");
        if (username.equals(data[1][0]) && password.equals(data[1][1])) {
            loadFXML("AdminUI.fxml", adminLoginButton, "Admin Dashboard");
        } else {
            System.out.println("wrong input");
        }
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
    private Button stockManageButton;

    @FXML
    private Button stockorderButton;

    @FXML
    private Button priceHistoryButton;

    @FXML
    private Button sessionsButton;

    @FXML
    private Button approvalButton;

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

    @FXML
    void stockManageClicked(ActionEvent event) {
        loadFXML("StockManage.fxml", stockManageButton, "Stock Management");
    }

    @FXML
    void stockorderClicked(ActionEvent event) {
        loadFXML("StockOrders.fxml", stockorderButton, "Stock Orders");
    }

    @FXML
    void priceHistoryClicked(ActionEvent event) {
        loadFXML("AdminPriceHistory.fxml", priceHistoryButton, "Price History");
    }

    @FXML
    void sessionsButtonClicked(ActionEvent event) {
        if (!tradingManager.isTradingSessionOpen()) {
            loadFXML("TradingSessions.fxml", sessionsButton, "Trading Sessions Intiate");
        }
        loadFXML("TradingSessionsClose.fxml", sessionsButton, "Trading Sessions Close");
    }

    @FXML
    void approvalClicked(ActionEvent event) {
        loadFXML("Approval.fxml", approvalButton, "Approval System");
    }
}