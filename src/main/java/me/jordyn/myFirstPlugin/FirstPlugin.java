package me.jordyn.myFirstPlugin;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;
import me.jordyn.myFirstPlugin.commands.HelloCommand;
import me.jordyn.myFirstPlugin.commands.ReloadCommand;
import me.jordyn.myFirstPlugin.commands.SVACommand;
import me.jordyn.myFirstPlugin.commands.SetSpawnCommand;
import me.jordyn.myFirstPlugin.commands.TargetPlayerCommand;
import me.jordyn.myFirstPlugin.commands.TellSelfCommand;
import me.jordyn.myFirstPlugin.configs.CustomConfig;
import me.jordyn.myFirstPlugin.listeners.JoinListener;
import me.jordyn.myFirstPlugin.listeners.LeaveListener;
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

    plugin = this;
    LOGGER.info("myFirstPlugin enabled");
    getCommand("fpsetspawn").setExecutor(new SetSpawnCommand(this));
    getCommand("fpt").setExecutor(new TargetPlayerCommand());
    getCommand("hello").setExecutor(helloCommand);
    getCommand("sva").setExecutor(new SVACommand());
    getCommand("tellself").setExecutor(new TellSelfCommand());
    getCommand("preload").setExecutor(new ReloadCommand(this));
    getServer().getPluginManager().registerEvents(new JoinListener(this), this);
    getServer().getPluginManager().registerEvents(new LeaveListener(), this);
    getServer().getPluginManager().registerEvents(new SVAListener(), this);

  }

  public void onDisable(){
    LOGGER.info("myFirstPlugin disabled");
  }

  public static FirstPlugin getPlugin() { return plugin; }

}
