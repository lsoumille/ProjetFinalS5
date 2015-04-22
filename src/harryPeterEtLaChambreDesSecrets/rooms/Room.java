package harryPeterEtLaChambreDesSecrets.rooms;

import harryPeterEtLaChambreDesSecrets.commands.Command;
import harryPeterEtLaChambreDesSecrets.items.Item;
import harryPeterEtLaChambreDesSecrets.items.Key;
import harryPeterEtLaChambreDesSecrets.items.Mug;
import harryPeterEtLaChambreDesSecrets.persons.Player;
import harryPeterEtLaChambreDesSecrets.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

/**
 * The Class Room. A room has a name, a description, an activity or not, several
 * issues or not, several items or not and a list of usable commands.
 */
public class Room {

	/** Name of the room. */
	protected String name;

	/** The description. */
	protected String description;

	/** The activity. */
	protected Activity activity;

	/** The exits. */
	protected HashMap<String, Room> exits = new HashMap<>();

	/** The room items. */
	protected List<Item> roomItem = new ArrayList<Item>();

	/** The commands you can use in. */
	protected List<Command> commands;

	/**
	 * Instantiates a new room.
	 * 
	 * @param name
	 *            the name
	 * @param description
	 *            the description
	 * @param act
	 *            the act
	 */
	public Room(String name, String description, Activity act) {
		this.name = name;
		this.activity = act;
		this.description = description;
		this.commands = Utils.ROOM_COMMANDS;
	}

	/**
	 * Returns a string which is the room's exits, for example
	 * "Exits: north west".
	 * 
	 * @return Details of the room's exits.
	 */
	public String getExitString() {
		String returnString = "Exits:";
		Set<String> keys = exits.keySet();
		for (String exit : keys) {
			returnString += " " + exit;
		}
		return returnString;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return "You are in " + description;
	}
	
	/**
	 * @param commands the commands to set
	 */
	public void setCommands(List<Command> commands) {
		this.commands = commands;
	}

	/**
	 * Gets the exits.
	 * 
	 * @return the exits
	 */
	public HashMap<String, Room> getExits() {
		return exits;
	}

	/**
	 * Define an exit from this room.
	 * 
	 * @param direction
	 *            The direction of the exit.
	 * @param neighbor
	 *            The room to which the exit leads.
	 */
	public void setExit(String direction, Room neighbor) {
		exits.put(direction, neighbor);
	}

	/**
	 * Gets the exit.
	 * 
	 * @param direction
	 *            the direction
	 * @return the exit
	 */
	public Room getExit(String direction) {
		return exits.get(direction);
	}

	/**
	 * Gets the item in a string.
	 * 
	 * @return the items string
	 */
	public String getItemsinString() {
		String returnString = "";

		Iterator<Item> it = this.roomItem.iterator();

		while (it.hasNext()) {
			Item item = it.next();
			returnString += " " + item.getName();
		}

		// Displays nothing if there is no item in the room
		if (returnString.length() == 0)
			return returnString;
		else
			return ("Items in room :" + returnString + "\n");
	}

	/**
	 * Gets the commands list.
	 * 
	 * @return the commands list
	 */
	public List<Command> getCommands() {
		return commands;
	}

	/**
	 * Gets the key.
	 * 
	 * @return the key
	 */
	public Key getKey() {
		return null;
	}

	/**
	 * Puts item in room and removes it from the player.
	 * 
	 * @param item
	 *            the item
	 * @param player
	 *            the player
	 */
	public void putItemInRoom(Item item, Player player) {
		player.removeItemFromPlayer(item);
		this.roomItem.add(item);
	}

	/**
	 * Gets the item by string.
	 * 
	 * @param str
	 *            the item name
	 * @return the item object
	 */
	public Item getItemByString(String str) {
		for (Item item : roomItem)
			if (item.getName().toLowerCase().equals(str))
				return item;

		return null;
	}

	/**
	 * Removes the item from room and adds it on player.
	 * 
	 * @param item
	 *            the item
	 * @param player
	 *            the player
	 */
	public void removeItemFromRoom(Item item, Player player) {
		player.addItemOnPlayer(item);
		this.roomItem.remove(item);
	}

	/**
	 * Adds the item in the room.
	 * 
	 * @param item
	 *            the item
	 */
	public void addItem(Item item) {
		if (item != null)
			this.roomItem.add(item);
	}

	@Override
	public String toString() {
		String str = "";

		// Name
		str += ("\n[" + this.name + "]\n");

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

	/**
	 * Gets the activity.
	 * 
	 * @return the activity
	 */
	public Activity getActivity() {
		return activity;
	}

	/**
	 * Checks the usability of a command in the room.
	 * 
	 * @param command
	 *            the command
	 * @return the command
	 */
	public Command CommandIsAvailable(Command command) {
		for (Command cmd : commands) {
			if (cmd.haveSameFirstWord(command))
				return cmd;
		}
		return null;
	}

	/**
	 * Shows the commands list.
	 */
	public void showCommands() {
		for (Command cmd : commands) {
			System.out.print(cmd + " ");
		}
		System.out.println();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public void fillTheMug(Mug mug) {
			System.out.println(">>You can't do this here. Mwahaha !");
	}
	
	/**
	 * Gets the list of items
	 * 
	 * @return List<Item> roomItem
	 */
    public List<Item> getRoomItem() {
        return roomItem;
    }
    
    /**
     * add a hashmap with all the exits 
     * 
     * @param exits
     */
    public void addAllExits(HashMap<String, Room> exits){
        this.exits = exits;
    }
    
    /**
     * add a hashmap with all the exits 
     * 
     * @param exits
     */
    public void addAllItem(ArrayList<Item> allItem){
        this.roomItem = allItem;
    }

}
