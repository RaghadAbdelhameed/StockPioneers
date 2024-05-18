import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class zDepositWithdrawalController extends MainController {
    private RegularUser regularUser;

    // Diposit & Withdrawal
    @FXML
    private Button DBackButton;

    @FXML
    void DBackbutonClicked() {
        loadFXML("UserFeatures.fxml", DBackButton, "User Features");
    }

    @FXML
    private static Label BalanceLabel;

    @FXML
    private TextField DTextField;

    @FXML
    private Button WithdrawalButton;

    @FXML
    private Button DepositButton;

    @FXML
    void DepositButtonClicked(ActionEvent event) {
        double amount = Double.parseDouble(DTextField.getText());
        regularUser = new RegularUser("", "", "");
        regularUser.deposit(amount);
    }

    @FXML
    void WithdrawalButtonClicked(ActionEvent event) {
        double amount = Double.parseDouble(DTextField.getText());
        regularUser.withdrawal(amount);
    }
}
