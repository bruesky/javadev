package ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import application.SystemManager;
import business.Book;
import business.BookCopy;
import business.CheckoutEntry;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CheckCopyStatusController {
	
	public class TableItemData{
		private String tb_isbn;
		private String tb_title;
		private int tb_num;
		private String tb_status;
		private String tb_mem;
		public String getTb_isbn() {
			return tb_isbn;
		}
		public String getTb_title() {
			return tb_title;
		}
		public int getTb_num() {
			return tb_num;
		}
		public String getTb_status() {
			return tb_status;
		}
		public String getTb_mem() {
			return tb_mem;
		}
		@Override
		public String toString() {
			return tb_isbn+" "+tb_title+" "+tb_num+" "+tb_status+" "+tb_mem;
		}
	}
	
	@FXML
	private Button btnSearchBook;
	
	@FXML
	private TextField isbn;
	
	@FXML
	private Label msgLabel;
	private Book book;
	
	@FXML
	private TableView<TableItemData> tableBookCopy;
	@FXML
	private TableColumn<String, TableItemData> tb_isbn;
	@FXML
	private TableColumn<String, TableItemData> tb_title;
	@FXML
	private TableColumn<String, TableItemData> tb_num;
	@FXML
	private TableColumn<String, TableItemData> tb_status;
	@FXML
	private TableColumn<String, TableItemData> tb_mem;
	
	private List<TableItemData> itemDatas = new ArrayList<CheckCopyStatusController.TableItemData>();

	@FXML
	private void btnClick() {
		if (isbn.getText().equals("")) {
			msgLabel.setText("Please input the ISBN of the book!");
			return;
		} else if (!isbn.getText().matches("^[0-9-]*$")) {
			msgLabel.setText("ISBN must be numbers or '-'!");
			return;
		}
		msgLabel.setText("");
		this.book = SystemManager.getInstance().getBookByISBN(isbn.getText());

		List<BookCopy> copies = this.book.getCopies();
		itemDatas.clear();
		for (BookCopy bookCopy : copies) {
			TableItemData tableItemData = new TableItemData();
			tableItemData.tb_isbn = bookCopy.getOriginal().getISBN();
			tableItemData.tb_title = bookCopy.getOriginal().getTitle();
			tableItemData.tb_num = bookCopy.getCopyNumber();
			for (CheckoutEntry ce : bookCopy.getCheckoutEntrys()) {
				tableItemData.tb_status = ce.getDueDate().toString();
				LocalDate nowDate = LocalDate.now();
				if (nowDate.compareTo(ce.getDueDate())>0) {
					tableItemData.tb_status = "past due";
				}
				tableItemData.tb_mem = ce.getLendToMemberIdString();
			}
			itemDatas.add(tableItemData);
		}
		
		tableBookCopy.getItems().clear();
		tb_isbn.setCellValueFactory(new PropertyValueFactory<>("tb_isbn"));
		tb_title.setCellValueFactory(new PropertyValueFactory<>("tb_title"));
		tb_num.setCellValueFactory(new PropertyValueFactory<>("tb_num"));
		tb_status.setCellValueFactory(new PropertyValueFactory<>("tb_status"));
		tb_mem.setCellValueFactory(new PropertyValueFactory<>("tb_mem"));
		tableBookCopy.getItems().addAll(itemDatas);
	}

}
