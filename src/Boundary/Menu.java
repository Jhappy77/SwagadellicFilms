package Boundary;

import java.io.IOException;
import java.text.ParseException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Menu implements View {

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
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
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

}
