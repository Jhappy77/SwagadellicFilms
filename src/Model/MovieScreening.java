package Model;

import java.sql.Date;

public class MovieScreening {
	
	private Date movieDate; // CHANGED from string to date
	private String screenTime;
	private String theatreName;
	private String movieName;
	private String id;
	
	public MovieScreening(Date date, String sName, String tName, String mName, String i) {
		setMovieDate(date);
		setScreenTime(sName);
		setTheatreName(tName);
		setMovieName(mName);
		setId(i);
	}

	public Date getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(Date movieDate) {
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
