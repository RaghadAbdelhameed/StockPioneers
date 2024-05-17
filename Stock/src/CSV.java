import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CSV {

	public static void writeStockHistory(List<Stock> stock,List<StockPrice> stockp) {
		try (PrintWriter writer = new PrintWriter(new FileWriter("StockHistory.csv"))) {
			// Write stock header
			writer.println(
					"StockLabel,StockCompany,StockInitialPrice,Dividends,AvailableStocks,ProfitPercentage,CurrentPrice");
			for (Stock line : stock) {
				writer.print(String.format("%s,%s,%d", line.getLabel(), line.getCompany(),line.getAvailableStocks()));
			}
			for (StockPrice line : stockp) {
				writer.println(String.format("%d,%d,%d,%d", 
						line.getInitialPrice(), line.getDividends(), line.getTradingPrice(),line.getProfitPercentage()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String[][] readData(String fp) {
	    String filePath = fp;
	    BufferedReader reader = null;
	    List<String[]> dataList = new ArrayList<>(); // Use a List to store the data from all lines
	    try {
	        reader = new BufferedReader(new FileReader(filePath));
	        String line = "";
	        while ((line = reader.readLine()) != null) {
	            // Split by comma
	            String[] data = line.split(",");

	            // Add the data to the list
	            dataList.add(data);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if (reader != null) {
	            try {
	                reader.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    // Convert the list to a 2D array and return it
	    int rows = dataList.size();
	    String[][] result = new String[rows][5];
	    for (int i = 0; i < rows; i++) {
	        result[i] = dataList.get(i);
	    }
	    return result;
	}
	public static void writeData(List<RegularUser> users) {
		try (PrintWriter writer = new PrintWriter(new FileWriter("Stock\\src\\csvfiles\\UserData.csv"))) {
			writer.println("UserName,Password,ID,AccountBalance,gender");
			for (RegularUser user : users) {
				writer.println(String.format("%s,%s,%d,%.2f,%s", user.getUserName(), user.getPassword(), user.getID(),
						user.getAccountBalance(), user.getGender()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
