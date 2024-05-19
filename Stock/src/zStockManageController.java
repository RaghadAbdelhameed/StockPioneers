
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class zStockManageController extends MainController {

    // private User user;
    // private RegularUser regularUser;
    private Admin admin;
    // private RegularUser currentUser;
    private Stock stock;
    private StockPrice stockprice;

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
        stock = new Stock();
        admin = Admin.getInstance("", "");
        stockprice = new StockPrice();
        String label = createStockLabelField.getText();
        String company = createStockCompanyField.getText();
        double initialPrice = Double.parseDouble(createInitialPriceField.getText());
        double tradingPrice = Double.parseDouble(createTradingPriceField.getText());
        double dividends = Double.parseDouble(createDividendsField.getText());
        double profitPercentage = Double.parseDouble(createProfitPercentageField.getText());
        int availableStocks = Integer.parseInt(createAvailableStocksField.getText());
        stock.setLabel(label);
        stock.setCompany(company);
        stockprice.setInitialPrice(initialPrice);
        stockprice.setTradingPrice(tradingPrice);
        stockprice.setDividends(dividends);
        stockprice.setProfitPercentage(profitPercentage);
        stock.setAvailableStocks(availableStocks);
        admin.createStock(stock, stockprice);
    }

    // Update Stock
    @FXML
    private Button searchStockButton;

    @FXML
    private Button stockUpdateButton;

    @FXML
    private TextField updateClosePriceField;

    @FXML
    private TextField updateDividendsField;

    @FXML
    private TextField updateFinalPriceField;

    @FXML
    private TextField updateInitialPriceField;

    @FXML
    private TextField updateOpeningPriceField;

    @FXML
    private TextField updateProfitPercentageField;

    @FXML
    private TextField updateStockLabelField;

    @FXML
    private TextField updateTradingPriceField;
    @FXML
    private Label deleteStockCompany;

    @FXML
    private Label deleteStockLabel;

    @FXML
    private Label deleteStockPrice;

    @FXML
    void searchDeleteStockClicked(ActionEvent event) {
        int index = searchID(searchLabelfield, deleteStockLabel);
        List<Stock> stocks = CSV.getStocks();
        List<StockPrice> stockprices = CSV.getStockPrices();
        if (index >= 0) {
            deleteStockLabel.setTextFill(Color.BLACK);
            deleteStockCompany.setText("Company: " + stocks.get(index).getCompany());
            deleteStockPrice.setText("Stock Price :" + stockprices.get(index).getTradingPrice());
        }
    }

    @FXML
    void stockUpdateClicked(ActionEvent event) {
        stock = new Stock();
        admin = Admin.getInstance("", "");
        stockprice = new StockPrice();
        String label = updateStockLabelField.getText();
        double openingPrice = Double.parseDouble(updateOpeningPriceField.getText());
        double closingPrice = Double.parseDouble(updateClosePriceField.getText());
        double finalPrice = Double.parseDouble(updateFinalPriceField.getText());
        double initialPrice = Double.parseDouble(updateInitialPriceField.getText());
        double tradingPrice = Double.parseDouble(updateTradingPriceField.getText());
        double dividends = Double.parseDouble(updateDividendsField.getText());
        double profitPercentage = Double.parseDouble(updateProfitPercentageField.getText());
        stock.setLabel(label);
        stockprice.setOpeningPrice(openingPrice);
        stockprice.setClosingPrice(closingPrice);
        stockprice.setFinalPrice(finalPrice);
        stockprice.setInitialPrice(initialPrice);
        stockprice.setTradingPrice(tradingPrice);
        stockprice.setDividends(dividends);
        stockprice.setProfitPercentage(profitPercentage);
        admin.updateStock(stock, initialPrice, openingPrice, finalPrice,
                closingPrice, tradingPrice, dividends,
                profitPercentage);
    }

    @FXML
    private Label stocksearchlabel;

    @FXML
    void searchUpdateStockClicked(ActionEvent event) {
        int index = searchID(updateStockLabelField, stocksearchlabel);
        if (index > 0) {
            stocksearchlabel.setOpacity(1);
            stocksearchlabel.setTextFill(Color.BLACK);
            stocksearchlabel.setText("Found");
        }
    }

    // Delete Stock
    @FXML
    private Button stockDeleteButton;

    @FXML
    private TextField searchLabelfield;

    @FXML
    void stockDeleteClicked(ActionEvent event) {
        admin = Admin.getInstance("", "");
        List<Stock> stocks = CSV.getStocks();
        List<StockPrice> stockprices = CSV.getStockPrices();
        int index = searchID(searchLabelfield, deleteStockLabel);
        // stock.setLabel(label);
        if (index >= 0)
            admin.deleteStock(stocks.get(index), stockprices.get(index), index);
    }

    // Retrieve Stock
    @FXML
    private TextField searchRetrieveLabelfield;

    @FXML
    private Button searchRetrieveStockButton;

    @FXML
    private Label RetiveStockAvailable;

    @FXML
    private Label RetriveStockCompany;

    @FXML
    private Label RetriveStockLabel;

    @FXML
    private Label RetriveStockPrice;
    @FXML
    void searchRetriveStockClicked(ActionEvent event) {
          int index= searchID(searchRetrieveLabelfield,RetriveStockLabel);
          List<Stock>stocks=CSV.getStocks();
          List<StockPrice> stockprices= CSV.getStockPrices();
          if (index>=0) {
          RetriveStockLabel.setTextFill(Color.BLACK);
          RetriveStockCompany.setText("Company: " +stocks.get(index).getCompany());
          RetriveStockPrice.setText("Stock Price :"+ stockprices.get(index).getTradingPrice());
          RetiveStockAvailable.setText("Available Stocks: "+ stocks.get(index).getAvailableStocks() );
          }     
    }

    int searchID(TextField stocklabel, Label label) {
        try {
            String stockLabel = stocklabel.getText();
            boolean found = false;
            List<Stock> stocks = CSV.getStocks();
            for (int i = 1; i < stocks.size(); i++) {
                if (stockLabel.equals(stocks.get(i).getLabel())) {
                    label.setOpacity(0);
                    found = true;
                    return i;
                }
            }
            if (!stockLabel.matches("\\d+")) {
                throw new Exception();
            }
            if (!found) {
                label.setTextFill(Color.RED);
                label.setOpacity(1);
                label.setText("Not Found");
            }
        } catch (Exception e) {
            label.setTextFill(Color.RED);
            label.setOpacity(1);
            label.setText("Invalid Input");
            System.out.println(e);
        }
        return -1;
    }
}
