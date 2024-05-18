import java.time.LocalDateTime;
import java.util.List;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class zAdminPriceController extends MainController {

    private User user;
    // private StockPrice stockPrice;
    // private RegularUser regularUser;
    // private Admin admin;
    // private RegularUser currentUser;
    // private Stock stock;

    // public void setStockPrice(StockPrice stockPrice) {
    // this.stockPrice = stockPrice; // Reference to the Admin instance
    // }

    // Price History
    @FXML
    private Button searchAdminPriceLabelButton;

    @FXML
    private TextField searchAdminPriceLabelField;

    @FXML
    private TableView<StockPrice> adminPriceTableView;

    @FXML
    private TableColumn<StockPrice, Double> priceColumn;

    @FXML
    private TableColumn<StockPrice, LocalDateTime> priceTimeColumn;

    public void admininitialize() {
        // Bind columns to corresponding properties
        priceColumn
                .setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrice()).asObject());
        priceTimeColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPriceTime()));
    }

    @FXML
    void searchAdminPriceLabelClicked(ActionEvent event) {
        String priceLabel = searchAdminPriceLabelField.getText();
        if (priceLabel == null || priceLabel.isEmpty()) {
            // Show an error message if the label is empty
            showErrorDialog("Error", "Please enter a valid stock label.");
            return;
        }

        // Assuming stockPrice is set properly before invoking this method
        List<StockPrice> priceHistory = user.retrieveStockPriceHistory(priceLabel);
        if (priceHistory == null || priceHistory.isEmpty()) {
            // Show a message if no price history is found
            showErrorDialog("Error", "No price history found for label: " + priceLabel);
            return;
        }

        // Set the items of the TableView
        ObservableList<StockPrice> data = FXCollections.observableArrayList(priceHistory);
        adminPriceTableView.setItems(data);
    }

}
