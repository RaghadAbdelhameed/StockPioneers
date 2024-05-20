import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import java.io.IOException;

public class zPremiumController extends MainController {

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
                loadFXML("PremiumCharts.fxml", subscribeButton, "Premium User");

                // Show Notifications when Subscribed is Confirmed
                Stage notificationStage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Notification.fxml"));
                Parent root;
                try {
                    root = loader.load();
                    Scene scene = new Scene(root);
                    notificationStage.setScene(scene);
                    notificationStage.setTitle("Notifications");
                    notificationStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @FXML
    private Button BackButton;

    @FXML
    void BackButtonClicked(ActionEvent event) {
        loadFXML("UserFeatures.fxml", BackButton, "User Features");
    }

}
