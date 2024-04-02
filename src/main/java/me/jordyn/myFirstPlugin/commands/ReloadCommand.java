package me.jordyn.myFirstPlugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.jordyn.myFirstPlugin.FirstPlugin;
import me.jordyn.myFirstPlugin.configs.CustomConfig;

public class ReloadCommand implements CommandExecutor {
    
    private final FirstPlugin plugin;

    public ReloadCommand(FirstPlugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        
        Player player = (Player) sender;
        CustomConfig.reloadCustomFile();
        plugin.reloadConfig();
        player.sendMessage(ChatColor.YELLOW + "Config files reloaded");

        return true;
    }
    
}
