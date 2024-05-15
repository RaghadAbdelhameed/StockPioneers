
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class zStockManageController extends MainController {

    // private User user;
    // private RegularUser regularUser;
    private Admin admin;
    // private RegularUser currentUser;
    private Stock stock;
    
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

    // Retrieve Stock
    @FXML
    private TextField searchRetrieveLabelfield;

    @FXML
    private Button searchRetrieveStockButton;

    @FXML
    void searchRetriveStockClicked(ActionEvent event) {
        String label = searchRetrieveLabelfield.getText();
        stock.setLabel(label);
        admin.accessStock(label);
    }
}
