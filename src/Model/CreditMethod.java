package Model;

public class CreditMethod implements PaymentMethod{
	private int number; 
	private int cvv;
	
	CreditMethod(int n, int c)
	{
		number = n; 
		cvv = c;
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

}
