package Boundary;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MovieApp extends Application{
	private View view;
	private Button button1, button2, button3;
	private Stage window;
	private Scene scene1, scene2;
	public static void main(String[] args)
	{
		launch(args);
	}
	
//	public static Stage getStage()
//	{
//		return window;
//	}
//	
//	public static Scene getScene1()
//	{
//		return scene1;
//	}
//	
//	public static Scene getScene2()
//	{
//		return scene2;
//	}
	
//	public void displayMenu()
//	{
//		
//	}
	
	public void setView(View v)
	{
		view = v;
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
//		HBox topMenu = new HBox();
		primaryStage.setTitle("First Menu");
		button1 = new Button("Log in");
		button1.setPrefSize(120, 30);
	
		button1.setOnAction(e-> {
			//setView(new LoginView());
			window.setScene(scene2);
			//view.perform(window, scene1, scene2);
		});

		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(button1);
		scene1 = new Scene(layout1, 200, 200);
		
		button2 = new Button("Go back to menu");
		button2.setOnAction(e->{
			window.setScene(scene1);
		});
		StackPane layout2 = new StackPane();
		layout2.getChildren().addAll(button2);
		scene2 = new Scene(layout2, 200, 200);
		window.setScene(scene1);
		window.show();
		
//		topMenu.getChildren().addAll(button1);
//		HBox left = new HBox();
//		button2 = new Button("Sign up");
//		button3 = new Button("Continue as guest");
//		left.getChildren().addAll(button2, button3);
//		BorderPane borderPane = new BorderPane();
//		borderPane.setTop(topMenu);
//		borderPane.setLeft(left);
//		scene1 = new Scene(borderPane, 300, 250);
//		primaryStage.setScene(scene1);
//		primaryStage.show();
	}
}
