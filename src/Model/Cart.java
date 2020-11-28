package Model;

import java.util.List;

public class Cart {
	
	private List<Ticket> tickets;
	private static Cart cart;
	
	private Cart() {}
	
	public static Cart getInstance() {
		if(cart == null)
			cart = new Cart();
		return cart;
	}
	
	public boolean makePayment() { // UNIMPLEMENTED
		// CHECK TO SEE PAYMENT FIRST
		
		double total = 0;
		for(Ticket t: tickets) {
			total += t.getPrice();
		}
		
		// CONFIRM PAYMENT TO FINANCIAL INSTITUTION
		
		// if successful = true, else = false
	}
	
	public Cart getCart() {
		return this;
	}
	
	public void setCart(Cart c) {
		cart = c;
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
	
}
