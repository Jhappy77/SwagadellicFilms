package Boundary;

<<<<<<< HEAD
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
=======

import java.io.IOException;
import java.util.ArrayList;

import Controller.MovieController;
import Controller.PaymentController;
import Model.MovieScreening;
import Model.Ticket;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class MovieApp extends Application {
<<<<<<< HEAD
	
	Stage window;
	
    public static void main(String[] args) {
        launch(args);
    }
=======

	Stage window;
	Scene scene;

    public static void main(String[] args) {
    	MovieController.showTimes = new ArrayList<MovieScreening>();
//    	PaymentController.tickets = new ArrayList<Ticket>();
    	PaymentController.bookedSeats = new ArrayList<Seat>();
        launch(args);
    }
    

    
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da

	@Override
	public void start(Stage primaryStage){
		
		try {
<<<<<<< HEAD
			this.window=primaryStage;
			Parent root =FXMLLoader.load(getClass().getResource("/Boundary/MainPage.fxml"));
			Scene scene= new Scene(root);
=======
			window= new Stage();
			Parent root =FXMLLoader.load(getClass().getResource("/Boundary/MainPage.fxml"));
			scene= new Scene(root);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
			window.setScene(scene);
			window.show();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.print("error");
		}
		
	}
	
	public void login(ActionEvent event) {
<<<<<<< HEAD
		
		LoginView lv = new LoginView();
		lv.begin(window);;
=======
		LoginView lv = new LoginView();
		window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		lv.begin(window);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
	}
	
	public void signUp(ActionEvent event) {
		
		SignUpView sv= new SignUpView();
<<<<<<< HEAD
		sv.perform();
=======
		window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		sv.begin(window);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
		
	}
	
	public void useAsGuest(ActionEvent event) {
		Menu m= new Menu();
<<<<<<< HEAD
=======
		window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		m.begin(window);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
		m.perform();
	}


<<<<<<< HEAD
}
=======
}
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
