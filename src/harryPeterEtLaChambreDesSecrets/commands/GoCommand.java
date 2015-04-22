package harryPeterEtLaChambreDesSecrets.commands;

import harryPeterEtLaChambreDesSecrets.items.Item;
import harryPeterEtLaChambreDesSecrets.persons.Player;
import harryPeterEtLaChambreDesSecrets.rooms.Activity;
import harryPeterEtLaChambreDesSecrets.rooms.Room;
import harryPeterEtLaChambreDesSecrets.utils.Game;
import harryPeterEtLaChambreDesSecrets.utils.Utils;

/**
 * The Class GoCommand which allows you to move into a room.
 */
public class GoCommand extends Command {

	/**
	 * Instantiates a new go command.
	 * 
	 * @param secondWord
	 *            the second word
	 */
	public GoCommand() {
		super("go", null);

	}

	@Override
	public boolean use(Player player) {
		if (!this.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			System.out.println(">>Go where?");
			return false;
		}

		// Try to leave current room.
		Room nextRoom = player.getCurrentRoom().getExit(this.secondWord);
		if (nextRoom == null) {
			System.out.println(">>There is no door!");
		} else {
			// Voldemort can move
			Game.vdm.changeRoom();
			
			// Go to the next room
			player.enterInRoom(nextRoom);

			// Displays the details of the new room
			printCurrentRoom(player);
			
			// If voldemort is in the new room    
			Utils.checkVoldemort(player, player.getCurrentRoom());

			// Launch the activity of the new room if it exists and if the player is not dead
			int playerEnergy = player.getEnergy();
			if ((playerEnergy > 0) && (playerEnergy <= Player.MAX_ENERGY))
				printActivityRoom(player);

		}
		return false;
	}

	/**
	 * Launches the activity room.
	 * 
	 * @param player
	 *            the player
	 */
	private void printActivityRoom(Player player) {
		// Launch activity of the new room if it exists
		Activity act = player.getCurrentRoom().getActivity();
		if (act != null) {
			 Item itemActivity = act.getAward();
			 if (!player.hasItemByName(itemActivity.getName()))
				 act.launch(player);
		}

	}

	/**
	 * Prints the current room.
	 * 
	 * @param player
	 *            the player
	 */
	private void printCurrentRoom(Player player) {
		Room currentRoom = player.getCurrentRoom();
		System.out.println("\n[" + currentRoom.getName() + "]\n"
				+ currentRoom.getDescription() + "\n"
				+ currentRoom.getItemsinString() + player.getEnergyInString()
				+ "\n" + player.getItemsInString());
	}
}