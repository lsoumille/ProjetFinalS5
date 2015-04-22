package harryPeterEtLaChambreDesSecrets.utils;

import java.io.FileNotFoundException;
import harryPeterEtLaChambreDesSecrets.commands.Command;
import harryPeterEtLaChambreDesSecrets.commands.Parser;
import harryPeterEtLaChambreDesSecrets.exceptions.NullRoomAtBeginningForPlayerException;
import harryPeterEtLaChambreDesSecrets.exceptions.NullRoomAtBeginningForVoldemortException;
import harryPeterEtLaChambreDesSecrets.items.Mug;
import harryPeterEtLaChambreDesSecrets.items.WorldMap;
import harryPeterEtLaChambreDesSecrets.persons.Player;
import harryPeterEtLaChambreDesSecrets.persons.Voldemort;
import harryPeterEtLaChambreDesSecrets.rooms.Room;

/**
 * This class is the main class of the "Harry Peter et la Chambre des Secrets"
 * application. This is a very simple, text based adventure game. Users can walk
 * around some scenery. That's all.
 * 
 * To play this game, create an instance of this class and call the "play"
 * method.
 * 
 * This main class creates and initializes all the others: it creates all rooms,
 * creates the parser and starts the game.
 * 
 */

public class Game {

	/** The parser which get console inputs. */
	private Parser parser;

	/** Current player that you are controlling. */
	private Player player;

	/** The guy you shouldn't meet. */
	public static Voldemort vdm;

	/**
	 * Create the game and initialize its internal map.
	 * 
	 * @throws NullRoomAtBeginningForPlayerException
	 *             the null room at beginning exception
	 * @throws NullRoomAtBeginningForVoldemortException
	 *             the null room at beginning for voldemort exception
	 */
	public Game() throws NullRoomAtBeginningForPlayerException,
			NullRoomAtBeginningForVoldemortException {

		Mappage.loadMap();
		this.parser = new Parser();

		// Instantiates player and Voldemort
		this.player = new Player(Mappage.playerStartRoom);
		Game.vdm = new Voldemort(Mappage.voldemortStartRoom);
	}

	/**
	 * Main play routine. Loops until end of play.
	 */
	public void play() {
		// Display the Welcome message
		Utils.printWelcome();

		// Adding starting items to the player
		this.player.addItemOnPlayer(new Mug());
		this.player.addItemOnPlayer(new WorldMap());
		// this.player.addItemOnPlayer(new Marauder());

		// Display the current room of the player
		printCurrentRoom();

		// Enter the main command loop. Here we repeatedly read commands and
		// execute them until the game is over
		boolean finished = false;
		while (!finished) {
			Command command = parser.getCommand();
			finished = processCommand(command, player) || checkEnergy();
		}

		// Displays the end message
		System.out.println("Thank you for playing. Good bye.");
	}

	/**
	 * Loads the saved game.
	 * 
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	public void load() {
		// BufferedReader br = new BufferedReader(new
		// FileReader(Utils.FILE_PATH));
		// Gson gson = new Gson();

		// Converts the json string back to object
		Badge b = Utils.json.fromJson(Utils.Reader(Utils.FILE_PATH),
				Badge.class);

		// Reload player and Voldemort
		this.player.setEnergy(b.getPlayerEnergy());
		// Ressource r = new Ressource();
		// this.player.setCurrentRoom(r.searchRoom(b.getPlayerRoom()));
		this.player.setCurrentRoom(Mappage.searchRoom(b.getPlayerRoom()));
		Game.vdm.setCurrentRoom(Mappage.searchRoom(b.getVdmRoom()));
		this.player
				.setItemsOnPlayer(Mappage.searchInventory(b.getPlayerItems()));
	}

	/**
	 * Given a command, process (that is: execute) the command.
	 * 
	 * @param command
	 *            The command to be processed.
	 * @param player
	 *            the player
	 * @return true If the command ends the game, false otherwise.
	 */
	private boolean processCommand(Command command, Player player) {
		// Gets a valid command
		Command usableCom = player.getCurrentRoom().CommandIsAvailable(command);
		if (usableCom != null) {
			// Gets the second word of the command
			usableCom.setSecondWord(command.getSecondWord());
			return usableCom.use(player);
		} else {
			System.out
					.println(">>Invalid command. Either the command can't be used here, "
							+ "\nor you are trying to cheat!");
		}

		return false;
	}

	/**
	 * Check the player energy.
	 * 
	 * @return true, if the player has too much energy or not enough false, if
	 *         energy is good
	 */
	public boolean checkEnergy() {
		// Too much energy involves the player's death
		if (player.hasTooMuchEnergy()) {
			System.out.println("You have too much energy, then you died. :(");
			return true;
		} else if (player.hasNotEnoughEnergy()) {
			// Not enough energy too
			System.out.println("You have no more energy, then you died. :(");
			return true;
		}
		return false;
	}

	/**
	 * Prints the details of the current room.
	 */
	private void printCurrentRoom() {
		Room currentRoom = player.getCurrentRoom();
		System.out.println("\n[" + currentRoom.getName() + "]\n"
				+ currentRoom.getDescription() + "\n"
				+ currentRoom.getItemsinString() + player.getEnergyInString()
				+ "\n" + player.getItemsInString());
	}

}
