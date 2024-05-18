import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class zTransactionHistoryController extends MainController implements Initializable {
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

		opLabel1.setText(String.valueOf(transactions.get(0).getOpType()));
		opLabel2.setText(String.valueOf(transactions.get(1).getOpType()));
		opLabel3.setText(String.valueOf(transactions.get(2).getOpType()));

		tranIDLabel1.setText(String.valueOf(transactions.get(0).getTransactionId()));
		tranIDLabel2.setText(String.valueOf(transactions.get(1).getTransactionId()));
		tranIDLabel3.setText(String.valueOf(transactions.get(2).getTransactionId()));

		tranTimeLabel1.setText(String.valueOf(transactions.get(0).getTransactionTime()));
		tranTimeLabel2.setText(String.valueOf(transactions.get(1).getTransactionTime()));
		tranTimeLabel3.setText(String.valueOf(transactions.get(2).getTransactionTime()));

		stockLabel1.setText(String.valueOf(CSV.getStocks().get(0).getLabel()));
		stockLabel2.setText(String.valueOf(CSV.getStocks().get(1).getLabel()));
		stockLabel3.setText(String.valueOf(CSV.getStocks().get(2).getLabel()));

		priceLabel1.setText(String.valueOf(CSV.getStockPrices().get(0).getTradingPrice()));
		priceLabel2.setText(String.valueOf(CSV.getStockPrices().get(1).getTradingPrice()));
		priceLabel3.setText(String.valueOf(CSV.getStockPrices().get(2).getTradingPrice()));

		amountLabel1.setText(String.valueOf(transactions.get(0).getAmount()));
		amountLabel2.setText(String.valueOf(transactions.get(1).getAmount()));
		amountLabel3.setText(String.valueOf(transactions.get(2).getAmount()));

	}

}