
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class zUserController extends MainController {
	private RegularUser currentUser;
	private Admin admin;

	// User Login
	@FXML
	private Button AccountManageButton;

	@FXML
	private Button loginUserButton;

	@FXML
	private Hyperlink signupLink;

	@FXML
	private Button backButton;

	@FXML
	private PasswordField userPasswordField;
	@FXML
	private TextField userUsernameField;
	public static int index;

	@FXML
	void loginUserClicked(ActionEvent event) {
		String password = userPasswordField.getText();
		String username = userUsernameField.getText();
		String[][] data = (CSV.readData("csv files/UserData.csv"));
		boolean found = false;
		for (int i = 1; i < data.length; i++) {
			if (username.equals(data[i][0]) && password.equals(data[i][1])) {
				loadFXML("UserFeatures.fxml", loginUserButton, "User Dashboard");
				found = true;
				index = i - 1;
				break;
			}
		}
		if (!found) {
			System.out.println("wrong input");
		}
	}

	@FXML
	private TextField signupusername;
	@FXML
	private PasswordField signuppassword;

	@FXML
	void signubloginclicked(ActionEvent event) {
		try {
			String[][] data = CSV.readData("csv files/UserData.csv");
			// admin=new Admin("ahmed","ahmed");
			Admin admin = Admin.getInstance("ahmed", "ahmed45");
			String username = signupusername.getText();
			String password = signuppassword.getText();
			int counter = data.length;
			String gender = genderChoicebox.getValue();
			currentUser = new RegularUser(username, password, gender);
			currentUser.setID(counter++);
			admin.createUser(currentUser);
			System.out.println(username + "  " + password);
			if (!currentUser.getUserName().equals("")) {
				loadFXML("UserFeatures.fxml", loginUserButton, "User Dashboard");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@FXML
	void handleSignupClicked(ActionEvent event) {
		loadFXML("UserSignup.fxml", signupLink, "User Signup");
	}

	@FXML
	void backButtonClicked() {
		System.out.println("Going Back to Login Page...");
		loadFXML("NewLogin.fxml", backButton, "Login Page");
	}

	@FXML
	void AccountManageClicked(ActionEvent event) {
		loadFXML("AccountManage.fxml", AccountManageButton, "Create an Account");
	}

	// User Signup

	@FXML
	private TextField emailField;

	// @FXML
	// private DatePicker birthPicker;

	@FXML
	private Button logoutUserButton;

	@FXML
	private ChoiceBox<String> genderChoicebox;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// setLabelText();
		if (genderChoicebox == null) {
			genderChoicebox = new ChoiceBox<>();
		}
		genderChoicebox.getItems().addAll("Male", "Female");

	}

	// User Features
	@FXML
	private Button orderManageButton;

	@FXML
	private Button userPriceHistoryButton;

	@FXML
	private Button DepositWithdrawalButton;

	@FXML
	private Button financialButton;

	@FXML
	private Button TransactionHistoryButton;

	@FXML
	private Button chartingButton;

	@FXML
	private Button marketButton;

	@FXML
	private Button premiumButton;

	@FXML
	void premiumClicked(ActionEvent event) {
		loadFXML("Premium.fxml", premiumButton, "Premium User");
	}

	@FXML
	void orderManageClicked(ActionEvent event) {
		loadFXML("OrderManage.fxml", orderManageButton, "Order Management");
	}

	@FXML
	void marketClicked(ActionEvent event) {
		loadFXML("MarketTracking.fxml", marketButton, "Market Performance Tracking");
	}

	@FXML
	void financialClicked(ActionEvent event) {
		loadFXML("FinancialActions.fxml", financialButton, "Financial Actions");
		// currentUser.getFinancialTransactions();
	}

	@FXML
	void userPriceHistoryClicked(ActionEvent event) {
		loadFXML("UserPriceHistory.fxml", userPriceHistoryButton, "Price History");
	}

	@FXML
	void DepositWithdrawalButtonClicked() {
		loadFXML("withdrawal.fxml", DepositWithdrawalButton, "Deposite and Withdrawal");
	}

	@FXML
	void TransactionHistoryClicked(ActionEvent event) {
		try {
			loadFXML("TransactionHistory.fxml", financialButton, "Transaction History");
			// currentUser.listAllTransactions();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@FXML
	void chartingClicked(ActionEvent event) {
		loadFXML("Charts.fxml", chartingButton, "Charting Options");
	}

	@FXML
	void logoutUserClicked(ActionEvent event) {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Logout Confirmation");
		alert.setHeaderText(null);
		alert.setContentText("Are you sure that you want to Logout?");

		// Customize the buttons
		ButtonType yesButton = new ButtonType("Yes");
		ButtonType noButton = new ButtonType("No");

		alert.getButtonTypes().setAll(yesButton, noButton);

		// Show the alert and wait for user response
		Optional<ButtonType> result = alert.showAndWait();

		// Check which button the user clicked
		if (result.isPresent() && result.get() == yesButton) {
			loadFXML("UserLogin.fxml", logoutUserButton, "User Login");
		}
	}

}
