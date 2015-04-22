package harryPeterEtLaChambreDesSecrets.commands;

import harryPeterEtLaChambreDesSecrets.items.Item;
import harryPeterEtLaChambreDesSecrets.persons.Player;

/**
 * The Class UseCommand which allows you to use an item.
 */
public class UseCommand extends Command {

	/**
	 * Instantiates a new use command.
	 * 
	 * @param secondWord
	 *            the second word
	 */
	public UseCommand() {
		super("use", null);
	}

	@Override
	public boolean use(Player player) {
		String secondStr = this.getSecondWord();
		Item i = player.getItemByString(secondStr);
		if (i != null) {
			i.use(player);
			player.setEnergy(player.getEnergy() - i.getEnergyConsumed());
		} else {
			System.out.println(">>What??");
		}
		return false;
	}

}
