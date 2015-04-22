package harryPeterEtLaChambreDesSecrets;

import java.io.FileNotFoundException;

import harryPeterEtLaChambreDesSecrets.exceptions.NullRoomAtBeginningForPlayerException;
import harryPeterEtLaChambreDesSecrets.exceptions.NullRoomAtBeginningForVoldemortException;
import harryPeterEtLaChambreDesSecrets.graphics.Menu;

public class Main {

	public static void main(String[] args)
			throws NullRoomAtBeginningForPlayerException,
			NullRoomAtBeginningForVoldemortException, FileNotFoundException {
		new Menu();
	}

}
