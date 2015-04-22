package harryPeterEtLaChambreDesSecrets.commands;

import harryPeterEtLaChambreDesSecrets.persons.Player;

/**
 * The Class InventoryCommand. It displays the player inventory.
 */
public class InventoryCommand extends Command {

	/**
	 * Instantiates a new inventory command.
	 */
	public InventoryCommand() {
		super("inventory", null);
	}

	@Override
	public boolean use(Player p) {
		System.out.println(p.getItemsInString());
		return false;
	}

}
