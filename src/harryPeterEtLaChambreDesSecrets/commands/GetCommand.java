package harryPeterEtLaChambreDesSecrets.commands;

import harryPeterEtLaChambreDesSecrets.items.Item;
import harryPeterEtLaChambreDesSecrets.persons.Player;
import harryPeterEtLaChambreDesSecrets.rooms.Room;

/**
 * The Class GetCommand. It allows to pick up an item from the room.
 */
public class GetCommand extends Command {

	/**
	 * Instantiates a new gets the command.
	 * 
	 * @param str
	 *            the name of the item to pick up.
	 */
	public GetCommand() {
		super("get", null);
	}

	@Override
	public boolean use(Player p) {
		if (!this.hasSecondWord()) {
			// if there is no second word, we don't know what to take...
			System.out.println(">>Take what?");
			return false;
		}

		Room currentRoom = p.getCurrentRoom();
		Item itemWanted = currentRoom.getItemByString(this.getSecondWord());

		// No item in the room
		if (itemWanted == null)
			System.out.println(">>There isn't this item in this room!");
		else
			currentRoom.removeItemFromRoom(itemWanted, p);// Pick the item

		return false;
	}

}
