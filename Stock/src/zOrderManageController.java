import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class zOrderManageController extends MainController {
    // private User user;
    private RegularUser regularUser;
    // private Admin admin;
    // private RegularUser currentUser;
    // private Stock stock;

    // Order Management
    @FXML
    private Button buyStockButton;

    @FXML
    private Button sellStockButton;

    @FXML
    void buyStockClicked(ActionEvent event) {
        loadFXML("BuyStock.fxml", buyStockButton, "Buy Stock");
    }

    @FXML
    void sellStockClicked(ActionEvent event) {
        loadFXML("SellStock.fxml", sellStockButton, "Sell Stock");
    }

    // Buy Stock
    @FXML
    private Button buyButton;

    @FXML
    private TextField stockBuyCompanyField;

    @FXML
    private TextField stockBuyLabelField;

    @FXML
    private TextField stockMaxPriceField;

    @FXML
    private TextField stockBuyAmountField;

    @FXML
    void buyClicked(ActionEvent event) {
        String label = stockBuyLabelField.getText();
        String company = stockBuyCompanyField.getText();
        int amount = Integer.parseInt(stockBuyAmountField.getText());
        double maxPrice = Double.parseDouble(stockMaxPriceField.getText());
        System.out.println(label + "  " + company + "  " + maxPrice + "  " + amount);
        try {
            (regularUser).buyStockOrder(label, company, maxPrice, amount);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input. You must enter a digit in max.price field");
        }
    }

    // Sell Stock
    @FXML
    private Button sellButton;

    @FXML
    private TextField stockMinPriceField;

    @FXML
    private TextField stockSellCompanyField;

    @FXML
    private TextField stockSellLabelField;

    @FXML
    private TextField stockSellAmountField;

    @FXML
    void sellClicked(ActionEvent event) {
        String label = stockSellLabelField.getText();
        String company = stockSellCompanyField.getText();
        int amount = Integer.parseInt(stockSellAmountField.getText());
        double minPrice = Double.parseDouble(stockMinPriceField.getText());
        System.out.println(label + "  " + company + "  " + minPrice + "  " + amount);
        try {
            (regularUser).sellStockOrder(label, company, minPrice, amount);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input. You must enter a digit in min.price field");
        }
    }
}
