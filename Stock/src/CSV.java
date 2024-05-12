import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CSV {

	public static void writeStockHistory(List<Stock> stock) {
		try (PrintWriter writer = new PrintWriter(new FileWriter("StockHistory.csv"))) {
			// Write stock header
			writer.println(
					"StockLabel,StockCompany,StockInitialPrice,Dividends,AvailableStocks,ProfitPercentage,CurrentPrice");

			for (Stock line : stock) {
				writer.println(String.format("%s,%s,%d,%d,%d,%d,%d", line.getLabel(), line.getCompany(),
						line.getInitialPrice(), line.getDividends(), line.getTradingPrice(), line.getAvailableStocks(),
						line.getProfitPercentage()));

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String[] readData(String fp) {
		String[] data = null;
		String filePath = fp;
		BufferedReader reader = null;
		String line = "";
		try {
			reader = new BufferedReader(new FileReader(filePath));
			while ((line = reader.readLine()) != null) {
				// Split by comma
				data = line.split(",");

				// Do something with the data, for example:
				for (String datum : data) {
					System.out.print(datum + " ");
				}
				System.out.println();

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
		return data;

	}

	public static void writeData(List<User> user) {

		try (PrintWriter writer = new PrintWriter(new FileWriter("userData"))) {
			// Write stock header
			writer.println("UserName,Password,ID,gender,AccountBalance");

			for (User line : user) {
				writer.println(String.format("%s,%s,%d,%d,%d,", line.getUserName(), line.getPassword(), line.getID(),
						line.getAccountBalance(), line.gender()));

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
