package me.jordyn.myFirstPlugin;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;
import me.jordyn.myFirstPlugin.listeners.JoinListener;
import me.jordyn.myFirstPlugin.listeners.LeaveListener;

public class Plugin extends JavaPlugin{
  private static final Logger LOGGER=Logger.getLogger("myFirstPlugin");
  private CommandHandler commandHandler = new CommandHandler();

  public void onEnable(){
    LOGGER.info("myFirstPlugin enabled");
    getCommand("hello").setExecutor(commandHandler);
    getServer().getPluginManager().registerEvents(new JoinListener(), this);
    getServer().getPluginManager().registerEvents(new LeaveListener(), this);
  }

  public void onDisable(){
    LOGGER.info("myFirstPlugin disabled");
  }
}
