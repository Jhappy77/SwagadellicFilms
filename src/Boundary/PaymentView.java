package Boundary;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class PaymentView {
	
	Stage window;
	
	ObservableList<String> cbctList;
	
	@FXML
	private ChoiceBox cbct;
	
	public PaymentView() {
		 cbct = new ChoiceBox();
		 cbctList = FXCollections.observableArrayList("Credit Card","Debit Card");
		 initialize();
	}
	@FXML
	public void initialize() {
		cbct.setItems(cbctList);
	}
		 
	public void perform() {
		
		try {
			window= new Stage();
			Parent root =FXMLLoader.load(getClass().getResource("/Boundary/Payment.fxml"));
			Scene scene= new Scene(root);
			window.setScene(scene);
			window.show();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void confirmPayment(ActionEvent event) {
		//Logic in here confirms payment

	}
	
	public void goBack(ActionEvent event) {
		//logic for going to the menu window:
		//for now:
		Menu m = new Menu();
		m.perform();
	}

}
