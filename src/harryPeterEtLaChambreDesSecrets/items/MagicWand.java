package harryPeterEtLaChambreDesSecrets.items;

import harryPeterEtLaChambreDesSecrets.persons.Player;

/**
 * The Class MagicWand. This is what you have to find to become a good sorcerer.
 */
public class MagicWand extends Item {
	
	/** The energy consumed by using. */
	public final static int WAND_ENERGY = Player.MAX_ENERGY;

	/**
	 * Instantiates a new magic wand.
	 */
	public MagicWand() {
		super("MagicWand", MagicWand.WAND_ENERGY);
	}

	@Override
	public void use(Player player) {
		System.out.println("Well !! You get your magic wand back !! \n"
				+ "You don't know anything about magic \n"
				+ "and you tried to use it, so you kill yourself ! :/");
	}

}
