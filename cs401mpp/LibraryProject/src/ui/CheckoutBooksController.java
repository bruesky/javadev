package ui;

import java.time.LocalDate;

import application.SystemManager;
import business.Author;
import business.Book;
import business.BookCopy;
import business.CheckoutEntry;
import business.CheckoutRecord;
import business.LibraryMember;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CheckoutBooksController{
	
	private Book book;
	
	@FXML
	private TextField isbn;

	@FXML
	private Label lblTitle;
	@FXML
	private Label lblAuthor;
	@FXML
	private Label lblCopyCount;
	@FXML
	private Label lblMaxCheckoutDays;
	
	@FXML
	private TextField memberId;
	
	@FXML
	private Button btnSearchBook;
	
	@FXML
	private Button btnCheckoutBook;
	
	@FXML
	private Label msgLabel;

	@FXML
	private TableView<BookCopy> tableBookCopy;
	@FXML
	private TableColumn<String, BookCopy> colCopyNumber;
	@FXML
	private TableColumn<String, BookCopy> colAvailable;
	
	@FXML
	private void btnSearchBookClick() {
		doSearchBook();
	}
	
	private void doSearchBook() {
		if (isbn.getText().equals("")) {
			msgLabel.setText("Please input the ISBN of the book!");
			return;
		} else if (!isbn.getText().matches("^[0-9-]*$")) {
			msgLabel.setText("ISBN must be numbers or '-'!");
			return;
		}
		this.book = SystemManager.getInstance().getBookByISBN(isbn.getText());
		if (book == null) {
			msgLabel.setText("A book with this ISBN does not exist!");
			return;
		}

		// show data
		lblTitle.setText(book.getTitle());

		String authors = "";
		for (Author a : book.getAuthors()) {
			if (!"".equals(authors)) {
				authors += "; ";
			}
			authors += a.getFirstName() + " " + a.getLastName();
		}
		lblAuthor.setText(authors);
		lblCopyCount.setText(String.valueOf(book.getCopies().size()));
		lblMaxCheckoutDays.setText(String.valueOf(book.getMaxCheckoutDays()));
		// show bookcopy
		tableBookCopy.getItems().clear();
		colCopyNumber.setCellValueFactory(new PropertyValueFactory<>("copyNumber"));
		colAvailable.setCellValueFactory(new PropertyValueFactory<>("available"));
		tableBookCopy.getItems().addAll(book.getCopies());
	}
	@FXML
	private void btnCheckoutBookClick() {
		if (tableBookCopy.getSelectionModel().getSelectedItem() == null) {
			msgLabel.setText("Please choose a copy of book!");
			return;
		}
		if (memberId.getText().equals("")) {
			msgLabel.setText("Please input the member Id!");
			return;
		}
		LibraryMember libraryMember = SystemManager.getInstance().getLibraryMemberByID(memberId.getText());
		if (libraryMember==null) {
			msgLabel.setText("This member does not exist!");
			return;
		}
		// get the selected bookcopy
		BookCopy bookCopy = tableBookCopy.getSelectionModel().getSelectedItem();
		if (bookCopy.isAvailable() == false) {
			msgLabel.setText("This copy of book is not availale, choose another copy!");
			return;
		}
		bookCopy.setAvailable(false);
		
		CheckoutEntry checkoutEntry = new CheckoutEntry();
		checkoutEntry.setBookCopy(bookCopy);
		checkoutEntry.setCheckoutDate(LocalDate.now());
		checkoutEntry.setCheckedout(true);
		checkoutEntry.setDueDate(LocalDate.now().plusDays(this.book.getMaxCheckoutDays()));
		if (libraryMember.getCheckoutRecord() ==null) {
			libraryMember.setCheckoutRecord(new CheckoutRecord());
		}
		libraryMember.getCheckoutRecord().addEntry(checkoutEntry);
		int update = SystemManager.getInstance().saveBook(book);
		update = SystemManager.getInstance().saveLibraryMember(libraryMember);
		if (update == 1) {
			msgLabel.setText("This copy of book is successfully checkouted!");
			doSearchBook();
			return;
		} else {
			msgLabel.setText("Checkout failed, try again!");
			return;
		}
	}

}
