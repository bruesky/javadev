package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController {
	@FXML
	private TextField un; 
	@FXML
	private PasswordField pw; 
	@FXML
	private Button btnButton;
	@FXML
	private Text ctext;
	
	public void login(ActionEvent actionEvent) {
		System.out.print("hello");
		String nameString = un.getText();
		String pwdString = pw.getText();
		System.out.println(nameString+" "+pwdString);
		
		ctext.setText(nameString+" "+pwdString);
		
		if (un.equals("Renuka") && pw.equals("Renuka")) {
			ctext.setText("Successful");
//			ctext.showAndWait();
		} else {
			System.out.println("Failure");
			ctext.setText("Login Failure due to incorrect Userid or Password");
//			ctext.showAndWait();
		}
	}
	
	
}
