/**
 * 
 */
package ui;

import java.util.ArrayList;
import java.util.List;

import application.SystemManager;
import business.Address;
import business.Author;
import business.Book;
import business.BookCopy;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * @author 610122
 *
 */
public class AddBookController{
	
	public class TableEdit {
		private String firstName;
		private String lastName;
		private String credentials;
		private String bio;
		private String street;
		private String city;
		private String state;
		private String zip;
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getCredentials() {
			return credentials;
		}
		public void setCredentials(String credentials) {
			this.credentials = credentials;
		}
		public String getBio() {
			return bio;
		}
		public void setBio(String bio) {
			this.bio = bio;
		}
		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getZip() {
			return zip;
		}
		public void setZip(String zip) {
			this.zip = zip;
		}
		
	}
	
	@FXML
	private TextField isbn;
	@FXML
	private TextField title;
	@FXML
	private TextField maxCheckoutdays;
	@FXML
	private TextField copyNumber;
	
	@FXML
	private TableView<TableEdit> tableAuthor;
	@FXML
	private TableColumn<String, TableEdit> colFirstName;
	@FXML
	private TableColumn<String, TableEdit> colLastName;
	@FXML
	private TableColumn<String, TableEdit> colCredentials;
	@FXML
	private TableColumn<String, TableEdit> colBio;
	@FXML
	private TableColumn<String, TableEdit> colStreet;
	@FXML
	private TableColumn<String, TableEdit> colCity;
	@FXML
	private TableColumn<String, TableEdit> colState;
	@FXML
	private TableColumn<String, TableEdit> colZip;
	@FXML
	private TextField firstName;
	@FXML
	private TextField lastName;
	@FXML
	private TextField credentials;
	@FXML
	private TextField bio;
	@FXML
	private TextField street;
	@FXML
	private TextField city;
	@FXML
	private TextField state;
	@FXML
	private TextField zip;
	@FXML
	private Label msgLabel;
	
	@FXML
	private Button btnAddBook;
	
	@FXML
	private void initialize() {
		colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		colCredentials.setCellValueFactory(new PropertyValueFactory<>("credentials"));
		colBio.setCellValueFactory(new PropertyValueFactory<>("bio"));
		colStreet.setCellValueFactory(new PropertyValueFactory<>("street"));
		colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
		colState.setCellValueFactory(new PropertyValueFactory<>("state"));
		colZip.setCellValueFactory(new PropertyValueFactory<>("zip"));
	}
	@FXML
	private void btnAddAuthorClick() {
		msgLabel.setText("");
		if ("".equals(firstName.getText())) {
			msgLabel.setText("Please input first name!");
			return;
		}
		if ("".equals(lastName.getText())) {
			msgLabel.setText("Please input last name!");
			return;
		}
		if ("".equals(street.getText())) {
			msgLabel.setText("Please input street!");
			return;
		}
		TableEdit t = new TableEdit();
		t.firstName = firstName.getText();
		t.lastName = lastName.getText();
		t.credentials = credentials.getText();
		t.bio = bio.getText();
		t.street = street.getText();
		t.city = city.getText();
		t.state = state.getText();
		t.zip = zip.getText();
		
		tableAuthor.getItems().add(t);
	}
	
	@FXML
	private void btnDelAuthorClick() {
		msgLabel.setText("");
		List<TableEdit> t = tableAuthor.getItems();
		if (tableAuthor.getSelectionModel().getSelectedIndex() < 0) {
			msgLabel.setText("Please select a data!");
			return;			
		}
		t.remove(tableAuthor.getSelectionModel().getSelectedIndex());
		tableAuthor.getItems().clear();
		tableAuthor.getItems().addAll(t);
	}
	
	@FXML
	private void btnAddBookClick() {
		msgLabel.setText("");
		if (isbn.getText().equals("")) {
			msgLabel.setText("Please input the ISBN of the book!");
			return;
		}
		if (!isbn.getText().matches("^[0-9-]*$")) {
			msgLabel.setText("ISBN must be numbers or '-'!");
			return;
		}
		if (title.getText().equals("")) {
			msgLabel.setText("Please input the title of the book!");
			return;
		}
		if (maxCheckoutdays.getText().equals("")) {
			msgLabel.setText("Please input the title of the book!");
			return;
		}
		if (!maxCheckoutdays.getText().matches("^[0-9]*$")) {
			msgLabel.setText("ISBN must be numbers!");
			return;
		}
		Book book = new Book(title.getText(), isbn.getText(), Integer.valueOf(maxCheckoutdays.getText()));
		List<Author> authorList = new ArrayList<Author>();
		for (TableEdit t  : tableAuthor.getItems()) {
			Address ad = new Address(t.getStreet(), t.getCity(), t.getState(), t.getZip());
			Author au = new Author(t.getFirstName(),t.getLastName(),"",t.getCredentials(),t.getBio());
			au.setAddress(ad);
			au.setBook(book);
			authorList.add(au);
		}
		book.setAuthors(authorList);
		
		List<BookCopy> bookCopyList = new ArrayList<BookCopy>();
		for (int i = 1; i<=Integer.valueOf(copyNumber.getText()); i++) {
			BookCopy bookCopy = new BookCopy(book);
			bookCopy.setAvailable(true);
			bookCopy.setCopyNumber(i);
			bookCopyList.add(bookCopy);
		}
		book.setCopies(bookCopyList);
		int update = SystemManager.getInstance().saveBook(book);
		if (update == 1) {
			msgLabel.setText("A book is successfully added!");
			return;
		} else {
			msgLabel.setText("Add failed, try again!");
			return;
		}
	}
	
}
