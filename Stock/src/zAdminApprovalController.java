import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class zAdminApprovalController extends MainController implements Initializable{
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
        admin=Admin.getInstance("ahmed","Ahmed");
       List<RegularUser> users=CSV.getUsers();
       List<Transaction>pendingransactions=CSV.getPendingTransaction();
        regularUser=users.get(zUserController.index);
        transaction=pendingransactions.get(0);
    	String name = userName1Label.getText();
        double account = Double.parseDouble(Account1Label.getText());
        double amount = Double.parseDouble(amount1Label.getText());
        Operation operation = Operation.valueOf(operation1Label.getText());
        regularUser.setUserName(name);
        regularUser.setAccountBalance(account);
       // transaction.setOpType(operation);
        if (operation == Operation.deposit) {
            admin.approveDeposit(regularUser, amount, transaction,0);
        } else if (operation == Operation.withdrawal) {
            admin.approveWithdrawal(regularUser, amount, transaction,0);
        }
        userName1Label.setText("");
    	Account1Label.setText("");
    	amount1Label.setText("");
    	operation1Label.setText("");
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
        String name = userName2Label.getText();
        double account = Double.parseDouble(Account2Label.getText());
        int amount = Integer.parseInt(amount2Label.getText());
        Operation operation = Operation.valueOf(operation2Label.getText());
        regularUser.setUserName(name);
        regularUser.setAccountBalance(account);
        transaction.setOpType(operation);
        if (operation == Operation.deposit) {
            admin.approveDeposit(regularUser, amount, transaction,1);
        } else if (operation == Operation.withdrawal) {
            admin.approveWithdrawal(regularUser, amount, transaction,1);
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
        String name = userName3Label.getText();
        double account = Double.parseDouble(Account3Label.getText());
        int amount = Integer.parseInt(amount3Label.getText());
        Operation operation = Operation.valueOf(operation3Label.getText());
        regularUser.setUserName(name);
        regularUser.setAccountBalance(account);
        transaction.setOpType(operation);
        if (operation == Operation.deposit) {
            admin.approveDeposit(regularUser, amount, transaction,2);
        } else if (operation == Operation.withdrawal) {
            admin.approveWithdrawal(regularUser, amount, transaction,2);
        }
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	List<Transaction> pendingransactions=CSV.getPendingTransaction();
    	List<RegularUser>users=CSV.getUsers();
    	if(pendingransactions.size()>0) {
    	userName1Label.setText(users.get(pendingransactions.get(0).getUserId()-1).getUserName());
    	Account1Label.setText(String.valueOf(users.get(pendingransactions.get(0).getUserId()-1).getAccountBalance()));
    	amount1Label.setText(String.valueOf(pendingransactions.get(0).getAmount()));
    	operation1Label.setText(String.valueOf(pendingransactions.get(0).getOpType()));
    	}
    	if(pendingransactions.size()>1) {
    	userName2Label.setText(users.get(pendingransactions.get(1).getUserId()-1).getUserName());
    	Account2Label.setText(String.valueOf(users.get(pendingransactions.get(1).getUserId()-1).getAccountBalance()));
    	amount2Label.setText(String.valueOf(pendingransactions.get(1).getAmount()));
    	operation2Label.setText(String.valueOf(pendingransactions.get(1).getOpType()));
    	}
    	if(pendingransactions.size()>2) {
    	userName3Label.setText(users.get(pendingransactions.get(2).getUserId()-1).getUserName());
    	Account3Label.setText(String.valueOf(users.get(pendingransactions.get(2).getUserId()-1).getAccountBalance()));
    	amount3Label.setText(String.valueOf(pendingransactions.get(2).getAmount()));
    	operation3Label.setText(String.valueOf(pendingransactions.get(2).getOpType()));
    	}
    }
}
