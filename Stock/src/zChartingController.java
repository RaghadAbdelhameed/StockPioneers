import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class zChartingController extends MainController implements Initializable {
    private Admin admin;
    private Stock stock;
    @FXML
    private Button pBackButton;

    @FXML
    void pBackButtonClicked(ActionEvent event) {
        loadFXML("PremiumUser2.fxml", pBackButton, "Premium User");
    }

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

    @FXML
    private LineChart<String, Double> lineChart;
    @FXML
    private CategoryAxis monthAxis;
    @FXML
    private NumberAxis priceAxis;
    @FXML
    private ChoiceBox<Operation> periodChoicebox;
    private static final String[] MONTHS = { "jan", "feb", "mar", "apr", "may", "june", "jule", "aug", "sep" };
    private static final double[] PRICES = { 50.0, 100.0, 10.0, 50.0, 50.0, 90.0, 50.0, 50.0, 50.0 ,50.0,50.0,50.0};

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        try {
			if (periodChoicebox == null) {
	            periodChoicebox = new ChoiceBox<>();
	        }
    	  	periodChoicebox.getItems().addAll(Operation.buy, Operation.deposit, Operation.sell, Operation.withdrawal);
            XYChart.Series<String, Double> priceHistorySeries = new XYChart.Series<>();
            priceHistorySeries.setName("Price History");
            for (int i = 0; i < MONTHS.length; i++) {
                priceHistorySeries.getData().add(new XYChart.Data<>(MONTHS[i], PRICES[i]));
            }
            lineChart.getData().add(priceHistorySeries);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
