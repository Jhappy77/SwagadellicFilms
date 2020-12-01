package Controller;

import java.util.ArrayList;

import Model.PaymentMethod;
import Model.Ticket;
import Model.User;

public class PaymentController {
	private User u;
	public static void addPayment(User u)
	{
		
	}
	
	public static int searchPaymentID(String id)
	{
		return 0;
	}
	
	public static Ticket searchRefundableTicket(String id)
	{
		return null;
	}
	
	public static void refundTickets(ArrayList<String> ids)
	{
		
	}
	
	public static void payTickets(PaymentMethod method)
	{
		
	}
	
	public static void removeTicket(String id)
	{
		
	}
	
	public void setUser(User u)
	{
		this.u = u;
	}
	
}
