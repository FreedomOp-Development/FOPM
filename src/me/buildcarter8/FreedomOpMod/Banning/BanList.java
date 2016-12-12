package me.buildcarter8.FreedomOpMod.Banning;

import java.io.File;
import java.util.Date;
import org.bukkit.*;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.Configuration;

public class BanList {
    private static final File BANLIST = new File("banned-players.yml");
    protected static final YamlConfiguration YAML = YamlConfiguration.loadConfiguration(BANLIST);
    protected static Configuration defaults;
    
    public static void add(String name, String IP, String reason, String adminName) {
        //methods here
    }
}
