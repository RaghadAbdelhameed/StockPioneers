import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button adminButton;

    @FXML
    private Button userButton;

    @FXML
    void adminButtonClicked() {
        // Handle admin button click
        System.out.println("Logging in as Admin.... ");
    }

    @FXML
    void userButtonClicked() {
        // Handle user button click
        System.out.println("Logging in as User.... ");
    }
    
    @FXML
    void handleUsernameFieldAction() {
        String username = usernameField.getText();
        System.out.println("Username entered: " + username);
    }
    
    @FXML
    void handlePasswordFieldAction() {
        String password = passwordField.getText();
        System.out.println("Password entered: " + password);
    }
}
