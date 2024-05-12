
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

    @FXML
    private PasswordField adminPasswordField;

    @FXML
    private TextField adminUsernameField;

    @FXML
    private Button backButton;

    @FXML
    private Button adminLoginButton;

    @FXML
    void handleAdminPasswordInput(ActionEvent event) {
        String password = adminPasswordField.getText();
        System.out.println("Password entered: " + password);
    }

    @FXML
    void handleAdminUsernamInput(ActionEvent event) {
        String username = adminUsernameField.getText();
        System.out.println("Username entered: " + username);
    }

    @FXML
    void adminLoginButtonClicked(ActionEvent event) {
        loadFXML("AdminUI.fxml", adminLoginButton, "Admin Dashboard");
    }

    @FXML
    void backButtonClicked() {
        System.out.println("Going Back to Login Page...");
        loadFXML("NewLogin.fxml", backButton, "Login Page");
    }

    // Admin UI
    @FXML
    private Button adminLogoutButton;

    @FXML
    private Button userManageButton;

    @FXML
    private Button stockManageButton;

    @FXML
    private Button stockorderButton;

    @FXML
    private Button priceHistoryButton;

    @FXML
    private Button sessionsButton;

    @FXML
    void adminLogoutButtonClicked(ActionEvent event) {
        // Create a confirmation alert
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure that you want to Logout?");

        // Customize the buttons
        ButtonType yesButton = new ButtonType("Yes");
        ButtonType noButton = new ButtonType("No");

        alert.getButtonTypes().setAll(yesButton, noButton);

        // Show the alert and wait for user response
        Optional<ButtonType> result = alert.showAndWait();

        // Check which button the user clicked
        if (result.isPresent() && result.get() == yesButton) {
            loadFXML("AdminLogin.fxml", adminLogoutButton, "Admin Login");
        }
    }

    @FXML
    void userManageClicked(ActionEvent event) {
        loadFXML("UserManage.fxml", userManageButton, "User Management");
    }

    @FXML
    void stockManageClicked(ActionEvent event) {
        loadFXML("StockManage.fxml", stockManageButton, "Stock Management");
    }

    @FXML
    void stockorderClicked(ActionEvent event) {
        loadFXML("StockOrders.fxml", stockorderButton, "Stock Orders");
    }

    @FXML
    void priceHistoryClicked(ActionEvent event) {
        loadFXML("AdminPriceHistory.fxml", priceHistoryButton, "Price History");
    }

    @FXML
    void sessionsButtonClicked(ActionEvent event) {
        loadFXML("TradingSessions.fxml", sessionsButton, "Trading Sessions Control");
    }

    // User Management
    @FXML
    private Button createUserButton;

    @FXML
    private Button updateUserButton;

    @FXML
    private Button deleteUserButton;

    @FXML
    private Button retriveUserButton;

    @FXML
    void createUserClicked(ActionEvent event) {
        loadFXML("CreateUser.fxml", createUserButton, "Create User");
    }

    @FXML
    void updateUserClicked(ActionEvent event) {
        loadFXML("UpdateUser.fxml", updateUserButton, "Update User");
    }

    @FXML
    void deleteUserClicked(ActionEvent event) {
        loadFXML("DeleteUser.fxml", deleteUserButton, "Delete User");
    }

    @FXML
    void retriveUserClicked(ActionEvent event) {
        loadFXML("RetriveUser.fxml", retriveUserButton, "Retrive User");
    }

    // Create User
    private User user;
    private RegularUser regularUser;

    @FXML
    private TextField createUsernamefiled;

    @FXML
    private PasswordField createPasswordfiled;

    @FXML
    private TextField createAccountBalancefiled;

    @FXML
    private TextField createIDfiled;

    // @FXML
    // private ChoiceBox<?> createGenderBox;

    @FXML
    private Button saveCreateButton;

    @FXML
    void saveCreateClicked(ActionEvent event) {
        String username = createUsernamefiled.getText();
        String password = createPasswordfiled.getText();
        int id = Integer.parseInt(createIDfiled.getText());
        double balance = Double.parseDouble(createAccountBalancefiled.getText());
        currentUser.setID(id);
        currentUser.setUserName(username);
        currentUser.setPassword(password);
        currentUser.setAccountBalance(balance);
        admin.createUser(currentUser);
        String gender = genderChoicebox.getValue(); // Assuming you've populated the
        // choice box with appropriate values
        System.out.println(username + "  " + password + "  " + id + "  " + balance);

    }

    // Update User
    private Admin admin; // Admin instance to interact with business logic
    private RegularUser currentUser; // User object for creating or updating users

    public void setUser(RegularUser user) {
        this.currentUser = user; // Reference to the Admin instance
    }

    public void setAdmin(Admin admin) {
        this.admin = admin; // Reference to the Admin instance
    }

    @FXML
    private TextField UpdateAccountBalancefield;

    @FXML
    private TextField UpdateIDfield;

    @FXML
    private PasswordField UpdatePasswordfield;

    @FXML
    private TextField UpdateUsernsamefield;

    @FXML
    private Button updateButton;

    @FXML
    void updateClicked(ActionEvent event) {
        {
            String username = UpdateUsernsamefield.getText();
            double accountBalance = Double.parseDouble(UpdateAccountBalancefield.getText());
            int id = Integer.parseInt(UpdateIDfield.getText());
            // gender gender = currentUser.gender();

            currentUser.setID(id);
            currentUser.setUserName(username);
            currentUser.setAccountBalance(accountBalance);
            admin.updateUser(currentUser);

            System.out.println(id + "  " + username + "  " + accountBalance);

            // Create a new User object with the updated information
            // RegularUser updatedUser = new RegularUser(username, password, id,
            // accountBalance,
            // gender);
            // // Call the updateUser method of the Admin class
            // admin.updateUser(updatedUser);
        }
    }

    // delete user

    @FXML
    private Button deleteButton;

    @FXML
    private TextField searchIDfield;

    // @FXML
    // private Label searchResult;

    @FXML
    private Button searhButton;

    @FXML
    void deleteClicked(ActionEvent event) {
        int searchid = Integer.parseInt(searchIDfield.getText());
        try {
            currentUser.setID(searchid);
            // Call the updateUser method of the Admin class with the retrieved id
            admin.deleteUser(searchid);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input. You must enter a digit.");
        }
    }

    @FXML
    void searchClicked(ActionEvent event) {
        // admin.accessUser(searchid);
        // for (User user : Users) {
        // if (user.getID() == searchid) {
        // return currentUser; // return a new User object
        // }
        // }
        // System.out.println(" User Not Found ");
        // return null; // return nothing
    }

    // Retrive User

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
    private Stock stock; // User object for creating or updating users

    public void setStock(Stock stock) {
        this.stock = stock; // Reference to the Admin instance
    }

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
        admin.deleteStock(label);

    }

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

    // Price History
    public void setStockPrice(StockPrice stockPrice) {
        this.stockPrice = stockPrice; // Reference to the Admin instance
    }

    private StockPrice stockPrice;

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

    private void showErrorDialog(String title, String message) {
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

    // User Login
    @FXML
    private Button loginUserButton;

    @FXML
    private Hyperlink signupLink;

    @FXML
    void loginUserClicked(ActionEvent event) {
        loadFXML("UserFeatures.fxml", loginUserButton, "User Dashboard");

    }

    @FXML
    void handleSignupClicked(ActionEvent event) {
        loadFXML("UserSignup.fxml", signupLink, "User Signup");
    }

    // User Signup

    @FXML
    private TextField emailField;

    // @FXML
    // private DatePicker birthPicker;

    @FXML
    private Button logoutUserButton;

    @FXML
    private ChoiceBox<String> genderChoicebox;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        //setLabelText();
        if (genderChoicebox == null) {
            genderChoicebox = new ChoiceBox<>();
        }
        genderChoicebox.getItems().addAll("Male", "Female");

    }

    // User Features
    @FXML
    private Button orderManageButton;

    @FXML
    private Button userPriceHistoryButton;

    @FXML
    void orderManageClicked(ActionEvent event) {
        loadFXML("OrderManage.fxml", orderManageButton, "Order Management");
    }

    @FXML
    void userPriceHistoryClicked(ActionEvent event) {
        loadFXML("UserPriceHistory.fxml", userPriceHistoryButton, "Price History");
    }

    // Order Management
    @FXML
    private Button buyStockButton;

    @FXML
    private Button sellStockButton;

    @FXML
    private Button DepositWithdrawalButton;

    @FXML
    void buyStockClicked(ActionEvent event) {
        loadFXML("BuyStock.fxml", buyStockButton, "Buy Stock");
    }

    @FXML
    void DepositWithdrawalButtonClicked() {
        loadFXML("withdrawal.fxml", DepositWithdrawalButton, "Deposite and Withdrawal");
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
        //userPriceTableView.setItems(pricedata);
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

    @FXML
    void logoutUserClicked(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure that you want to Logout?");

        // Customize the buttons
        ButtonType yesButton = new ButtonType("Yes");
        ButtonType noButton = new ButtonType("No");

        alert.getButtonTypes().setAll(yesButton, noButton);

        // Show the alert and wait for user response
        Optional<ButtonType> result = alert.showAndWait();

        // Check which button the user clicked
        if (result.isPresent() && result.get() == yesButton) {
            loadFXML("UserLogin.fxml", logoutUserButton, "User Login");
        }
    }

    private void loadFXML(String fxmlFileName, Hyperlink link, String title) {
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

    private void loadFXML(String fxmlFileName, Button button, String title) {
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
    private Button PHBackButton;
    @FXML
    void PHBackButtonClicked(ActionEvent event) {
    	loadFXML("AdminUI.fxml",PHBackButton,"Admin Dashboard");
    }
    @FXML
    private Button BSBackButton;
    @FXML
    void BSBackButtonClicked(ActionEvent event) {
    	loadFXML("OrderManage.fxml",BSBackButton,"Order Management");
    }
    @FXML
    private Button CSBackButton;
    @FXML
    void CSBackButtonClicked(ActionEvent event) {
    	loadFXML("StockManage.fxml",CSBackButton,"Stock Management");
    }
    @FXML
    private Button DSBackButton;
    @FXML
    void DSBackButtonClicked(ActionEvent event) {
    	loadFXML("StockManage.fxml",DSBackButton,"Stock Management");
    }
    @FXML
    private Button DUBackButton;
    @FXML
    void DUBackButtonClicked(ActionEvent event) {
    	loadFXML("UserManage.fxml",DUBackButton,"User Management");
    }
    @FXML
    private Button OMBackButton;
    @FXML
    void OMBackButtonClicked(ActionEvent event) {
    	loadFXML("UserFeatures.fxml",OMBackButton,"User Dashboard");
    }
    @FXML
    private Button RSBackButton;
    @FXML
    void RSBackButtonClicked(ActionEvent event) {
    	loadFXML("StockManage.fxml",RSBackButton,"Stock Management");
    }
    @FXML
    private Button RUBackButton;
    @FXML
    void RUBackButtonClicked(ActionEvent event) {
    	loadFXML("UserManage.fxml",RUBackButton,"User Management");
    }
    @FXML
    private Button SSBackButton;
    @FXML
    void SSBackButtonClicked(ActionEvent event) {
    	loadFXML("OrderManage.fxml",SSBackButton,"Order Management");
    }
    @FXML
    private Button SMBackButton;
    @FXML
    void SMBackButtonClicked(ActionEvent event) {
    	loadFXML("AdminUI.fxml",SMBackButton,"Admin Dashboard");
    }
    @FXML
    private Button SOBackButton;
    @FXML
    void SOBackButtonClicked(ActionEvent event) {
    	loadFXML("AdminUI.fxml",SOBackButton,"Admin Dashboard");
    }
    @FXML
    private Button USBackButton;
    @FXML
    void USBackButtonClicked(ActionEvent event) {
    	loadFXML("StockManage.fxml",USBackButton,"Stock Management");
    }
    @FXML
    private Button UUBackButton;
    @FXML
    void UUBackButtonClicked(ActionEvent event) {
    loadFXML("UserManage.fxml",UUBackButton,"User Management");
    }	
    @FXML
    private Button UMBackButton;
    @FXML
    void UMBackButtonClicked(ActionEvent event) {
    	loadFXML("AdminUI.fxml",UMBackButton,"Admin Dashboard");
    } 
    @FXML
    private Button UPHBackButton;
    @FXML
    void UPHBackButtonClicked(ActionEvent event) {
    	loadFXML("UserFeatures.fxml",UPHBackButton,"User Dashboard");
    }
    @FXML
    private Button CUBackButton;
    @FXML
    void CUBackButtonClicked(ActionEvent event) {
    loadFXML("UserManage.fxml",CUBackButton,"User Management");
    }	
}