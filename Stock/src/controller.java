import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class controller {

    @FXML
    private Button adminbutton;

    @FXML
    private PasswordField passwordfield;

    @FXML
    private Button userbutton;

    @FXML
    private TextField usernamefield;

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
        String username = usernamefield.getText();
        System.out.println("Username entered: " + username);
    }

    @FXML
    void handlePasswordFieldAction() {
        String password = passwordfield.getText();
        System.out.println("Password entered: " + password);
    }

}
