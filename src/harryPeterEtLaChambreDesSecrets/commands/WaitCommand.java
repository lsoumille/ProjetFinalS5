package harryPeterEtLaChambreDesSecrets.commands;

import harryPeterEtLaChambreDesSecrets.persons.Player;
import harryPeterEtLaChambreDesSecrets.utils.Game;
import harryPeterEtLaChambreDesSecrets.utils.Utils;

public class WaitCommand extends Command {

    public WaitCommand() {
        super("wait", null);
    }
    
    @Override
    public boolean use(Player player) {
        // Voldemort can move
        Game.vdm.changeRoom();
        
        System.out.println("You are waiting..."); 
        
        // Check if voldemort is in the same room
        return Utils.checkVoldemort(player, player.getCurrentRoom());
    }
}
