import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.time.LocalDateTime;

public class zAdminSessionsController extends MainController {
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
        loadFXML("Thankyou.fxml", closeButton, "THANK YOU!!!!!");

        // if (isOpen) {
        // this.closeTime = LocalDateTime.now(); // closing trading session
        // isOpen = false;
        // System.out.println("Trading session closed at " + closeTime);
        // } else {
        // System.out.println(" No trading sessions are currently opened ");
        // }
    }

    @FXML
    protected Button initiateButton;

    @SuppressWarnings("static-access")
    @FXML
    void intiateClicked(ActionEvent event) {
        // admin.getInstance("skaf", "faf", gender.male, tradingManager);
        tradingManager = new TradingManager();
        admin = Admin.getInstance("", "");
        admin.initiateTradingSession();
        loadFXML("TradingSessionsClose.fxml", initiateButton, "Trading Sessions");

        // if (!isOpen) {
        // this.openTime = LocalDateTime.now(); // opening trading session
        // isOpen = true;
        // System.out.println(" Trading session is opened at " + openTime);
        // } else {
        // System.out.println(" Trading session is already opened ");
    }

}
