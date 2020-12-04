package Model;

public class AnonymousUser implements User{
	
	public void subscribe() {
		
	}

	@Override
	public float getRefundFee() {
		// TODO Auto-generated method stub
		return 0.15f;
	}

	@Override
	public boolean canSeeEarlyInfo() {
		return false;
	}
	
}

