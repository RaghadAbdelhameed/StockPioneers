import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class zAdminSessionsController extends MainController {
    private Admin admin;

    @FXML
    private Button closeButton;

    @FXML
    void closeClicked(ActionEvent event) {
        admin.closeTradingSession();
    }

    @FXML
    private Button initiateButton;

    @FXML
    void intiateClicked(ActionEvent event) {
        admin.initiateTradingSession();

    }
}