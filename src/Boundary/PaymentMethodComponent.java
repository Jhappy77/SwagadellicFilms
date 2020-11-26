package Boundary;

import Model.PaymentMethod;

public class PaymentMethodComponent {
	private PaymentMethod method;
	
	public void switchMethod()
	{
		
	}
	
	public void setPaymentMethod(PaymentMethod m) //strategy pattern
	{
		method = m;
	}
}
