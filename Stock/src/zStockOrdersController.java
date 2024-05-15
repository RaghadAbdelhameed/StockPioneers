import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class zStockOrdersController extends MainController {

    // private User user;
    // private RegularUser regularUser;
    private Admin admin; 
    // private RegularUser currentUser; 
    private Stock stock; 

     // Stock Orders
     @FXML
     private Button searchLabelButton;
 
     @FXML
     private TextField searchLabelField;
 
     @FXML
     void searchLabelClicked(ActionEvent event) {
         String label = searchLabelField.getText();
         stock.setLabel(label);
         admin.listByLabel(label);
     }
}
