package Model;

public class FinancialInstitution {
    public static Payment processPayment(Payment p)
    {
        PaymentMethod pm = p.getMethod();
        if(pm instanceof DebitMethod) {
            if(processDebitMethod((DebitMethod)pm))
            {
                p.setProcess(true);
                System.out.println("Payment with " + ((DebitMethod)pm).validateMessage() + " was processed");
                return p;
            }
            else
            {
                p.setProcess(false);
                System.out.println("Payment with " + ((DebitMethod)pm).validateMessage() + " was not processed");
                return p;
            }
        }
        else if(pm instanceof CreditMethod)
        {
            if(processCreditMethod((CreditMethod)pm))
            {
                p.setProcess(true);
                System.out.println("Payment with " + ((CreditMethod)pm).validateMessage() + " was processed");
                return p;
            }
            else
            {
                p.setProcess(false);
                System.out.println("Payment with " + ((CreditMethod)pm).validateMessage() + " was not processed");
                return p;
            }
        }
        
        return p;
    }
    
    private static boolean processDebitMethod(DebitMethod dMethod)
    {
        if(dMethod.getCVV() == 111 && dMethod.getNumber() == 1111111)
        {
            return true;
        }
        return false;
    }
    
    private static boolean processCreditMethod(CreditMethod cMethod)
    {
        if(cMethod.getCVV() == 111 && cMethod.getNumber() == 1111111)
        {
            return true;
        }
        return false;
    }
}