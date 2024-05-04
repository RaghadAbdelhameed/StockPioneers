import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primarystage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primarystage.setTitle("Login Form");
        primarystage.setScene(new Scene(root, 663, 450));
        primarystage.setFullScreen(false);
        primarystage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}