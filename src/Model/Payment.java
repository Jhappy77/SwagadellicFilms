package Model;

import java.util.UUID;

public class Payment {
	private String id;
	private PaymentMethod method;
	private float dollarAmount;
	private boolean isProcessed;
	
	public Payment(float amount, PaymentMethod m)
	{
		//Generates a random UUID
		id = UUID.randomUUID().toString().substring(0, 30);
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
	
	public boolean getIsProcessed()
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
