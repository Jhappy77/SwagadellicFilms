package Boundary;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import Controller.DatabaseManager;
import Controller.MovieController;
import Model.Movie;
import Model.MovieScreening;
import Model.MovieTheatre;
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

public class SelectMovieView {
	private MovieScreening showTime;
	Stage window;
	
//	ObservableList<String> cbbtList ;
//	ObservableList<String> cbbmList ;
//	ObservableList<String> cbbsList ;
	
	ObservableList<Movie> cbbmList ;
	ObservableList<MovieTheatre> cbbtList ;
	ObservableList<MovieScreening> cbbsList ;
	
	@FXML
	private ChoiceBox<Movie> cbbm;
	@FXML
	private ChoiceBox<MovieTheatre> cbbt;
	
	@FXML
	private ChoiceBox<MovieScreening> cbbs;
	
	public SelectMovieView() throws ParseException {
		 cbbm = new ChoiceBox<Movie>();
//		 cbbt = new ChoiceBox<MovieTheatre>();
//		 cbbs = new ChoiceBox<MovieScreening>();
//		 cbbtList = FXCollections.observableArrayList();
		 cbbmList = FXCollections.observableArrayList();
//		 cbbsList = FXCollections.observableArrayList();
//		 
//		 cbbtList.removeAll(cbbtList);
		 cbbmList.removeAll(cbbmList);
//		 cbbsList.removeAll(cbbsList);
		 List<Movie> MList = DatabaseManager.getInstance().queryMovies();
		 for(int i=0; i<MList.size(); i++)
			 cbbmList.add(MList.get(i));
		 cbbm.getItems().addAll(cbbmList);
		 Movie m = cbbm.getValue();
//		 
//		 List<MovieTheatre> TList = DatabaseManager.getInstance().queryTheatresWithMovie(m.getId());
//		 for(int i=0; i<TList.size(); i++)
//			 cbbtList.add(TList.get(i));
//		 cbbt.getItems().addAll(cbbtList);
//		 MovieTheatre mt = cbbt.getValue();
//		 
//		 List<MovieScreening> MSList = DatabaseManager.getInstance().queryScreeningsAtTheatre(m.getId(), mt.getId());
//		 for(int i=0; i<MSList.size(); i++)
//			 cbbsList.add(MSList.get(i));
//		 cbbs.getItems().addAll(cbbsList);
//		 showTime = cbbs.getValue();
//		 MovieController.showTimes.add(showTime);
//		//Logic here can grab information from the database to put in Observablelists for list of movie theatres, movies and show times
//		//to show in choice boxes
		initialize();
		 
	}
	
	@FXML
	public void initialize() {
//		cbbt.setItems(cbbtList);	
		cbbm.setItems(cbbmList);
//		cbbs.setItems(cbbsList);	
	}
	
	public void begin(Stage s)
	{
		window = s;
		perform();
	}

	public void perform() {
		
		try {
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
		window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		SeatView sv = new SeatView(showTime);
		sv.begin(window);
	}
	
	public void goBack(ActionEvent event) {
		//logic for going to the previous window:
		//for now:
		Menu m = new Menu();
		m.perform();
	}
}

