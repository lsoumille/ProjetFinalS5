package harryPeterEtLaChambreDesSecrets.items;

import java.util.Random;

import harryPeterEtLaChambreDesSecrets.persons.Player;

/**
 * The Class Mug. A mug is used to drink coffee.
 */
public class Mug extends Item {

	/** The maximum energy you can get by drinking a coffee. */
	private static final int MAX_ENERGY_GAIN = 5;
	
	/** The minimum energy you can get by drinking a coffee. */
	private static final int MIN_ENERGY_GAIN = 2;

	/** The state of the mug. Empty or not. */
	private boolean state;

	/**
	 * Instantiates a new mug.
	 */
	public Mug() {
		super("Mug", 0);
	}

	/**
	 * Fills the mug.
	 */
	public void full() {
		if (this.isEmpty()) {
			this.state = true;
			System.out.println("You have filled your mug.");
		} else
			System.out.println(">>Your mug is already full.");
	}

	/**
	 * Checks if the mug is empty.
	 * 
	 * @return true, if is empty
	 */
	private boolean isEmpty() {
		if (!state)
			return true;
		else
			return false;
	}

	@Override
	public void use(Player player) {
		// Mug empty
		if (this.isEmpty())
			System.out.println(">>Sorry, Mug is empty !");
		else {
			// Mug not empty
			System.out.println("Wouhou ! You feel the effect of coffee.");
			this.state = false;
			player.setEnergy(player.getEnergy() + this.getRandomEnergy());
			System.out.println(player.getEnergyInString());
		}
	}

	/**
	 * Gets a random energy between limits.
	 *
	 * @return the random energy
	 */
	private int getRandomEnergy() {
		int energy;
		energy = new Random().nextInt(MAX_ENERGY_GAIN - MIN_ENERGY_GAIN + 1)
				+ MIN_ENERGY_GAIN;
		return energy;
	}

}
