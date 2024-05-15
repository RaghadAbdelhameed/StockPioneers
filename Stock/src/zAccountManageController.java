import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class zAccountManageController extends MainController {

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

    }

}
