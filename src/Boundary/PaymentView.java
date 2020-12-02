package Boundary;

import java.io.IOException;

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
import javafx.stage.Stage;

public class PaymentView implements View{

	Stage window;
	
	ObservableList<String> cbctList;
	
	@FXML
	private ChoiceBox<String> cbct;
	
	@FXML
	private Label paymentstatus;
	
	@FXML
	private Label amount;
	
	@FXML
	private TextField txtcn;
	
	public PaymentView() {
		 cbct = new ChoiceBox<String>();
		 cbctList = FXCollections.observableArrayList("Credit Card","Debit Card");
		 initialize();
	}
	@FXML
	public void initialize() {
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
		if(paymentType.equals("Credit Card"))
		{
			PaymentMethodComponent pmc = new PaymentMethodComponent();
			pmc.setPaymentMethod(new CreditMethod(Integer.parseInt(cardNumber)));
			if(PaymentController.payTickets(pmc.getMethod()))
			{
				amount.setText(Float.toString(PaymentController.getPrice()));
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
				amount.setText(Float.toString(PaymentController.getPrice()));
				paymentstatus.setText("Amount paid successully");
			}
			else
				paymentstatus.setText("Credit card denied");
		}
	}
	
	public void buyMoreTickets(ActionEvent event) throws Exception {
		window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		Parent root =FXMLLoader.load(getClass().getResource("/Boundary/SelectMovie.fxml"));
		Scene scene= new Scene(root);
		window.setScene(scene);
		window.show();
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
