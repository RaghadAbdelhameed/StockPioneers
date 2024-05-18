import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class zUserManageController extends MainController {

//    private User user;
	// private RegularUser regularUser;
	private Admin admin;
	private RegularUser currentUser;

	// User Management
	@FXML
	private Button createUserButton;

	@FXML
	private Button updateUserButton;

	@FXML
	private Button deleteUserButton;

	@FXML
	private Button retriveUserButton;

	@FXML
	void createUserClicked(ActionEvent event) {
		loadFXML("CreateUser.fxml", createUserButton, "Create User");
	}

	@FXML
	void updateUserClicked(ActionEvent event) {
		loadFXML("UpdateUser.fxml", updateUserButton, "Update User");
	}

	@FXML
	void deleteUserClicked(ActionEvent event) {
		loadFXML("DeleteUser.fxml", deleteUserButton, "Delete User");
	}

	@FXML
	void retriveUserClicked(ActionEvent event) {
		loadFXML("RetriveUser.fxml", retriveUserButton, "Retrive User");
	}

	// Create User

	@FXML
	private TextField createUsernamefiled;

	@FXML
	private PasswordField createPasswordfiled;

	@FXML
	private TextField createAccountBalancefiled;

	@FXML
	private TextField createIDfiled;

	// @FXML
	// private ChoiceBox<?> createGenderBox;

	@FXML
	private Button saveCreateButton;

	@FXML
	void saveCreateClicked(ActionEvent event) {
		try {
			String[][] data = CSV.readData("src/csv files/UserData.csv");
			Admin admin = Admin.getInstance("ahmed", "ahmed45");
			String username = createUsernamefiled.getText();
			String password = createPasswordfiled.getText();
			int counter = data.length;
			String gender = genderChoicebox.getValue();
			currentUser = new RegularUser(username, password, gender);
			currentUser.setID(counter++);
			admin.createUser(currentUser);
			System.out.println(username + "  " + password);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Update User

	@FXML
	private TextField UpdateIDfield;

	@FXML
	private TextField UpdatePasswordfield;

	@FXML
	private TextField UpdateUsernsamefield;

	@FXML
	private Button updateButton;

	@FXML
	void updateClicked(ActionEvent event) {
		try {
			int searchid = searchID(searchIDfield, deleteUserLabel);
			Admin admin = Admin.getInstance("ahmed", "ahmed45");
			String username = UpdateUsernsamefield.getText();
			String password = UpdatePasswordfield.getText();
			String[][] data = CSV.readData("src/csv files/UserData.csv");
			currentUser = new RegularUser(username, password, Integer.parseInt(data[searchid][2]),
					Double.parseDouble(data[searchid][3]), data[searchid][4]);
			admin.updateUser(currentUser);
			System.out.println(username + "  " + password);
		} catch (Exception e) {

		}
	}

	@FXML
	void updateSearchClicked(ActionEvent event) throws Exception {
		int searchid = searchID(searchIDfield, deleteUserLabel);
		// String[][] data =(CSV.readData("src/csv files/UserData.csv"));
		if (searchid > 0) {
			deleteUserLabel.setTextFill(Color.BLACK);
			deleteUserLabel.setOpacity(1);
			deleteUserLabel.setText("found");
		}

	}

	// delete user

	@FXML
	private Button deleteButton;

	@FXML
	private TextField searchIDfield;

	@FXML
	private Button searhButton;

	@FXML
	void deleteClicked(ActionEvent event) {
		try {
			int searchid = searchID(searchIDfield, deleteUserLabel);
			Admin admin = Admin.getInstance("ahmed", "ahmed45");
			String[][] data = (CSV.readData("src/csv files/UserData.csv"));
			if (searchid > 0) {
				currentUser = new RegularUser(data[searchid][0], data[searchid][1], Integer.parseInt(data[searchid][2]),
						Double.parseDouble(data[searchid][3]), data[searchid][4]);
				admin.deleteUser(currentUser);
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid Input. You must enter a digit.");
		}
	}

	@FXML
	private Label deleteuserusernamelabel;
	@FXML
	private Label deleteuserabalance;
	@FXML
	private Label deleteUserLabel;

	@FXML
	void searchClicked(ActionEvent event) {
		int searchid = searchID(searchIDfield, deleteUserLabel);
		String[][] data = (CSV.readData("src/csv files/UserData.csv"));
		if (searchid > 0) {
			deleteuserusernamelabel.setTextFill(Color.BLACK);
			deleteuserusernamelabel.setText("username: " + data[searchid][0]);
			deleteuserabalance.setText("account balance: " + data[searchid][3]);
		}
	}

	// Retrive User
	@FXML
	private TextField searchRetriveIDfield;

	@FXML
	private Button searhRetrieveButton;
	@FXML
	private Label retriveUserLabel;
	@FXML
	private Label retriveUserUNLabel;
	@FXML
	private Label retriveUserABLabel;
	@FXML
	private Label retriveUserEmailLabel;
	@FXML
	private Label retriveUserGenderLabel;

	@FXML
	void searchRetrieveClicked(ActionEvent event) {
		int searchid = searchID(searchRetriveIDfield, retriveUserLabel);
		String[][] data = (CSV.readData("src/csv files/UserData.csv"));
		if (searchid > 0) {
			retriveUserUNLabel.setText("UserName: " + data[searchid][0]);
			retriveUserABLabel.setText("Account Balance: " + data[searchid][3]);
			// retriveUserEmailLabel.setText("UserName: "+data[searchid][0]);
			retriveUserGenderLabel.setText("Gender: " + data[searchid][4]);
		}
	}

	int searchID(TextField id, Label label) {
		try {
			int searchid = Integer.parseInt(id.getText());
			System.out.println(searchid);
			boolean found = false;
			String[][] data = CSV.readData("src/csv files/UserData.csv");
			for (int i = 1; i < data.length; i++) {
				if (searchid == Integer.parseInt(data[i][2])) {
					label.setOpacity(0);
					found = true;
					return searchid;
				}

			}
			if (searchid <= 0) {
				throw new Exception();
			}
			if (!found) {
				label.setTextFill(Color.RED);
				label.setOpacity(1);
				label.setText("Not Found");
			}
		} catch (Exception e) {
			label.setTextFill(Color.RED);
			label.setOpacity(1);
			label.setText("Invalid Input");
			System.out.println(e);
		}
		return 0;
	}
}
