package Controller;

import java.util.ArrayList;
import java.util.Map;

import Model.Movie;
import Model.MovieScreening;
import Model.MovieTheatre;

public class MovieController {
	public static ArrayList<MovieScreening> showTimes;
	public final static String DB_URL = "https://calm-shelf-23678.herokuapp.com/swagDB/";
	private static MovieScreening selectedScreening;
	
	
	public static MovieScreening getSelectedScreening() {
		return selectedScreening;
	}
	
	//TODO: This is a method for searching movies. 
	//We probably don't need it.
//	public static Movie findMovie(String movieName)
//	{
//		String movieURL = DB_URL + "movies";
//		
//		return null;
//	}
	
	public static MovieTheatre findTheatre(Movie movie)
	{
		return null;
	}
	
	public static MovieScreening findScreening(Movie movie, MovieTheatre theatre)
	{
		return null;
		
	}
	
	public static Map<String, String> getAvailableMovies()
	{
		return null;
		
	}
	
	public static Map<String, String> getAvailableTheatre(String movieID)
	{
		return null;
		
	}
	
	public static Map<String, String> getAvailableScreening(String theatreID)
	{
		return null;
		
	}
	
	public static void chooseScreening(String screeningID)
	{
		
	}
	
}
