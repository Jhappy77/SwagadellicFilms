package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import Boundary.Seat;
import Model.Cart;
import Model.FinancialInstitution;
import Model.Payment;
import Model.PaymentMethod;
import Model.Ticket;
import Model.User;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PaymentController {
	public static ArrayList<Seat> bookedSeats;
//	private User u;
//	
//	public static void addPayment(User u)
//	{
//		
//	}
	
	/**
	 * Price of any additional charges (I.E. renewing things)
	 */
	private static float price;
	
	public static float getTotalPrice() {
		Cart theCart = Cart.getInstance();
		return price + theCart.subtotal();
	}
	public static void setPrice(float f) {
		price =f;
	}
	
	
	public static int searchPaymentID(String id)
	{
		return 0;
	}
	
	/**
	 * Searches for a ticket by ID. If it doesn't find it or if it is not refundable,
	 * returns an exception.
	 * @throws TicketException 
	 */
	public static Ticket searchRefundableTicket(String id) throws TicketException
	{
		DatabaseManager dbms = DatabaseManager.getInstance();
		//TODO: Make sure this works in dbms (broken when written)
		Ticket t;
		try{
			t = dbms.queryTicket(id);
		} catch(Exception e){
			throw new TicketException(TicketException.ErrorType.NOT_FOUND, id);
		}
		if(t == null) {
			throw new TicketException(TicketException.ErrorType.NOT_FOUND, id);
		}
		else if(t.getIsExpired()) {
			throw new TicketException(TicketException.ErrorType.EXPIRED, id);
		}
		else if(!t.getIsCancellable()) {
			throw new TicketException(TicketException.ErrorType.UNCANCELLABLE, id);
		}
		return t;
	}
	
	/**
	 * Refunds a list of tickets.
	 * These tickets were retrieved using searchRefundable ticket,
	 * so we know they're refundable.
	 * @param ids
	 */
	public static void refundTickets(ArrayList<String> ids)
	{
		for(String ticketId: ids) {
			
		}
	}
	
	/**
	 * Pays for all the tickets that are currently in the cart.
	 * This is a simple abstraction of what would actually happen.
	 * @param method
	 */
	public static boolean payTickets(PaymentMethod method) throws PaymentException
	{
		Cart theCart = Cart.getInstance();
		Payment thePayment = theCart.makePayment(method);
		thePayment = FinancialInstitution.processPayment(thePayment);
		if(thePayment.getIsProcessed()) {
			DatabaseManager dbm = DatabaseManager.getInstance();
			try {
//				dbm.savePayment(thePayment);
				theCart.saveTickets();
				theCart.clear();
				PaymentController.setPrice(0);
				return true;
			} catch (JSONException e) {
				
				
				//TODO: better error checking for paying tickets
				
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			throw new PaymentException("Payment was not accepted.");
		}
		return false;
	}
	
	/**
	 * Removes a ticket from the cart
	 * @param id ID of ticket to remove from cart
	 */
	public static void removeTicket(String id)
	{
		Cart theCart = Cart.getInstance();
		theCart.removeTicket(id);
	}
	
	/**
	 * Fills the cart content VBox
	 * @param cartContent
	 */
	public static List<Label> fillCartContentView() {
		Cart theCart = Cart.getInstance();
		List<Label> cartInfos = new ArrayList<>();
		
		for(Ticket t: theCart.getTickets()) {
			String message = t.toString();
			Label l = new Label();
			l.setText(message);
			cartInfos.add(l);
			System.out.println("Your cart contains:" + message);
		}
		
		//cartContent.getChildren().addAll(cartInfos);
		return cartInfos;
		
	}
	
	
}
