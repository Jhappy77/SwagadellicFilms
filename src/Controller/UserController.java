package Controller;

import java.io.IOException;
import java.util.Date;

import org.json.JSONException;

import Model.PaymentMethod;
import Model.RegisteredUser;
import Model.User;

public class UserController {
<<<<<<< HEAD
	private User u;
	
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
	
	public void setUser(User u)
	{
		this.u = u;
=======
	private static User u;
	
	
	public static void addUser(String username, String password, String email, Date birthdate, String name, String address, PaymentMethod method) throws JSONException, IOException
	{
		setUser(new RegisteredUser(username, password, email, birthdate, name, address, method));
		DatabaseManager.getInstance().saveRegisteredUser((RegisteredUser)u);
	}
	
	public static void setUser(User us)
	{
		u = us;
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da
	}
}
