
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class zUserController extends MainController {

    // User Login
    @FXML
    private Button AccountManageButton;

    @FXML
    private Button loginUserButton;

    @FXML
    private Hyperlink signupLink;

    @FXML
    private Button backButton;

    @FXML
    void loginUserClicked(ActionEvent event) {
        loadFXML("UserFeatures.fxml", loginUserButton, "User Dashboard");

    }

    @FXML
    void handleSignupClicked(ActionEvent event) {
        loadFXML("UserSignup.fxml", signupLink, "User Signup");
    }

    @FXML
    void backButtonClicked() {
        System.out.println("Going Back to Login Page...");
        loadFXML("NewLogin.fxml", backButton, "Login Page");
    }

    @FXML
    void AccountManageClicked(ActionEvent event) {
        loadFXML("AccountManage.fxml", AccountManageButton, "Create an Account");
    }

    // User Signup

    @FXML
    private TextField emailField;

    // @FXML
    // private DatePicker birthPicker;

    @FXML
    private Button logoutUserButton;

    @FXML
    private ChoiceBox<String> genderChoicebox;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // setLabelText();
        if (genderChoicebox == null) {
            genderChoicebox = new ChoiceBox<>();
        }
        genderChoicebox.getItems().addAll("Male", "Female");

    }

    // User Features
    @FXML
    private Button orderManageButton;

    @FXML
    private Button userPriceHistoryButton;

    @FXML
    private Button DepositWithdrawalButton;

    @FXML
    private Button financialButton;

    @FXML
    private Button TransactionHistoryButton;

    @FXML
    void orderManageClicked(ActionEvent event) {
        loadFXML("OrderManage.fxml", orderManageButton, "Order Management");
    }

    @FXML
    void financialClicked(ActionEvent event) {
    }

    @FXML
    void userPriceHistoryClicked(ActionEvent event) {
        loadFXML("UserPriceHistory.fxml", userPriceHistoryButton, "Price History");
    }

    @FXML
    void DepositWithdrawalButtonClicked() {
        loadFXML("withdrawal.fxml", DepositWithdrawalButton, "Deposite and Withdrawal");
    }

    @FXML
    void TransactionHistoryClicked(ActionEvent event) {
        loadFXML("TransactionHistory.fxml", financialButton, "Transaction History");

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

}
