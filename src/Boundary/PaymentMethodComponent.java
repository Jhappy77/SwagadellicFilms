package Boundary;

import Model.CreditMethod;
import Model.DebitMethod;
import Model.PaymentMethod;

public class PaymentMethodComponent {
	private PaymentMethod method;
	
	public void switchMethod(int number)
	{
		if(method instanceof DebitMethod)
			setPaymentMethod(new CreditMethod(number));
		else if(method instanceof CreditMethod)
			setPaymentMethod(new DebitMethod(number));
	}
	
	public void setPaymentMethod(PaymentMethod m) //strategy pattern
	{
		method = m;
	}
	
	public PaymentMethod getMethod()
	{
		return method;
	}
}
