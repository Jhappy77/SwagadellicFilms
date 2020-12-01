package Boundary;

import java.io.IOException;
<<<<<<< HEAD

=======
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

import org.json.JSONException;

import Controller.UserController;
import Model.CreditMethod;
import Model.DebitMethod;
import Model.PaymentMethod;
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
<<<<<<< HEAD
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
=======
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
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
<<<<<<< HEAD
=======
	private TextField txtaddress;
	
	@FXML
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
	private TextField txtccn;
	
	@FXML
	private TextField txtusername;
	
	@FXML
	private TextField txtpassword;
<<<<<<< HEAD
=======
	
	@FXML 
	private CheckBox credit;
	
	@FXML
	private CheckBox debit;
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
	
	
	public void begin(Stage s)
	{
		window = s;
		perform();
	}
	
	@Override
	public void perform() {
		try {
<<<<<<< HEAD
			Stage primaryStage = new Stage();
			Parent root =FXMLLoader.load(getClass().getResource("/Boundary/SignUp.fxml"));
			Scene scene= new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
=======
			Parent root =FXMLLoader.load(getClass().getResource("/Boundary/SignUp.fxml"));
			Scene scene= new Scene(root);
			window.setScene(scene);
			window.show();
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
<<<<<<< HEAD
	public void signUp(ActionEvent event) {
		if(txtname.getText().isEmpty() || txtusername.getText().isEmpty() || txtpassword.getText().isEmpty() ||
				txtemail.getText().isEmpty() || txtemail.getText().isEmpty() || txtccn.getText().isEmpty()) {
=======
	public void signUp(ActionEvent event) throws IOException, JSONException {
		window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		if(txtname.getText().isEmpty() || txtusername.getText().isEmpty() || txtpassword.getText().isEmpty() ||
				txtemail.getText().isEmpty() || txtccn.getText().isEmpty() || txtaddress.getText().isEmpty()) {
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
			
			lbstatus.setText("Fill all Fields");
			
		}
		
		else {
<<<<<<< HEAD
			lbstatus.setText("All Fields filled");
		}
	}
	
	public void goBack(ActionEvent event) {
	}
	
=======
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
	
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
	
	
	

}
