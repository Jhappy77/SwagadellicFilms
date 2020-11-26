package Model;

import java.util.List;

public class Cart {
	
	private List<Ticket> tickets;
	Cart cart;
	
	public Cart() {
		
	}
	
	public boolean makePayment() {
		return true;
	}
	
	public Cart getCart() {
		return this;
	}
	
	public void setCart(Cart c) {
		this.cart = c;
	}
	
	public void clear() {
		tickets.clear();
	}
	
	public void addTicket(Ticket t) {
		tickets.add(t);
	}
	
	public void removeTicket(String id) { //
		tickets.remove(id);
	}
	
}
