package harryPeterEtLaChambreDesSecrets.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import harryPeterEtLaChambreDesSecrets.commands.Command;
import harryPeterEtLaChambreDesSecrets.commands.EnergyCommand;
import harryPeterEtLaChambreDesSecrets.commands.FillMugCommand;
import harryPeterEtLaChambreDesSecrets.commands.GetCommand;
import harryPeterEtLaChambreDesSecrets.commands.GoCommand;
import harryPeterEtLaChambreDesSecrets.commands.HelpCommand;
import harryPeterEtLaChambreDesSecrets.commands.InventoryCommand;
import harryPeterEtLaChambreDesSecrets.commands.QuitCommand;
import harryPeterEtLaChambreDesSecrets.commands.SaveCommand;
import harryPeterEtLaChambreDesSecrets.commands.UseCommand;
import harryPeterEtLaChambreDesSecrets.commands.WaitCommand;
import harryPeterEtLaChambreDesSecrets.items.InvisibilityCloak;
import harryPeterEtLaChambreDesSecrets.json.RoomDeserialize;
import harryPeterEtLaChambreDesSecrets.json.RoomJson;
import harryPeterEtLaChambreDesSecrets.json.RoomSerialize;
import harryPeterEtLaChambreDesSecrets.persons.Player;
import harryPeterEtLaChambreDesSecrets.rooms.Room;

/**
 * The Class Utils which contains some useful methods and attributes.
 */
public class Utils {

	/** Defines if the prowler is launched in the console or through a GUI. */
	public static boolean GRAPHIC_MODE = true;

	/** The prowler's use statement. */
	public static boolean MARAUDER_IN_USE = false;

	/** The path to the JSON folder. */
	public static final String PATH = "C:/Users/user/workspace/HarryPeter/json";

	/** The path to the JSON file (save). */
	public static final String FILE_PATH = PATH + "/Save/save";

	/** Directory with all the JSON Item files */
	public static final String ITEM_PATH = PATH + "/Items/";

	/** Directory with all the JSON Room files */
	public static final String ROOM_PATH = PATH + "/Map/room";

	public static final int kNbRoom = 19;
	public static final int kNbKey = 7;

	/** Object use to create JSON file */
	public static Gson json = new GsonBuilder()
			.registerTypeAdapter(Room.class, new RoomSerialize())
			.registerTypeAdapter(RoomJson.class, new RoomDeserialize())
			.serializeNulls().setPrettyPrinting().create();

	/** The helps. */
	public static String helps = "You are in the University of Polylard. \n"
			+ "Try to access the last room by escaping Voldemort and using some funny items.\n"
			+ "\nCommands : \n"
			+ "'go direction' (direction : up down north south east west) : walk room by room\n"
			+ "'wait' : wait a moment\n" + "'get itemName' : get the item\n"
			+ "'use itemName' : use the item\n"
			+ "'inventory' : display your inventory\n"
			+ "'energy' : display your energy\n" + "'quit' : quit the game\n"
			+ "'fillmug' : fill the mug (only used in the lunchroom)\n"
			+ "'save' : save the game\n";

	/**
	 * Print out the opening message for the player.
	 */
	public static void printWelcome() {
		System.out.println();
		System.out.println("Welcome to Polydlard!");
		System.out
				.println("You are a young really mediocre sorcerer's apprentice.\n"
						+ "You don't know anything about magic and you don't know how to defend yourself. \n"
						+ "Everybody hates you. It seems that you are extremely stunned because you \n"
						+ "forgot your magic wand in the room 3/4. Go there to get it back.\n");
		System.out.println("Type 'help' if you need help.");
		System.out.println();
	}

	/** All commands used in room. */
	public static final List<Command> ROOM_COMMANDS = new ArrayList<Command>() {

		private static final long serialVersionUID = 1L;

		{
			add(new UseCommand());
			add(new GoCommand());
			add(new QuitCommand());
			add(new HelpCommand());
			add(new InventoryCommand());
			add(new GetCommand());
			add(new EnergyCommand());
			add(new WaitCommand());
			add(new SaveCommand());
		}
	};

	/** All commands used in a lunchroom. */
	public static final List<Command> LUNCHROOM_COMMANDS = new ArrayList<Command>() {

		private static final long serialVersionUID = 1L;

		{
			this.addAll(ROOM_COMMANDS);
			add(new FillMugCommand());
		}
	};

	/**
	 * Check Voldemort.
	 * 
	 * @param player
	 *            the player
	 * @param nextRoom
	 *            the next room
	 * @return true, if successful
	 */
	public static boolean checkVoldemort(Player player, Room nextRoom) {
		// check if Voldemort is in the the nextroom
		if (Game.vdm.getCurrentRoom().equals(nextRoom)) {
			System.out.println("VOLDEMORT IS HERE !!");

			// Having the invisibility cloak save you
			if (player.hasItemByName("Cloak")) {
				System.out
						.println("You are hidding thanks to your invisibility cloak. Fiou !");
				player.setEnergy(player.getEnergy()
						- InvisibilityCloak.CLOAK_ENERGY_AUTOMATIC);
				player.removeItemFromPlayer(player.getItemByString("cloak"));
				System.out
						.println("You have lost your invisibility cloak and some energy.");
				return false;
			} else {
				System.out.println("He kills you...");
				player.setEnergy(0);
				return true;
			}
		}
		return false;
	}

	/**
	 * Create a new file and write the JSON inside
	 * 
	 * @param json
	 *            object in JSON
	 * @param path
	 *            destination of the file
	 */
	public static void Writer(String json, String path) {
		try {
			FileWriter writer = new FileWriter(path);
			writer.write(json);
			writer.close();
			System.out.println("Saved with success.");
		} catch (IOException e) {
			System.err.println("Error during the save of the file.");
		}
	}

	/**
	 * Read the content of a JSON file
	 * 
	 * @param path
	 * @return contents of the file
	 * @throws FileNotFoundException
	 */
	public static BufferedReader Reader(String path) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			System.err.println("Error loading map.");
		}
		return br;
	}
}
