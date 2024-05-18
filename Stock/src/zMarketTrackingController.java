import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class zMarketTrackingController extends MainController implements Initializable {
	@FXML
	private Label marketprefLabel;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		marketprefLabel.setText("%"+String.valueOf(MarketPerformanceTracker.calculateAggregateMarketPerformance()));
	}
}
