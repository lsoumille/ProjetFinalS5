package harryPeterEtLaChambreDesSecrets.commands;

import harryPeterEtLaChambreDesSecrets.persons.Player;

/**
 * The Class QuitCommand which allows you to quit the game. :(
 */
public class QuitCommand extends Command {

	/**
	 * Instantiates a new quit command.
	 */
	public QuitCommand() {
		super("quit", null);
	}

	@Override
	public boolean use(Player p) {
		return true;
	}
}
