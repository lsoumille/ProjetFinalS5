package harryPeterEtLaChambreDesSecrets.items;

import harryPeterEtLaChambreDesSecrets.persons.Player;
import harryPeterEtLaChambreDesSecrets.rooms.Room;

import java.util.Map.Entry;

/**
 * The Class WorldMap. A WorldMap indicates the exits of the current room.
 */
public class WorldMap extends Item {
	
	/** The energy consumed by using. */
	public static final int MAP_ENERGY = 0;

	/**
	 * Instantiates a new world map.
	 */
	public WorldMap() {
		super("Map", WorldMap.MAP_ENERGY);
	}

	@Override
	public void use(Player player) {
		System.out.println("Map :");
		for (Entry<String, Room> e : player.getCurrentRoom().getExits()
				.entrySet())
			System.out.println("\t" + e.getKey() + " -> "
					+ e.getValue().getName());
	}
}
