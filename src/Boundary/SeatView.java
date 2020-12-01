package Boundary;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SeatView {
	
	Stage window;
	ArrayList<String> bookedSeats;
	
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
	
	public SeatView() {
		bookedSeats= new ArrayList<String>();
	}
		
		
	public void perform() {
		try {
			window= new Stage();
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
		
		int count=0;
		String message = "";
		
		if (A1.isSelected()) {
			count++;
			message += "A1\n";
			bookedSeats.add("A1");
		}
		
		if (A2.isSelected()) {
			count++;
			message += "A2\n";
			bookedSeats.add("A2");
		}
		if (A3.isSelected()) {
			count++;
			message += "A3\n";
			bookedSeats.add("A3");	
		}
		if (A4.isSelected()) {
			count++;
			message += "A4\n";
			bookedSeats.add("A4");
			
		}
		if (A5.isSelected()) {
			count++;
			message += "A5\n";
			bookedSeats.add("A5");
		}
		if (A6.isSelected()) {
			count++;
			message += "A6\n";
			bookedSeats.add("A6");
		}
		if (A7.isSelected()) {
			count++;
			message += "A7\n";
			bookedSeats.add("A7");
		}
		
		if (B1.isSelected()) {
			count++;
			message += "B1\n";
			bookedSeats.add("B1");
		}
		if (B2.isSelected()) {
			count++;
			message += "B2\n";
			bookedSeats.add("B2");
			
		}
		if (B3.isSelected()) {
			count++;
			message += "B3\n";
			bookedSeats.add("B3");		
		}
		if (B4.isSelected()) {
			count++;
			message += "B4\n";
			bookedSeats.add("B4");
		}
		if (B5.isSelected()) {
			count++;
			message += "B5\n";
			bookedSeats.add("B5");
		}
		if (B6.isSelected()) {
			count++;
			message += "B6\n";
			bookedSeats.add("B6");
		}
		if (B7.isSelected()) {
			count++;
			message += "B7\n";
			bookedSeats.add("B7");
		}
		
		if (C1.isSelected()) {
			count++;
			message += "C1\n";
			bookedSeats.add("C1");
		}
		if (C2.isSelected()) {
			count++;
			message += "C2\n";
			bookedSeats.add("C2");
		}
		if (C3.isSelected()) {
			count++;
			message += "C3\n";
			bookedSeats.add("C3");		
		}
		if (C4.isSelected()) {
			count++;
			message += "C4\n";
			bookedSeats.add("C4");
		}
		if (C5.isSelected()) {
			count++;
			message += "C5\n";
			bookedSeats.add("C5");
		}
		if (C6.isSelected()) {
			count++;
			message += "C6\n";
			bookedSeats.add("C6");
		}
		if (C7.isSelected()) {
			count++;
			message += "C7\n";
			bookedSeats.add("C7");
		}
		
		if (D1.isSelected()) {
			count++;
			message += "D1\n";
			bookedSeats.add("D1");
		}
		if (D2.isSelected()) {
			count++;
			message += "D2\n";
			bookedSeats.add("D2");
		}
		if (D3.isSelected()) {
			count++;
			message += "D3\n";
			bookedSeats.add("D3");		
		}
		if (D4.isSelected()) {
			count++;
			message += "D4\n";
			bookedSeats.add("D4");
		}
		if (D5.isSelected()) {
			count++;
			message += "D5\n";
			bookedSeats.add("D5");
		}
		if (D6.isSelected()) {
			count++;
			message += "D6\n";
			bookedSeats.add("D6");
		}
		if (D7.isSelected()) {
			count++;
			message += "D7\n";
			bookedSeats.add("D7");
		}
		
		lbss.setText(message);
		lbcount.setText("Number of Seats Booked: "+ count);
	}
	
	public void Continue(ActionEvent event) {
		PaymentView p= new PaymentView();
		p.perform();
	}
	

}
