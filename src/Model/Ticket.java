package Model;

import java.sql.Date;

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
		isCancellable = isNotWithinRange(showTime.getMovieDate());
	}
	
	public Date getMovieDate() { // UNFINISHED
		return showTime.getMovieDate();
	}
	
	public String getTime() {	//UNFINISHED
		return showTime.getScreenTime();
	}
	
	public void display() {	// UNFINISHED
		
	}
	
	public boolean isNotWithinRange(Date d) {	// ADDED FUNCTION
		Date startDate = showTime.getMovieDate();
		Date endDate = showTime.getMovieDate();
		endDate.;
		return (d.before(startDate) || d.after(endDate));
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
