package Boundary;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

import org.json.JSONException;

import Controller.UserController;
import Model.CreditMethod;
import Model.DebitMethod;
import Model.PaymentMethod;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpView implements View{
	private Stage window;
	private PaymentMethodComponent method;
	@FXML
	private Label lbstatus;
	
	@FXML
	private TextField txtname;
	
	@FXML
	private DatePicker dob;
	
	@FXML
	private TextField txtemail;
	
	@FXML
	private TextField txtaddress;
	
	@FXML
	private TextField txtccn;
	
	@FXML
	private TextField txtusername;
	
	@FXML
	private TextField txtpassword;
	
	@FXML 
	private CheckBox credit;
	
	@FXML
	private CheckBox debit;
	
	
	public void begin(Stage s)
	{
		window = s;
		perform();
	}
	
	@Override
	public void perform() {
		try {
			Parent root =FXMLLoader.load(getClass().getResource("/Boundary/SignUp.fxml"));
			Scene scene= new Scene(root);
			window.setScene(scene);
			window.show();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void signUp(ActionEvent event) throws IOException, JSONException {
		window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		if(txtname.getText().isEmpty() || txtusername.getText().isEmpty() || txtpassword.getText().isEmpty() ||
				txtemail.getText().isEmpty() || txtccn.getText().isEmpty() || txtaddress.getText().isEmpty()) {
			
			lbstatus.setText("Fill all Fields");
			
		}
		
		else {
			LocalDate date = dob.getValue();
			Instant instant = Instant.from(date);
			Date birthdate = Date.from(instant);
			UserController.addUser(txtusername.getText(), txtpassword.getText(), txtemail.getText(), birthdate, txtname.getText(), txtaddress.getText(), method.getMethod());
			Parent mainMenuView = FXMLLoader.load(getClass().getResource("/Boundary/RUMenuPage.fxml"));
			Scene s = new Scene(mainMenuView);
			window.setScene(s);
			window.show();
		}
	}
	
	public void checkBox(ActionEvent event)
	{
		if(credit.isSelected())
			method.setPaymentMethod(new CreditMethod(Integer.parseInt(txtccn.getText())));
		if(debit.isSelected())
			method.setPaymentMethod(new DebitMethod(Integer.parseInt(txtccn.getText())));
		else if(!credit.isSelected() && !debit.isSelected())
			lbstatus.setText("Please choose payment method");
			
	}
	
	public void returnToMenu(ActionEvent event) throws IOException
	{
		window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		Parent root =FXMLLoader.load(getClass().getResource("/Boundary/MainPage.fxml"));
		Scene scene= new Scene(root);
		window.setScene(scene);
		window.show();
	}
	
	
	
	

}
