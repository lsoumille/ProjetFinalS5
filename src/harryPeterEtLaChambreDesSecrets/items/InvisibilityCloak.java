package harryPeterEtLaChambreDesSecrets.items;

import harryPeterEtLaChambreDesSecrets.persons.Player;

/**
 * The Class InvisibilityCloak. This item allows to be invincible during a few
 * moment.
 */
public class InvisibilityCloak extends Item {

	/** The energy consumed by using it. The item is automatically used. */
	public static final int CLOAK_ENERGY_AUTOMATIC = 4;

	/**
	 * Instantiates a new invisibility cloak.
	 * 
	 * @param energy
	 *            the energy
	 */
	public InvisibilityCloak() {
		super("Cloak", 0);
	}

	@Override
	public void use(Player player) {
		System.out.println(">>This item can't be used.");
	}

}
