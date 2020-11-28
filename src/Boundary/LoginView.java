package Boundary;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginView implements View{
	
	Stage window;
	
	@FXML
	private Label lbstatus;
	
	@FXML
	private TextField txtusername;
	
	@FXML
	private TextField txtpassword;
	
	public void begin(Stage ps) {
		window=ps;
		perform();
	}
	
	@Override
	public void perform() {
		try {
			//window= new Stage();
			Parent root =FXMLLoader.load(getClass().getResource("/Boundary/Login.fxml"));
			Scene scene= new Scene(root);
			window.setScene(scene);
			window.show();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Login(ActionEvent event) {
		if(txtusername.getText().contentEquals("user") && txtpassword.getText().equals("pass")) {
			lbstatus.setText("Login Success");
		}
		else {
			lbstatus.setText("Login Failed, try again");
		}
		if(lbstatus.getText().contentEquals("Login Success")) {
			Menu m = new Menu();
			m.perform();
		}
	}
}



