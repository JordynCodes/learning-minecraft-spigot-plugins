package me.jordyn.myFirstPlugin.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.jordyn.myFirstPlugin.FirstPlugin;

public class SetSpawnCommand implements CommandExecutor {

    private final FirstPlugin plugin;

    public SetSpawnCommand(FirstPlugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        
        if (!(sender instanceof Player p)) {
            return true;
        }

        Location location = p.getLocation();
        plugin.getConfig().set("spawn", location);
        plugin.saveConfig();
        p.sendMessage("Spawn location set.");

        return true;
    }
    
}
