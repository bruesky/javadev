/**
 * 
 */
package ui;

import application.SystemManager;
import business.Address;
import business.LibraryMember;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * @author 610122
 *
 */
public class AddMemberController{
	
	@FXML
	private TextField memberId;
	
	@FXML
	private TextField firstName;
	
	@FXML
	private TextField lastName;

	@FXML
	private TextField street;
	
	@FXML
	private TextField city;
	
	@FXML
	private TextField state;
	
	@FXML
	private TextField zip;
	
	@FXML
	private TextField telNumber;
	
	@FXML
	private Button btnAddMemer;
	
	@FXML
	private Label msgLabel;
	
	@FXML
	private void btnAddMemberClick() {
		if (memberId.getText().equals("")) {
			msgLabel.setText("Please input the member id!");
			return;
		}
		if (firstName.getText().equals("")) {
			msgLabel.setText("Please input the first Name!");
			return;
		}
		if (lastName.getText().equals("")) {
			msgLabel.setText("Please input the last Name!");
			return;
		}
		if (street.getText().equals("")) {
			msgLabel.setText("Please input the street!");
			return;
		}
		if (!zip.getText().matches("^[0-9]*$")) {
			msgLabel.setText("zip must be numbers!");
			return;
		}
		if (!telNumber.getText().matches("^[0-9]*$")) {
			msgLabel.setText("tel Number must be numbers!");
			return;
		}
		// check if the member id exists
		LibraryMember libraryMember = SystemManager.getInstance().getLibraryMemberByID(memberId.getText());
		if (libraryMember != null) {
			msgLabel.setText("Can't add member, the member Id already exists!");
			return;
		}
		Address addr = new Address(street.getText(), city.getText(), state.getText(), zip.getText());
		libraryMember = new LibraryMember(firstName.getText(),lastName.getText(),"",memberId.getText(),addr);
		int update = SystemManager.getInstance().saveLibraryMember(libraryMember);
		if (update == 1) {
			msgLabel.setText("A member is successfully added!");
			return;
		} else {
			msgLabel.setText("Add failed, try again!");
			return;
		}
	}

}
