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
        // tradingManager = new TradingManager();
        admin = Admin.getInstance("rawan", "rawan55");
        admin.closeTradingSession();

        // if (isOpen) {
        // this.closeTime = LocalDateTime.now(); // closing trading session
        // isOpen = false;
        // System.out.println("Trading session closed at " + closeTime);
        // } else {
        // System.out.println(" No trading sessions are currently opened ");
        // }
    }

    @FXML
    private Label closeSessionLabel = new Label();

    @FXML
    protected Button initiateButton;

    @SuppressWarnings("static-access")
    @FXML
    void intiateClicked(ActionEvent event) {
        // admin.getInstance("skaf", "faf", gender.male, tradingManager);
        tradingManager = new TradingManager();
        admin = Admin.getInstance("", "");
        admin.initiateTradingSession();
        // closeSessionLabel.setText(String.valueOf(LocalDateTime.now()));
        loadFXML("TradingSessionsClose.fxml", initiateButton, "Trading Sessions");
        // closeSessionLabel.setText(String.valueOf(LocalDateTime.now()));
        // if (!isOpen) {
        // this.openTime = LocalDateTime.now(); // opening trading session
        // isOpen = true;
        // System.out.println(" Trading session is opened at " + openTime);
        // } else {
        // System.out.println(" Trading session is already opened ");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        closeSessionLabel.setText("This Session opened at " + String.valueOf(LocalDateTime.now()));
    }

}
