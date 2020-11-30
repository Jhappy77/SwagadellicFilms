package Model;

public class DebitMethod implements PaymentMethod{
	private int number;
	private int cvv;
	
	
	public DebitMethod(int n)
	{
		number = n;
		cvv  = 111;
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
	
	public void setNumber(int n)
	{
		number = n;
	}
	
	public void setCVV(int c)
	{
		number = c;
	}

}
