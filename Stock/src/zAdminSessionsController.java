import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class zAdminSessionsController extends MainController implements Initializable {
    protected Admin admin;
    private TradingManager tradingManager;
    private LocalDateTime closeTime;
    protected boolean isOpen = false;
    private LocalDateTime openTime;

    @FXML
    private Button closeButton;

    @FXML
    void closeClicked(ActionEvent event) {
        loadFXML("Thankyou.fxml", closeButton, "THANKYOU!!!!!");
        admin = Admin.getInstance("rawan", "rawan55");
        admin.closeTradingSession();

    }

    @FXML
    private Label closeSessionLabel = new Label();

    @FXML
    protected Button initiateButton;

    @SuppressWarnings("static-access")
    @FXML
    void intiateClicked(ActionEvent event) {
        tradingManager = new TradingManager();
        admin = Admin.getInstance("", "");
        admin.initiateTradingSession();
        loadFXML("TradingSessionsClose.fxml", initiateButton, "Trading Sessions");

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        closeSessionLabel.setText("This Session opened at " + String.valueOf(LocalDateTime.now()));
    }

}
