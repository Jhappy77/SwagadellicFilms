package Model;

public class Payment {
	private String id;
	private PaymentMethod method;
	private float dollarAmount;
	private boolean isProcessed;
	
	Payment(String i, float amount)
	{
		id = i;
		dollarAmount = amount;
		method = null;
		isProcessed = false;
	}
	
	public void setPaymentMethod(PaymentMethod pm)
	{
		method = pm;
	}
	
	public PaymentMethod getMethod()
	{
		return method;
	}
	
	public void setProcess(boolean processed)
	{
		isProcessed = processed;
	}
	
	public String getID()
	{
		return id;
	}
	
	public float getAmount()
	{
		return dollarAmount;
	}
	
	public boolean getState()
	{
		return isProcessed;
	}
}
