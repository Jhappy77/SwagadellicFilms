package Boundary;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;

public interface SeatMap {
	abstract public List<Node> display();
	abstract public Seat getSeatID();
	abstract public void loadBookedSeat(List<Integer> ids);
}
