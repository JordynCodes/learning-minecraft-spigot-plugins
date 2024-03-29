package me.jordyn.myFirstPlugin.commands;

import java.util.logging.Logger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelloCommand implements CommandExecutor{

    private static final Logger LOGGER=Logger.getLogger("myFirstPlugin");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if (sender instanceof Player p){

            String message = "";
            if (args.length > 0)
                message += " " + String.join(" ", args);
            LOGGER.info(p.getDisplayName() + " has said hello" + message);
        }

        return true;

    }
}
