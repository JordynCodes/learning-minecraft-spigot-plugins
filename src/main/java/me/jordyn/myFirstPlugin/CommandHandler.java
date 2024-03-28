package me.jordyn.myFirstPlugin;

import java.util.logging.Logger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor{

    private static final Logger LOGGER=Logger.getLogger("myFirstPlugin");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if (command.getName().equalsIgnoreCase("hello")) {

            if (sender instanceof Player p){
                LOGGER.info(p.getDisplayName() + " has said hello.");
            }
            return true;

        }
        return false;

    }
}
