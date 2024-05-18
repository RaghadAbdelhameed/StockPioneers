import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CSV {

	public static void writeStockHistory(List<Stock> stock, List<StockPrice> stockp) {
		try (PrintWriter writer = new PrintWriter(new FileWriter("src/csv files/StockHistory.csv"))) {
			// Write stock header

			writer.println(
					"StockLabel,StockCompany,AvailableStocks,StockInitialPrice,StockOpeningPrice,StockFinalPrice,StockClosingPrice,StockTradingPrice,Dividends,ProfitPercentage,DateTime");
			for (int i = 0; i < stock.size(); i++) {
				Stock stockData = stock.get(i);
				StockPrice stockPriceData = stockp.get(i);
				writer.println(String.format("%s,%s,%d,%f,%f,%f,%f,%f,%f,%f,%s", stockData.getLabel(),
						stockData.getCompany(), stockData.getAvailableStocks(), stockPriceData.getInitialPrice(),
						stockPriceData.getOpeningPrice(), stockPriceData.getFinalPrice(),
						stockPriceData.getClosingPrice(), stockPriceData.getTradingPrice(),
						stockPriceData.getDividends(), stockPriceData.getProfitPercentage(),
						stockPriceData.getDateTime()));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void writeTransactionHistory(List<Transaction> trnsaction) { // Nagafa
		try (PrintWriter writer = new PrintWriter(new FileWriter("src/csv files/TranscationHistory.csv"))) {
			// Write stock header

			writer.println("transactionId,userID,stockLabel,opType,amount,price,Transactiontime");
			for (int i = 0; i < trnsaction.size(); i++) {
				Transaction transactionData = trnsaction.get(i);
//				writer.println(); // Add a blank line between stock and stock price data
				writer.println(String.format("%d,%d,%s,%s,%f,%f,%s", transactionData.getTransactionId(),
						transactionData.getUserId(), transactionData.getLabel(), transactionData.getOpType(),
						transactionData.getAmount(), transactionData.getPrice(), transactionData.getTransactionTime()));
			}
		} catch (Exception e) {
			System.out.println(e);
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
		try (PrintWriter writer = new PrintWriter(new FileWriter("src/csv files/UserData.csv"))) {
			writer.println("UserName,Password,ID,AccountBalance,gender");
			for (RegularUser user : users) {
				writer.println(String.format("%s,%s,%d,%.2f,%s", user.getUserName(), user.getPassword(), user.getID(),
						user.getAccountBalance(), user.getGender()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String[][] readStocks() {
		String filePath = "src/csv files/StockHistory.csv";
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
		String[][] result = new String[rows][10];
		for (int i = 0; i < rows; i++) {
			result[i] = dataList.get(i);
		}
		return result;
	}

	public static List<Stock> getStocks() {
		List<Stock> stocks = new ArrayList<>();
		String[][] data = readStocks();
		for (int i = 1; i < data.length; i++) {
			Stock stock = new Stock(data[i][0], data[i][1], Integer.parseInt(data[i][2]));
			stocks.add(stock);
		}
		return stocks;
	}

	public static List<StockPrice> getStockPrices() {
		List<StockPrice> stocks = new ArrayList<>();
		String[][] data = readStocks();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS");
		for (int i = 1; i < data.length; i++) {
			StockPrice stockPrice = new StockPrice(Double.parseDouble(data[i][3]), Double.parseDouble(data[i][4]),
					Double.parseDouble(data[i][5]), Double.parseDouble(data[i][6]), Double.parseDouble(data[i][7]),
					Double.parseDouble(data[i][8]), Double.parseDouble(data[i][9]),
					LocalDateTime.parse(data[i][11], formatter));
			stocks.add(stockPrice);
		}
		return stocks;
	}

	public static List<StockPrice> getFinantialAction() {
		List<StockPrice> stocks = new ArrayList<>();
		String[][] data = readStocks();
		for (int i = 1; i < data.length; i++) {
			StockPrice stockPrice = new StockPrice(Double.parseDouble(data[i][9]));
			stocks.add(stockPrice);
		}
		return stocks;
	}

	public static String[][] readTransactions() {

		String filePath = "src/csv files/TranscationHistory.csv";
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
		String[][] result = new String[rows][6];
		for (int i = 0; i < rows; i++) {
			result[i] = dataList.get(i);
		}
		return result;
	}

	public static List<Transaction> getTransactionHistory() {
		List<Transaction> transactions = new ArrayList<>();
		String[][] data = readTransactions();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS");
		for (int i = 1; i < data.length; i++) {
			Transaction transaction = new Transaction(Integer.parseInt(data[i][0]), Operation.valueOf(data[i][3]),
					Double.parseDouble(data[i][4]), LocalDateTime.parse(data[i][6], formatter));
			transactions.add(transaction);
		}
		return transactions;
	}

}
