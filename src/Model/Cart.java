package Model;

import java.util.ArrayList;
import java.util.List;

import Controller.DatabaseManager;
import Controller.UserController;

public class Cart {
	private static ArrayList<Ticket> ticketsInfo;
	private List<Ticket> tickets;
	private List<Ticket> refundTickets;
	private static Cart cart;
	
	public void addRefundTicket(Ticket t)
	{
		refundTickets.add(t);
	}
	
	public ArrayList<Ticket> getTicketsInfo()
	{
		return ticketsInfo;
	}
	
	public void addTicketsInfo(Ticket t)
	{
		ticketsInfo.add(t);
	}
	
	public void clearInfo()
	{
		ticketsInfo.clear();
	}
	public List<Ticket> getRefundTickets()
	{
		return refundTickets;
	}
	
	private Cart() {
		tickets = new ArrayList<Ticket>();
		refundTickets = new ArrayList<Ticket>();
		ticketsInfo = new ArrayList<Ticket>();
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
	
	public float subtotal() {
		float total = 0;
		for(Ticket t: tickets) {
			total += t.getPrice();
		}
		for(Ticket t: refundTickets) {
			
			total -= (t.getPrice() - UserController.getUser().getRefundFee() * t.getPrice());
			
		}
		return total;
	}
	
	public Payment makePayment(PaymentMethod pm) { 
		return new Payment(subtotal(), pm);
	}
	
	public void clear() {
		tickets.clear();
		refundTickets.clear();
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
		}
		for(Ticket t: refundTickets) {
			DatabaseManager dbm = DatabaseManager.getInstance();
			dbm.removeTicket(t.getId());
		}
		clear();
	}
	
	
	
}
