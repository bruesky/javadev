/**
 * 
 */
package ui;

import application.SystemManager;
import business.Author;
import business.Book;
import business.BookCopy;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * @author 610122
 *
 */
public class AddBookCopyController{

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
	private Label msgLabel;
	
	@FXML
	private Button btnSearchBook;
	
	@FXML
	private Button btnAddBookCopy;
	
	@FXML
	private void btnSearchBookClick() {
		if (isbn.getText().equals("")) {
			msgLabel.setText("Please input the ISBN of the book!");
			return;
		} else if (!isbn.getText().matches("^[0-9-]*$")) {
			msgLabel.setText("ISBN must be numbers or '-'!");
			return;
		}
		this.book = SystemManager.getInstance().getBookByISBN(isbn.getText());
		// show data
		lblTitle.setText(book.getTitle());
		
		String authors = "";
		for ( Author a : book.getAuthors()) {
			if (!"".equals(authors)) {
				authors += "; ";
			}
			authors += a.getFirstName()+" " + a.getLastName();
		}
		lblAuthor.setText(authors);
		lblCopyCount.setText(String.valueOf(book.getCopies().size()));
		lblMaxCheckoutDays.setText(String.valueOf(book.getMaxCheckoutDays()));
	}
	
	@FXML
	private void btnAddBookCopyClick() {
		BookCopy bookCopy = new BookCopy(this.book);
		bookCopy.setCopyNumber(this.book.getCopies().size() + 1);
		this.book.getCopies().add(bookCopy);
		int update = SystemManager.getInstance().saveBook(this.book);
		if (update == 1) {
			msgLabel.setText("A copy of this book is successfully added!");
			return;
		} else {
			msgLabel.setText("Add failed, try again!");
			return;
		}
	}
	
}
