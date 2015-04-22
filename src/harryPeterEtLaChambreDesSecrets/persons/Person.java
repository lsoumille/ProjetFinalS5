package harryPeterEtLaChambreDesSecrets.persons;

import harryPeterEtLaChambreDesSecrets.rooms.Room;

/**
 * The Class Person.
 */
public class Person {

	/** The current room of the person. */
	protected Room currentRoom;

	/**
	 * Instantiates a new person. A person needs a room to spawn.
	 * 
	 * @param roomStart
	 *            the start room
	 */
	public Person(Room roomStart) {
		this.currentRoom = roomStart;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
	/**
	 * Gets the current room.
	 * 
	 * @return the current room
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}

}
