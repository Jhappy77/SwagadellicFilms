package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;

public class Ticket {
	
	private MovieScreening showTime;
	private double price;
	private String id;
	private boolean isCancellable;
	private boolean isExpired;
	
	public Ticket(String s, MovieScreening sTime) {
		setPrice(20);
		setId(s);
		setMovieDate(sTime);
		isCancellable = cancellable(showTime.getMovieDate());
	}
	
	public void addSeat(Seat s)
	{
		showTime.addSeat(s);
	}
	public boolean cancellable(LocalDateTime d) {	// ADDED FUNCTION
		LocalDateTime startDate = subtractDays(showTime.getMovieDate(), 3);
		return d.isBefore(startDate);
	}
	
    public LocalDateTime subtractDays(LocalDateTime date, int days) {	// ADDED FUNCTION
    	LocalDateTime startDate = date;
    	startDate.minusDays(days);
        return startDate;
    }
    public void setExpiry() {
    	isExpired = expired(showTime.getMovieDate());
    }
	public boolean expired(LocalDateTime d) {
		Calendar c = Calendar.getInstance();
		return !(c.before(d));
	}
	
	public LocalDateTime getMovieDate() {
		return showTime.getMovieDate();
	}
	
	public void setMovieDate(MovieScreening sTime) {
		showTime = sTime;
	}
	
	public String getTime() {
		return showTime.getScreenTime();
	}
	


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public MovieScreening getScreening()
	{
		return showTime;
	}
	
//	@Override
//	public String toString() {
//		String s = 	"Seat Number: " + seats + ". ID: " + id + "\n"
//				  + "Movie Date and Time: " + showTime.getMovieDate().toString() + "\n"
//				  + "Ticket Price: " + price;
//		return s;
//	}
	
}
