
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

public class zStockManageController extends MainController{
    
    // private User user;
    // private RegularUser regularUser;
    private Admin admin; 
    // private RegularUser currentUser; 
    private Stock stock; 
    
    // public void setStock(Stock stock) {
    //     this.stock = stock; // Reference to the Admin instance
    // }
    
    // Stock Management
    @FXML
    private Button createStockButton;

    @FXML
    private Button retriveStockButton;

    @FXML
    private Button updateStockButton;

    @FXML
    private Button deleteStockButton;

    @FXML
    void createStockClicked(ActionEvent event) {
        loadFXML("CreateStock.fxml", createStockButton, "Create Stock");
    }

    @FXML
    void retriveStockClicked(ActionEvent event) {
        loadFXML("RetrieveStock.fxml", retriveStockButton, "Retrive Stock");
    }

    @FXML
    void updateStockClicked(ActionEvent event) {
        loadFXML("UpdateStock.fxml", updateStockButton, "Update Stock");
    }

    @FXML
    void deleteStockClicked(ActionEvent event) {
        loadFXML("DeleteStock.fxml", deleteStockButton, "Delete Stock");
    }

    // Create Stock

    @FXML
    private TextField createAvailableStocksField;

    @FXML
    private TextField createDividendsField;

    @FXML
    private TextField createInitialPriceField;

    @FXML
    private TextField createProfitPercentageField;

    @FXML
    private TextField createStockCompanyField;

    @FXML
    private TextField createStockLabelField;

    @FXML
    private TextField createTradingPriceField;

    @FXML
    private Button stockCreateButton;

    @FXML
    void stockCreateClicked(ActionEvent event) {
        String label = createStockLabelField.getText();
        String company = createStockCompanyField.getText();
        double initialPrice = Double.parseDouble(createInitialPriceField.getText());
        double tradingPrice = Double.parseDouble(createTradingPriceField.getText());
        double dividends = Double.parseDouble(createDividendsField.getText());
        double profitPercentage = Double.parseDouble(createProfitPercentageField.getText());
        int availableStocks = Integer.parseInt(createAvailableStocksField.getText());
        stock.setLabel(label);
        stock.setCompany(company);
        stock.setInitialPrice(initialPrice);
        stock.setTradingPrice(tradingPrice);
        stock.setDividends(dividends);
        stock.setProfitPercentage(profitPercentage);
        stock.setAvailableStocks(availableStocks);
        admin.createStock(stock);
    }

    // Update Stock
    @FXML
    private Button searchStockButton;

    @FXML
    private Button stockUpdateButton;

    @FXML
    private TextField updateAvailableStocksField;

    @FXML
    private TextField updateDividendsField;

    @FXML
    private TextField updateInitialPriceField;

    @FXML
    private TextField updateProfitPercentageField;

    @FXML
    private TextField updateStockCompanyField;

    @FXML
    private TextField updateStockLabelField;

    @FXML
    private TextField updateTradingPriceField;

    @FXML
    void searchStockClicked(ActionEvent event) {
    }

    @FXML
    void stockUpdateClicked(ActionEvent event) {
        String label = createStockLabelField.getText();
        String company = createStockCompanyField.getText();
        double initialPrice = Double.parseDouble(createInitialPriceField.getText());
        double tradingPrice = Double.parseDouble(createTradingPriceField.getText());
        double dividends = Double.parseDouble(createDividendsField.getText());
        double profitPercentage = Double.parseDouble(createProfitPercentageField.getText());
        int availableStocks = Integer.parseInt(createAvailableStocksField.getText());
        stock.setLabel(label);
        stock.setCompany(company);
        stock.setInitialPrice(initialPrice);
        stock.setTradingPrice(tradingPrice);
        stock.setDividends(dividends);
        stock.setProfitPercentage(profitPercentage);
        stock.setAvailableStocks(availableStocks);
        admin.updateStock(stock);
    }

    // Delete Stock
    @FXML
    private Button stockDeleteButton;

    @FXML
    private TextField searchLabelfield;

    @FXML
    void stockDeleteClicked(ActionEvent event) {
        String label = searchLabelfield.getText();
        stock.setLabel(label);
        admin.deleteStock(stock);
    }
}
