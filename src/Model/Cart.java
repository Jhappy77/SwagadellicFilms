package Model;

import java.util.ArrayList;
import java.util.List;

import Controller.DatabaseManager;

public class Cart {
	
	private List<Ticket> tickets;
	private static Cart cart;
	
	private Cart() {
		tickets = new ArrayList<Ticket>();
	}
	
	public static Cart getInstance() {
		if(cart == null)
			cart = new Cart();
		return cart;
	}
	
	public List<Ticket> getTickets()
	{
		return tickets;
	}
	
	public Payment makePayment(PaymentMethod pm) { 
		float total = 0;
		for(Ticket t: tickets) {
			total += t.getPrice();
		}
		return new Payment(total, pm);
	}
	
	public void clear() {
		tickets.clear();
	}
	
	public void addTicket(Ticket t) {
		tickets.add(t);
	}
	
	public void removeTicket(String id) {
		for(Ticket t: tickets) {
			if(t.getId() == id)
				tickets.remove(t);
		}
	}
	
	/**
	 * Saves the tickets in the cart to the database.
	 */
	public void saveTickets() throws Exception {
		for(Ticket t: tickets) {
			DatabaseManager dbm = DatabaseManager.getInstance();
			dbm.saveTicket(t);
			this.removeTicket(t.getId());
		}
	}
	
	
}
