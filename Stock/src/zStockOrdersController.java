
// import javafx.beans.property.SimpleDoubleProperty;
// import javafx.beans.property.SimpleObjectProperty;
// import javafx.collections.FXCollections;
// import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
// import javafx.fxml.FXMLLoader;
// import javafx.fxml.Initializable;
// import javafx.scene.Parent;
// import javafx.scene.Scene;
// import javafx.scene.control.Alert;
// import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
// import javafx.scene.control.ButtonType;
// import javafx.scene.control.ChoiceBox;
// import javafx.scene.control.ComboBox;
// import javafx.scene.control.DatePicker;
// import javafx.scene.control.Hyperlink;
// import javafx.scene.control.Label;
// import javafx.scene.control.Labeled;
// import javafx.scene.control.PasswordField;
// import javafx.scene.control.TableColumn;
// import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
// import javafx.scene.paint.Color;
// import javafx.scene.text.Font;
// import javafx.stage.Stage;
// import java.io.IOException;
//import java.lang.classfile.Label;
// import java.net.URL;
// import java.time.LocalDateTime;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;
// import java.util.ResourceBundle;

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
