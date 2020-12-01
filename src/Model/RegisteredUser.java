package Model;

import java.util.Date;

public class RegisteredUser implements User{
	private String username;
	private String password;
	private String email;
	private String name;
	private String address;
	private Date DateOfBirth;
	private PaymentMethod method;
	

	public RegisteredUser(String username, String password, String email, Date birthdate, String name, String address, PaymentMethod method) {
		this.setUsername(username);
		this.setPassword(password);
		this.setEmail(email);
		this.setName(name);
		this.setAddress(address);
		this.setDateOfBirth(birthdate);
		this.setMethod(method);
//		userID = id;
	}
	
	public RegisteredUser(String username, String password, String email, Date birthdate, String name) {
        this.setUsername(username);
        this.setPassword(password);
        this.setEmail(email);
        this.setName(name);
        this.setDateOfBirth(birthdate);
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
	


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Date getDateOfBirth() {
		return DateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}


	public PaymentMethod getMethod() {
		return method;
	}


	public void setMethod(PaymentMethod method) {
		this.method = method;
	}
	

}
