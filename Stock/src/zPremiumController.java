import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

public class zPremiumController extends MainController {
    private MarketPerformanceTracker marketPerformanceTracker;
    private User user;
    private Observer observer;
    private PremiumUser premiumUser;

    @FXML
    private Button subscribeButton;

    @FXML
    void subscribeClicked(ActionEvent event) {
        // observer.update(user);
        // marketPerformanceTracker.subscribe(observer);

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
                // Show Notification.fxml over PremiumUser2.fxml
                Stage notificationStage = new Stage();
                // notificationStage.initStyle(StageStyle.UNDECORATED);
                // notificationStage.initModality(Modality.APPLICATION_MODAL);

                FXMLLoader loader = new FXMLLoader(getClass().getResource("Notification.fxml"));
                Parent root;
                try {
                    root = loader.load();
                    Scene scene = new Scene(root);
                    notificationStage.setScene(scene);
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

    @FXML
    private Button chartingButton;

    @FXML
    void chartingClicked(ActionEvent event) {
        loadFXML("Charts.fxml", chartingButton, "Charting Options");
    }

    @FXML
    private Button unsubscribeButton;

    @FXML
    private TextField stockLabelField;

    @FXML
    void unsubscribeClicked(ActionEvent event) {
        // observer.update(user);
        // marketPerformanceTracker.unsubscribe(observer);
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
