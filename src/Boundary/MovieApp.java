package Boundary;


import java.io.IOException;
import java.util.ArrayList;

import Controller.MovieController;
import Controller.PaymentController;
import Model.MovieScreening;
import Model.Seat;
import Model.Ticket;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class MovieApp extends Application {

	Stage window;
	Scene scene;

    public static void main(String[] args) {
    	MovieController.showTimes = new ArrayList<MovieScreening>();
//    	PaymentController.tickets = new ArrayList<Ticket>();
    	PaymentController.bookedSeats = new ArrayList<Seat>();
        launch(args);
    }
    

    

	@Override
	public void start(Stage primaryStage){
		
		try {
			window= new Stage();
			Parent root =FXMLLoader.load(getClass().getResource("/Boundary/MainPage.fxml"));
			scene= new Scene(root);
			window.setScene(scene);
			window.show();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.print("error");
		}
		
	}
	
	public void login(ActionEvent event) {
		LoginView lv = new LoginView();
		window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		lv.begin(window);
	}
	
	public void signUp(ActionEvent event) {
		
		SignUpView sv= new SignUpView();
		window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		sv.begin(window);
		
	}
	
	public void useAsGuest(ActionEvent event) {
		Menu m= new Menu();
		window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		m.begin(window);
		m.perform();
	}


}
