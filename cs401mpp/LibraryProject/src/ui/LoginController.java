/**
 * 
 */
package ui;

import java.io.IOException;

import application.SystemManager;
import business.Staff;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * @author jiang
 *
 */
public class LoginController {

	@FXML
	private TextField userName;
	
	@FXML
	private PasswordField password;
	
	@FXML
	private Button btnLogin;
	
	@FXML
	private Label msgLabel;

	private MainFrameController mainFrameController;
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void btnLoginClick() throws IOException {
		if (userName.getText().equals("")) {
			msgLabel.setText("Please input staff id!");
			return;
		}
		if (password.getText().equals("")) {
			msgLabel.setText("Please input password!");
			return;
		}
		Staff staff = SystemManager.getInstance().getStaffByID(userName.getText());
		if (staff==null) {
			msgLabel.setText("User does not exists!");
			return;
		} else if  (!staff.getPassword().equals(password.getText()))  {
			msgLabel.setText("Wrong password!");
			return;
		} else {
			msgLabel.setText("");
			this.mainFrameController.afterLogin(staff);
		}
	}
	
	public void setMainFrameController(MainFrameController controller) {
		this.mainFrameController = controller;
	}
}
