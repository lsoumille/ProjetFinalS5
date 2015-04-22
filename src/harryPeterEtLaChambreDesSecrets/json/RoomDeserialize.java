package harryPeterEtLaChambreDesSecrets.json;

import harryPeterEtLaChambreDesSecrets.items.Key;
import harryPeterEtLaChambreDesSecrets.rooms.Activity;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class RoomDeserialize implements JsonDeserializer<RoomJson> {

	/*
	 * A specific deserializer to create an object RoomJson from a room json
	 * file
	 * 
	 * @see
	 * com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement,
	 * java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
	 */
	public RoomJson deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) {
		// create jsonobject from json text
		JsonObject result = json.getAsJsonObject();

		// retrieving attributes
		String name = result.get("name").getAsString();
		String description = result.get("description").getAsString();

		// retriving exit in string
		HashMap<String, String> exits = new HashMap<String, String>();
		ArrayList<String> exitAvailable = new ArrayList<String>();
		JsonObject jExits = (JsonObject) result.get("exits");
		Set<Entry<String, JsonElement>> sets = jExits.entrySet();
		for (Entry<String, JsonElement> entry : sets) {
			exitAvailable.add(entry.getKey());
		}
		for (String str : exitAvailable) {
			exits.put(str, jExits.get(str).getAsString());
		}

		// retrieving activity
		Activity act = context.deserialize(result.get("activity"),
				Activity.class);

		// retrieving Key
		Key key = context.deserialize(result.get("keyToEnter"), Key.class);

		// retrieving items in string
		ArrayList<String> roomItem = new ArrayList<String>();
		JsonObject jItems = (JsonObject) result.get("roomItem");
		sets = jItems.entrySet();
		for (Entry<String, JsonElement> entry : sets) {
			roomItem.add(entry.getKey());
		}

		return new RoomJson(name, description, act, exits, roomItem, key);
	}

}
