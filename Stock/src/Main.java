import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import java.util.List;
import java.util.Optional;

public class Main extends Application {
    public static List<RegularUser> users = CSV.getUsers();
    public static List<Transaction> transactions = CSV.getTransactionHistory();
    public static List<StockPrice> stockprices = CSV.getStockPrices();
    public static List<Stock> stocks = CSV.getStocks();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("NewLogin.fxml"));
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(new Scene(root, 850, 444));
        primaryStage.setFullScreen(false);
        primaryStage.setResizable(false); // Set resizable to false
        primaryStage.setOnCloseRequest(event -> {
            event.consume(); // Consume the event to prevent the window from closing directly

            // Create a confirmation alert
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Exit Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to close?");

            // Customize the buttons
            ButtonType yesButton = new ButtonType("Yes");
            ButtonType noButton = new ButtonType("No");

            alert.getButtonTypes().setAll(yesButton, noButton);

            // Show the alert and wait for user response
            Optional<ButtonType> result = alert.showAndWait();

            // Check which button the user clicked
            if (result.isPresent() && result.get() == yesButton) {
                primaryStage.close(); // Close the window
            }
        });
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
