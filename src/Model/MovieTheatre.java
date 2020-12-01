package Model;

// UPDATED: changed genre to theatreType
public class MovieTheatre {

	private String location;
	private String name;
	private String id;
	private String theatreType;
	
	public MovieTheatre(String loc, String n, String i, String g) {
		setLocation(loc);
		setName(n);
		setId(i);
		setTheatreType(g);
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTheatreType() {
		return theatreType;
	}

	public void setTheatreType(String theatreType) {
		this.theatreType = theatreType;
	}
	
}
