package Boundary;

import java.io.IOException;
import java.util.ArrayList;

import Controller.PaymentController;
import Model.MovieScreening;
import Model.Seat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SeatView implements View{
	
	Stage window;
	private MovieScreening showTime;
	@FXML
	private CheckBox A1;
	@FXML
	private CheckBox A2;
	@FXML
	private CheckBox A3;
	@FXML
	private CheckBox A4;
	@FXML
	private CheckBox A5;
	@FXML
	private CheckBox A6;
	@FXML
	private CheckBox A7;
	
	@FXML
	private CheckBox B1;
	@FXML
	private CheckBox B2;
	@FXML
	private CheckBox B3;
	@FXML
	private CheckBox B4;
	@FXML
	private CheckBox B5;
	@FXML
	private CheckBox B6;
	@FXML
	private CheckBox B7;
	
	@FXML
	private CheckBox C1;
	@FXML
	private CheckBox C2;
	@FXML
	private CheckBox C3;
	@FXML
	private CheckBox C4;
	@FXML
	private CheckBox C5;
	@FXML
	private CheckBox C6;
	@FXML
	private CheckBox C7;
	
	@FXML
	private CheckBox D1;
	@FXML
	private CheckBox D2;
	@FXML
	private CheckBox D3;
	@FXML
	private CheckBox D4;
	@FXML
	private CheckBox D5;
	@FXML
	private CheckBox D6;
	@FXML
	private CheckBox D7;
	
	@FXML
	private Label lbmoviename;
	
	@FXML
	private Label lbss;
	
	@FXML
	private Label lbcount;
	
	public SeatView(MovieScreening ms) {
		showTime = ms;
	}
	
	public void begin(Stage s)
	{
		window = s;
		perform();
	}
		
		
	public void perform() {
		try {
			Parent root =FXMLLoader.load(getClass().getResource("/Boundary/Seating.fxml"));
			Scene scene= new Scene(root);
			window.setScene(scene);
			window.show();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void checkEvent(ActionEvent event){
		window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		int count=0;
		String message = "";
		
		if (A1.isSelected()) {
			count++;
			message += "A1\n";
			Seat seat = new Seat("A1");
			showTime.addSeat(seat);
		}
		
		if (A2.isSelected()) {
			count++;
			message += "A2\n";
			Seat seat = new Seat("A2");
			showTime.addSeat(seat);
		}
		if (A3.isSelected()) {
			count++;
			message += "A3\n";
			Seat seat = new Seat("A3");
			showTime.addSeat(seat);
		}
		if (A4.isSelected()) {
			count++;
			message += "A4\n";
			Seat seat = new Seat("A4");
			showTime.addSeat(seat);
			
		}
		if (A5.isSelected()) {
			count++;
			message += "A5\n";
			Seat seat = new Seat("A5");
			showTime.addSeat(seat);
		}
		if (A6.isSelected()) {
			count++;
			message += "A6\n";
			Seat seat = new Seat("A6");
			showTime.addSeat(seat);
		}
		if (A7.isSelected()) {
			count++;
			message += "A7\n";
			Seat seat = new Seat("A7");
			showTime.addSeat(seat);
		}
		
		if (B1.isSelected()) {
			count++;
			message += "B1\n";
			Seat seat = new Seat("B1");
			showTime.addSeat(seat);
		}
		if (B2.isSelected()) {
			count++;
			message += "B2\n";
			Seat seat = new Seat("B2");
			showTime.addSeat(seat);
			
		}
		if (B3.isSelected()) {
			count++;
			message += "B3\n";
			Seat seat = new Seat("B3");
			showTime.addSeat(seat);
		}
		if (B4.isSelected()) {
			count++;
			message += "B4\n";
			Seat seat = new Seat("B4");
			showTime.addSeat(seat);
		}
		if (B5.isSelected()) {
			count++;
			message += "B5\n";
			Seat seat = new Seat("B5");
			showTime.addSeat(seat);
		}
		if (B6.isSelected()) {
			count++;
			message += "B6\n";
			Seat seat = new Seat("B6");
			showTime.addSeat(seat);
		}
		if (B7.isSelected()) {
			count++;
			message += "B7\n";
			Seat seat = new Seat("B7");
			showTime.addSeat(seat);
		}
		
		if (C1.isSelected()) {
			count++;
			message += "C1\n";
			Seat seat = new Seat("C1");
			showTime.addSeat(seat);
		}
		if (C2.isSelected()) {
			count++;
			message += "C2\n";
			Seat seat = new Seat("C2");
			showTime.addSeat(seat);
		}
		if (C3.isSelected()) {
			count++;
			message += "C3\n";
			Seat seat = new Seat("C3");
			showTime.addSeat(seat);
		}
		if (C4.isSelected()) {
			count++;
			message += "C4\n";
			Seat seat = new Seat("C4");
			showTime.addSeat(seat);
		}
		if (C5.isSelected()) {
			count++;
			message += "C5\n";
			Seat seat = new Seat("C5");
			showTime.addSeat(seat);
		}
		if (C6.isSelected()) {
			count++;
			message += "C6\n";
			Seat seat = new Seat("C6");
			showTime.addSeat(seat);
		}
		if (C7.isSelected()) {
			count++;
			message += "C7\n";
			Seat seat = new Seat("C7");
			showTime.addSeat(seat);
		}
		
		if (D1.isSelected()) {
			count++;
			message += "D1\n";
			Seat seat = new Seat("D1");
			showTime.addSeat(seat);
		}
		if (D2.isSelected()) {
			count++;
			message += "D2\n";
			Seat seat = new Seat("D2");
			showTime.addSeat(seat);
		}
		if (D3.isSelected()) {
			count++;
			message += "D3\n";
			Seat seat = new Seat("D3");
			showTime.addSeat(seat);
		}
		if (D4.isSelected()) {
			count++;
			message += "D4\n";
			Seat seat = new Seat("D4");
			showTime.addSeat(seat);
		}
		if (D5.isSelected()) {
			count++;
			message += "D5\n";
			Seat seat = new Seat("D5");
			showTime.addSeat(seat);
		}
		if (D6.isSelected()) {
			count++;
			message += "D6\n";
			Seat seat = new Seat("D6");
			showTime.addSeat(seat);
		}
		if (D7.isSelected()) {
			count++;
			message += "D7\n";
			Seat seat = new Seat("D7");
			showTime.addSeat(seat);
		}
		lbss.setText(message);
		lbcount.setText("Number of Seats Booked: "+ count);
	}
	
	public void Continue(ActionEvent event) {
		window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		PaymentView p= new PaymentView(showTime, false, false);
		p.begin(window);
	}
	

}
