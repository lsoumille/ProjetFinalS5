package harryPeterEtLaChambreDesSecrets.items;

import harryPeterEtLaChambreDesSecrets.persons.Player;

/**
 * The Class Item. An Item can be used.
 */
public class Item {
	
	/** The name of the item. */
	private String name;
	
	/** The energy consumed by using the item. */
	protected int energyConsumed;
	
	/**
	 * Instantiates a new item.
	 *
	 * @param name the name
	 * @param energy the energy
	 */
	public Item (String name, int energy) {
		this.name = name;
		this.energyConsumed = energy;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	@Override
	public String toString(){
		return this.name ;
	}
	
	/**
	 * Method which make the player use the item.
	 *
	 * @param player the player
	 */
	public void use(Player player) {
		System.out.println(">>This item can't be used.");
	};

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * Gets the energy consumed by using this.
	 *
	 * @return the energy consumed
	 */
	public int getEnergyConsumed() {
		return energyConsumed;
	}
	
}
