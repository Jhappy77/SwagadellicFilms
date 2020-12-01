package Boundary;

import javafx.css.PseudoClass;
import javafx.scene.control.Button;



public class Seat extends Button{
	
	//Pseudo classes for CSS
	public static final PseudoClass PSEUDO_CLASS_UNAVAILABLE = PseudoClass.getPseudoClass("seat--unavailable");
	public static final PseudoClass PSEUDO_CLASS_UNSELECTED = PseudoClass.getPseudoClass("seat--unselected");
	public static final PseudoClass PSEUDO_CLASS_SELECTED = PseudoClass.getPseudoClass("seat--selected");
	
	
	private boolean isAvailable;
	private boolean isSelected;
	private SeatView parentView;
	private int seatID;
	
	public Seat(int seatNo, SeatView view)
	{
		super(Integer.toString(seatNo));
		seatID = seatNo;
		isAvailable = true;
		isSelected = false;
		parentView = view;
	}
	
	// Reaction to pressing button
	public void fire() {
		if(isAvailable) {
			if(isSelected) {
				markUnselected();
				parentView.removeSeat(seatID);
			}
			else {
				markSelected();
				parentView.addSeat(seatID);
			}
		} else {
			System.out.println("Could not select seat #" + seatID + " as it's already booked.");
		}
	}
	
	public void markUnselected() {
		System.out.println("You unselected seat #" + seatID);
		isSelected = false;
		this.pseudoClassStateChanged(PSEUDO_CLASS_UNAVAILABLE, false);
		this.pseudoClassStateChanged(PSEUDO_CLASS_SELECTED, false);
		this.pseudoClassStateChanged(PSEUDO_CLASS_UNSELECTED, true);
	}
	
	public void markSelected() {
		System.out.println("You selected seat #" + seatID);
		isSelected = true;
		this.pseudoClassStateChanged(PSEUDO_CLASS_UNAVAILABLE, false);
		this.pseudoClassStateChanged(PSEUDO_CLASS_SELECTED, true);
		this.pseudoClassStateChanged(PSEUDO_CLASS_UNSELECTED, false);
	}

	public void makeUnavailable() {
		isAvailable = false;
		this.pseudoClassStateChanged(PSEUDO_CLASS_UNAVAILABLE, true);
		this.pseudoClassStateChanged(PSEUDO_CLASS_SELECTED, false);
		this.pseudoClassStateChanged(PSEUDO_CLASS_UNSELECTED, false);
	}
	
	public int getSeatID() {
		return seatID;
	}

	
}
