package Boundary;

import java.util.ArrayList;

import Model.Seat;

public interface SeatMap {
	abstract public void display();
	abstract public Seat getSeatID();
	abstract public void loadBookedSeat(ArrayList<Integer> ids);
}
