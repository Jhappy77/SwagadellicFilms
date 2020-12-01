package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;

import Boundary.Seat;

// UPDATE: removed screenTime because movieDate covers both time and date
public class MovieScreening {
	
	private LocalDateTime movieDate; // CHANGED from string to LocalDateTime
	private String theatreName;
	private String movieName;
	private String id;
	private ArrayList<Seat> seats;
	private String timeString;
	private String shorthandName;
	
	public MovieScreening(LocalDateTime date, String tName, String mName, String i) {
		seats = new ArrayList<Seat>();
		setMovieDate(date);
		setTheatreName(tName);
		setMovieName(mName);
		setId(i);
		setShorthandName();
	}

	public void setShorthandName() {
		timeString = movieDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH)+" "+movieDate.getDayOfMonth() + "@" + movieDate.toLocalTime().format(DateTimeFormatter.ISO_TIME);
		shorthandName = movieName + " on " + timeString + " ("+theatreName+")";
	}
	
	
	@Override
	public String toString() {
		return shorthandName;
	}
	
	public void addSeat(Seat s)
	{
		seats.add(s);
	}
	
	public LocalDateTime getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(LocalDateTime movieDate) {
		this.movieDate = movieDate;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Seat> getSeats() {
		return seats;
	}

}
