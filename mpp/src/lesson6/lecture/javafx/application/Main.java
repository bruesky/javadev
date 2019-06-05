package lesson6.lecture.javafx.application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import java.awt.*;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			Parent root = FXMLLoader.load(getClass().getResource("MyTest.fxml"));
//			Scene scene = new Scene(root,400,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setTitle("Login Window");
//			primaryStage.setScene(scene);
//			primaryStage.show();


//			primaryStage.setTitle("Slide");
//
//			Group root1 = new Group();
//			Group root2 = new Group();
//
//			Scene scene1 = new Scene(root1, 300, 250);
//			Scene scene2 = new Scene(root2, 300, 250);
//
//			Rectangle rectangle2 = new Rectangle(300, 250);
//			rectangle2.setFill(Color.BLUE);
//			root2.getChildren().add(rectangle2);



//			Rectangle rectangle1 = new Rectangle(300, 250);
//			rectangle1.setFill(Color.RED);
//			root1.getChildren().add(rectangle1);

//			Button btn = new Button();
//			root1.getChildren().add(btn);
//
//
//
//			primaryStage.setScene(scene1);
//			primaryStage.show();
//
//
//			btn.setOnAction(new EventHandler< ActionEvent >(){
//				@Override
//				public void handle(ActionEvent event) {
//					primaryStage.setScene(scene2);
//				}
//			});
			// Here i  need a slide effect,
			// this method is called when a button is pressed.




			primaryStage.setTitle("Popup Example");
			final Popup popup = new Popup();
			popup.setX(300);
			popup.setY(200);
			popup.getContent().addAll(new Circle(25, 25, 50, Color.AQUAMARINE));

			Button show = new Button("Show");
			show.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					popup.show(primaryStage);
				}
			});

			Button hide = new Button("Hide");
			hide.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					popup.hide();
				}
			});

			HBox layout = new HBox(10);
			layout.setStyle("-fx-background-color: cornsilk; -fx-padding: 10;");
			layout.getChildren().addAll(show, hide);

			primaryStage.setScene(new Scene(layout));
			primaryStage.show();

			show.setVisible(false);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
