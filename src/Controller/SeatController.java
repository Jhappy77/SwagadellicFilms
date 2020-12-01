package Controller;

import java.util.List;
import java.util.UUID;

import Boundary.Seat;
import Model.Cart;
import Model.MovieScreening;
import Model.Ticket;

public class SeatController {
	
	// The screening that is currently selected
	private static MovieScreening theScreening;
	
	
	public SeatController() {
		//TODO: Add some error catching if there is no selected screening
		theScreening = MovieController.getSelectedScreening();
	}
	
	private static void addTicketToCart(Ticket ticket)
	{
		Cart theCart = Cart.getInstance();
		theCart.addTicket(ticket);
	}
	
	public static void removeTicketFromCart(String id)
	{
		Cart theCart = Cart.getInstance();
		theCart.removeTicket(id);
	}
	
	public MovieScreening getActiveScreening()
	{
		return theScreening;
	}
	
	public List<Integer> getBookedSeatIDs()
	{
		DatabaseManager dbm = DatabaseManager.getInstance();
		return dbm.queryBookedSeats(theScreening.getId());
	}
	
	public void addSeatsToCart(List<Integer> ids)
	{
		for(int seatId: ids) {
			// Generates a random Ticket ID
			String ticketId = UUID.randomUUID().toString().substring(0, 20);
			// Creates a ticket
			Ticket t = new Ticket(ticketId, theScreening, seatId);
			// Adds it to cart
			addTicketToCart(t);
		}
	}
}
