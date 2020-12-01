package Boundary;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpView implements View{
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
	private TextField txtccn;
	
	@FXML
	private TextField txtusername;
	
	@FXML
	private TextField txtpassword;
	
	private void Signup()
	{
		
	}
	
	private void switchPayment()
	{
		
	}
	
	@Override
	public void perform() {
		try {
			Stage primaryStage = new Stage();
			Parent root =FXMLLoader.load(getClass().getResource("/Boundary/SignUp.fxml"));
			Scene scene= new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void signUp(ActionEvent event) {
		if(txtname.getText().isEmpty() || txtusername.getText().isEmpty() || txtpassword.getText().isEmpty() ||
				txtemail.getText().isEmpty() || txtemail.getText().isEmpty() || txtccn.getText().isEmpty()) {
			
			lbstatus.setText("Fill all Fields");
			
		}
		
		else {
			lbstatus.setText("All Fields filled");
		}
	}
	
	public void goBack(ActionEvent event) {
	}
	
	
	
	

}
