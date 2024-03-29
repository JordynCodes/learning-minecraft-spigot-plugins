package me.jordyn.myFirstPlugin.listeners;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import me.jordyn.myFirstPlugin.FirstPlugin;

public class TestPluginListener implements Listener{

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {

        FirstPlugin.getPlugin();
        
    }
}
