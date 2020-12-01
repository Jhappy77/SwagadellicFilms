package Boundary;

import java.io.IOException;


import Controller.DatabaseManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
	
	public void begin(Stage s)
	{
		window = s;
		perform();
	}
	
	@Override
	public void perform() {
		try {
//			window = new Stage();
			Parent root =FXMLLoader.load(getClass().getResource("/Boundary/LoginNew.fxml"));
			Scene scene= new Scene(root);
			window.setScene(scene);
			window.show();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Login(ActionEvent event) {
		window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		if(txtusername.getText().contentEquals("user") && txtpassword.getText().equals("pass")) {
//			if(DatabaseManager.getInstance().validateLogin(txtusername.getText(), txtpassword.getText())){
				lbstatus.setText("Login Success");
			
		}
		else
			lbstatus.setText("Login failed, try again");
//		}
		if(lbstatus.getText().contentEquals("Login Success")) {
			SpecialMenu m = new SpecialMenu();
			m.begin(window);
		}
	}
	
	public void returnToMenu(ActionEvent event) throws IOException
	{
		window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		Parent root =FXMLLoader.load(getClass().getResource("/Boundary/MainPage2.fxml"));
		Scene scene= new Scene(root);
		window.setScene(scene);
		window.show();
	}

}



