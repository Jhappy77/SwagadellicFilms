package Controller;

import java.util.ArrayList;
import java.util.Map;

import Model.Movie;
import Model.MovieScreening;
import Model.MovieTheatre;

public class MovieController {
	public static ArrayList<MovieScreening> showTimes;
	private static MovieScreening selectedScreening;
	
	
	public static MovieScreening getSelectedScreening() {
		return selectedScreening;
	}
	
	public static void setSelectedScreening(MovieScreening ms) {
		selectedScreening = ms;
	}
	
	
	
}
