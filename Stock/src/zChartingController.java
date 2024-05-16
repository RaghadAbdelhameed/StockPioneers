import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class zChartingController extends MainController {
    private Admin admin;
    private Stock stock;

    @FXML
    private Button candlestickChartsButton;

    @FXML
    private Button lineChartsButton;

    @FXML
    private Button searchButton;

    @FXML
    private TextField stockLabelField;

    @FXML
    void candlestickChartsClicked(ActionEvent event) {
        loadFXML("CandleStickCharts.fxml", candlestickChartsButton, "CandleStick Charts ");
    }

    @FXML
    void lineChartsClicked(ActionEvent event) {
        loadFXML("LineCharts.fxml", lineChartsButton, "Line Charts");
    }

    @FXML
    void searchClicked(ActionEvent event) {
        String label = stockLabelField.getText();
        stock.setLabel(label);
        admin.accessStock(label);
    }

    // Line Charts NOTE: back button is the same for both
    @FXML
    private Button backButton;

    @FXML
    void backClicked(ActionEvent event) {
        loadFXML("Charts.fxml", backButton, "Charting Options");
    }

}
