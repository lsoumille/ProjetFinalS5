package harryPeterEtLaChambreDesSecrets.json;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

import harryPeterEtLaChambreDesSecrets.items.Item;
import harryPeterEtLaChambreDesSecrets.items.Key;
import harryPeterEtLaChambreDesSecrets.rooms.Activity;
import harryPeterEtLaChambreDesSecrets.rooms.Room;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class RoomSerialize implements JsonSerializer<Room> {

	/*
	 * Create a json text which represents a room
	 * 
	 * @see com.google.gson.JsonSerializer#serialize(java.lang.Object,
	 * java.lang.reflect.Type, com.google.gson.JsonSerializationContext)
	 */
	public JsonElement serialize(final Room room, final Type type,
			final JsonSerializationContext context) {
		// create jsonobject
		JsonObject result = new JsonObject();

		// serialize attributes in json
		result.add("name", new JsonPrimitive(room.getName()));
		result.add("description", new JsonPrimitive(room.getDescription()));
		result.add("activity",
				context.serialize(room.getActivity(), Activity.class));
		result.add("keyToEnter", context.serialize(room.getKey(), Key.class));

		// create exits in hashmap<string, string> to avoid infinite loop
		JsonObject tmp = new JsonObject();
		HashMap<String, Room> exits = room.getExits();
		for (String key : exits.keySet()) {
			tmp.add(key, new JsonPrimitive(exits.get(key).getName()));
		}
		result.add("exits", tmp);

		// create item in Arraylist<string>
		tmp = new JsonObject();
		ArrayList<Item> allItems = (ArrayList<Item>) room.getRoomItem();
		for (Item object : allItems) {
			tmp.add(object.getName(), new JsonPrimitive(object.getName()));
		}
		result.add("roomItem", tmp);

		return result;
	}
}
