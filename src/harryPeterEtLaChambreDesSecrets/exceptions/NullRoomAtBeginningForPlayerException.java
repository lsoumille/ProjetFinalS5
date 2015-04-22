package harryPeterEtLaChambreDesSecrets.exceptions;

/**
 * The Class NullRoomAtBeginningForPlayerException. Called when the player doesn't have a
 * valid start room.
 */
public class NullRoomAtBeginningForPlayerException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new null room at beginning exception.
	 */
	public NullRoomAtBeginningForPlayerException() {
	}

	@Override
	public String toString() {
		return "Player needs a beginning room to start the party. See in class Mappage.";
	}

}
