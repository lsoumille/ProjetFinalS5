package harryPeterEtLaChambreDesSecrets.graphics;

import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import harryPeterEtLaChambreDesSecrets.rooms.Room;
import harryPeterEtLaChambreDesSecrets.utils.Game;
import harryPeterEtLaChambreDesSecrets.utils.Utils;

import javax.swing.JFrame;


/**
 * The Class MarauderGUI. This is the frame containing all the rooms of the
 * current stair.
 */
public class MarauderGUI extends JFrame {

	/** The height. */
	private int height;

	/** The width. */
	private int width;

	/** The middle of screen (axe X). */
	private int startX;

	/** The middle of screen (axe Y). */
	private int startY;

	/** The Constant ROOM_GUI_X. */
	private final static int ROOM_GUI_X = 160;

	/** The Constant ROOM_GUI_Y. */
	private final static int ROOM_GUI_Y = 60;

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new Marauder GUI.
	 * 
	 * @param currentRoom
	 *            the current room
	 */
	public MarauderGUI(Room currentRoom) {
		super("Marauder");
		
		// Setting the frame
		this.setFrame();

		ArrayList<Room> roomCalled = new ArrayList<Room>();
		this.mappage(currentRoom, null, new RoomGUI(currentRoom, this.startX,
				this.startY), roomCalled);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.validate();
		this.repaint();
	}

	/**
	 * Sets the frame.
	 */
	private void setFrame() {
		// Visible
		this.setVisible(true);

		// No layout
		this.setLayout(null);

		// Not resizable
		this.setResizable(false);

		// Action on close
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				// Marauder is not in use anymore
				if (Utils.MARAUDER_IN_USE) {
					Utils.MARAUDER_IN_USE = false;
				}
			}
		});

		// Full screen mode
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice vc = env.getDefaultScreenDevice();
        vc.setFullScreenWindow(this);
		this.setExtendedState((getExtendedState() & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH ? JFrame.NORMAL
				: JFrame.MAXIMIZED_BOTH);

		// Get width and height
		this.height = this.getHeight();
		this.width = this.getWidth();

		// Get the middle of the frame
		this.startX = this.width / 2 - RoomGUI.WIDTH / 2;
		this.startY = this.height / 2 - RoomGUI.HEIGHT / 2;
	}

	/**
	 * Mappage. It create all labels, calculates their position according a
	 * direction, and put them in the frame.
	 * 
	 * @param room
	 *            the room
	 * @param direction
	 *            the direction
	 * @param exRoom
	 *            the ex room
	 * @param roomCalled
	 *            the room called
	 */
	private void mappage(Room room, String direction, RoomGUI exRoom,
			ArrayList<Room> roomCalled) {
		boolean currentRoom = false;

		// Checks if the room has already been called
		if (!roomCalled.contains(room)) {
			// Calculate positions of the new JLabel
			int newRoomX = exRoom.getPosX();
			int newRoomY = exRoom.getPosY();

			if (direction != null) {
				switch (direction) {
				case "north":
					newRoomY -= MarauderGUI.ROOM_GUI_Y;
					break;

				case "south":
					newRoomY += MarauderGUI.ROOM_GUI_Y;
					break;

				case "west":
					newRoomX -= MarauderGUI.ROOM_GUI_X;
					break;

				case "east":
					newRoomX += MarauderGUI.ROOM_GUI_X;
					break;

				default:
				}
			} else {
				currentRoom = true;
			}

			// Create the new RoomGUI
			RoomGUI newRoom = new RoomGUI(room, newRoomX, newRoomY);
			
			if (direction != null)
				newRoom.setColorOppositeExit(direction, Colors.GOOD_EXIT);

			// Setting the label color : 
			// - green 	: player
			// - red 	: Voldemort
			if (currentRoom) {
				newRoom.setBackground(Colors.CURRENT_ROOM);
				newRoom.setRoomNameBackground(Colors.CURRENT_ROOM);
			}
			if (room == Game.vdm.getCurrentRoom()) {
				newRoom.setBackground(Colors.VOLDEMORT_ROOM);
				newRoom.setRoomNameBackground(Colors.VOLDEMORT_ROOM);
			}

			// Add the JLabel to the Frame
			this.getContentPane().add(newRoom);

			// Add room labeled in array list
			roomCalled.add(room);

			// Call the method for exits of room
			HashMap<String, Room> exits = room.getExits();

			Iterator<Room> itExit = exits.values().iterator();
			Iterator<String> itDirection = exits.keySet().iterator();

			while (itExit.hasNext()) {
				String newDirection = itDirection.next();
				Room exit = itExit.next();

				if (newDirection.equals("south") || newDirection.equals("north") || newDirection
						.equals("west") || newDirection.equals("east")) {
					newRoom.setColorExit(newDirection, Colors.GOOD_EXIT);
					mappage(exit, newDirection, newRoom, roomCalled);
				}
					
			}
			
			this.validate();
			this.repaint();
		}

	}

}
