package harryPeterEtLaChambreDesSecrets.commands;

import harryPeterEtLaChambreDesSecrets.persons.Player;

/**
 * The Class EnergyCommand. It displays the player energy.
 */
public class EnergyCommand extends Command {

	/**
	 * Instantiates a new energy command.
	 */
	public EnergyCommand() {
		super("energy", null);
	}

	@Override
	public boolean use(Player p) {
		System.out.println(p.getEnergyInString());
		return false;
	}

}
