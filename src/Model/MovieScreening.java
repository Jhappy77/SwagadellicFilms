package Model;

import java.time.LocalDateTime;

public class MovieScreening {
	
	private LocalDateTime movieDate; // CHANGED from string to date
	private String screenTime;
	private String theatreName;
	private String movieName;
	private String id;
	
	public MovieScreening(LocalDateTime date, String sName, String tName, String mName, String i) {
		setMovieDate(date);
		setScreenTime(sName);
		setTheatreName(tName);
		setMovieName(mName);
		setId(i);
	}

	public LocalDateTime getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(LocalDateTime movieDate) {
		this.movieDate = movieDate;
	}
	
	public String getScreenTime() {
		return screenTime;
	}

	public void setScreenTime(String screenTime) {
		this.screenTime = screenTime;
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

}
