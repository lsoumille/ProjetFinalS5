package harryPeterEtLaChambreDesSecrets.commands;

import harryPeterEtLaChambreDesSecrets.persons.Player;
import harryPeterEtLaChambreDesSecrets.utils.Badge;
import harryPeterEtLaChambreDesSecrets.utils.Game;
import harryPeterEtLaChambreDesSecrets.utils.Utils;

/**
 * The Class SaveCommand. Used to save the game.
 */
public class SaveCommand extends Command {
	
	/**
	 * Instantiates a new save command.
	 */
	public SaveCommand() {
		super("save", null);
	}

	@Override
	public boolean use(Player p) {
		Badge b = new Badge(p,Game.vdm);
		Utils.Writer(Utils.json.toJson(b), Utils.FILE_PATH);
		return false;
	}

}
