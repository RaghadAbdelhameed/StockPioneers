import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class zUserPriceController extends MainController{
    private User user;
    // private RegularUser regularUser;
    // private Admin admin;
    // private RegularUser currentUser;
    // private Stock stock; 

    // Price History
    @FXML
    private Button searchUserPriceLabelButton;

    @FXML
    private TextField searchUserPriceLabelField;

    @FXML
    private TableView<?> userPriceTableView;

    @FXML
    private TableColumn<StockPrice, Double> userpriceColumn;

    @FXML
    private TableColumn<StockPrice, LocalDateTime> userpriceTimeColumn;

    public void userinitialize() {
        // Bind columns to corresponding properties
        userpriceColumn
                .setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrice()).asObject());
        userpriceTimeColumn
                .setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPriceTime()));
    }

    @FXML
    void searchUserPriceLabelClicked(ActionEvent event) {
        String priceLabel = searchUserPriceLabelField.getText();
        if (priceLabel == null || priceLabel.isEmpty()) {
            // Show an error message if the label is empty
            showErrorDialog("Error", "Please enter a valid stock label.");
            return;
        }
        List<StockPrice> priceHistory = user.retrieveStockPriceHistory(priceLabel);
        if (priceHistory == null || priceHistory.isEmpty()) {
            // Show a message if no price history is found
            showErrorDialog("Error", "No price history found for label: " + priceLabel);
            return;
        }
        ObservableList<StockPrice> pricedata = FXCollections.observableArrayList(priceHistory);
        userPriceTableView.setItems(pricedata);
    }
    
}
