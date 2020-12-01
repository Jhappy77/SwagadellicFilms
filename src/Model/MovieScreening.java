package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;

// UPDATE: removed screenTime because movieDate covers both time and date
public class MovieScreening {
	
	private LocalDateTime movieDate; // CHANGED from string to LocalDateTime
	private String theatreName;
	private String movieName;
	private String id;
	private ArrayList<Seat> seats;
	
	public MovieScreening(LocalDateTime date, String tName, String mName, String i) {
		seats = new ArrayList<Seat>();
		setMovieDate(date);
		setTheatreName(tName);
		setMovieName(mName);
		setId(i);
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
