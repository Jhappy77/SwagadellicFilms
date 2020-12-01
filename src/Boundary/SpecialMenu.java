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
import javafx.stage.Stage;

public class SpecialMenu implements View{
	
	@Override
	public void perform() {
		try {
			Stage primaryStage = new Stage();
			Parent root =FXMLLoader.load(getClass().getResource("/Boundary/RUMenuPage.fxml"));
			Scene scene= new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
=======
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SpecialMenu implements View{
	Stage window;
	@Override
	public void perform() {
		
		try {
			Parent root =FXMLLoader.load(getClass().getResource("/Boundary/RUMenuPage.fxml"));
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
	
	public void payAnnualFee(ActionEvent event) {
		PaymentView p= new PaymentView();
		p.perform();
	}
=======
	 public void begin(Stage s)
	 {
		 window = s;
		 perform();
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

		public void cancelTicket(ActionEvent event) {}
		
		public void payAnnualFee(ActionEvent event) {
			PaymentView p= new PaymentView(true, true);
			p.perform();
		}
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da

}
