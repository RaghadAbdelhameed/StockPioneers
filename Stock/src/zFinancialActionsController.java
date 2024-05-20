import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class zFinancialActionsController extends MainController implements Initializable {
	@FXML
	private Label amountLabel1;

	@FXML
	private Label amountLabel2;

	@FXML
	private Label amountLabel3;

	@FXML
	private Label opLabel1;

	@FXML
	private Label opLabel2;

	@FXML
	private Label opLabel3;

	@FXML
	private Label priceLabel1;

	@FXML
	private Label priceLabel2;

	@FXML
	private Label priceLabel3;

	@FXML
	private Label stockLabel1;

	@FXML
	private Label stockLabel2;

	@FXML
	private Label stockLabel3;

	@FXML
	private Label tranIDLabel1;

	@FXML
	private Label tranIDLabel2;

	@FXML
	private Label tranIDLabel3;

	@FXML
	private Label tranTimeLabel1;

	@FXML
	private Label tranTimeLabel2;

	@FXML
	private Label tranTimeLabel3;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		List<Transaction> transactions = CSV.getTransactionHistory();
		if(transactions.size()>3) {
		opLabel1.setText(String.valueOf(transactions.get(3).getOpType()));
		tranIDLabel1.setText(String.valueOf(transactions.get(3).getTransactionId()));
		tranTimeLabel1.setText(String.valueOf(transactions.get(3).getTransactionTime()));
		stockLabel1.setText(String.valueOf(CSV.getStocks().get(3).getLabel()));
		priceLabel1.setText(String.valueOf(CSV.getStockPrices().get(3).getTradingPrice()));
		amountLabel1.setText(String.valueOf(transactions.get(3).getAmount()));
		}
		if(transactions.size()>4) {
		opLabel2.setText(String.valueOf(transactions.get(4).getOpType()));
		tranIDLabel2.setText(String.valueOf(transactions.get(4).getTransactionId()));
		tranTimeLabel2.setText(String.valueOf(transactions.get(4).getTransactionTime()));
		stockLabel2.setText(String.valueOf(CSV.getStocks().get(4).getLabel()));
		priceLabel2.setText(String.valueOf(CSV.getStockPrices().get(4).getTradingPrice()));
		amountLabel2.setText(String.valueOf(transactions.get(4).getAmount()));
		}
		if(transactions.size()>5) {
		opLabel3.setText(String.valueOf(transactions.get(5).getOpType()));
		tranIDLabel3.setText(String.valueOf(transactions.get(5).getTransactionId()));
		tranTimeLabel3.setText(String.valueOf(transactions.get(5).getTransactionTime()));
		stockLabel3.setText(String.valueOf(CSV.getStocks().get(5).getLabel()));	
		priceLabel3.setText(String.valueOf(CSV.getStockPrices().get(5).getTradingPrice()));
		amountLabel3.setText(String.valueOf(transactions.get(5).getAmount()));
		}
	}
}
