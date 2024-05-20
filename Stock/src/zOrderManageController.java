import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class zOrderManageController extends MainController {
    // private User user;
    private RegularUser regularUser;
    // private Admin admin;
    // private RegularUser currentUser;
    // private Stock stock;

    // Order Management
    @FXML
    private Button buyStockButton;

    @FXML
    private Button sellStockButton;

    @FXML
    void buyStockClicked(ActionEvent event) {
        loadFXML("BuyStock.fxml", buyStockButton, "Buy Stock");
    }

    @FXML
    void sellStockClicked(ActionEvent event) {
        loadFXML("SellStock.fxml", sellStockButton, "Sell Stock");
    }

    // Buy Stock
    @FXML
    private Button buyButton;

    @FXML
    private Label availableStocks;

    @FXML
    private Label companyLabel;

    @FXML
    private Label maxPriceLabel;

    @FXML
    private Button buySearchStockButton;

    @FXML
    private TextField buyStockLabelField;
    @FXML
    private Label buyStockLabel;
    @FXML
    private TextField amountTextField;
    @FXML
    void buySearchStockClicked(ActionEvent event) {
    	int index= searchID(buyStockLabelField,buyStockLabel);
    	  List<Stock>stocks=CSV.getStocks();
          List<StockPrice> stockprices= CSV.getStockPrices();
          if (index>=0) {
        	  buyStockLabel.setTextFill(Color.BLACK);
        	  companyLabel.setText(stocks.get(index).getCompany());
        	  maxPriceLabel.setText(String.valueOf(stockprices.get(index).getTradingPrice()));
        	  availableStocks.setText(String.valueOf(stocks.get(index).getAvailableStocks()));
          }
    }
    public static boolean bought=false;
    @FXML
    void buyClicked(ActionEvent event) {
    	int index= searchID(buyStockLabelField,buyStockLabel);
    	List<RegularUser>users=CSV.getUsers();
    	List<Stock>stocks=CSV.getStocks();
    	regularUser=users.get(zUserController.index);
        String label = buyStockLabelField.getText();
        String company = companyLabel.getText();
        int amount = Integer.parseInt(amountTextField.getText());
        double maxPrice = Double.parseDouble(maxPriceLabel.getText());
        System.out.println(label + "  " + company + "  " + maxPrice + "  " + amount);
        try {
        	if(index>0)
            regularUser.buyStockOrder(label, company, maxPrice, amount,searchID(buyStockLabelField,buyStockLabel));
        	if(bought) {
        	availableStocks.setText(String.valueOf(stocks.get(index).getAvailableStocks()));
        	bought=false;
        	}
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input. You must enter a digit in max.price field");
        }
    }
    // Sell Stock
    @FXML
    private Label minPriceLabel;

    @FXML
    private Button sellButton;
    @FXML
    private TextField sellStockLabelField;
    @FXML
    private Label sellStockLabel;
    @FXML
    void sellSearchStockClicked(ActionEvent event) {
    	int index= sellsearchID(sellStockLabelField,sellStockLabel);
    	  List<Stock>stocks=CSV.getStocks();
          List<StockPrice> stockprices= CSV.getStockPrices();
          List<BoughtStock> boughtstocks=CSV.getHaveStocks();
          if (index>=0) {
        	  sellStockLabel.setTextFill(Color.BLACK);
        	  companyLabel.setText(stocks.get(index).getCompany());
        	  minPriceLabel.setText(String.valueOf(stockprices.get(index).getTradingPrice()));
        	  availableStocks.setText(String.valueOf(boughtstocks.get(boughtstockindex).getAmount()));
          }
    }
   
    @FXML
    void sellClicked(ActionEvent event) {
        String label = sellStockLabelField.getText();
        String company = companyLabel.getText();
        int amount = Integer.parseInt(amountTextField.getText());
    	int index= searchID(sellStockLabelField,sellStockLabel);
    	List<RegularUser>users=CSV.getUsers();
    	List<Stock>stocks=CSV.getStocks();
    	regularUser=users.get(zUserController.index);
        double minPrice = Double.parseDouble(minPriceLabel.getText());
        System.out.println(label + "  " + company + "  " + minPrice + "  " + amount);
        try {
        	if(index>0)
            (regularUser).sellStockOrder(label, company, minPrice, amount,index);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input. You must enter a digit in min.price field");
        }
    }
    int searchID(TextField stocklabel, Label label) {
        try {
            String stockLabel = stocklabel.getText();
            boolean found = false;
            List<Stock> stocks = CSV.getStocks();
            for (int i = 1; i < stocks.size(); i++) {
                if (stockLabel.equals(stocks.get(i).getLabel())) {
                    label.setOpacity(0);
                    found = true;
                    return i;
                }
            }
            if (!stockLabel.matches("\\d+")) {
                throw new Exception();
            }
            if (!found) {
                label.setTextFill(Color.RED);
                label.setOpacity(1);
                label.setText("Not Found");
            }
        } catch (Exception e) {
            label.setTextFill(Color.RED);
            label.setOpacity(1);
            label.setText("Invalid Input");
            System.out.println(e);
        }
        return -1;
    }
    private int boughtstockindex;
    int sellsearchID(TextField stocklabel, Label label) {
        try {
            String stockLabel = stocklabel.getText();
            List<Stock> stocks=CSV.getStocks();
            List<BoughtStock> boughtstocks=CSV.getHaveStocks();
            for (int i = 0; i < stocks.size(); i++) {
                if (stockLabel.equals(stocks.get(i).getLabel())) {
                    for (int j = 0; j < boughtstocks.size(); j++) {
                        if (stocks.get(i).getLabel().equals(boughtstocks.get(j).getLabel()) && boughtstocks.get(j).getUserID() == zUserController.index + 1) {
                            label.setOpacity(0);
                            boughtstockindex=j;
                            return i;
                        }
                    }
                }
            }
            label.setTextFill(Color.RED);
            label.setOpacity(1);
            label.setText("Not Found");
        } catch (Exception e) {
            label.setTextFill(Color.RED);
            label.setOpacity(1);
            label.setText("Invalid Input");
            System.out.println(e);
        }
        return -1;
    }
}
