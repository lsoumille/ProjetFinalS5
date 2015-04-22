package harryPeterEtLaChambreDesSecrets.rooms;

import java.util.Scanner;

import harryPeterEtLaChambreDesSecrets.items.Item;
import harryPeterEtLaChambreDesSecrets.persons.Player;

/**
 * The Class Activity. An activity is a question that you need to answer in
 * order to resume the game.
 */
public class Activity {

	/** The award after a good answer. */
	private Item award; // or not

	/** The question. */
	private String question;

	/** The good answer. */
	private String answer;

	/** The energy lost if bad answer. */
	private int energyToLose;

	/** Flag of the activity statement. Resolved or not. */
	private boolean activityDone = false;

	/**
	 * Instantiates a new activity.
	 * 
	 * @param question
	 *            the question
	 * @param answer
	 *            the answer
	 * @param energyLostIfLose
	 *            the energy lost if bad answer
	 * @param award
	 *            the award
	 */
	public Activity(String question, String answer, int energyLostIfLose,
			Item award) {
		this.question = question;
		this.answer = answer.toLowerCase();
		this.energyToLose = energyLostIfLose;
		this.award = award;
	}

	/**
	 * Gets the question.
	 * 
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * Gets the answer.
	 * 
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * Gets the energy to lose after a bad answer.
	 * 
	 * @return the energyToLose
	 */
	public int getEnergyToLose() {
		return energyToLose;
	}

	/**
	 * Sets the question.
	 * 
	 * @param question
	 *            the new question
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return ("The question is : " + this.question + "\nThe answer is : "
				+ answer + "\nThe energy gainded of lost : " + energyToLose + ".");
	}

	/**
	 * Launch the activity if it is not resolved yet.
	 * 
	 * @param player
	 *            the player
	 */
	public void launch(Player player) {
		@SuppressWarnings("resource")
		Scanner answerScanner = new Scanner(System.in);
		
		// Do not ask the question if it has been resolved
		while (!this.activityDone) {
			// Displays the question
			System.out
					.println("\nA flying parchment want you to answer a question.\n");
			System.out.println("Question : " + this.question);
			System.out.print("Answer : ");

			// Read the input answer
			String lineRead;
			lineRead = answerScanner.nextLine().toLowerCase();

			// Good answer
			if (lineRead.equals(this.answer)) {
				System.out.println("\nGOOD!\n");
				player.addItemOnPlayer(this.award);
				this.activityDone = true;

			} else {
				// Bad answer
				System.out.println("\nWRONG!\n");
				// Decreases the player energy
				player.setEnergy(player.getEnergy() - this.energyToLose);
				// Quit the game if the player has not enough energy
				if (player.hasNotEnoughEnergy())
					return;
			}
		}
	}

	/**
	 * Gets the award.
	 * 
	 * @return the award
	 */
	public Item getAward() {
		return award;
	}

	// JSON Data
	/**
	 * Méthode qui sauvegarde la liste des activites.
	 * 
	 * public void sauvegarder(){ ObjectOutputStream oos;
	 * 
	 * try { oos = new ObjectOutputStream( new BufferedOutputStream( new
	 * FileOutputStream( new File("Activity.txt")))); oos.writeObject(liste);
	 * oos.close(); } catch (FileNotFoundException e) { e.printStackTrace(); }
	 * catch (IOException e) { e.printStackTrace(); }
	 * 
	 * } /** Méthode qui récupère la liste des badges sauvegardée.
	 * 
	 * public void recuperer(){ ObjectInputStream ois; try {
	 * 
	 * ois = new ObjectInputStream( new BufferedInputStream( new
	 * FileInputStream( new File("Activity.txt")))); liste =
	 * (ArrayList<Badge>)ois.readObject(); ois.close(); } catch
	 * (ClassNotFoundException e) { e.printStackTrace(); } catch (IOException
	 * e){ e.printStackTrace(); } finally {
	 * 
	 * } } /** Méthode qui écrit la liste des badges dans un fichier
	 * Badge.json.
	 * 
	 * public void exporter(){ try { JSONObject obj = new
	 * JSONObject().put(liste.toString(),true); FileWriter file = new
	 * FileWriter("Activity.json"); file.write(obj.toString()); file.flush();
	 * file.close();
	 * 
	 * } catch (JSONException e) { e.printStackTrace(); } catch (IOException e)
	 * { e.printStackTrace(); } }
	 */

}
