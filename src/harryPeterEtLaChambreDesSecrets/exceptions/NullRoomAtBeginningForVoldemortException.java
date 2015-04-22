package harryPeterEtLaChambreDesSecrets.exceptions;

/**
 * The Class NullRoomAtBeginningForVoldemortException. Called when Voldemort doesn't have a
 * valid start room.
 */
public class NullRoomAtBeginningForVoldemortException extends Exception {

	private static final long serialVersionUID = 1L;

	public NullRoomAtBeginningForVoldemortException() {
	}
	
	@Override
	public String toString() {
		return "Voldemort needs a beginning room to start the party. See in class Mappage.";
	}

}
