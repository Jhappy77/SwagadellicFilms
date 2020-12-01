package Boundary;

import java.io.IOException;
<<<<<<< HEAD
import java.util.ArrayList;

=======
//import java.util.ArrayList;
import java.util.UUID;

import Controller.PaymentController;
//import Controller.PaymentController;
import Controller.SeatController;
import Model.Cart;
//import Model.MovieScreening;
import Model.Seat;
import Model.Ticket;
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
<<<<<<< HEAD
=======
import javafx.scene.control.Button;
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

<<<<<<< HEAD
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
=======
public class SeatView implements View{
	
	Stage window;
//	private MovieScreening SeatController.theScreening;
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
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
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
<<<<<<< HEAD
	
	@FXML
	private Label lbcount;
	
	public SeatView() {
		bookedSeats= new ArrayList<String>();
	}
		
		
	public void perform() {
		try {
			window= new Stage();
=======
	
	@FXML
	private Label lbcount;
	
//	public SeatView(MovieScreening ms) {
//		SeatController.theScreening = ms;
//	}
	
	
	public void begin(Stage s)
	{
		window = s;
		perform();
	}
		
		
	public void perform() {
		try {
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
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
<<<<<<< HEAD
		
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
=======
		window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		int count=0;
		String message = "";
		
		if (A1.isSelected()) {
			count++;
			message += "A1\n";
			Seat seat = new Seat("A1");
			SeatController.theScreening.addSeat(seat);
			String ticketId = UUID.randomUUID().toString().substring(0, 20);
			Ticket t = new Ticket(ticketId, SeatController.theScreening, seat.getSeatID());
			PaymentController.bookedSeats.add(seat);
			Cart.getInstance().addTicket(t);
		}
		
		if (A2.isSelected()) {
			count++;
			message += "A2\n";
			Seat seat = new Seat("A2");
			SeatController.theScreening.addSeat(seat);
			String ticketId = UUID.randomUUID().toString().substring(0, 20);
			Ticket t = new Ticket(ticketId, SeatController.theScreening, seat.getSeatID());
			PaymentController.bookedSeats.add(seat);
			Cart.getInstance().addTicket(t);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
		}
		if (A3.isSelected()) {
			count++;
			message += "A3\n";
<<<<<<< HEAD
			bookedSeats.add("A3");	
=======
			Seat seat = new Seat("A3");
			SeatController.theScreening.addSeat(seat);
			String ticketId = UUID.randomUUID().toString().substring(0, 20);
			Ticket t = new Ticket(ticketId, SeatController.theScreening, seat.getSeatID());
			PaymentController.bookedSeats.add(seat);
			Cart.getInstance().addTicket(t);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
		}
		if (A4.isSelected()) {
			count++;
			message += "A4\n";
<<<<<<< HEAD
			bookedSeats.add("A4");
			
=======
			Seat seat = new Seat("A4");
			SeatController.theScreening.addSeat(seat);
			String ticketId = UUID.randomUUID().toString().substring(0, 20);
			Ticket t = new Ticket(ticketId, SeatController.theScreening, seat.getSeatID());
			PaymentController.bookedSeats.add(seat);
			Cart.getInstance().addTicket(t);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
		}
		if (A5.isSelected()) {
			count++;
			message += "A5\n";
<<<<<<< HEAD
			bookedSeats.add("A5");
=======
			Seat seat = new Seat("A5");
			SeatController.theScreening.addSeat(seat);
			String ticketId = UUID.randomUUID().toString().substring(0, 20);
			Ticket t = new Ticket(ticketId, SeatController.theScreening, seat.getSeatID());
			PaymentController.bookedSeats.add(seat);
			Cart.getInstance().addTicket(t);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
		}
		if (A6.isSelected()) {
			count++;
			message += "A6\n";
<<<<<<< HEAD
			bookedSeats.add("A6");
=======
			Seat seat = new Seat("A6");
			SeatController.theScreening.addSeat(seat);
			String ticketId = UUID.randomUUID().toString().substring(0, 20);
			Ticket t = new Ticket(ticketId, SeatController.theScreening, seat.getSeatID());
			PaymentController.bookedSeats.add(seat);
			Cart.getInstance().addTicket(t);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
		}
		if (A7.isSelected()) {
			count++;
			message += "A7\n";
<<<<<<< HEAD
			bookedSeats.add("A7");
=======
			Seat seat = new Seat("A7");
			SeatController.theScreening.addSeat(seat);
			String ticketId = UUID.randomUUID().toString().substring(0, 20);
			Ticket t = new Ticket(ticketId, SeatController.theScreening, seat.getSeatID());
			PaymentController.bookedSeats.add(seat);
			Cart.getInstance().addTicket(t);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
		}
		
		if (B1.isSelected()) {
			count++;
			message += "B1\n";
<<<<<<< HEAD
			bookedSeats.add("B1");
=======
			Seat seat = new Seat("B1");
			SeatController.theScreening.addSeat(seat);
			String ticketId = UUID.randomUUID().toString().substring(0, 20);
			Ticket t = new Ticket(ticketId, SeatController.theScreening, seat.getSeatID());
			PaymentController.bookedSeats.add(seat);
			Cart.getInstance().addTicket(t);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
		}
		if (B2.isSelected()) {
			count++;
			message += "B2\n";
<<<<<<< HEAD
			bookedSeats.add("B2");
			
=======
			Seat seat = new Seat("B2");
			SeatController.theScreening.addSeat(seat);
			String ticketId = UUID.randomUUID().toString().substring(0, 20);
			Ticket t = new Ticket(ticketId, SeatController.theScreening, seat.getSeatID());
			PaymentController.bookedSeats.add(seat);
			Cart.getInstance().addTicket(t);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
		}
		if (B3.isSelected()) {
			count++;
			message += "B3\n";
<<<<<<< HEAD
			bookedSeats.add("B3");		
=======
			Seat seat = new Seat("B3");
			SeatController.theScreening.addSeat(seat);
			String ticketId = UUID.randomUUID().toString().substring(0, 20);
			Ticket t = new Ticket(ticketId, SeatController.theScreening, seat.getSeatID());
			PaymentController.bookedSeats.add(seat);
			Cart.getInstance().addTicket(t);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
		}
		if (B4.isSelected()) {
			count++;
			message += "B4\n";
<<<<<<< HEAD
			bookedSeats.add("B4");
=======
			Seat seat = new Seat("B4");
			SeatController.theScreening.addSeat(seat);
			String ticketId = UUID.randomUUID().toString().substring(0, 20);
			Ticket t = new Ticket(ticketId, SeatController.theScreening, seat.getSeatID());
			PaymentController.bookedSeats.add(seat);
			Cart.getInstance().addTicket(t);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
		}
		if (B5.isSelected()) {
			count++;
			message += "B5\n";
<<<<<<< HEAD
			bookedSeats.add("B5");
=======
			Seat seat = new Seat("B5");
			SeatController.theScreening.addSeat(seat);
			String ticketId = UUID.randomUUID().toString().substring(0, 20);
			Ticket t = new Ticket(ticketId, SeatController.theScreening, seat.getSeatID());
			PaymentController.bookedSeats.add(seat);
			Cart.getInstance().addTicket(t);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
		}
		if (B6.isSelected()) {
			count++;
			message += "B6\n";
<<<<<<< HEAD
			bookedSeats.add("B6");
=======
			Seat seat = new Seat("B6");
			SeatController.theScreening.addSeat(seat);
			String ticketId = UUID.randomUUID().toString().substring(0, 20);
			Ticket t = new Ticket(ticketId, SeatController.theScreening, seat.getSeatID());
			PaymentController.bookedSeats.add(seat);
			Cart.getInstance().addTicket(t);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
		}
		if (B7.isSelected()) {
			count++;
			message += "B7\n";
<<<<<<< HEAD
			bookedSeats.add("B7");
=======
			Seat seat = new Seat("B7");
			SeatController.theScreening.addSeat(seat);
			String ticketId = UUID.randomUUID().toString().substring(0, 20);
			Ticket t = new Ticket(ticketId, SeatController.theScreening, seat.getSeatID());
			PaymentController.bookedSeats.add(seat);
			Cart.getInstance().addTicket(t);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
		}
		
		if (C1.isSelected()) {
			count++;
			message += "C1\n";
<<<<<<< HEAD
			bookedSeats.add("C1");
=======
			Seat seat = new Seat("C1");
			SeatController.theScreening.addSeat(seat);
			String ticketId = UUID.randomUUID().toString().substring(0, 20);
			Ticket t = new Ticket(ticketId, SeatController.theScreening, seat.getSeatID());
			PaymentController.bookedSeats.add(seat);
			Cart.getInstance().addTicket(t);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
		}
		if (C2.isSelected()) {
			count++;
			message += "C2\n";
<<<<<<< HEAD
			bookedSeats.add("C2");
=======
			Seat seat = new Seat("C2");
			SeatController.theScreening.addSeat(seat);
			String ticketId = UUID.randomUUID().toString().substring(0, 20);
			Ticket t = new Ticket(ticketId, SeatController.theScreening, seat.getSeatID());
			PaymentController.bookedSeats.add(seat);
			Cart.getInstance().addTicket(t);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
		}
		if (C3.isSelected()) {
			count++;
			message += "C3\n";
<<<<<<< HEAD
			bookedSeats.add("C3");		
=======
			Seat seat = new Seat("C3");
			SeatController.theScreening.addSeat(seat);
			String ticketId = UUID.randomUUID().toString().substring(0, 20);
			Ticket t = new Ticket(ticketId, SeatController.theScreening, seat.getSeatID());
			PaymentController.bookedSeats.add(seat);
			Cart.getInstance().addTicket(t);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
		}
		if (C4.isSelected()) {
			count++;
			message += "C4\n";
<<<<<<< HEAD
			bookedSeats.add("C4");
=======
			Seat seat = new Seat("C4");
			SeatController.theScreening.addSeat(seat);
			String ticketId = UUID.randomUUID().toString().substring(0, 20);
			Ticket t = new Ticket(ticketId, SeatController.theScreening, seat.getSeatID());
			PaymentController.bookedSeats.add(seat);
			Cart.getInstance().addTicket(t);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
		}
		if (C5.isSelected()) {
			count++;
			message += "C5\n";
<<<<<<< HEAD
			bookedSeats.add("C5");
=======
			Seat seat = new Seat("C5");
			SeatController.theScreening.addSeat(seat);
			String ticketId = UUID.randomUUID().toString().substring(0, 20);
			Ticket t = new Ticket(ticketId, SeatController.theScreening, seat.getSeatID());
			PaymentController.bookedSeats.add(seat);
			Cart.getInstance().addTicket(t);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
		}
		if (C6.isSelected()) {
			count++;
			message += "C6\n";
<<<<<<< HEAD
			bookedSeats.add("C6");
=======
			Seat seat = new Seat("C6");
			SeatController.theScreening.addSeat(seat);
			String ticketId = UUID.randomUUID().toString().substring(0, 20);
			Ticket t = new Ticket(ticketId, SeatController.theScreening, seat.getSeatID());
			PaymentController.bookedSeats.add(seat);
			Cart.getInstance().addTicket(t);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
		}
		if (C7.isSelected()) {
			count++;
			message += "C7\n";
<<<<<<< HEAD
			bookedSeats.add("C7");
=======
			Seat seat = new Seat("C7");
			SeatController.theScreening.addSeat(seat);
			String ticketId = UUID.randomUUID().toString().substring(0, 20);
			Ticket t = new Ticket(ticketId, SeatController.theScreening, seat.getSeatID());
			PaymentController.bookedSeats.add(seat);
			Cart.getInstance().addTicket(t);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
		}
		
		if (D1.isSelected()) {
			count++;
			message += "D1\n";
<<<<<<< HEAD
			bookedSeats.add("D1");
=======
			Seat seat = new Seat("D1");
			SeatController.theScreening.addSeat(seat);
			String ticketId = UUID.randomUUID().toString().substring(0, 20);
			Ticket t = new Ticket(ticketId, SeatController.theScreening, seat.getSeatID());
			PaymentController.bookedSeats.add(seat);
			Cart.getInstance().addTicket(t);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
		}
		if (D2.isSelected()) {
			count++;
			message += "D2\n";
<<<<<<< HEAD
			bookedSeats.add("D2");
=======
			Seat seat = new Seat("D2");
			SeatController.theScreening.addSeat(seat);
			String ticketId = UUID.randomUUID().toString().substring(0, 20);
			Ticket t = new Ticket(ticketId, SeatController.theScreening, seat.getSeatID());
			PaymentController.bookedSeats.add(seat);
			Cart.getInstance().addTicket(t);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
		}
		if (D3.isSelected()) {
			count++;
			message += "D3\n";
<<<<<<< HEAD
			bookedSeats.add("D3");		
=======
			Seat seat = new Seat("D3");
			SeatController.theScreening.addSeat(seat);
			String ticketId = UUID.randomUUID().toString().substring(0, 20);
			Ticket t = new Ticket(ticketId, SeatController.theScreening, seat.getSeatID());
			PaymentController.bookedSeats.add(seat);
			Cart.getInstance().addTicket(t);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
		}
		if (D4.isSelected()) {
			count++;
			message += "D4\n";
<<<<<<< HEAD
			bookedSeats.add("D4");
=======
			Seat seat = new Seat("D4");
			SeatController.theScreening.addSeat(seat);
			String ticketId = UUID.randomUUID().toString().substring(0, 20);
			Ticket t = new Ticket(ticketId, SeatController.theScreening, seat.getSeatID());
			PaymentController.bookedSeats.add(seat);
			Cart.getInstance().addTicket(t);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
		}
		if (D5.isSelected()) {
			count++;
			message += "D5\n";
<<<<<<< HEAD
			bookedSeats.add("D5");
=======
			Seat seat = new Seat("D5");
			SeatController.theScreening.addSeat(seat);
			String ticketId = UUID.randomUUID().toString().substring(0, 20);
			Ticket t = new Ticket(ticketId, SeatController.theScreening, seat.getSeatID());
			PaymentController.bookedSeats.add(seat);
			Cart.getInstance().addTicket(t);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
		}
		if (D6.isSelected()) {
			count++;
			message += "D6\n";
<<<<<<< HEAD
			bookedSeats.add("D6");
=======
			Seat seat = new Seat("D6");
			SeatController.theScreening.addSeat(seat);
			String ticketId = UUID.randomUUID().toString().substring(0, 20);
			Ticket t = new Ticket(ticketId, SeatController.theScreening, seat.getSeatID());
			PaymentController.bookedSeats.add(seat);
			Cart.getInstance().addTicket(t);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
		}
		if (D7.isSelected()) {
			count++;
			message += "D7\n";
<<<<<<< HEAD
			bookedSeats.add("D7");
		}
		
=======
			Seat seat = new Seat("D7");
			SeatController.theScreening.addSeat(seat);
			String ticketId = UUID.randomUUID().toString().substring(0, 20);
			Ticket t = new Ticket(ticketId, SeatController.theScreening, seat.getSeatID());
			PaymentController.bookedSeats.add(seat);
			Cart.getInstance().addTicket(t);
		}
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
		lbss.setText(message);
		lbcount.setText("Number of Seats Booked: "+ count);
	}
	
	public void Continue(ActionEvent event) {
<<<<<<< HEAD
		PaymentView p= new PaymentView();
		p.perform();
=======
		window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		PaymentView p= new PaymentView(false, false);
		p.begin(window);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
	}
	

}
