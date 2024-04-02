package me.jordyn.myFirstPlugin.configs;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class CustomConfig {
    
    private static File file;
    private static FileConfiguration customFile;
    private static final Logger LOGGER=Logger.getLogger("myFirstPlugin");

    public static void setup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("myFirstPlugin").getDataFolder(), "customconfig.yml");
        if (!file.exists()){
            try{
                file.createNewFile();
            } catch (IOException e){
                // oof
            }
        }

        customFile = YamlConfiguration.loadConfiguration(file);

    }

    public static FileConfiguration getCustomFile(){
        return customFile;
    }

    public static void saveCustomFile() {
        try {
            customFile.save(file);
        } catch (IOException e) {
            LOGGER.info("An IOException occurred while saving the file: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void reloadCustomFile(){
        customFile = YamlConfiguration.loadConfiguration(file);
    }

}
