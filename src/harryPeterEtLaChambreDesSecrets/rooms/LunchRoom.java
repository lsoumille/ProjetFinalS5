package harryPeterEtLaChambreDesSecrets.rooms;

import harryPeterEtLaChambreDesSecrets.items.Mug;
import harryPeterEtLaChambreDesSecrets.utils.Utils;

/**
 * The Class LunchRoom where you can drink a coffee.
 */
public class LunchRoom extends Room {

	/**
	 * Instantiates a new lunch room.
	 *
	 * @param name the name
	 * @param description the description
	 * @param act the act
	 */
	public LunchRoom(String name, String description) {
		super(name, description, null);
		this.setCommands(Utils.LUNCHROOM_COMMANDS);
	}
	
	@Override
	public void fillTheMug(Mug mug) {
		
	}

	
	
}
