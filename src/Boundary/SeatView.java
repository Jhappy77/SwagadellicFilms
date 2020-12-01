package Boundary;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import Controller.SeatController;
import Model.MovieScreening;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SeatView implements View, Initializable{
	
	Stage window;
//	private MovieScreening SeatController.theScreening;
	
	@FXML
	private Label lbmoviename;
	
	@FXML
	private Label lbss;
	
	public SeatMap theSeatMap;
	
	
	public void begin(Stage s)
	{
		window = s;
		perform();
	}
		
	@FXML
	private VBox seatMapBox;
	private SeatController seatController;
	
	private List<Integer> selectedSeats;
	
	public void addSeat(int seatID) {
		selectedSeats.add(seatID);
		System.out.println("The selected seats are: " + selectedSeats.toString());
	}
	
	public void removeSeat(int seatID) {
		selectedSeats.removeAll(Arrays.asList(seatID));
		System.out.println("The selected seats are: " + selectedSeats.toString());
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		seatController = new SeatController();
		MovieScreening screening = seatController.getActiveScreening();
		lbmoviename.setText(screening.toString());
		
		
		theSeatMap = new RectangleSeatMap(20, 10, this);
		// Marks the seats which have already been booked as unavailable. 
		theSeatMap.loadBookedSeat(seatController.getBookedSeatIDs());
		seatMapBox.getChildren().addAll(theSeatMap.display());
		
		
		selectedSeats = new ArrayList<>();
	}
	
	public void perform() {
		try {
			Parent root =FXMLLoader.load(getClass().getResource("/Boundary/Seating.fxml"));
			Scene scene= new Scene(root);
			//scene.getStylesheets().add("Style.css");
			//scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
			window.setScene(scene);
			
			window.show();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void checkEvent(ActionEvent event){
		
		System.out.println("Check event!");
		window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		int count=0;
		String message = "Hello world!";
		lbss.setText(message);
	}
	
	public void Continue(ActionEvent event) {
		
		seatController.addSeatsToCart(selectedSeats);
		
		
		window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		PaymentView p= new PaymentView(false, false);
		p.begin(window);
	}
	

}
