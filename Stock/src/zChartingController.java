import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class zChartingController extends MainController {

	@FXML
	private Button BackButton;

	@FXML
	private Button dayButton;

	@FXML
	private Button monthButton;

	@FXML
	private Button weekButton;

	@FXML
	private Button yearButton;

	@FXML
	private Button unsubscribeButton;

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

	@FXML
	void BackButtonClicked(ActionEvent event) {
		loadFXML("UserFeatures.fxml", BackButton, "Premium User");
	}

	@FXML
	void dayClicked(ActionEvent event) {
		loadFXML("LineChartsDay.fxml", dayButton, "Line Charts");
	}

	@FXML
	void weekClicked(ActionEvent event) {
		loadFXML("LineChartsWeek.fxml", weekButton, "Line Charts");
	}

	@FXML
	void monthClicked(ActionEvent event) {
		loadFXML("LineChartsMonth.fxml", monthButton, "Line Charts");
	}

	@FXML
	void yearClicked(ActionEvent event) {
		loadFXML("LineChartsYear.fxml", yearButton, "Line Charts");
	}

}
