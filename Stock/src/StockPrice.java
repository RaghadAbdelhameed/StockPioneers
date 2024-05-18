import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StockPrice {

	private double initialPrice;
	private double openingPrice;
	private double finalPrice;
	private double closingPrice;
	private double tradingPrice;
	private double dividends;
	private double profitPercentage;
	private LocalDateTime dateTime;

	public StockPrice(double initialPrice, double openingPrice, double finalPrice, double closingPrice,
			double tradingPrice, double dividends, double profitPercentage, LocalDateTime dateTime) {
		this.initialPrice = initialPrice;
		this.openingPrice = openingPrice;
		this.finalPrice = finalPrice;
		this.closingPrice = closingPrice;
		this.tradingPrice = tradingPrice;
		this.dividends = dividends;
		this.profitPercentage = profitPercentage;
		this.dateTime = dateTime;
	}

	public StockPrice(double tradingPrice, LocalDateTime dateTime) {
		this.tradingPrice = tradingPrice;
		this.dateTime = dateTime;
	}

	public StockPrice(double profitPercentage) {
		this.profitPercentage = profitPercentage;
	}

	public StockPrice() {
		this.dateTime = LocalDateTime.now();
		// TODO Auto-generated constructor stub
	}

	public double getInitialPrice() {
		return initialPrice;
	}

	public void setInitialPrice(double initialPrice) {
		this.initialPrice = initialPrice;
	}

	public double getProfitPercentage() {
		return profitPercentage;
	}

	public void setProfitPercentage(double profitPercentage) {
		this.profitPercentage = profitPercentage;
	}

	public double getOpeningPrice() {
		return openingPrice;
	}

	public void setOpeningPrice(double openingPrice) {
		this.openingPrice = openingPrice;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public double getClosingPrice() {
		return closingPrice;
	}

	public void setClosingPrice(double closingPrice) {
		this.closingPrice = closingPrice;
	}

	public double getTradingPrice() {
		return tradingPrice;
	}

	public void setTradingPrice(double tradingPrice) {
		this.tradingPrice = tradingPrice;
	}

	public double getDividends() {
		return dividends;
	}

	public void setDividends(double dividends) {
		this.dividends = dividends;
	}

	public String getDateTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS");
		String formattedDateTime = dateTime.format(formatter);
		return formattedDateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	// public List<StockPrice> getPriceHistory() {
	// return priceHistory;
	// }

	@Override
	public String toString() {
		return " StockPrice{" + "initialPrice=" + initialPrice + ", openingPrice=" + openingPrice + ", finalPrice="
				+ finalPrice + ", closingPrice=" + closingPrice + ", tradingPrice=" + tradingPrice + ", dividends="
				+ dividends + ", profitPercentage=" + profitPercentage + ", dateTime=" + dateTime + '}';
	}
}
