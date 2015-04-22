package harryPeterEtLaChambreDesSecrets.json;

import java.util.ArrayList;
import java.util.HashMap;

import harryPeterEtLaChambreDesSecrets.items.Key;
import harryPeterEtLaChambreDesSecrets.rooms.Activity;

public class RoomJson {

	/** The name. */
	private String name;

	/** The description. */
	private String description;

	/** The activity. */
	private Activity activity;

	/** exits in string */
	private HashMap<String, String> exits = new HashMap<String, String>();

	/** items in string */
	private ArrayList<String> roomItem = new ArrayList<String>();

	private Key keyToEnter;

	public RoomJson(String name, String description, Activity activity,
			HashMap<String, String> exits, ArrayList<String> roomItem,
			Key keyToEnter) {
		this.name = name;
		this.description = description;
		this.activity = activity;
		this.exits = exits;
		this.roomItem = roomItem;
		this.keyToEnter = keyToEnter;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Activity getActivity() {
		return activity;
	}

	public HashMap<String, String> getExits() {
		return exits;
	}

	public ArrayList<String> getRoomItem() {
		return roomItem;
	}

	@Override
	public String toString() {
		return "RoomJson [name=" + name + ", description=" + description
				+ ", activity=" + activity + ", exits=" + exits + ", roomItem="
				+ roomItem + ", keyToEnter=" + keyToEnter + "]";
	}

	public Key getKeyToEnter() {
		return keyToEnter;
	}

}
