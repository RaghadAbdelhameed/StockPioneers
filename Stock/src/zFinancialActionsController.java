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
		int counter = 0;
		for (int i = 0; i < transactions.size(); i++) {
			if ((transactions.get(i).getOpType().equals(Operation.deposit) ||
					transactions.get(i).getOpType().equals(Operation.deposit)) &&
					transactions.get(i).getUserId() == (zUserController.index + 1)) {
				counter++;
				switch (counter) {
					case 1:
						opLabel1.setText(String.valueOf(transactions.get(i).getOpType()));
						tranIDLabel1.setText(String.valueOf(transactions.get(i).getTransactionId()));
						tranTimeLabel1.setText(String.valueOf(transactions.get(i).getTransactionTime()));
						// stockLabel1.setText(String.valueOf(CSV.getStocks().get(i).getLabel()));
						// priceLabel1.setText(String.valueOf(CSV.getStockPrices().get(i).getTradingPrice()));
						amountLabel1.setText(String.valueOf(transactions.get(i).getAmount()));
						break;
					case 2:
						opLabel2.setText(String.valueOf(transactions.get(i).getOpType()));
						tranIDLabel2.setText(String.valueOf(transactions.get(i).getTransactionId()));
						tranTimeLabel2.setText(String.valueOf(transactions.get(i).getTransactionTime()));
						// stockLabel2.setText(String.valueOf(CSV.getStocks().get(i).getLabel()));
						// priceLabel2.setText(String.valueOf(CSV.getStockPrices().get(i).getTradingPrice()));
						amountLabel2.setText(String.valueOf(transactions.get(i).getAmount()));
						break;
					case 3:
						opLabel3.setText(String.valueOf(transactions.get(i).getOpType()));
						tranIDLabel3.setText(String.valueOf(transactions.get(i).getTransactionId()));
						tranTimeLabel3.setText(String.valueOf(transactions.get(i).getTransactionTime()));
						// stockLabel3.setText(String.valueOf(CSV.getStocks().get(i).getLabel()));
						// priceLabel3.setText(String.valueOf(CSV.getStockPrices().get(i).getTradingPrice()));
						amountLabel3.setText(String.valueOf(transactions.get(i).getAmount()));
						break;
				}
			}
		}

	}
}