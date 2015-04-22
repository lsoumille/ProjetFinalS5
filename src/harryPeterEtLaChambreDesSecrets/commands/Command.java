package harryPeterEtLaChambreDesSecrets.commands;

import harryPeterEtLaChambreDesSecrets.persons.Player;

/**
 * The Class Command. A command is a game action. It could has two word.
 */
public class Command {

	/** The command word. */
	private String commandWord;

	/** The second word. */
	protected String secondWord;

	/**
	 * Create a command object. First and second word must be supplied, but
	 * either one (or both) can be null.
	 * 
	 * @param firstWord
	 *            The first word of the command. Null if the command was not
	 *            recognized.
	 * @param secondWord
	 *            The second word of the command.
	 */
	public Command(String firstWord, String secondWord) {
		try{
			commandWord = firstWord.toLowerCase();
			this.secondWord = secondWord;
		} catch (NullPointerException e) {
			return;
		}
		
	}

	/**
	 * Return the command word (the first word) of this command. If the command
	 * was not understood, the result is null.
	 * 
	 * @return The command word.
	 */
	public String getCommandWord() {
		return commandWord;
	}

	/**
	 * The consequences of the command. This is what is done when the player
	 * enters a command.
	 * 
	 * @param player
	 *            the player
	 * @return true, if successful
	 */
	public boolean use(Player player) {
		return false;
	}

	/**
	 * Gets the second word of the command.
	 * 
	 * @return The second word of this command. Returns null if there was no
	 *         second word.
	 */
	public String getSecondWord() {
		return secondWord;
	}

	/**
	 * Sets the second word.
	 * 
	 * @param str
	 *            the str
	 * @return the command
	 */
	public Command setSecondWord(String str) {
		if (str != null) {
			this.secondWord = str.toLowerCase();
		}
		return this;
	}

	/**
	 * Checks for second word.
	 * 
	 * @return true if the command has a second word.
	 */
	public boolean hasSecondWord() {
		return (secondWord != null);
	}

	/**
	 * Have same first word. (A little equals method)
	 * 
	 * @param obj
	 *            the obj
	 * @return true, if successful
	 */
	public boolean haveSameFirstWord(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Command other = (Command) obj;
		if (commandWord == null) {
			if (other.commandWord != null)
				return false;
		} else if (!commandWord.equals(other.commandWord))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return commandWord;
	}
}
