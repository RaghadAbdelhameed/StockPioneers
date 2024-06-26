import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class zAdminApprovalController extends MainController implements Initializable {
    private Admin admin;
    private RegularUser regularUser;
    private Transaction transaction;
    private List<RegularUser> users = CSV.getUsers();
    private List<Transaction> pendingransactions = CSV.getPendingTransaction();
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
        admin = Admin.getInstance("ahmed", "Ahmed");
        regularUser = users.get(zUserController.index);
        transaction = pendingransactions.get(0);
        String name = userName1Label.getText();
        if (pendingransactions.size() > 0) {
            if (name == null || name.isEmpty()) {
                return;
            }
            double account = Double.parseDouble(Account1Label.getText());
            double amount = Double.parseDouble(amount1Label.getText());
            Operation operation = Operation.valueOf(operation1Label.getText());
            regularUser.setUserName(name);
            regularUser.setAccountBalance(account);
            if (operation == Operation.deposit) {
                admin.approveDeposit(regularUser, amount, transaction, 0);
            } else if (operation == Operation.withdrawal) {
                admin.approveWithdrawal(regularUser, amount, transaction, 0);
            }
            userName1Label.setText("");
            Account1Label.setText("");
            amount1Label.setText("");
            operation1Label.setText("");
            initialize(null, null);
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
        admin = Admin.getInstance("ahmed", "Ahmed");
        regularUser = users.get(zUserController.index);
        transaction = pendingransactions.get(1);
        String name = userName2Label.getText();
        if (pendingransactions.size() > 1) {
            if (name == null || name.isEmpty()) {
                return;
            }
            double account = Double.parseDouble(Account2Label.getText());
            double amount = Double.parseDouble(amount2Label.getText());
            Operation operation = Operation.valueOf(operation2Label.getText());
            regularUser.setUserName(name);
            regularUser.setAccountBalance(account);
            if (operation == Operation.deposit) {
                admin.approveDeposit(regularUser, amount, transaction, 1);
            } else if (operation == Operation.withdrawal) {
                admin.approveWithdrawal(regularUser, amount, transaction, 1);
            }
            userName2Label.setText("");
            Account2Label.setText("");
            amount2Label.setText("");
            operation2Label.setText("");
            initialize(null, null);
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
        admin = Admin.getInstance("ahmed", "Ahmed");
        regularUser = users.get(zUserController.index);
        transaction = pendingransactions.get(2);
        String name = userName3Label.getText();
        if (pendingransactions.size() > 2) {
            if (name == null || name.isEmpty()) {
                return;
            }
            double account = Double.parseDouble(Account3Label.getText());
            double amount = Double.parseDouble(amount3Label.getText());
            Operation operation = Operation.valueOf(operation3Label.getText());
            regularUser.setUserName(name);
            regularUser.setAccountBalance(account);
            if (operation == Operation.deposit) {
                admin.approveDeposit(regularUser, amount, transaction, 2);
            } else if (operation == Operation.withdrawal) {
                admin.approveWithdrawal(regularUser, amount, transaction, 2);
            }
            userName3Label.setText("");
            Account3Label.setText("");
            amount3Label.setText("");
            operation3Label.setText("");
            initialize(null, null);
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        users = CSV.getUsers();
        pendingransactions = CSV.getPendingTransaction();
        for (int i = 0; i < pendingransactions.size(); i++) {
            Transaction transaction = pendingransactions.get(i);
            RegularUser user = users.get(transaction.getUserId() - 1);
            switch (i + 1) {
                case 1:
                    userName1Label.setText(user.getUserName());
                    Account1Label.setText(String.valueOf(user.getAccountBalance()));
                    amount1Label.setText(String.valueOf(transaction.getAmount()));
                    operation1Label.setText(String.valueOf(transaction.getOpType()));
                    break;
                case 2:
                    userName2Label.setText(user.getUserName());
                    Account2Label.setText(String.valueOf(user.getAccountBalance()));
                    amount2Label.setText(String.valueOf(transaction.getAmount()));
                    operation2Label.setText(String.valueOf(transaction.getOpType()));
                    break;
                case 3:
                    userName3Label.setText(user.getUserName());
                    Account3Label.setText(String.valueOf(user.getAccountBalance()));
                    amount3Label.setText(String.valueOf(transaction.getAmount()));
                    operation3Label.setText(String.valueOf(transaction.getOpType()));
                    break;
                default:
                    break;
            }
        }
    }
}