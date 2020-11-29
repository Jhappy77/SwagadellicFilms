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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CancelView {
	
Stage window;
	
	ObservableList<String> cbutList;
	
	@FXML
	private ChoiceBox cbut;
	
	@FXML
	private TextField txtsid;
	
	@FXML
	private TextField txttid;
	
	public CancelView() {
		 cbut = new ChoiceBox();
		 cbutList = FXCollections.observableArrayList("Guest","Registered");
		 initialize();
	}
	@FXML
	public void initialize() {
		cbut.setItems(cbutList);
	}
	
	public void perform() {
		
		try {
			window= new Stage();
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
			PaymentView p= new PaymentView();
			p.perform();
		}
		else {
			//For registered user add logic to make cancellation then take to the main menu
			SpecialMenu m = new SpecialMenu();
			m.perform();
		}

	}
	
	public void goBack(ActionEvent event) {
		//logic for going to the menu window:
		//for now:
		Menu m = new Menu();
		m.perform();
	}

}
