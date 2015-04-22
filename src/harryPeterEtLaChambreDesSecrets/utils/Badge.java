package harryPeterEtLaChambreDesSecrets.utils;

import java.util.ArrayList;

import harryPeterEtLaChambreDesSecrets.persons.Player;
import harryPeterEtLaChambreDesSecrets.persons.Voldemort;

/**
 * The Class Badge.
 */
public class Badge {

	/** The player energy. */
	private int playerEnergy;

	/** The player room. */
	private String playerRoom;

	/** The Voldemort room. */
	private String vdmRoom;

	/** The player's items. */
	private ArrayList<String> playerItems;

	/**
	 * Instantiates a new badge.
	 * 
	 * @param newJoueur
	 *            the new joueur
	 * @param vdm
	 *            the vdm
	 */
	public Badge(Player newJoueur, Voldemort vdm) {
	    this.playerEnergy = newJoueur.getEnergy();
		this.playerRoom = newJoueur.getCurrentRoom().getName();
		this.vdmRoom = vdm.getCurrentRoom().getName();
		this.playerItems = newJoueur.getArrayStringInventory();
		

	}

	/**
	 * Gets the player energy.
	 * 
	 * @return the player energy
	 */
	public int getPlayerEnergy() {
		return playerEnergy;
	}

	/**
	 * Sets the player energy.
	 * 
	 * @param playerEnergy
	 *            the new player energy
	 */
	public void setPlayerEnergy(int playerEnergy) {
		this.playerEnergy = playerEnergy;
	}

	/**
	 * Gets the player room.
	 * 
	 * @return the player room
	 */
	public String getPlayerRoom() {
		return playerRoom;
	}

	/**
	 * Sets the player room.
	 * 
	 * @param playerRoom
	 *            the new player room
	 */
	public void setPlayerRoom(String playerRoom) {
		this.playerRoom = playerRoom;
	}

	/**
	 * Gets the vdm room.
	 * 
	 * @return the vdm room
	 */
	public String getVdmRoom() {
		return vdmRoom;
	}

	/**
	 * Sets the vdm room.
	 * 
	 * @param vdmRoom
	 *            the new vdm room
	 */
	public void setVdmRoom(String vdmRoom) {
		this.vdmRoom = vdmRoom;
	}

	/**
	 * Gets the as.
	 * 
	 * @return the as
	 */
	public ArrayList<String> getPlayerItems() {
		return playerItems;
	}

	/**
	 * Sets the as.
	 * 
	 * @param as
	 *            the new as
	 */
	public void setPlayerItems(ArrayList<String> as) {
		this.playerItems = as;
	}
}
