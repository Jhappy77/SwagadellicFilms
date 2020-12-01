package Boundary;

import java.io.IOException;

<<<<<<< HEAD
=======
import Controller.DatabaseManager;
import Model.Ticket;
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
<<<<<<< HEAD
import javafx.scene.control.ChoiceBox;
=======
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CancelView {
	
<<<<<<< HEAD
Stage window;
=======
	Stage window;
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
	
	ObservableList<String> cbutList;
	
	@FXML
<<<<<<< HEAD
	private ChoiceBox cbut;
=======
	private ChoiceBox<String> cbut;
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
	
	@FXML
	private TextField txtsid;
	
	@FXML
<<<<<<< HEAD
	private TextField txttid;
	
	public CancelView() {
		 cbut = new ChoiceBox();
=======
	private Label cancelstatus;
	
	@FXML
	private TextField txttid;
	
	public CancelView() {
		 cbut = new ChoiceBox<String>();
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
		 cbutList = FXCollections.observableArrayList("Guest","Registered");
		 initialize();
	}
	@FXML
	public void initialize() {
		cbut.setItems(cbutList);
	}
	
<<<<<<< HEAD
	public void perform() {
		
		try {
			window= new Stage();
=======
	public void begin(Stage s)
	{
		window = s;
		perform();
	}
	
	public void perform() {
		
		try {
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
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
		if(cbut.getValue().equals("Guest")) {
<<<<<<< HEAD
			PaymentView p= new PaymentView();
			p.perform();
=======
			Ticket t = DatabaseManager.getInstance().queryTicket(txttid.getText());
			
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
		}
		else {
			//For registered user add logic to make cancellation then take to the main menu
			SpecialMenu m = new SpecialMenu();
			m.perform();
		}

	}
	
	public void goBack(ActionEvent event) {
<<<<<<< HEAD
		//logic for going to the menu window:
		//for now:
		Menu m = new Menu();
		m.perform();
=======
	 	window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		//logic for going to the menu window:
		//for now:
		Menu m = new Menu();
		m.begin(window);
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
	}

}
