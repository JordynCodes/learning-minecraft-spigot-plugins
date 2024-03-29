package me.jordyn.myFirstPlugin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import me.jordyn.myFirstPlugin.FirstPlugin;

public class JoinListener implements Listener{

    private final FirstPlugin plugin;
    
    public JoinListener(FirstPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        String joinMessage = this.plugin.getConfig().getString("join-message");
        if (joinMessage != null){
            joinMessage = joinMessage.replace("%player%", e.getPlayer().getDisplayName());
            e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', joinMessage));
        }
    }

}
