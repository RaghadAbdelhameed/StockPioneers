
import java.time.LocalDateTime; // for price history

// class for stocks prices management and monitoring
public class StockPrice {

    private double price;
    private LocalDateTime priceTime; // record prices at a specific time

    StockPrice(double price, LocalDateTime priceTime) {
        this.price = price;
        this.priceTime = priceTime;
    }

    public double getPrice() { // retrieve stock price
        return price;
    }

    public void setPrice(double price) { // set stock price
        this.price = price;
    }

    public LocalDateTime getPriceTime() {
        return priceTime;
    }

    public void setPriceTime(LocalDateTime priceTime) {
        this.priceTime = priceTime;
    }

    @Override
    public String toString() { // display the price history for stocks
        return "Price{ " +
                "dateTime = " + priceTime +
                ", price = " + price +
                " }";
    }

}
