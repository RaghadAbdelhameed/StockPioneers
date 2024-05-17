import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class zStockOrdersController extends MainController implements Initializable{

    // private User user;
    private RegularUser regularUser;
    private Stock stock; 
    private Transaction transaction;

     // Stock Orders
     @FXML
     private Button searchLabelButton;
 
     @FXML
     private TextField searchLabelField;

      @FXML
    private ChoiceBox<Operation> operationChoiceBox;
 
     @FXML
     void searchLabelClicked(ActionEvent event) {
         String label = searchLabelField.getText();
         Operation operation= operationChoiceBox.getValue();
         transaction.setOpType(operation);
         stock.setLabel(label);
         regularUser.listStockOrders(label,transaction);
     }
     @Override
     public void initialize(URL arg0, ResourceBundle arg1) {
         // setLabelText();
         if (operationChoiceBox == null) {
        	 operationChoiceBox = new ChoiceBox<>();
         }
         operationChoiceBox.getItems().addAll(Operation.buy,Operation.sell,Operation.deposit,Operation.withdrawal);

     }

}
