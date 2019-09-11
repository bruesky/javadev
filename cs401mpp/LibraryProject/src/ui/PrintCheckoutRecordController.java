package ui;

import java.util.ArrayList;
import java.util.List;

import application.SystemManager;
import business.CheckoutEntry;
import business.CheckoutRecord;
import business.FineRecord;
import business.LibraryMember;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrintCheckoutRecordController {
	
	private CheckoutRecord cr;
	private List<CheckoutEntry> entries = new ArrayList<>();
	private List<FineRecord> fines = new ArrayList<>();

	@FXML
	private Label title;
	
	@FXML
	private Label memberIdLabel;
	
	@FXML
	private TextField memberId;
	
	@FXML
	private Button printBtn;
	
	@FXML
	private TextArea checkoutRecord;
	
	@FXML
	private Label msgLabel;
	
	
	@FXML
	private void btnPrintCheckoutRecordClick() {
		if (memberId.getText().equals("")) {
			msgLabel.setText("Please input a member ID!");
			return;
		}
		
		LibraryMember libraryMember = SystemManager.getInstance().getLibraryMemberByID(memberId.getText());
		if (libraryMember==null) {
			msgLabel.setText("This member does not exist!");
			return;
		}
		
		checkoutRecord.clear();
		checkoutRecord.appendText(libraryMember.toString()+ '\r' + '\n');
		
		cr = libraryMember.getCheckoutRecord();
		entries = cr.getEntries();
		
		for(CheckoutEntry ce:entries) {
			checkoutRecord.appendText("Copy number is " + ce.getBookCopy().getCopyNumber() + '\r' + '\n');
			checkoutRecord.appendText("Checkout date is " + ce.getCheckoutDate().toString() + '\r' + '\n');
			checkoutRecord.appendText("Due date is " + ce.getDueDate().toString() + '\r' + '\n');
		}
		
		fines = cr.getFines();
		
		for(FineRecord fr:fines) {
		//	fr.getAmount();
		//	fr.getDateOfReturn();
		//	fr.getDaysLate();
		//	fr.getNumber();
			
			checkoutRecord.appendText("Amount is " + fr.getAmount() + '\r' + '\n');
			checkoutRecord.appendText("Date of return is " + fr.getDateOfReturn().toString() + '\r' + '\n');
			checkoutRecord.appendText("Delay days is " + fr.getDaysLate() + '\r' + '\n');
			checkoutRecord.appendText("Number is " + fr.getNumber() + '\r' + '\n');
			
		}
		
		
		//checkoutRecord.setText();
		
	}
	
	
}
