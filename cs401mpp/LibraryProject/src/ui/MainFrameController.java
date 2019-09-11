/**
 * 
 */
package ui;

import java.io.IOException;

import business.Auth;
import business.Staff;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * @author jiang
 *
 */
public class MainFrameController {

	@FXML
	private VBox vbox;
	
	@FXML
	private AnchorPane anchorPaneMain;

	@FXML
	private void initialize() throws IOException {
		this.beforeLogin();
	}
	
	private void beforeLogin() throws IOException {

		Text title = new Text("please login");
		title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		vbox.getChildren().add(title);

		Hyperlink options[] = new Hyperlink[] { new Hyperlink("Login") };

		// Load root layout from fxml file.
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainFrameController.class.getResource("./Login.fxml"));
		AnchorPane ap = (AnchorPane) loader.load();
		LoginController controller = loader.getController();
		controller.setMainFrameController(this);
		anchorPaneMain.getChildren().setAll(ap);
		options[0].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				anchorPaneMain.getChildren().setAll(ap);
			}
		});
		vbox.getChildren().clear();
		for (int i = 0; i < options.length; i++) {
			VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
			vbox.getChildren().add(options[i]);
		}
	}
	/**
	 * set menu after login
	 * @param auth
	 * @throws IOException
	 */
	void afterLogin(Staff staff) throws IOException {
		Text title1 = new Text("welcome");
		title1.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		vbox.getChildren().add(title1);
		Text title = new Text("Menu");
		title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		vbox.getChildren().add(title);

		Hyperlink options[] = new Hyperlink[] { 
				new Hyperlink("Checkout book"),
				new Hyperlink("* Print checkout record"), 
				new Hyperlink("Add new member"), 
				new Hyperlink("Add copy of book"), 
				new Hyperlink("* Add book"), 
				new Hyperlink("* Check copy status"), 
				new Hyperlink("Logout") };

		FXMLLoader loader1 = new FXMLLoader();
		loader1.setLocation(MainFrameController.class.getResource("./CheckoutBooks.fxml"));
		AnchorPane ap1 = (AnchorPane) loader1.load();
//		CheckoutBooksController checkoutBookController = (CheckoutBooksController) loader.getController();
//		checkoutBookController.setMainFrameController(this);
		options[0].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				anchorPaneMain.getChildren().setAll(ap1);
			}
		});
		
		FXMLLoader loader5 = new FXMLLoader();
		loader5.setLocation(MainFrameController.class.getResource("./PrintCheckoutRecord.fxml"));
		AnchorPane ap5 = (AnchorPane) loader5.load();
//		AddMemberController addMembercontroller = (AddMemberController) loader1.getController();
//		addMembercontroller.setMainFrameController(this);
		
		options[1].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				anchorPaneMain.getChildren().setAll(ap5);
			}
		});
//		options[1].setStyle("-fx-background-color: yellow;");
		
		FXMLLoader loader2 = new FXMLLoader();
		loader2.setLocation(MainFrameController.class.getResource("./AddMember.fxml"));
		AnchorPane ap2 = (AnchorPane) loader2.load();
//		AddMemberController addMembercontroller = (AddMemberController) loader1.getController();
//		addMembercontroller.setMainFrameController(this);
		
		options[2].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				anchorPaneMain.getChildren().setAll(ap2);
			}
		});
		
		FXMLLoader loader3 = new FXMLLoader();
		loader3.setLocation(MainFrameController.class.getResource("./AddBookCopy.fxml"));
		AnchorPane ap3 = (AnchorPane) loader3.load();
//		AddBookCopyController addBookCopyController = (AddBookCopyController) loader.getController();
//		addBookCopyController.setMainFrameController(this);
		options[3].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				anchorPaneMain.getChildren().setAll(ap3);
			}
		});

		FXMLLoader loader4 = new FXMLLoader();
		loader4.setLocation(MainFrameController.class.getResource("./AddBook.fxml"));
		AnchorPane ap4 = (AnchorPane) loader4.load();
//		AddBookCopyController addBookCopyController = (AddBookCopyController) loader.getController();
//		addBookCopyController.setMainFrameController(this);
		options[4].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				anchorPaneMain.getChildren().setAll(ap4);
			}
		});
//		options[4].setStyle("-fx-background-color: yellow;");
		
		FXMLLoader loader6 = new FXMLLoader();
		loader6.setLocation(MainFrameController.class.getResource("./CheckCopyStatus.fxml"));
		AnchorPane ap6 = (AnchorPane) loader6.load();
//		AddBookCopyController addBookCopyController = (AddBookCopyController) loader.getController();
//		addBookCopyController.setMainFrameController(this);
		options[5].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				anchorPaneMain.getChildren().setAll(ap6);
			}
		});
//		options[5].setStyle("-fx-background-color: yellow;");
		
		options[6].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				try {
					beforeLogin();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		vbox.getChildren().clear();
		for (int i = 0; i < options.length; i++) {
			if (staff.getAuth().equals(Auth.ADMIN) && (i == 0 || i == 1)) {
				continue;
			}
			if (staff.getAuth().equals(Auth.LIBRARIAN) && (i >= 2 && i <= 5)) {
				continue;
			}
			VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
			vbox.getChildren().add(options[i]);
		}
		
		anchorPaneMain.getChildren().clear();

	}

}
