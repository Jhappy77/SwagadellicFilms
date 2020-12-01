package Boundary;

import java.io.IOException;

<<<<<<< HEAD
=======
import Controller.DatabaseManager;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginView implements View{
	
	Stage window;
<<<<<<< HEAD
	
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
			window= new Stage();
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
=======
//	Scene scene;
	
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
		Parent root =FXMLLoader.load(getClass().getResource("/Boundary/MainPage.fxml"));
		Scene scene= new Scene(root);
		window.setScene(scene);
		window.show();
	}
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
}



