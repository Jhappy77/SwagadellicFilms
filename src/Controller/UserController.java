package Controller;

import Model.AnonymousUser;
import Model.PaymentMethod;
import Model.RegisteredUser;
import Model.User;

public class UserController {
	private static User selectedUser;
	
	public static boolean verifyLoginDebit(String username, String password)
	{
		return false;
	}
	
	public static boolean verifyLoginCredit(String username, String password)
	{
		return false;
	}
	
	public static void addUser(String username, String password, String email, String birthdate, String name, String address, PaymentMethod method)
	{
		
	}
	
	
	public static User getActive()
	{
		return selectedUser;
	}
	
	public void setActive(User customer)
	{
		selectedUser = customer;
	}
}
