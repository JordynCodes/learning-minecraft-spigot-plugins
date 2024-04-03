package me.jordyn.myFirstPlugin;

import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import me.jordyn.myFirstPlugin.commands.GetNBTBlockCommand;
import me.jordyn.myFirstPlugin.commands.HelloCommand;
import me.jordyn.myFirstPlugin.commands.ReloadCommand;
import me.jordyn.myFirstPlugin.commands.SVACommand;
import me.jordyn.myFirstPlugin.commands.SetSpawnCommand;
import me.jordyn.myFirstPlugin.commands.TargetPlayerCommand;
import me.jordyn.myFirstPlugin.commands.TellSelfCommand;
import me.jordyn.myFirstPlugin.configs.CustomConfig;
import me.jordyn.myFirstPlugin.configs.HopperData;
import me.jordyn.myFirstPlugin.listeners.JoinListener;
import me.jordyn.myFirstPlugin.listeners.LeaveListener;
import me.jordyn.myFirstPlugin.listeners.NBTHopperListener;
import me.jordyn.myFirstPlugin.listeners.SVAListener;

public class FirstPlugin extends JavaPlugin{
  private static final Logger LOGGER=Logger.getLogger("myFirstPlugin");
  private HelloCommand helloCommand = new HelloCommand();
  private static FirstPlugin plugin;

  public void onEnable(){

    // config.yml
    getConfig().options().copyDefaults();
    saveDefaultConfig();

    // customconfig.yml
    CustomConfig.setup();
    CustomConfig.getCustomFile().addDefault("message", "Hello, self!");
    CustomConfig.getCustomFile().options().copyDefaults(true);
    CustomConfig.saveCustomFile();

    // hopper_data.yml
    HopperData.setup();
    HopperData.getHopperDataFile().options().copyDefaults(true);
    HopperData.saveHopperDataFile();

    plugin = this;
    LOGGER.info("myFirstPlugin enabled");
    getCommand("fpsetspawn").setExecutor(new SetSpawnCommand(this));
    getCommand("fpt").setExecutor(new TargetPlayerCommand());
    getCommand("hello").setExecutor(helloCommand);
    getCommand("sva").setExecutor(new SVACommand());
    getCommand("tellself").setExecutor(new TellSelfCommand());
    getCommand("preload").setExecutor(new ReloadCommand(this));
    getCommand("getnbthopper").setExecutor(new GetNBTBlockCommand(this));
    getServer().getPluginManager().registerEvents(new JoinListener(this), this);
    getServer().getPluginManager().registerEvents(new LeaveListener(), this);
    getServer().getPluginManager().registerEvents(new SVAListener(), this);
    getServer().getPluginManager().registerEvents(new NBTHopperListener(this), this);


  }

  public ItemStack getNBTHopper(){
        ItemStack hopper = new ItemStack(Material.HOPPER);
        ItemMeta hopperMeta = hopper.getItemMeta();
        PersistentDataContainer data = hopperMeta.getPersistentDataContainer();
        data.set(new NamespacedKey(plugin, "message"), PersistentDataType.STRING, "you placed an nbt hopper");
        hopper.setItemMeta(hopperMeta);
        return hopper;
  }

  public void onDisable(){
    LOGGER.info("myFirstPlugin disabled");
  }

  public static FirstPlugin getPlugin() { return plugin; }

}
