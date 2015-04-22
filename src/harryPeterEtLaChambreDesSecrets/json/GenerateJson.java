package harryPeterEtLaChambreDesSecrets.json;

import java.util.ArrayList;
import harryPeterEtLaChambreDesSecrets.items.InvisibilityCloak;
import harryPeterEtLaChambreDesSecrets.items.Item;
import harryPeterEtLaChambreDesSecrets.items.Key;
import harryPeterEtLaChambreDesSecrets.items.MagicWand;
import harryPeterEtLaChambreDesSecrets.items.Marauder;
import harryPeterEtLaChambreDesSecrets.rooms.Activity;
import harryPeterEtLaChambreDesSecrets.rooms.LockedRoom;
import harryPeterEtLaChambreDesSecrets.rooms.LunchRoom;
import harryPeterEtLaChambreDesSecrets.rooms.Room;
import harryPeterEtLaChambreDesSecrets.utils.Utils;

public class GenerateJson {

	public GenerateJson() {
	}

	public void createMapInJson() {

		// Keys
		Key key1 = new Key("keyOne");
		Key key2 = new Key("keyTwo");
		Key keyA = new Key("keyA");
		Key keyB = new Key("keyB");
		Key keyC = new Key("keyC");
		Key keyS1 = new Key("keyStairs1");
		Key keyS2 = new Key("keyStairs2");

		ArrayList<Key> allKeys = new ArrayList<Key>();
		allKeys.add(key1);
		allKeys.add(key2);
		allKeys.add(keyA);
		allKeys.add(keyB);
		allKeys.add(keyC);
		allKeys.add(keyS1);
		allKeys.add(keyS2);
		// allKeys contains all the object Key

		// Serialize each key
		String strJson = new String();
		int i = 1;
		for (Key key : allKeys) {
			strJson = Utils.json.toJson(key, Key.class);
			System.out.print(key.getName() + " : ");
			Utils.Writer(strJson, Utils.ITEM_PATH + "key" + i++);
		}

		// Items
		InvisibilityCloak cloak = new InvisibilityCloak();
		Marauder marauder = new Marauder();
		MagicWand magicWand = new MagicWand();
		ArrayList<Item> allItems = new ArrayList<Item>();
		allItems.add(cloak);
		allItems.add(marauder);
		allItems.add(magicWand);
		// allItems contains Marauder, MagicWand and Invisibility Cloak

		// serialize each object
		for (Item item : allItems) {
			strJson = Utils.json.toJson(item, item.getClass());
			System.out.print(item.getName() + " : ");
			Utils.Writer(strJson, Utils.ITEM_PATH + item.getName());
		}

		// Serialize Rooms
		// Activities
		Activity a1 = new Activity(
				"Quelle est la somme en degre des angles d'un triangle ?",
				"180", 2, key2);
		Activity a2 = new Activity("Quelle est le symbole chimique du fer ?",
				"Fe", 3, keyS1);
		Activity a3 = new Activity("Quelle est la capitale de l'Espagne ?",
				"Madrid", 3, keyS2);
		Activity a4 = new Activity("Combien y a-t-il de continents ?", "5", 3,
				keyA);
		Activity a5 = new Activity(
				"Comment etait la table legendaire du roi Arthur ?", "Ronde",
				4, keyB);
		Activity a6 = new Activity(
				"Quelle planete est connue pour ses anneaux ?", "Saturne", 4,
				cloak);
		Activity a7 = new Activity("Combien Jesus comptait-il d'apotres ?",
				"12", 4, keyC);

		ArrayList<Room> allRooms = new ArrayList<Room>();
		// Rooms
		Room e1Corridor1, e1Corridor2, e1Corridor3, e1Room, e1Lock1, e1Lock2, e1Lock3, e1Lock4;
		Room e2Corridor1, e2Corridor2, e2Lock1, e2Lock2, e2Lock3, e2Lunch;
		Room e1Stairs, e2Stairs, e3Stairs, e3Lock1, secret;

		// The final Room
		secret = new Room(
				"Room 3/4",
				"the FINAL ROOM 3/4 !!! Congratulations. Your magic wand is standing here.",
				null);
		secret.addItem(magicWand);

		// Stage 1
		e1Stairs = new Room("Stairs 1 (Stage 1)",
				"the stairs of the first stage. There is dead cat. It stinks.",
				null);
		e1Corridor1 = new Room(
				"Corridor 1 (Stage 1)",
				"the first corridor of the first stage. There are torches on walls.",
				null);
		e1Corridor2 = new Room(
				"Corridor 2 (Stage 1)",
				"the second corridor of the first stage. There are some talking paintings.",
				null);
		e1Corridor3 = new Room(
				"Corridor 3 (Stage 1)",
				"the third corridor of the first stage. There are some flying heads.",
				null);

		e1Room = new Room(
				"Room 1 (Stage 1)",
				"the first room of the first stage. There is a hand stuck to the ground.",
				null);
		e1Room.addItem(marauder);
		e1Room.addItem(key1);

		e1Lock1 = new LockedRoom("Room 2 (Stage 1)",
				"the second room of the first stage. It smell good here.", a3,
				keyA);
		e1Lock2 = new LockedRoom(
				"Room 3 (Stage 1)",
				"the third room of the first stage. There is a window... closed.",
				a1, key1);
		e1Lock3 = new LockedRoom("Room 4 (Stage 1)",
				"the fourth room of the first stage. There is a zombie dog.",
				a2, key2);
		e1Lock4 = new LockedRoom("Room 5 (Stage 1)",
				"the fifth room of the first stage. Charlie is here.", null,
				key2);

		// Exits of the first stage
		e1Corridor1.setExit("north", e1Corridor2);
		e1Corridor1.setExit("south", e1Stairs);
		e1Corridor2.setExit("north", e1Corridor3);
		e1Corridor2.setExit("south", e1Corridor1);
		e1Corridor2.setExit("west", e1Lock1);
		e1Corridor2.setExit("east", e1Lock3);
		e1Corridor3.setExit("north", e1Room);
		e1Corridor3.setExit("south", e1Corridor2);
		e1Corridor3.setExit("west", e1Lock2);
		e1Corridor3.setExit("east", e1Lock4);
		e1Lock1.setExit("east", e1Corridor2);
		e1Lock3.setExit("west", e1Corridor2);
		e1Lock3.setExit("north", e1Lock4);
		e1Lock2.setExit("east", e1Corridor3);
		e1Lock4.setExit("west", e1Corridor3);
		e1Lock4.setExit("south", e1Lock3);
		e1Room.setExit("south", e1Corridor3);
		e1Stairs.setExit("north", e1Corridor1);

		allRooms.add(e1Corridor1);
		allRooms.add(e1Corridor2);
		allRooms.add(e1Corridor3);
		allRooms.add(e1Lock1);
		allRooms.add(e1Lock2);
		allRooms.add(e1Lock3);
		allRooms.add(e1Lock4);
		allRooms.add(e1Room);

		// Stage 2
		e2Stairs = new LockedRoom(
				"Stairs 2 (Stage 2)",
				"the stairs of second stage. Well... nothing to say about this room.",
				null, keyS1);
		e2Corridor1 = new Room(
				"Corridor 1 (Stage 2)",
				"the first corridor of the second stage. There is a loooooooooooooooooooong red carpet.",
				null);
		e2Corridor2 = new Room("Corridor 2 (Stage 2)",
				"the second corridor of the second stage.", a4);
		e2Lunch = new LunchRoom(
				"LunchRoom (Stage 2)",
				"the lunchroom of the second stage. There is a coffee machine. Yes, Harry Peter usualy drinks coffee.");
		e2Lock1 = new LockedRoom(
				"Room 1 (Stage 2)",
				"the first room of the second stage. There are skulls everywhere. What happenned here ?!",
				a5, keyA);
		e2Lock2 = new LockedRoom(
				"Room 2 (Stage 2)",
				"the second room of the second stage. There is a bed but you can't use it.",
				a6, keyB);
		e2Lock3 = new LockedRoom("Room 3 (Stage 2)",
				"the third room of the second stage. There is a chair.", null,
				keyC);

		// Exits for the second stage
		e1Stairs.setExit("up", e2Stairs);
		e2Stairs.setExit("down", e1Stairs);
		e2Stairs.setExit("north", e2Corridor1);
		e2Corridor1.setExit("south", e2Stairs);
		e2Corridor1.setExit("north", e2Lock1);
		e2Corridor1.setExit("east", e2Corridor2);
		e2Lock1.setExit("south", e2Corridor1);
		e2Corridor2.setExit("west", e2Corridor1);
		e2Corridor2.setExit("south", e2Lunch);
		e2Corridor2.setExit("north", e2Lock2);
		e2Lunch.setExit("north", e2Corridor2);
		e2Lock2.setExit("south", e2Corridor2);
		e2Lock2.setExit("north", e2Lock3);
		e2Lock3.setExit("south", e2Lock2);
		e2Lock3.setExit("teleportation", secret);

		allRooms.add(e1Stairs);
		allRooms.add(e2Corridor1);
		allRooms.add(e2Corridor2);
		allRooms.add(e2Lock1);
		allRooms.add(e2Lock2);
		allRooms.add(e2Lock3);
		allRooms.add(e2Lunch);

		// Stage 3
		e3Stairs = new LockedRoom("Stairs 3 (Stage 3)",
				"the stairs of third stage. Let's go !", null, keyS2);
		e3Lock1 = new LockedRoom("Room 1 (Stage 3)",
				"the first and only room of the third stage. What the f***?!",
				a7, keyS2);

		// Exits for the third stage
		e2Stairs.setExit("up", e3Stairs);
		e3Stairs.setExit("down", e2Stairs);
		e3Stairs.setExit("north", e3Lock1);
		e3Lock1.setExit("south", e3Stairs);

		secret.setExit("teleportation", e1Room);

		allRooms.add(e2Stairs);
		allRooms.add(secret);
		allRooms.add(e3Stairs);
		allRooms.add(e3Lock1);
		// allRooms contains all the rooms

		i = 1; // re init i
		for (Room room : allRooms) {
			strJson = Utils.json.toJson(room, Room.class);
			System.out.print(room.getName() + " : ");
			Utils.Writer(strJson, Utils.ROOM_PATH + i++);
		}
		System.out.println("\nSerialization done");
	}
}
