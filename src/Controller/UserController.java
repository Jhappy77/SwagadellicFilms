package Controller;

import java.io.IOException;
import java.util.Date;

import org.json.JSONException;

import Model.PaymentMethod;
import Model.RegisteredUser;
import Model.User;

public class UserController {
	private static User u;
	
	
	public static void addUser(String username, String password, String email, Date birthdate, String name, String address, PaymentMethod method) throws JSONException, IOException
	{
		setUser(new RegisteredUser(username, password, email, birthdate, name, address, method));
		DatabaseManager.getInstance().saveRegisteredUser((RegisteredUser)u);
	}
	
	public static void setUser(User us)
	{
		u = us;
	}
}
