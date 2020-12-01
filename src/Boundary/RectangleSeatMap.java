package Boundary;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class RectangleSeatMap implements SeatMap{
	
	private List<Seat> map;
	private int width, height;

	public RectangleSeatMap(int width, int height, SeatView view) {
		map = new ArrayList<Seat>();
		this.width = width;
		this.height = height;
		
		for(int i=1; i<= width*height; i++) {
			map.add(new Seat(i, view));
		}
		
	}
	

	@Override
	public List<Node> display() {
		List<Node> hboxes = new ArrayList<Node>();
		for(int i=0; i<height; i++) {
			HBox row = new HBox(10);
			row.getChildren().addAll(map.subList(i*width, (i*width+width)));
			hboxes.add(row);
		}
		return hboxes;
	}

	@Override
	public Seat getSeatID() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	/**
	 * Marks the seats which have already been booked as unavailable.
	 */
	public void loadBookedSeat(List<Integer> ids) {
		for(int id: ids) {
			if(map.size()>id) {
				// Marks the seat as unavailable
				map.get(id-1).makeUnavailable();
			}
		}
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
