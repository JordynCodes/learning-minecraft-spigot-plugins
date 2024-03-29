package me.jordyn.myFirstPlugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TargetPlayerCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        
        if (!(sender instanceof Player p)) {
            return true;
        }

        if(args.length == 0){
            p.sendMessage("You must choose a player to target.");
            return true;
        }
        
        String playerName = args[0];
        Player target = Bukkit.getServer().getPlayerExact(playerName);
        if (target == null){
            p.sendMessage("Must target an online player.");
        } else {
            target.sendMessage("You have been targeted!");
        }

        return true;
    }
    
}
