package harryPeterEtLaChambreDesSecrets.items;

import java.util.ArrayList;
import java.util.Map.Entry;

import harryPeterEtLaChambreDesSecrets.graphics.MarauderGUI;
import harryPeterEtLaChambreDesSecrets.persons.Player;
import harryPeterEtLaChambreDesSecrets.rooms.Room;
import harryPeterEtLaChambreDesSecrets.utils.Game;
import harryPeterEtLaChambreDesSecrets.utils.Utils;

/**
 * The Class Marauder. The Marauder allows to display all the map and Voldemort.
 */
public class Marauder extends Item {

	/** The energy consumed by using this. */
	public static final int Marauder_ENERGY = 1;

	/**
	 * Instantiates a new Marauder.
	 */
	public Marauder() {
		super("Marauder", Marauder.Marauder_ENERGY);
	}

	/**
	 * Method which make the player use the Marauder.
	 * 
	 * @param player
	 *            the player
	 */
	@Override
	public void use(Player player) {

		if (Utils.GRAPHIC_MODE) {
			// GRAPHIC MODE
			if (Utils.MARAUDER_IN_USE)
				System.out
						.println("Please closse the Marauder frame before launching another one.");
			else {
				Utils.MARAUDER_IN_USE = true;
				new MarauderGUI(player.getCurrentRoom());
			}
		} else {
			// CONSOLE MODE
			System.out.println("Marauder :");

			Room room = player.getCurrentRoom();

			// Print rooms
			ArrayList<Room> roomCalled = new ArrayList<Room>();
			this.printRooms(room, roomCalled);

			// Where is the bad boy?
			System.out.println("---> Voldemort is in the "
					+ Game.vdm.getCurrentRoom().getName());
			// Where is the player?
			System.out.println("---> You are in the "
					+ player.getCurrentRoom().getName());

		}

	}

	/**
	 * Prints the rooms which have not been printed yet.
	 * 
	 * @param room
	 *            the room
	 * @param roomCalled
	 *            the rooms already called
	 */
	private void printRooms(Room room, ArrayList<Room> roomCalled) {
		// Display the room
		System.out.println(room);

		roomCalled.add(room);

		// Display all exits of the room
		for (Entry<String, Room> e : room.getExits().entrySet()) {
			Room roomToDisplay = e.getValue();

			// Don't print the room which calls this method
			if (!roomCalled.contains(roomToDisplay))
				printRooms(roomToDisplay, roomCalled);
		}

	}
}
