package me.jordyn.myFirstPlugin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SVAListener implements Listener{

    @EventHandler
    public void onSVAClick(InventoryClickEvent e){

        if (!e.getView().getTitle().equals(ChatColor.GREEN + "SVA Vault"))
            return;
        if (!e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Fake SVA"))
            return;
        e.setCancelled(true);
        Player p = (Player) e.getWhoClicked();
        p.sendMessage("You clicked on me!");

    }
    
}
