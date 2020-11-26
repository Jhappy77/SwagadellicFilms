package Model;

import java.util.Date;

public class RegisteredUser implements User{
	private String name;
	private Date DateOfBirth;
	
	public RegisteredUser(String n, Date dob)
	{
		name = n;
		DateOfBirth = dob;
	}
	

	@Override
	public float getRefundFee() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean canSeeEarlyInfo() {
		// TODO Auto-generated method stub
		return false;
	}

}
