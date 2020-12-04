package Boundary;

import java.io.IOException;

import java.text.ParseException;

import Controller.PaymentController;
import Controller.UserController;
import Model.AnonymousUser;
import Model.RegisteredUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Menu implements View {


	Stage window;
	

	@FXML
	private Label userstatus;
	
	public void begin(Stage s)
	{
		window = s;
		perform();
	}
	@Override
	public void perform() {
		try {
			Parent root =FXMLLoader.load(getClass().getResource("/Boundary/MenuPage2.fxml"));
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
		window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		Parent root =FXMLLoader.load(getClass().getResource("/Boundary/LoginNew.fxml"));
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
	
	public void payAnnualFee(ActionEvent event)
	{
		window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		if(UserController.getUser() instanceof RegisteredUser)
		{
			PaymentView pv = new PaymentView();
			PaymentController.setPrice(20);
			pv.begin(window);
		}
		else if(UserController.getUser() instanceof AnonymousUser)
		{
			userstatus.setText("You have to log in first");
		}
			
	}
	
	public void signOut(ActionEvent event)
	{
		window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		if(UserController.getUser() instanceof RegisteredUser)
		{
			UserController.setUser(new AnonymousUser());
			userstatus.setText("Sign out successfully");
		}
		else if(UserController.getUser() instanceof AnonymousUser)
		{
			userstatus.setText("You have to log in first");
		}
	}

}
