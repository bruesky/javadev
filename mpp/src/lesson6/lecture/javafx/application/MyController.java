package lesson6.lecture.javafx.application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MyController {
	@FXML
	private Button bt1;
	@FXML
	private TextField uid;
	@FXML
	private PasswordField pwd;

	public void submit(ActionEvent event) {
		String s1, s2;
		s1 = uid.getText();
		s2 = pwd.getText();
		System.out.println(s1 + " " + s2);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Login Confrimation");
		if (s1.equals("Renuka") && s2.equals("Renuka")) {
			alert.setContentText("Successful");
			alert.showAndWait();
		} else {
			System.out.println("Failure");
			alert.setContentText("Login Failure due to incorrect Userid or Password");
			alert.showAndWait();
		}
	}
}
