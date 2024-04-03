package me.jordyn.myFirstPlugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.jordyn.myFirstPlugin.FirstPlugin;

public class GetNBTBlockCommand implements CommandExecutor{

    private final FirstPlugin plugin;

    public GetNBTBlockCommand(FirstPlugin plugin){
        this.plugin = plugin;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        
        if (!(sender instanceof Player player)){
            return true;
        }

        player.getInventory().addItem(plugin.getNBTHopper());

        return true;
    }
    
}
