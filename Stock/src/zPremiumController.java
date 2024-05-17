import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class zPremiumController<YourController> extends MainController {
    @FXML
    private Button subscribeButton;

    @FXML
    void subscribeClicked(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Subscription");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to subscribe to StockPioneers for $20 per month?");

        // Define actions for Yes and No buttons
        ButtonType buttonTypeYes = new ButtonType("Yes");
        ButtonType buttonTypeNo = new ButtonType("No");
        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

        // Handle user's choice
        alert.showAndWait().ifPresent(buttonType -> {
            if (buttonType == buttonTypeYes) {
                loadFXML("PremiumUser2.fxml", subscribeButton, "Premium User");
            }
        });
    }

    @FXML
    private Button BackButton;

    @FXML
    void BackButtonClicked(ActionEvent event) {
        loadFXML("UserFeatures.fxml", BackButton, "User Features");
    }

    @FXML
    private Button chartingButton;

    @FXML
    void chartingClicked(ActionEvent event) {
        loadFXML("Charts.fxml", chartingButton, "Charting Options");
    }

    @FXML
    private Button unsubscribeButton;

    @FXML
    void unsubscribeClicked(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Unsubscription");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to unsubscribe?");

        // Define actions for Yes and No buttons
        ButtonType buttonTypeYes = new ButtonType("Yes");
        ButtonType buttonTypeNo = new ButtonType("No");
        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

        // Handle user's choice
        alert.showAndWait().ifPresent(buttonType -> {
            if (buttonType == buttonTypeYes) {
                loadFXML("Premium.fxml", unsubscribeButton, "Premium");
            }
        });
    }
}
