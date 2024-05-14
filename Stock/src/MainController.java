
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
//import java.lang.classfile.Label;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    // New Login
    @FXML
    private Button adminButton;

    @FXML
    private Button userButton;

    @FXML
    void adminButtonClicked() {
        // Handle admin button click
        System.out.println("Logging in as Admin.... ");
        loadFXML("AdminLogin.fxml", adminButton, "Admin Login");
    }

    @FXML
    void userButtonClicked() {
        // Handle user button click
        System.out.println("Logging in as User.... ");
        loadFXML("UserLogin.fxml", userButton, "User Login");
    }

    protected void showErrorDialog(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Trading Sessions Control
    @FXML
    private Button initiateButton;

    @FXML
    void intiateClicked(ActionEvent event) {

    }


    

    
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

    // Diposit & Withdrawal
    @FXML
    private Button DBackButton;

    @FXML
    void DBackbutonClicked() {
        loadFXML("UserFeatures.fxml", DBackButton, "User Features");
    }

    @FXML
    private static Label BalanceLabel;

    @FXML
    private TextField DTextField;

    @FXML
    private Button WithdrawalButton;

    @FXML
    private Button DepositButton;

    @FXML
    void DepositButtonClicked(ActionEvent event) {
        // add account balance
        double newbalance = Double.parseDouble(DTextField.getText());
        BalanceLabel.setText(String.valueOf(newbalance));
    }

    @FXML
    void WithdrawalButtonClicked(ActionEvent event) {
        // add account balance and conditions
        // double balance-=Double.parseDouble(DTextField.getText());
        double newbalance = -Double.parseDouble(DTextField.getText());
        BalanceLabel.setText(String.valueOf(newbalance));
    }

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

        // Assuming stockPrice is set properly before invoking this method
        List<StockPrice> priceHistory = user.retrieveStockPriceHistory(priceLabel);
        if (priceHistory == null || priceHistory.isEmpty()) {
            // Show a message if no price history is found
            showErrorDialog("Error", "No price history found for label: " + priceLabel);
            return;
        }

        // Set the items of the TableView
        ObservableList<StockPrice> pricedata = FXCollections.observableArrayList(priceHistory);
        // userPriceTableView.setItems(pricedata);
    }

    // // handle errors
    // @FXML
    // private Label balanceError;

    // @FXML
    // private Label emailError;

    // @FXML
    // private Label passwordError;

    // void handleEmailInput() {
    // String email = emailField.getText();
    // if (!email.endsWith("@gmail.com") && !email.endsWith("@yahoo.com") &&
    // !email.endsWith("@hotmail.com")
    // && !email.endsWith("@outlook.com")) {
    // ((Labeled) emailError).setText("Email invalid"); // Assuming emailError is a
    // Label or Tooltip
    // } else {
    // ((Labeled) emailError).setText(""); // Clear the error message if the email
    // is valid

    // }
    // }

    protected void loadFXML(String fxmlFileName, Hyperlink link, String title) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFileName));
            Stage stage = (Stage) link.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void loadFXML(String fxmlFileName, Button button, String title) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFileName));
            Stage stage = (Stage) button.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private ChoiceBox<String> genderChoicebox;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // setLabelText();
        if (genderChoicebox == null) {
            genderChoicebox = new ChoiceBox<>();
        }
        genderChoicebox.getItems().addAll("Male", "Female");

    }

    @FXML
    private Button PHBackButton;

    @FXML
    void PHBackButtonClicked(ActionEvent event) {
        loadFXML("AdminUI.fxml", PHBackButton, "Admin Dashboard");
    }

    @FXML
    private Button BSBackButton;

    @FXML
    void BSBackButtonClicked(ActionEvent event) {
        loadFXML("OrderManage.fxml", BSBackButton, "Order Management");
    }

    @FXML
    private Button CSBackButton;

    @FXML
    void CSBackButtonClicked(ActionEvent event) {
        loadFXML("StockManage.fxml", CSBackButton, "Stock Management");
    }

    @FXML
    private Button DSBackButton;

    @FXML
    void DSBackButtonClicked(ActionEvent event) {
        loadFXML("StockManage.fxml", DSBackButton, "Stock Management");
    }

    @FXML
    private Button DUBackButton;

    @FXML
    void DUBackButtonClicked(ActionEvent event) {
        loadFXML("UserManage.fxml", DUBackButton, "User Management");
    }

    @FXML
    private Button OMBackButton;

    @FXML
    void OMBackButtonClicked(ActionEvent event) {
        loadFXML("UserFeatures.fxml", OMBackButton, "User Dashboard");
    }

    @FXML
    private Button RSBackButton;

    @FXML
    void RSBackButtonClicked(ActionEvent event) {
        loadFXML("StockManage.fxml", RSBackButton, "Stock Management");
    }

    @FXML
    private Button RUBackButton;

    @FXML
    void RUBackButtonClicked(ActionEvent event) {
        loadFXML("UserManage.fxml", RUBackButton, "User Management");
    }

    @FXML
    private Button SSBackButton;

    @FXML
    void SSBackButtonClicked(ActionEvent event) {
        loadFXML("OrderManage.fxml", SSBackButton, "Order Management");
    }

    @FXML
    private Button SMBackButton;

    @FXML
    void SMBackButtonClicked(ActionEvent event) {
        loadFXML("AdminUI.fxml", SMBackButton, "Admin Dashboard");
    }

    @FXML
    private Button SOBackButton;

    @FXML
    void SOBackButtonClicked(ActionEvent event) {
        loadFXML("AdminUI.fxml", SOBackButton, "Admin Dashboard");
    }

    @FXML
    private Button USBackButton;

    @FXML
    void USBackButtonClicked(ActionEvent event) {
        loadFXML("StockManage.fxml", USBackButton, "Stock Management");
    }

    @FXML
    private Button UUBackButton;

    @FXML
    void UUBackButtonClicked(ActionEvent event) {
        loadFXML("UserManage.fxml", UUBackButton, "User Management");
    }

    @FXML
    private Button UMBackButton;

    @FXML
    void UMBackButtonClicked(ActionEvent event) {
        loadFXML("AdminUI.fxml", UMBackButton, "Admin Dashboard");
    }

    @FXML
    private Button UPHBackButton;

    @FXML
    void UPHBackButtonClicked(ActionEvent event) {
        loadFXML("UserFeatures.fxml", UPHBackButton, "User Dashboard");
    }

    @FXML
    private Button CUBackButton;

    @FXML
    void CUBackButtonClicked(ActionEvent event) {
        loadFXML("UserManage.fxml", CUBackButton, "User Management");
    }
}