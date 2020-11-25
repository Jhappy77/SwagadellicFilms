package Controller;

import java.util.Map;

import Model.Movie;
import Model.MovieScreening;
import Model.MovieTheatre;

public class MovieController {
	private static MovieScreening selectedScreening;
	
	public static Movie findMovie(String movieName)
	{
		return null;
	}
	
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
