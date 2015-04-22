package harryPeterEtLaChambreDesSecrets.rooms;

import java.util.Map.Entry;

import harryPeterEtLaChambreDesSecrets.items.Item;
import harryPeterEtLaChambreDesSecrets.items.Key;

/**
 * The Class LockedRoom which is closed by a key.
 */
public class LockedRoom extends Room {

	/** The key needed to enter the room. */
	private Key keyToEnter;

	/**
	 * Instantiates a new locked room.
	 * 
	 * @param name
	 *            the name
	 * @param description
	 *            the description
	 * @param act
	 *            the act
	 * @param key
	 *            the key
	 */
	public LockedRoom(String name, String description, Activity act, Key key) {
		super(name, description, act);
		this.keyToEnter = key;
	}

	@Override
	public Key getKey() {
		return keyToEnter;
	}

	@Override
	public String toString() {
		String str = "";

		// Name
		str += ("\n[" + this.name + "]\n");

		// Name
		str += ("Key needed : " + this.keyToEnter.getName() + "\n");

		// Exits
		String strTemp = "";
		for (Entry<String, Room> e : this.getExits().entrySet())
			strTemp += "\t" + e.getKey() + " -> " + e.getValue().getName()
					+ "\n";
		if (strTemp.length() != 0) {
			str += "Exits : \n" + strTemp + "\n";
		}

		// Items
		strTemp = "";
		for (Item i : this.roomItem)
			strTemp += "\t" + i.getName() + "\n";
		if (strTemp.length() != 0) {
			str += "Items : \n" + strTemp + "\n";
		}

		str += "\n";

		return str;
	}

}
