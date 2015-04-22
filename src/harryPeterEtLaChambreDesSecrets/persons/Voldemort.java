package harryPeterEtLaChambreDesSecrets.persons;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import harryPeterEtLaChambreDesSecrets.exceptions.NullRoomAtBeginningForPlayerException;
import harryPeterEtLaChambreDesSecrets.exceptions.NullRoomAtBeginningForVoldemortException;
import harryPeterEtLaChambreDesSecrets.rooms.Room;

/**
 * The Class Voldemort. Voldemort is a bad boy which kills people. You shouldn't
 * have a date with him.
 */
public class Voldemort extends Person {

	/**
	 * Instantiates a new voldemort.
	 * 
	 * @param roomStart
	 *            the room start
	 * @throws NullRoomAtBeginningForPlayerException
	 *             the null room at beginning exception
	 */
	public Voldemort(Room roomStart) throws NullRoomAtBeginningForVoldemortException {
		super(roomStart);
		if (roomStart == null)
			throw new NullRoomAtBeginningForVoldemortException();
	}

	/**
	 * Makes move Voldemort randomly.
	 */
	public void changeRoom() {
		// 0,5 chance for Voldemort to move
		boolean changeRoom = new Random().nextBoolean();
		if (changeRoom) {
			HashMap<String, Room> exits = this.currentRoom.getExits();

			// Gets a random number between the numbe rof exits of a the
			// Voldemort current room
			int increment = new Random().nextInt(exits.size());

			// Gets the random exit
			Iterator<Room> it = exits.values().iterator();
			for (int i = 0; i < increment; i++) {
				it.next();
			}

			// Affects the Voldemort current room
			this.currentRoom = it.next();
		}

	}

}
