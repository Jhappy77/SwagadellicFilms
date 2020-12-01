package Boundary;

import java.io.IOException;

import Controller.DatabaseManager;
import Controller.PaymentController;
import Controller.UserController;
import Model.RegisteredUser;
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

public class CancelView {
	
Stage window;
	
	ObservableList<String> cbutList;
	
	@FXML
	private ChoiceBox<String> cbut;
	
	@FXML
	private TextField txtsid;
	
	@FXML
	private Label cancelstatus;
	
	@FXML
	private TextField txttid;
	
	public CancelView() {
		 cbut = new ChoiceBox<String>();
		 cbutList = FXCollections.observableArrayList("Guest","Registered");
		 initialize();
	}
	@FXML
	public void initialize() {
		cbut.setItems(cbutList);
	}
	
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void confirmCancellation(ActionEvent event) {
	 	window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		Ticket t = DatabaseManager.getInstance().queryTicket(txttid.getText());
		if(UserController.getUser() instanceof RegisteredUser) {
			DatabaseManager.getInstance().removeTicket(txttid.getText());
			PaymentView pv = new PaymentView();
			PaymentController.setPrice(0);
			pv.begin(window);
		}
		else {
			//For registered user add logic to make cancellation then take to the main menu
			DatabaseManager.getInstance().removeTicket(txttid.getText());
			SpecialMenu m = new SpecialMenu();
			PaymentView pv = new PaymentView();
			PaymentController.setPrice(-0.85f);
			m.begin(window);
		}

	}
	
	public void goBack(ActionEvent event) {
	 	window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		//logic for going to the menu window:
		//for now:
		Menu m = new Menu();
		m.begin(window);
	}

}
