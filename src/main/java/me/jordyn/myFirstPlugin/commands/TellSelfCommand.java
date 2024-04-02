package me.jordyn.myFirstPlugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.jordyn.myFirstPlugin.configs.CustomConfig;

public class TellSelfCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        
        if (!(sender instanceof Player player)){
            return true;
        }

        player.sendMessage(CustomConfig.getCustomFile().getString("message"));

        return true;
    }
    
}
