import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class zAccountManageController extends MainController {
    private RegularUser currentUser;
    private User user;

    @FXML
    private Button UPHBackButton;

    @FXML
    private TextField createAccountBalancefiled;

    @FXML
    private TextField createIDfiled;

    @FXML
    private PasswordField createPasswordfiled;

    @FXML
    private TextField createUsernamefiled;

    @FXML
    private ChoiceBox<?> genderChoicebox;

    @FXML
    private Button saveCreateButton;

    @FXML
    void UPHBackButtonClicked(ActionEvent event) {
        loadFXML("UserFeatures.fxml", UPHBackButton, "User Dashboard");
    }

    @FXML
    void saveCreateClicked(ActionEvent event) {
        String username = createUsernamefiled.getText();
        String password = createPasswordfiled.getText();
        int id = Integer.parseInt(createIDfiled.getText());
        double balance = Double.parseDouble(createAccountBalancefiled.getText());
        currentUser.setID(id);
        currentUser.setUserName(username);
        currentUser.setPassword(password);
        currentUser.setAccountBalance(balance);
        user.createUser(currentUser);
        // String gender = genderChoicebox.getValue(); // Assuming you've populated the
        // choice box with appropriate values
        System.out.println(username + "  " + password + "  " + id + "  " + balance);
    }

}
