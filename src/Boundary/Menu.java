package Boundary;

import java.io.IOException;
<<<<<<< HEAD
=======
import java.text.ParseException;
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
<<<<<<< HEAD
=======
import javafx.scene.control.Button;
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
import javafx.stage.Stage;

public class Menu implements View {

<<<<<<< HEAD
	@Override
	public void perform() {
		try {
			Stage primaryStage = new Stage();
			Parent root =FXMLLoader.load(getClass().getResource("/Boundary/MenuPage.fxml"));
			Scene scene= new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
=======
	Stage window;
	
	public void begin(Stage s)
	{
		window = s;
		perform();
	}
	@Override
	public void perform() {
		try {
			Parent root =FXMLLoader.load(getClass().getResource("/Boundary/MenuPage.fxml"));
			Scene scene= new Scene(root);
			window.setScene(scene);
			window.show();
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
<<<<<<< HEAD

	public void bookTickets(ActionEvent event) {
		SelectMovieView mv =new SelectMovieView();
		mv.perform();
	}

	public void cancelTicket(ActionEvent event) {}
=======
	public void signUp(ActionEvent event) throws IOException
	{
		window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		Parent root =FXMLLoader.load(getClass().getResource("/Boundary/SignUp.fxml"));
		Scene scene= new Scene(root);
		window.setScene(scene);
		window.show();
	}
	
	
	public void logIn(ActionEvent event) throws IOException
	{
		Parent root =FXMLLoader.load(getClass().getResource("/Boundary/Login.fxml"));
		Scene scene= new Scene(root);
		window.setScene(scene);
		window.show();
	}

	public void returnToMenu(ActionEvent event) throws IOException
	{
		window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		Parent root =FXMLLoader.load(getClass().getResource("/Boundary/MainPage.fxml"));
		Scene scene= new Scene(root);
		window.setScene(scene);
		window.show();
	}
	
	public void bookTickets(ActionEvent event) throws ParseException {
		window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		SelectMovieView mv =new SelectMovieView();
		mv.begin(window);
	}

	public void cancelTicket(ActionEvent event) {
		window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		CancelView cv = new CancelView();
		cv.begin(window);
	}
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da

}
