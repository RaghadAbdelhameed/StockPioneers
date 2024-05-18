import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class zUserPriceController extends MainController implements Initializable {
	@FXML
	private Button UPHBackButton;

	@FXML
	private Label pricelabel1;

	@FXML
	private Label pricelabel2;

	@FXML
	private Label pricelabel3;

	@FXML
	private Label stocklabel1;

	@FXML
	private Label stocklabel2;

	@FXML
	private Label stocklabel3;

	@FXML
	private Label timelabel1;

	@FXML
	private Label timelabel2;

	@FXML
	private Label timelabel3;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		List<StockPrice> stockprices = CSV.getStockPrices();
		List<Stock> stocks = CSV.getStocks();
		stocklabel1.setText(String.valueOf(stocks.get(0).getLabel()));
		stocklabel2.setText(String.valueOf(stocks.get(1).getLabel()));
		stocklabel3.setText(String.valueOf(stocks.get(2).getLabel()));

		pricelabel1.setText(String.valueOf(stockprices.get(0).getTradingPrice()));
		pricelabel2.setText(String.valueOf(stockprices.get(1).getTradingPrice()));
		pricelabel3.setText(String.valueOf(stockprices.get(2).getTradingPrice()));

		timelabel1.setText(String.valueOf(stockprices.get(0).getDateTime()));
		timelabel2.setText(String.valueOf(stockprices.get(1).getDateTime()));
		timelabel3.setText(String.valueOf(stockprices.get(2).getDateTime()));
	}
}
