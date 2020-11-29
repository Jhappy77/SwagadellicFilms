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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SelectMovieView {
	
	Stage window;
	
	ObservableList<String> cbbtList ;
	ObservableList<String> cbbmList ;
	ObservableList<String> cbbsList ;
	
	@FXML
	private ChoiceBox cbbt;
	@FXML
	private ChoiceBox cbbm;
	
	@FXML
	private ChoiceBox cbbs;
	
	public SelectMovieView() {
		 cbbt = new ChoiceBox();
		 cbbm = new ChoiceBox();
		 cbbs = new ChoiceBox();
		 cbbtList = FXCollections.observableArrayList("Theatre 1","Theatre 2");
		 cbbmList = FXCollections.observableArrayList("Movie 1","Movie 2");
		 cbbsList = FXCollections.observableArrayList("10:00 Am","2:00 Pm");
		//Logic here can grab information from the database to put in Observablelists for list of movie theatres, movies and show times
		//to show in choice boxes
		initialize();
	}
	
	@FXML
	public void initialize() {
		cbbt.setItems(cbbtList);	
		cbbm.setItems(cbbmList);
		cbbs.setItems(cbbsList);	
	}

	public void perform() {
		
		try {
			window= new Stage();
			Parent root =FXMLLoader.load(getClass().getResource("/Boundary/Selectmovie.fxml"));
			Scene scene= new Scene(root);
			window.setScene(scene);
			window.show();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void Continue(ActionEvent event) {
		//Logic in here takes you to the seat map of each selection
		//for now:
		SeatView sv = new SeatView();
		sv.perform();
	}
	
	public void goBack(ActionEvent event) {
		//logic for going to the previous window:
		//for now:
		Menu m = new Menu();
		m.perform();
	}
}

