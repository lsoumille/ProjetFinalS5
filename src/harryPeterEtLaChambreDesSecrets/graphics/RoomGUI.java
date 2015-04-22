package harryPeterEtLaChambreDesSecrets.graphics;

import harryPeterEtLaChambreDesSecrets.items.Key;
import harryPeterEtLaChambreDesSecrets.rooms.Room;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * The Class RoomGUI. This represents a Room.
 */
public class RoomGUI extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The height of the label. */
	public static final int HEIGHT = 50;

	/** The width of the label. */
	public static final int WIDTH = 150;

	private static final int HORIZONTAL_EXIT_WIDTH = 20;

	private static final int HORIZONTAL_EXIT_HEIGHT = 3;

	private static final int VERTICAL_EXIT_WIDTH = HORIZONTAL_EXIT_HEIGHT;

	private static final int VERTICAL_EXIT_HEIGHT = HORIZONTAL_EXIT_WIDTH;

	private static final int ROOM_NAME_WIDTH = 120;

	private static final int ROOM_NAME_HEIGHT = 40;

	/** The position in the frame (X axe). */
	private int posX;

	/** The position in the frame (Y axe). */
	private int posY;

	private JLabel roomName;

	private JLabel exitNorth;

	private JLabel exitSouth;

	private JLabel exitEast;

	private JLabel exitWest;

	/**
	 * Instantiates a new room GUI.
	 * 
	 * @param name
	 *            the name
	 * @param posX
	 *            the pos x
	 * @param posY
	 *            the pos y
	 */
	public RoomGUI(Room room, int posX, int posY) {
		super();

		// Layout Settings
		this.setPosX(posX);
		this.setPosY(posY);
		this.setBounds(this.posX, this.posY, RoomGUI.WIDTH, RoomGUI.HEIGHT);

		this.setDisplay(room.getName());

		this.setExits();
		 
		Key keyNeeded = room.getKey();
		if (keyNeeded != null) {
			String keyNeededName = keyNeeded.getName();
			this.setToolTipText("Need : " + keyNeededName);
		}
		

		this.validate();
		this.repaint();

	}

	private void setExits() {
		this.exitNorth = new JLabel();
		this.exitSouth = new JLabel();
		this.exitEast = new JLabel();
		this.exitWest = new JLabel();

		this.exitNorth.setBounds(RoomGUI.WIDTH / 2
				- RoomGUI.HORIZONTAL_EXIT_WIDTH / 2, 0,
				RoomGUI.HORIZONTAL_EXIT_WIDTH, RoomGUI.HORIZONTAL_EXIT_HEIGHT);
		this.exitSouth.setBounds(RoomGUI.WIDTH / 2
				- RoomGUI.HORIZONTAL_EXIT_WIDTH / 2, RoomGUI.HEIGHT
				- RoomGUI.HORIZONTAL_EXIT_HEIGHT,
				RoomGUI.HORIZONTAL_EXIT_WIDTH, RoomGUI.HORIZONTAL_EXIT_HEIGHT);
		this.exitEast.setBounds(RoomGUI.WIDTH - RoomGUI.VERTICAL_EXIT_WIDTH,
				RoomGUI.HEIGHT / 2 - RoomGUI.VERTICAL_EXIT_HEIGHT / 2,
				RoomGUI.VERTICAL_EXIT_WIDTH, RoomGUI.VERTICAL_EXIT_HEIGHT);
		this.exitWest.setBounds(0, RoomGUI.HEIGHT / 2
				- RoomGUI.VERTICAL_EXIT_HEIGHT / 2,
				RoomGUI.VERTICAL_EXIT_WIDTH, RoomGUI.VERTICAL_EXIT_HEIGHT);

		this.exitNorth.setOpaque(true);
		this.exitSouth.setOpaque(true);
		this.exitEast.setOpaque(true);
		this.exitWest.setOpaque(true);

		this.exitNorth.setVisible(true);
		this.exitSouth.setVisible(true);
		this.exitEast.setVisible(true);
		this.exitWest.setVisible(true);

		this.exitNorth.setBackground(Colors.BAD_EXIT);
		this.exitSouth.setBackground(Colors.BAD_EXIT);
		this.exitEast.setBackground(Colors.BAD_EXIT);
		this.exitWest.setBackground(Colors.BAD_EXIT);

		this.add(this.exitNorth);
		this.add(this.exitSouth);
		this.add(this.exitEast);
		this.add(this.exitWest);

	}

	public void setDisplay(String name) {
		// Display Settings
		this.setBackground(Colors.ROOM_BACKGROUND);
		this.setOpaque(true);
		this.setLayout(null);
		this.setVisible(true);

		this.roomName = new JLabel(name);
		this.roomName.setFont(new Font("Calibri", Font.BOLD, 13));
		this.roomName.setForeground(Color.white);
		this.roomName.setBackground(this.getBackground());
		this.roomName.setHorizontalAlignment(SwingConstants.CENTER);
		this.roomName.setVerticalAlignment(SwingConstants.CENTER);
		this.roomName.setOpaque(true);
		this.roomName.setBounds(
				RoomGUI.WIDTH / 2 - RoomGUI.ROOM_NAME_WIDTH / 2, RoomGUI.HEIGHT
						/ 2 - RoomGUI.ROOM_NAME_HEIGHT / 2,
				RoomGUI.ROOM_NAME_WIDTH, RoomGUI.ROOM_NAME_HEIGHT);

		this.add(roomName);
		
		
	}

	public void setRoomNameBackground(Color color) {
		this.roomName.setBackground(color);
	}

	/**
	 * Gets the position (Axe Y).
	 * 
	 * @return the pos y
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * Sets the position (Axe Y).
	 * 
	 * @param posY
	 *            the new pos y
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}

	/**
	 * Gets the position (Axe X).
	 * 
	 * @return the pos x
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * Sets the position (Axe X).
	 * 
	 * @param posX
	 *            the new pos x
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setColorExit(String direction, Color color) {
		switch (direction) {
		case "north":
			this.exitNorth.setBackground(color);
			break;
		case "south":
			this.exitSouth.setBackground(color);
			break;
		case "east":
			this.exitEast.setBackground(color);
			break;
		case "west":
			this.exitWest.setBackground(color);
			break;
		}
	}

	public void setColorOppositeExit(String direction, Color color) {
		switch (direction) {
		case "north":
			this.exitSouth.setBackground(color);
			break;
		case "south":
			this.exitNorth.setBackground(color);
			break;
		case "east":
			this.exitWest.setBackground(color);
			break;
		case "west":
			this.exitEast.setBackground(color);
			break;
		}

	}

}
