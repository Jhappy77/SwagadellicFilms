package Boundary;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MovieAppTest extends Application{
	private LoginView LView;
	private SignUpView SView;
	private PaymentView PView;
	private RefundView RView;
	private SeatView SeView;
	private SelectMovieView SMView;
	private Button button1, button2, button3;
	private Stage window;
	private Scene scene1, scene2;
	public static void main(String[] args)
	{
		MovieAppTest app = new MovieAppTest();
		launch(args);
	}
	
	public MovieAppTest()
	{
		LView = new LoginView();
		SView = new SignUpView();
		PView = new PaymentView();
		RView = new RefundView();
		SeView = new SeatView();
		SMView = new SelectMovieView();
	}
	
	


	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		primaryStage.setTitle("First Menu");
		button1 = new Button("Log in");
		button1.setPrefSize(120, 30);
		VBox layout1 = new VBox(20);
		StackPane layout2 = new StackPane();
		layout1.getChildren().addAll(button1);
		scene1 = new Scene(layout1, 200, 200);
		
		
		scene2 = new Scene(layout2, 200, 200);
		window.setScene(scene1);
		button1.setOnAction(e-> {
			LView.setWindow(window);
			LView.setScene1(scene2);
			LView.setScene2(scene1);
			LView.perform(layout1, layout2, button1);
		});
		
		window.show();
		
//		topMenu.getChildren().addAll(button1);
//		HBox left = new HBox();
		button2 = new Button("Sign up");
		button3 = new Button("Continue as guest");
		layout1.getChildren().addAll(button2, button3);
//		BorderPane borderPane = new BorderPane();
//		borderPane.setTop(topMenu);
//		borderPane.setLeft(left);
//		scene1 = new Scene(borderPane, 300, 250);
//		primaryStage.setScene(scene1);
//		primaryStage.show();
	}
}
