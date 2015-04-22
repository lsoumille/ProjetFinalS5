package harryPeterEtLaChambreDesSecrets.commands;

import harryPeterEtLaChambreDesSecrets.items.Item;
import harryPeterEtLaChambreDesSecrets.items.Mug;
import harryPeterEtLaChambreDesSecrets.persons.Player;

public class FillMugCommand extends Command {

	public FillMugCommand() {
		super("fillmug", null);
	}
	
	@Override
	public boolean use(Player p) {
		Item item = p.getItemByString("Mug");
		Mug mug = (Mug) item;
		mug.full();
		return false;
	}

}
