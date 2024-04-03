package me.jordyn.myFirstPlugin.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import me.jordyn.myFirstPlugin.FirstPlugin;
import me.jordyn.myFirstPlugin.configs.HopperData;

public class NBTHopperListener implements Listener{
    
    private final FirstPlugin plugin;

    public NBTHopperListener(FirstPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onNBTPlace(BlockPlaceEvent e){

        PersistentDataContainer data = e.getItemInHand().getItemMeta().getPersistentDataContainer();

        if (!data.has((new NamespacedKey(plugin, "message")), PersistentDataType.STRING)){
            return;
        }

        Block block = e.getBlock();
        Location location = new Location(block.getWorld(), block.getX(), block.getY(), block.getZ());
        String key = getLocationKey(location);
        HopperData.getHopperDataFile().set("hoppers." + key, location);
        HopperData.saveHopperDataFile();

        String message = data.get(new NamespacedKey(plugin, "message"), PersistentDataType.STRING);

        e.getPlayer().sendMessage(message);

    }

    @EventHandler
    public void onNBTBreak(BlockBreakEvent e){

        Block block = e.getBlock();
        Location blockLocation = new Location(block.getWorld(), block.getX(), block.getY(), block.getZ());

        ConfigurationSection hoppersSection = HopperData.getHopperDataFile().getConfigurationSection("hoppers");
        if (hoppersSection == null) {
            return;
        }

        Boolean hopperFound = false;

        for (String key : hoppersSection.getKeys(false)){
            if (blockLocation.equals(HopperData.getHopperDataFile().get("hoppers." + key))){
                HopperData.getHopperDataFile().set("hoppers." + key, null);
                HopperData.saveHopperDataFile();
                hopperFound = true;
                break;
            }
        }

        if (!hopperFound){
            return;
        }

        ItemStack droppedItem = plugin.getNBTHopper();
        e.setDropItems(false);
        block.getWorld().dropItemNaturally(block.getLocation(), droppedItem);

    }

    private String getLocationKey(Location location) {
        return location.getWorld().getName() + "_" + location.getBlockX() + "_" + location.getBlockY() + "_" + location.getBlockZ();
    }

}
