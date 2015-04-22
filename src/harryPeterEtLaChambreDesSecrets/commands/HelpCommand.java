package harryPeterEtLaChambreDesSecrets.commands;

import harryPeterEtLaChambreDesSecrets.persons.Player;
import harryPeterEtLaChambreDesSecrets.utils.Utils;

/**
 * The Class HelpCommand. Displays the helps.
 */
public class HelpCommand extends Command {

    /**
     * Instantiates a new help command.
     */
    public HelpCommand() {
        super("help", null);
    }
    
    /**
     * Print out some help informations. Here we print some stupid, cryptic
     * message and a list of the command words.
     *
     * @param p the p
     * @return true, if successful
     */
    @Override
    public boolean use(Player p){
        System.out.println(Utils.helps);
        System.out.println();
        System.out.println("Your command words are:");
        p.getCurrentRoom().showCommands();
        return false;
    }

}
