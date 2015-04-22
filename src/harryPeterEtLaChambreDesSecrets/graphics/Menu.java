package harryPeterEtLaChambreDesSecrets.graphics;

import harryPeterEtLaChambreDesSecrets.exceptions.NullRoomAtBeginningForPlayerException;
import harryPeterEtLaChambreDesSecrets.exceptions.NullRoomAtBeginningForVoldemortException;
import harryPeterEtLaChambreDesSecrets.utils.Game;
import harryPeterEtLaChambreDesSecrets.utils.Utils;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

/**
 * The Class Menu. It allows to load a game.
 */
public class Menu {

	/**
	 * Instantiates a new menu.
	 * 
	 * @throws NullRoomAtBeginningForPlayerException
	 *             the null room at beginning for player exception
	 * @throws NullRoomAtBeginningForVoldemortException
	 *             the null room at beginning for voldemort exception
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	public Menu() throws NullRoomAtBeginningForPlayerException,
			NullRoomAtBeginningForVoldemortException, FileNotFoundException {
		File file = new File(Utils.FILE_PATH);

		// If the save file exists, asks for load it.
		if (file.exists()) {
			int choice = JOptionPane.showConfirmDialog(null,
					"Do you want load the game saved ?",
					"Harry Peter et la Chambre des Secrets",
					JOptionPane.YES_NO_OPTION);
			if (choice == 0) {
				// YES
				Game g = new Game();
				g.load();
				g.play();
			} else {
				// NO
				new Game().play();
			}
		} else {
			new Game().play();
		}

	}

}
