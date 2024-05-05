import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class controller {

    @FXML
    private Button adminButton;

    @FXML
    private Button userButton;

    @FXML
    private Button backButton; // Add reference to the back button

    @FXML
    void adminButtonClicked() {
        // Handle admin button click
        System.out.println("Logging in as Admin.... ");
        loadAdminUI();
    }

    @FXML
    void userButtonClicked() {
        // Handle user button click
        System.out.println("Logging in as User.... ");
    }

    @FXML
    void backButtonClicked() {
        loadLoginUI();
    }

    private void loadAdminUI() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AdminUI.fxml"));
            Stage stage = (Stage) adminButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Admin Dashboard");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadLoginUI() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("NewLogin.fxml"));
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
