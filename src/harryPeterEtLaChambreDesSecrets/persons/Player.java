package harryPeterEtLaChambreDesSecrets.persons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import harryPeterEtLaChambreDesSecrets.exceptions.NullRoomAtBeginningForPlayerException;
import harryPeterEtLaChambreDesSecrets.items.Item;
import harryPeterEtLaChambreDesSecrets.items.Key;
import harryPeterEtLaChambreDesSecrets.rooms.Room;

/**
 * The Class Player.
 */
public class Player extends Person {

	/** The default energy of the player. */
	public static int DEFAULT_ENERGY = 15;

	/** The max energy of player. Having more than this energy, the player dies. */
	public static int MAX_ENERGY = 20;

	/** The player energy. */
	private int energy;

	/** The items on player. */
	private List<Item> itemsOnPlayer = new ArrayList<>();

	/**
	 * Instantiates a new player.
	 * 
	 * @param roomStart
	 *            the room start
	 * @throws NullRoomAtBeginningForPlayerException
	 *             the null room at beginning exception
	 */
	public Player(Room roomStart) throws NullRoomAtBeginningForPlayerException {
		super(roomStart);
		if (roomStart == null)
			throw new NullRoomAtBeginningForPlayerException();
		this.energy = Player.DEFAULT_ENERGY;
	}

	/**
	 * Gets the player's items in a string.
	 * 
	 * @return the items in string
	 */
	public String getItemsInString() {
		String returnString = "Inventory :";
		Iterator<Item> it = this.itemsOnPlayer.iterator();
		while (it.hasNext()) {
			returnString += " " + it.next().getName();
		}
		return returnString;
	}

	/**
	 * Gets the player energy.
	 * 
	 * @return the energy
	 */
	public int getEnergy() {
		return energy;
	}

	/**
	 * Sets the energy. Useful to make him die ! :)
	 * 
	 * @param energy
	 *            the new energy
	 */
	public void setEnergy(int energy) {
		this.energy = energy;
		// Displays the new energy number
		this.getEnergyInString();
	}

	/**
	 * Enter in a room.
	 * 
	 * @param roomToEnter
	 *            the room to enter
	 */
	public void enterInRoom(Room roomToEnter) {
		Key keyToEnter = roomToEnter.getKey();

		// To enter a room : either there is no key, or player has got the good
		// key
		if (keyToEnter == null) {
			this.currentRoom = roomToEnter;
		} else if (this.hasItemByName(keyToEnter.getName())) {
			this.currentRoom = roomToEnter;
		} else {
			System.out.println(">>You don't have the key to enter in this room.");
		}
	}

	/**
	 * Adds the item on player.
	 * 
	 * @param item
	 *            the item
	 */
	public void addItemOnPlayer(Item item) {
		System.out.println("You get " + item.getName() + ".");
		this.itemsOnPlayer.add(item);
	}

	/**
	 * Removes the item from player.
	 * 
	 * @param item
	 *            the item
	 */
	public void removeItemFromPlayer(Item item) {
		this.itemsOnPlayer.remove(this.itemsOnPlayer.indexOf(item));
	}

	/**
	 * Checks if the player has the item.
	 * 
	 * @param itemStr
	 *            the item name
	 * @return true, if successful
	 */
	public boolean hasItemByName(String itemStr) {
		for (Item item : itemsOnPlayer)
			if (item.getName().toLowerCase().equals(itemStr.toLowerCase()))
				return true;
		return false;
	}

	/**
	 * Gets the item according to its name.
	 * 
	 * @param str
	 *            the item name
	 * @return the item
	 */
	public Item getItemByString(String str) {
		for (Item i : this.itemsOnPlayer) {
			if (i.getName().toLowerCase().equals(str.toLowerCase()))
				return i;
		}

		return null;
	}

	/**
	 * Checks if the player has too much energy.
	 * 
	 * @return true, if successful
	 */
	public boolean hasTooMuchEnergy() {
		if (this.energy > Player.MAX_ENERGY)
			return true;
		return false;

	}

	/**
	 * Gets the energy in string.
	 * 
	 * @return the energy in string
	 */
	public String getEnergyInString() {
		return ("Energy : " + this.energy + "/" + Player.MAX_ENERGY);
	}

	/**
	 * Checks if the player has not enough energy.
	 * 
	 * @return true, if successful
	 */
	public boolean hasNotEnoughEnergy() {
		if (this.energy <= 0)
			return true;
		return false;
	}
	
	public List<Item> getItemsOnPlayer() {
		return itemsOnPlayer;
	}

	public void setItemsOnPlayer(List<Item> itemsOnPlayer) {
		this.itemsOnPlayer = itemsOnPlayer;
	}
	
	public ArrayList<String> getArrayStringInventory(){
		ArrayList<String> s = new ArrayList<String>();
		for(Item i : itemsOnPlayer){
		    s.add(i.getName());
		}
		return s;
	}

}
