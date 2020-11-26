package Model;

import java.sql.Date;
import java.util.Calendar;

public class Ticket {
	
	private int seatNumber;
	private MovieScreening showTime;
	private double price;
	private String id;
	private boolean isCancellable;
	private boolean isExpired;
	
	public Ticket(int seatNum, double p, String s) {
		setSeatNumber(seatNum);
		setPrice(p);
		setId(s);
		isCancellable = cancellable(showTime.getMovieDate());
	}
	
	public Date getMovieDate() { // UNFINISHED
		return showTime.getMovieDate();
	}
	
	public String getTime() {	//UNFINISHED
		return showTime.getScreenTime();
	}
	
	public void display() {	// UNFINISHED
		
	}
	
	public boolean cancellable(Date d) {	// ADDED FUNCTION
		Date startDate = subtractDays(showTime.getMovieDate(), 3);
		return d.before(startDate);
	}
	
    public static Date subtractDays(Date date, int days) {	// ADDED FUNCTION
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, -days);
        return new Date(c.getTimeInMillis());
    }

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
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
	
}
