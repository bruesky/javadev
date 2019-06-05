/**
 * 
 */
package sample;

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

import java.io.IOException;

/**
 * @author jiang
 *
 */
public class MainFrameController {

	@FXML
	private VBox vbox;
	
	@FXML
	private AnchorPane anchorPaneMain;

	// Reference to the main application.
	private Main mainApp;
	
	@FXML
	private void initialize() {
		Text title = new Text("Menu");
		   title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		   vbox.getChildren().add(title);
		 
		   Hyperlink options[] = new Hyperlink[] {
		       new Hyperlink("Login"),
		       new Hyperlink("Add a new library member"),
		       new Hyperlink("Checkout a book"),
		       new Hyperlink("Add a copy")};
		   
		   options[0].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
		        @Override
		        public void handle(MouseEvent e){
		            System.out.println("Mouse Entered on Click Me Two");
		            // Load root layout from fxml file.
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(MainFrameController.class.getResource("./Login.fxml"));
					try {
						anchorPaneMain.getChildren().setAll((AnchorPane)loader.load());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        }
		    });
		   for (int i=0; i<4; i++){
		       VBox.setMargin(options[i], new Insets(0, 0, 0, 8)); //为每个节点设置外边距
		       vbox.getChildren().add(options[i]);
		   }

	}
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;

		// Add observable list data to the table
//		personTable.setItems(mainApp.getPersonData());
	}
}
