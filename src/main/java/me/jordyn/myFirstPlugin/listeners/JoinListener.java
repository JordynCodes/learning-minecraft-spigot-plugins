package me.jordyn.myFirstPlugin.listeners;

import java.util.logging.Logger;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener{

    private static final Logger LOGGER=Logger.getLogger("myFirstPlugin");
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        LOGGER.info(player.getDisplayName() + " has joined the server.");
    }

}
