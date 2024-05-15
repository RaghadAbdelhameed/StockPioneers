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
    void buyClicked(ActionEvent event) {
        String label = stockBuyLabelField.getText();
        String company = stockBuyCompanyField.getText();
        double maxPrice = Double.parseDouble(stockMaxPriceField.getText());
        System.out.println(label + "  " + company + "  " + maxPrice);
        try {
            (regularUser).buyStockOrder(maxPrice, label, company);
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
    void sellClicked(ActionEvent event) {
        String label = stockSellLabelField.getText();
        String company = stockSellCompanyField.getText();
        double minPrice = Double.parseDouble(stockMinPriceField.getText());
        System.out.println(label + "  " + company + "  " + minPrice);
        try {
            (regularUser).sellStockOrder(label, company, minPrice);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input. You must enter a digit in min.price field");
        }
    }
}
