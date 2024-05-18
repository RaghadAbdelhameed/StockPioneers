import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class zAdminApprovalController extends MainController {
    private Admin admin;
    private RegularUser regularUser;
    private Transaction transaction;
    
    @FXML
    private Button SOBackButton;

    @FXML
    void SOBackButtonClicked(ActionEvent event) {
        loadFXML("AdminUI.fxml", SOBackButton, "Admin Features");
    }

    @FXML
    private Button approveRow1Button;

    @FXML
    private Label Account1Label;

    @FXML
    private Label amount1Label;

    @FXML
    private Label operation1Label;

    @FXML
    private Label userName1Label;

    @FXML
    void approveRow1Clicked(ActionEvent event) {
        String name= userName1Label.getText();
        double account = Double.parseDouble(Account1Label.getText());
        int amount = Integer.parseInt(amount1Label.getText());
        Operation operation = Operation.valueOf(operation1Label.getText());
        regularUser.setUserName(name);
        regularUser.setAccountBalance(account);
        transaction.setOpType(operation);
        if (operation == Operation.deposit) {
            admin.approveDeposit(regularUser, amount, transaction);
        } else if (operation == Operation.withdrawal) {
            admin.approveWithdrawal(regularUser, amount, transaction);
        }
    }

    @FXML
    private Label Account2Label;

    @FXML
    private Label amount2Label;

    @FXML
    private Label operation2Label;

    @FXML
    private Label userName2Label;

    @FXML
    private Button approveRow2Button;

    @FXML
    void approveRow2Clicked(ActionEvent event) {
        String name= userName2Label.getText();
        double account = Double.parseDouble(Account2Label.getText());
        int amount = Integer.parseInt(amount2Label.getText());
        Operation operation = Operation.valueOf(operation2Label.getText());
        regularUser.setUserName(name);
        regularUser.setAccountBalance(account);
        transaction.setOpType(operation);
        if (operation == Operation.deposit) {
            admin.approveDeposit(regularUser, amount, transaction);
        } else if (operation == Operation.withdrawal) {
            admin.approveWithdrawal(regularUser, amount, transaction);
        }
    }

    @FXML
    private Label userName3Label;

    @FXML
    private Label Account3Label;

    @FXML
    private Label amount3Label;

    @FXML
    private Label operation3Label;

    @FXML
    private Button approveRow3Button;

    @FXML
    void approveRow3Clicked(ActionEvent event) {
        String name= userName3Label.getText();
        double account = Double.parseDouble(Account3Label.getText());
        int amount = Integer.parseInt(amount3Label.getText());
        Operation operation = Operation.valueOf(operation3Label.getText());
        regularUser.setUserName(name);
        regularUser.setAccountBalance(account);
        transaction.setOpType(operation);
        if (operation == Operation.deposit) {
            admin.approveDeposit(regularUser, amount, transaction);
        } else if (operation == Operation.withdrawal) {
            admin.approveWithdrawal(regularUser, amount, transaction);
        }
    }


}
