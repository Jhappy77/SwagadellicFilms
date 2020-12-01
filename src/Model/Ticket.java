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
	private String seatNumber;
	
	public Ticket(String ticketId, MovieScreening sTime, String seatNumber) {
		this.setSeatNumber(seatNumber);
		setPrice(20);
		setId(ticketId);
		setMovieDate(sTime);
		isCancellable = cancellable(showTime.getMovieDate());
	}
	
	public boolean getIsCancellable() {
		return isCancellable;
	}
	
	public boolean getIsExpired() {
		return isExpired;
	}
	
	//TODO: Remove this function
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
	
//	public String getTime() {
//		return showTime.getScreenTime();
//	}

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

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	
//	@Override
//	public String toString() {
//		String s = 	"Seat Number: " + seats + ". ID: " + id + "\n"
//				  + "Movie Date and Time: " + showTime.getMovieDate().toString() + "\n"
//				  + "Ticket Price: " + price;
//		return s;
//	}
	
}
