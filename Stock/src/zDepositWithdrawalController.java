import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class zDepositWithdrawalController extends MainController {

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
        // add account balance
        double newbalance = Double.parseDouble(DTextField.getText());
        BalanceLabel.setText(String.valueOf(newbalance));
    }

    @FXML
    void WithdrawalButtonClicked(ActionEvent event) {
        // add account balance and conditions
        // double balance-=Double.parseDouble(DTextField.getText());
        double newbalance = -Double.parseDouble(DTextField.getText());
        BalanceLabel.setText(String.valueOf(newbalance));
    }
}
