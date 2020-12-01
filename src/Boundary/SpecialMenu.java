package Boundary;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void bookTickets(ActionEvent event) {
		SelectMovieView mv =new SelectMovieView();
		mv.perform();
	}

	public void cancelTicket(ActionEvent event) {}
	
	public void payAnnualFee(ActionEvent event) {
		PaymentView p= new PaymentView();
		p.perform();
	}

}
