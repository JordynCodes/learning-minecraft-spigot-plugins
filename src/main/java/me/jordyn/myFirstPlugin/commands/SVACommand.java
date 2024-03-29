package me.jordyn.myFirstPlugin.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SVACommand implements CommandExecutor{
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player p)) {
            return true;
        }
        
        Inventory inventory = Bukkit.createInventory(p, 54, ChatColor.GREEN + "SVA Vault");

        ItemStack item = new ItemStack(Material.DIAMOND_HOE, 1);
        ItemMeta itemMeta = item.getItemMeta();

        ArrayList<String> lore = new ArrayList<>();
        lore.add("What a cool tool!");
        lore.add("Don't you agree?");
        itemMeta.setLore(lore);

        itemMeta.setDisplayName(ChatColor.RED + "Fake SVA");
        item.setItemMeta(itemMeta);
        inventory.setItem(0, item);
        p.openInventory(inventory);

        return true;
    }

}
