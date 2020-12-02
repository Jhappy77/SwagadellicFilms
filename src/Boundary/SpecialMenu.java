//package Boundary;
//
//import java.io.IOException;
//import java.text.ParseException;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.stage.Stage;
//
//public class SpecialMenu implements View{
//	Stage window;
//	@Override
//	public void perform() {
//		
//		try {
//			Parent root =FXMLLoader.load(getClass().getResource("/Boundary/RUMenuPage.fxml"));
//			Scene scene= new Scene(root);
//			window.setScene(scene);
//			window.show();
//			} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//	 public void begin(Stage s)
//	 {
//		 window = s;
//		 perform();
//	 }
//	 
//	 public void returnToMenu(ActionEvent event) throws IOException
//		{
//			window = (Stage) ((Button) event.getSource()).getScene().getWindow();
//			Parent root =FXMLLoader.load(getClass().getResource("/Boundary/MainPage.fxml"));
//			Scene scene= new Scene(root);
//			window.setScene(scene);
//			window.show();
//		}
//	 public void bookTickets(ActionEvent event) throws ParseException {
//		 	window = (Stage) ((Button) event.getSource()).getScene().getWindow();
//			SelectMovieView mv =new SelectMovieView();
//			mv.begin(window);
//		}
//
//		public void cancelTicket(ActionEvent event) {}
//		
//		
//		//TODO: Ensure this is working correctly (Changed paymentview constructor)
//		public void payAnnualFee(ActionEvent event) {
//			PaymentView p= new PaymentView();
//			p.perform();
//		}
//
//}
