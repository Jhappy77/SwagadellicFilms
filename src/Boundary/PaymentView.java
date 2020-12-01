package Boundary;

import java.io.IOException;
<<<<<<< HEAD

=======
import java.util.ArrayList;

import org.json.JSONException;

import Controller.DatabaseManager;
import Controller.MovieController;
import Controller.PaymentController;
import Controller.PaymentException;
import Model.Cart;
import Model.CreditMethod;
import Model.DebitMethod;
import Model.FinancialInstitution;
import Model.MovieScreening;
import Model.Payment;
import Model.Ticket;
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
<<<<<<< HEAD
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PaymentView {
=======
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PaymentView implements View{
	public static int paymentID;
	private boolean fee;
	private boolean refund;
	private float price;
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
	
	Stage window;
	
	ObservableList<String> cbctList;
	
	@FXML
<<<<<<< HEAD
	private ChoiceBox cbct;
	
	@FXML
	private TextField txtcn;
	
	public PaymentView() {
		 cbct = new ChoiceBox();
=======
	private ChoiceBox<String> cbct;
	
	@FXML
	private Label paymentstatus;
	
	@FXML
	private Label amount;
	
	@FXML
	private TextField txtcn;
	
	public PaymentView(boolean fee, boolean refund) {
		this.refund = refund;
		this.fee = fee;
		price = 0;
		paymentID = 0;
		 cbct = new ChoiceBox<String>();
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
		 cbctList = FXCollections.observableArrayList("Credit Card","Debit Card");
		 initialize();
	}
	@FXML
	public void initialize() {
		cbct.setItems(cbctList);
	}
		 
	public void perform() {
		
		try {
<<<<<<< HEAD
			window= new Stage();
=======
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
			Parent root =FXMLLoader.load(getClass().getResource("/Boundary/Payment.fxml"));
			Scene scene= new Scene(root);
			window.setScene(scene);
			window.show();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
<<<<<<< HEAD
	public void confirmPayment(ActionEvent event) {
		//Logic in here confirms payment

	}
	
	public void goBack(ActionEvent event) {
		//logic for going to the menu window:
		//for now:
		Menu m = new Menu();
		m.perform();
=======
	public void confirmPayment(ActionEvent event) throws IOException, JSONException, PaymentException {
		if(!fee)
		{
			String paymentType = cbct.getValue();
			String cardNumber = txtcn.getText();
			if(paymentType.equals("Credit Card"))
			{
				PaymentMethodComponent pmc = new PaymentMethodComponent();
				pmc.setPaymentMethod(new CreditMethod(Integer.parseInt(cardNumber)));
				if(PaymentController.payTickets(pmc.getMethod()))
				{
					amount.setText(Float.toString(price));
					paymentstatus.setText("Amount paid successully");
				}
				else
					paymentstatus.setText("Credit card denied");
			}
			else
			{
				PaymentMethodComponent pmc = new PaymentMethodComponent();
				pmc.setPaymentMethod(new DebitMethod(Integer.parseInt(cardNumber)));
				if(PaymentController.payTickets(pmc.getMethod()))
				{
					amount.setText(Float.toString(price));
					paymentstatus.setText("Amount paid successully");
				}
				else
					paymentstatus.setText("Credit card denied");
			}
		}
		else if(fee && refund)
		{
			price = (float) -(0.85*(20));
			amount.setText(Float.toString(price));
			paymentstatus.setText("Amount refunded");
		}
		
		else if(fee && !refund)
		{
			price = 20;
			amount.setText(Float.toString(price));
			paymentstatus.setText("Amount paid successfully");
		}
	}
	
	
	public void goBack(ActionEvent event) {
		//logic for going to the menu window:
		//for now:
		window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		Menu m = new Menu();
		m.begin(window);
	}
	@Override
	public void begin(Stage s) {
		window = s;
		perform();
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
	}

}
