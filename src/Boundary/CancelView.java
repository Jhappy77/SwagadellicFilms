package Boundary;

import java.io.IOException;

import Controller.DatabaseManager;
import Model.Cart;
import Model.Ticket;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CancelView {
	
Stage window;
	
	ObservableList<String> cbutList;
	
	@FXML
	private TextField txtsid;
	
	@FXML
	private Label cancelstatus;
	
	@FXML
	private TextField txttid;
	
	
	public void begin(Stage s)
	{
		window = s;
		perform();
	}
	
	public void perform() {
		
		try {
			Parent root =FXMLLoader.load(getClass().getResource("/Boundary/Cancel.fxml"));
			Scene scene= new Scene(root);
			window.setScene(scene);
			window.show();
			} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void confirmCancellation(ActionEvent event) {
	 	window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		Ticket t = DatabaseManager.getInstance().queryTicket(txttid.getText());
		if(t!=null)
		{
			Cart.getInstance().addRefundTicket(t);
			try {
				DatabaseManager.getInstance().removeTicket(txttid.getText());
			} catch (IOException e) {
				cancelstatus.setText("Failed to remove ticket from database");
			}
				PaymentView pv = new PaymentView();
				pv.begin(window);
		}
		else
		{
			cancelstatus.setText("Failed to find ticket");
		}

	}

	
	public void goBack(ActionEvent event) throws IOException {
		window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		Parent root =FXMLLoader.load(getClass().getResource("/Boundary/MainPage.fxml"));
		Scene scene= new Scene(root);
		window.setScene(scene);
		window.show();
	}

}
