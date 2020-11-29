package Boundary;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class MovieApp extends Application {
	
	Stage window;
	
    public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void start(Stage primaryStage){
		
		try {
			this.window=primaryStage;
			Parent root =FXMLLoader.load(getClass().getResource("/Boundary/MainPage.fxml"));
			Scene scene= new Scene(root);
			window.setScene(scene);
			window.show();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.print("error");
		}
		
	}
	
	public void login(ActionEvent event) {
		
		LoginView lv = new LoginView();
		lv.begin(window);;
	}
	
	public void signUp(ActionEvent event) {
		
		SignUpView sv= new SignUpView();
		sv.perform();
		
	}
	
	public void useAsGuest(ActionEvent event) {
		Menu m= new Menu();
		m.perform();
	}


}