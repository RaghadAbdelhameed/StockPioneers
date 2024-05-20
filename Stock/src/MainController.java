import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
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
    protected ChoiceBox<String> genderChoicebox;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
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