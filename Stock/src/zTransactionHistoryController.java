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
		if(transactions.size()>0) {
			opLabel1.setText(String.valueOf(transactions.get(0).getOpType()));
			tranIDLabel1.setText(String.valueOf(transactions.get(0).getTransactionId()));
			tranTimeLabel1.setText(String.valueOf(transactions.get(0).getTransactionTime()));
			stockLabel1.setText(String.valueOf(CSV.getStocks().get(0).getLabel()));
			priceLabel1.setText(String.valueOf(CSV.getStockPrices().get(0).getTradingPrice()));
			amountLabel1.setText(String.valueOf(transactions.get(0).getAmount()));
			}
			if(transactions.size()>1) {
			opLabel2.setText(String.valueOf(transactions.get(1).getOpType()));
			tranIDLabel2.setText(String.valueOf(transactions.get(1).getTransactionId()));
			tranTimeLabel2.setText(String.valueOf(transactions.get(1).getTransactionTime()));
			stockLabel2.setText(String.valueOf(CSV.getStocks().get(1).getLabel()));
			priceLabel2.setText(String.valueOf(CSV.getStockPrices().get(1).getTradingPrice()));
			amountLabel2.setText(String.valueOf(transactions.get(1).getAmount()));
			}
			if(transactions.size()>2) {
			opLabel3.setText(String.valueOf(transactions.get(2).getOpType()));
			tranIDLabel3.setText(String.valueOf(transactions.get(2).getTransactionId()));
			tranTimeLabel3.setText(String.valueOf(transactions.get(2).getTransactionTime()));
			stockLabel3.setText(String.valueOf(CSV.getStocks().get(2).getLabel()));	
			priceLabel3.setText(String.valueOf(CSV.getStockPrices().get(2).getTradingPrice()));
			amountLabel3.setText(String.valueOf(transactions.get(2).getAmount()));
			}
	}

}