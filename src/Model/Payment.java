package Model;

public class Payment {
	private String id;
	private PaymentMethod method;
	private float dollarAmount;
	private boolean isProcessed;
	
	public Payment(String i, float amount, PaymentMethod m)
	{
		id = i;
		dollarAmount = amount;
		method = m;
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
	
	public boolean getProcess()
	{
		return isProcessed;
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
