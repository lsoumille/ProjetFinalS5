package harryPeterEtLaChambreDesSecrets.utils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import harryPeterEtLaChambreDesSecrets.items.InvisibilityCloak;
import harryPeterEtLaChambreDesSecrets.items.Item;
import harryPeterEtLaChambreDesSecrets.items.Key;
import harryPeterEtLaChambreDesSecrets.items.MagicWand;
import harryPeterEtLaChambreDesSecrets.items.Marauder;
import harryPeterEtLaChambreDesSecrets.json.RoomJson;
import harryPeterEtLaChambreDesSecrets.rooms.LockedRoom;
import harryPeterEtLaChambreDesSecrets.rooms.Room;

/**
 * The Class Mappage which builds the game map and contains the beginning rooms
 * for the player and Voldemort.
 */
public class Mappage {

	/** The player start room. */
	public static Room playerStartRoom = null;

	/** Voldemort start room. */
	public static Room voldemortStartRoom = null;

	/** all room in the map */
	public static ArrayList<Room> allRoom = new ArrayList<Room>();

	/** all items in the map */
	public static ArrayList<Item> allItem = new ArrayList<Item>();

	/**
	 * deserialize item's Json file to an arraylist<Item>
	 * 
	 * @return
	 * @throws JsonIOException
	 * @throws JsonSyntaxException
	 * @throws FileNotFoundException
	 */
	public static ArrayList<Item> deserializeItem() {
		// deserialize items to an arraylist
		ArrayList<Item> itemArray = new ArrayList<Item>();

		// deserialize keys
		int i = 1;
		while (i <= Utils.kNbKey) {
			itemArray.add(Utils.json.fromJson(
					Utils.Reader(Utils.ITEM_PATH + "key" + i++), Key.class));
		}

		// deserialize other items
		itemArray.add(Utils.json.fromJson(
				Utils.Reader(Utils.ITEM_PATH + "Marauder"), Marauder.class));
		itemArray.add(Utils.json.fromJson(
				Utils.Reader(Utils.ITEM_PATH + "Cloak"),
				InvisibilityCloak.class));
		itemArray.add(Utils.json.fromJson(
				Utils.Reader(Utils.ITEM_PATH + "MagicWand"), MagicWand.class));
		return itemArray;

	}

	/**
	 * deserialize all the rooms in JSON to an arraylist
	 * 
	 * @return
	 * @throws FileNotFoundException
	 */
	public static void deserializeRoom() {
		// deserialize room
		int i = 1;
		allItem = deserializeItem();
		// list of roomJson
		ArrayList<RoomJson> allRoomJson = new ArrayList<RoomJson>();
		while (i <= Utils.kNbRoom) {
			allRoomJson.add(Utils.json.fromJson(
					Utils.Reader(Utils.ROOM_PATH + i++), RoomJson.class));
		}

		// RoomJson -> Room
		// result in here
		ArrayList<Room> allRoomFinale = new ArrayList<Room>();

		// create item in each room
		Room roomTmp = null;
		for (RoomJson jRoom : allRoomJson) {
			if (jRoom.getKeyToEnter() != null) {
				roomTmp = new LockedRoom(jRoom.getName(),
						jRoom.getDescription(), jRoom.getActivity(),
						jRoom.getKeyToEnter());
			} else {
				roomTmp = new Room(jRoom.getName(), jRoom.getDescription(),
						jRoom.getActivity());
			}

			// jRoom Items added to roomTmp
			roomTmp.addAllItem(searchInventory(jRoom.getRoomItem()));

			// add to the final list
			allRoomFinale.add(roomTmp);
		}
		allRoom = allRoomFinale;

		// create exit room
		HashMap<String, String> strExits = new HashMap<String, String>();
		HashMap<String, Room> exits = new HashMap<String, Room>();
		for (RoomJson jRoom : allRoomJson) {
			strExits = jRoom.getExits();
			// creation of the hashmap
			for (String key : strExits.keySet()) {
				for (Room r : allRoomFinale) {
					if (r.getName().equals(strExits.get(key))) {
						exits.put(key, r);
					}
				}
			}
			// add the hashmap to the room
			searchRoom(jRoom.getName()).addAllExits(exits);
			exits = new HashMap<String, Room>();
		}
	}

	/**
	 * Search room.
	 * 
	 * @param str
	 *            the str
	 * @return the room
	 */
	public static Room searchRoom(String str) {
		for (int i = 0; i < allRoom.size(); i++) {
			if (str.equals(allRoom.get(i).getName())) {
				return allRoom.get(i);
			}
		}
		return null;
	}

	/**
	 * Search inventory.
	 * 
	 * @param as
	 *            the as
	 * @return the array list
	 */
	public static ArrayList<Item> searchInventory(ArrayList<String> as) {
		ArrayList<Item> aBuff = new ArrayList<Item>();
		for (int i = 0; i < as.size(); i++) {
			for (int j = 0; j < allItem.size(); j++) {
				if (as.get(i).equals(allItem.get(j).getName())) {
					aBuff.add(allItem.get(j));
				}
			}
		}
		return aBuff;
	}

	/**
	 * Loads the map.
	 * 
	 * @return the room
	 */
	public static void loadMap() {

		deserializeRoom();
		// Affecting the beginning rooms for the player and Voldemort
		for (Room rm : allRoom) {
			if (rm.getName().equals("Corridor 1 (Stage 1)")) {
				Mappage.playerStartRoom = rm;
			} else if (rm.getName().equals("Corridor 1 (Stage 2)")) {
				Mappage.voldemortStartRoom = rm;
			}
		}
	}
}
