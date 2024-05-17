import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class zStockOrdersController extends MainController {

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
    private ChoiceBox<?> operationChoiceBox;
 
     @FXML
     void searchLabelClicked(ActionEvent event) {
         String label = searchLabelField.getText();
         Operation operation= operationChoiceBox.getValue();
         transaction.setOpType(operation);
         stock.setLabel(label);
         regularUser.listStockOrders(label,transaction);
     }

}
