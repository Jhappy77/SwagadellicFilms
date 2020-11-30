package Model;

public class MovieTheatre {

	private String location;
	private String name;
	private String id;
	
	public MovieTheatre(String loc, String n, String i) {
		setLocation(loc);
		setName(n);
		setId(i);
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
	
}
