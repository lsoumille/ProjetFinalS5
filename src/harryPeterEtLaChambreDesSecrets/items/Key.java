package harryPeterEtLaChambreDesSecrets.items;

/**
 * The Class Key. A key may be necessary to access a room.
 */
public class Key extends Item {
	
	/** The energy consumed by using. */
	public final static int KEY_ENERGY = 0;

	/**
	 * Instantiates a new key.
	 *
	 * @param name the name
	 */
	public Key(String name) {
		super(name, Key.KEY_ENERGY);
	}
}
