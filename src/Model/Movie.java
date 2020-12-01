package Model;

import java.util.Date;

public class Movie {

	private String name;
	private String genre;
	private String id;
	private Date releaseDate;
	
	public Movie(String n, String g, String i, Date d) {
		setName(n);
		setGenre(g);
		setId(i);
		setReleaseDate(d);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
}
