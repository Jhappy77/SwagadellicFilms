package Boundary;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

import org.json.JSONException;

import Controller.PaymentController;
import Controller.PaymentException;
import Model.Cart;
import Model.CreditMethod;
import Model.DebitMethod;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PaymentView implements View{

	Stage window;
	Stage ticket;
	
	ObservableList<String> cbctList;
	
	@FXML
	private ChoiceBox<String> cbct;
	
	@FXML
	private Label paymentstatus;
	
	@FXML
	private VBox cartContent;
	
	@FXML
	private Label amount;
	
	@FXML 
	private Label ticketInfo;
	
	@FXML
	private Label ticketInfo2;
	
	@FXML
	private TextField txtcn;
	
	public PaymentView() {
		 cbct = new ChoiceBox<String>();
		 cbctList = FXCollections.observableArrayList("Credit Card","Debit Card");
		 initialize();
	}
	@FXML
	public void initialize() {
		cartContent = new VBox();
		cartContent.getChildren().addAll(PaymentController.fillCartContentView());
		setAmount();
		cbct.setItems(cbctList);
	}
		 
	public void perform() {
		
		try {
			Parent root =FXMLLoader.load(getClass().getResource("/Boundary/Payment.fxml"));
			Scene scene= new Scene(root);
			window.setScene(scene);
			window.show();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void confirmPayment(ActionEvent event) throws IOException, JSONException, PaymentException {
		String paymentType = cbct.getValue();
		String cardNumber = txtcn.getText();
		if(paymentType.isEmpty() || cardNumber.isEmpty())
		{
			paymentstatus.setText("Fill out all fields");
		}
		else
		{
			if(paymentType.equals("Credit Card"))
			{
				for(int i=0; i<Cart.getInstance().getTickets().size(); i++)
					Cart.getInstance().getTicketsInfo().add(Cart.getInstance().getTickets().get(i));
				PaymentMethodComponent pmc = new PaymentMethodComponent();
				pmc.setPaymentMethod(new CreditMethod(Integer.parseInt(cardNumber)));
				boolean paymentSucceeded = PaymentController.payTickets(pmc.getMethod());
				if(paymentSucceeded)
				{
					setAmount();
					ticket = new Stage();
					ticketInfo = new Label();
					Parent root =FXMLLoader.load(getClass().getResource("/Boundary/Ticket.fxml"));
					Scene scene= new Scene(root);
					ticket.setScene(scene);
					ticket.show();
					paymentstatus.setText("Amount paid successully");
				}
				else {
					paymentstatus.setText("Credit card denied");
				}
			}
			else
			{
				for(int i=0; i<Cart.getInstance().getTickets().size(); i++)
					Cart.getInstance().getTicketsInfo().add(Cart.getInstance().getTickets().get(i));
				PaymentMethodComponent pmc = new PaymentMethodComponent();
				pmc.setPaymentMethod(new DebitMethod(Integer.parseInt(cardNumber)));
				if(PaymentController.payTickets(pmc.getMethod()))
				{
					setAmount();
					ticket = new Stage();
					ticketInfo = new Label();
					Parent root =FXMLLoader.load(getClass().getResource("/Boundary/Ticket.fxml"));
					Scene scene= new Scene(root);
					ticket.setScene(scene);
					ticket.show();
					paymentstatus.setText("Amount paid successully");
				}
				else
					paymentstatus.setText("Debit card denied");
			}
		}
	}
	
	public void addToRefund(ActionEvent event) throws IOException
	{
		window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		Parent root =FXMLLoader.load(getClass().getResource("/Boundary/Cancel.fxml"));
		Scene scene= new Scene(root);
		window.setScene(scene);
		window.show();
	}
	
	private void setAmount() {
		String totalPrice = Float.toString(PaymentController.getTotalPrice());
		if(amount != null) {
		amount.setText("$" + totalPrice);
		} else {
			amount = new Label();
			amount.setText(totalPrice);
		}
	}
	
	public void buyMoreTickets(ActionEvent event) throws Exception {
		window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		Parent root =FXMLLoader.load(getClass().getResource("/Boundary/SelectMovie.fxml"));
		Scene scene= new Scene(root);
		window.setScene(scene);
		window.show();
	}
	
	public void ShowTickets(ActionEvent event)
	{
		
		String message = "";
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
		if(Cart.getInstance().getTicketsInfo().size() > 0 && Cart.getInstance().getTicketsInfo().size() < 6)
		{
			for(int i=0; i<Cart.getInstance().getTicketsInfo().size(); i++)
			{
				message+= "Ticket " + (i+1) + ": \n"
						+ "Ticket id: " + Cart.getInstance().getTicketsInfo().get(i).getId() + "\n"
						+ "Movie name: " + Cart.getInstance().getTicketsInfo().get(i).getScreening().getMovieName() + "\n"
						+ "Movie theatre: " + Cart.getInstance().getTicketsInfo().get(i).getScreening().getTheatreName() + "\n"
						+ "Screening time: " + Cart.getInstance().getTicketsInfo().get(i).getScreening().getMovieDate().format(formatter) + "\n"
						+ "Seat: " + Cart.getInstance().getTicketsInfo().get(i).getSeatNumber() + "\n\n";
			}
			ticketInfo.setText(message);
		}
		else if (Cart.getInstance().getTicketsInfo().size() >= 6)
		{
			String message2 = "";
			for(int i=0; i<Cart.getInstance().getTicketsInfo().size(); i++)
			{
				if(i<6)
				{
					message+= "Ticket " + (i+1) + ": \n"
							+ "Ticket id: " + Cart.getInstance().getTicketsInfo().get(i).getId() + "\n"
							+ "Movie name: " + Cart.getInstance().getTicketsInfo().get(i).getScreening().getMovieName() + "\n"
							+ "Movie theatre: " + Cart.getInstance().getTicketsInfo().get(i).getScreening().getTheatreName() + "\n"
							+ "Screening time: " + Cart.getInstance().getTicketsInfo().get(i).getScreening().getMovieDate().format(formatter) + "\n"
							+ "Seat: " + Cart.getInstance().getTicketsInfo().get(i).getSeatNumber() + "\n\n";
				}
				else
				{
					message2+= "Ticket " + (i+1) + ": \n"
							+ "Ticket id: " + Cart.getInstance().getTicketsInfo().get(i).getId() + "\n"
							+ "Movie name: " + Cart.getInstance().getTicketsInfo().get(i).getScreening().getMovieName() + "\n"
							+ "Movie theatre: " + Cart.getInstance().getTicketsInfo().get(i).getScreening().getTheatreName() + "\n"
							+ "Screening time: " + Cart.getInstance().getTicketsInfo().get(i).getScreening().getMovieDate().format(formatter) + "\n"
							+ "Seat: " + Cart.getInstance().getTicketsInfo().get(i).getSeatNumber() + "\n\n";
				}
			}
			ticketInfo.setText(message);
			ticketInfo2.setText(message2);
			
		}
		else if(Cart.getInstance().getTicketsInfo().size() == 0)
			ticketInfo.setText("No tickets purchased");
	}
	
	
	public void goBack(ActionEvent event) throws IOException {
		window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		Parent root =FXMLLoader.load(getClass().getResource("/Boundary/MainPage.fxml"));
		Scene scene= new Scene(root);
		window.setScene(scene);
		window.show();
	}
	@Override
	public void begin(Stage s) {
		window = s;
		perform();
	}

}
