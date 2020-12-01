package Model;

public class CreditMethod implements PaymentMethod{
<<<<<<< HEAD
=======
	private int number; 
	private int cvv;
	
	
	public CreditMethod(int n)
	{
		number = n; 
		cvv = 111;
	}
	@Override
	public String validateMessage() {
		return ("Credit card " + number);
	}
	
	public int getNumber()
	{
		return number;
	}
	
	public int getCVV()
	{
		return cvv;
	}
>>>>>>> a489fa46e6c00fd0c2432d59be00fa7416ce29da

	public void setNumber(int n)
	{
		number = n;
	}
	
	public void setCVV(int c)
	{
		number = c;
	}
}
