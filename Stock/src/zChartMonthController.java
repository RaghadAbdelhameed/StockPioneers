import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

public class zChartMonthController extends zChartingController{
@FXML
	private Button lineBackButton;
	
	@FXML
	void lineBackClicked(ActionEvent event) {
		loadFXML("PremiumCharts.fxml", lineBackButton, "Premium User");
	}

    @FXML
	private LineChart<String, Double> lineChart;
	@FXML
	private CategoryAxis monthAxis;
	@FXML
	private NumberAxis priceAxis;
	@FXML
	private ChoiceBox<String> periodChoicebox;

    private static final String[] MONTHS = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct",
    "Nov", "Dec" };
private static final double[] PRICES = { 75.0, 30.0, 100.0, 85.0, 150.0, 60.0, 100.0, 175.0, 70.0, 90.0, 125.0,
    50.0 };

    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if (periodChoicebox == null) {
			periodChoicebox = new ChoiceBox<>();
		}
		try {
			periodChoicebox.getItems().addAll("Day", "Week", "Month", "Year");
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