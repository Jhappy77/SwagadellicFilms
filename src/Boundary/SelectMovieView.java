package Boundary;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import Controller.DatabaseManager;
import Controller.MovieController;
import Controller.SeatController;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SelectMovieView {
	private MovieScreening showTime;
	private List<Movie> MList;
	private List<MovieTheatre> TList;
	private List<MovieScreening> MSList;
	private Movie m;
	Stage window;
	
//	ObservableList<String> cbbtList ;
//	ObservableList<String> cbbmList ;
//	ObservableList<String> cbbsList ;
	
	ObservableList<String> cbbmList ;
	ObservableList<String> cbbtList ;
	ObservableList<String> cbbsList ;
	
	@FXML
	private ComboBox<String> cbbm;
	@FXML
	private ComboBox<String> cbbt;
	
	@FXML
	private ComboBox<String> cbbs;
	
	@FXML
	private Label status;
	
	public SelectMovieView() throws ParseException {
		 cbbm = new ComboBox<String>();
		 cbbt = new ComboBox<String>();
		 cbbs = new ComboBox<String>();
		 cbbtList = FXCollections.observableArrayList();
		 cbbmList = FXCollections.observableArrayList();
		 cbbsList = FXCollections.observableArrayList();
		 
		 cbbt.setDisable(true);
		 cbbs.setDisable(true);
//		 
		 cbbtList.removeAll(cbbtList);
		 cbbmList.removeAll(cbbmList);
		 cbbsList.removeAll(cbbsList);
		 MList = DatabaseManager.getInstance().queryMovies();
		 for(int i=0; i<MList.size(); i++)
			 cbbmList.add(MList.get(i).getName());
		 cbbm.getItems().addAll(cbbmList);
//		 status.setText("Hello");
//			 
			
//				
				
				
//			}
//			else
//				cbbs.setDisable(true);
//		 }
//		 else
//		 {
//			 cbbs.setDisable(true);
//			 cbbt.setDisable(true);
//		 }
		 
		 
		
		 
		 
//		 MovieController.showTimes.add(showTime);
//		//Logic here can grab information from the database to put in Observablelists for list of movie theatres, movies and show times
//		//to show in choice boxes
		initialize();
		 
	}
	
	@FXML
	public void chooseTheatre(ActionEvent event)
	{
		String name = cbbm.getValue();
		 if(name!=null)
		 {
			 status.setText("Movie chosen successfully");
			 for(int i=0; i<MList.size(); i++)
				 if(MList.get(i).getName().equals(name))
					 m = MList.get(i);
			 
			 TList = DatabaseManager.getInstance().queryTheatresWithMovie(m.getId());
			 for(int i=0; i<TList.size(); i++)
				 cbbtList.add(TList.get(i).getName());
			 cbbt.getItems().addAll(cbbtList);
			 cbbt.setDisable(false);
			 initialize();
			
		 }
	}
	
	public void chooseScreening(ActionEvent event)
	{
		String TheatreName = cbbt.getValue();
		
		if(TheatreName!=null)
		{
			status.setText("Theatre chosen successfully");
			MovieTheatre mt = null;
			for(int i=0; i<TList.size(); i++)
				if(TList.get(i).getName().equals(TheatreName))
					mt = TList.get(i);
//			System.out.println(mt.toString());
			MSList = DatabaseManager.getInstance().queryScreeningsAtTheatre(m.getId(), mt.getId());
			 for(int i=0; i<MSList.size(); i++)
			 {
				 LocalDateTime ldt = MSList.get(i).getMovieDate();
				 DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
				 cbbsList.add(ldt.format(formatter));
				 status.setText(ldt.format(formatter));
			 }
			 
			 cbbs.getItems().addAll(cbbsList);
			 cbbs.setDisable(false);
			 initialize();
		}
	}
	
	@FXML
	public void initialize() {
		cbbt.setItems(cbbtList);	
		cbbm.setItems(cbbmList);
		cbbs.setItems(cbbsList);	
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
		String time = cbbs.getValue();
		 if(time!=null)
		 {
			 for(int i=0; i<MSList.size(); i++)
			 {
				 DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
				 if(time.equals(MSList.get(i).getMovieDate().format(formatter)))
					 showTime = MSList.get(i);
			 }
		 }
		MovieController.setSelectedScreening(showTime);
		
		window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		SeatView sv = new SeatView();
		sv.begin(window);
	}
	
	public void goBack(ActionEvent event) {
		//logic for going to the previous window:
		//for now:
		window = (Stage) ((Button) event.getSource()).getScene().getWindow();
		Menu m = new Menu();
		m.begin(window);
	}
}

