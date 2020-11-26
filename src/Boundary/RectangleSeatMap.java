package Boundary;

import java.util.ArrayList;
import java.util.List;

import Model.Seat;

public class RectangleSeatMap implements SeatMap{
	private List<Seat> map;
	private int width, height;

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seat getSeatID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadBookedSeat(ArrayList<Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	public void setWidth(int w)
	{
		width = w;
	}
	
	public void setHeight(int h)
	{
		height = h;
	}
}
