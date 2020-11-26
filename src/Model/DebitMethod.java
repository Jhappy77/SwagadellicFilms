package Model;

public class DebitMethod implements PaymentMethod{
	private int number;
	private int cvv;
	
	DebitMethod(int n, int c)
	{
		number = n;
		cvv  = c;
	}
	@Override
	public String validateMessage() {
		// TODO Auto-generated method stub
		return ("Debit card:" + number);
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
