package Controller;

/**
 * A class to help control exceptions when the user 
 * is searching for tickets to refund.
 *
 */
public class TicketException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum ErrorType{
			NOT_FOUND,
			EXPIRED,
			UNCANCELLABLE
	}
	
	private ErrorType theType;
	private String ticketId;
	
	public TicketException(ErrorType type, String ticketId) {
		theType = type;
		this.ticketId = ticketId;
	}
	
	public String getTicketMessage() {
		switch(theType) {
		case NOT_FOUND:
			return "Ticket " + ticketId + " could not be found.";
		case EXPIRED:
			return "Ticket " + ticketId + " has expired and cannot be returned.";
		case UNCANCELLABLE:
			return "Ticket " + ticketId + " cannot be cancelled (Screening is too close)";
		default:
			return "Ticket was unattainable";
		}
	}
}
