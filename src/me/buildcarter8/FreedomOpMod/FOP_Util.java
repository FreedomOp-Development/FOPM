package me.buildcarter8.FreedomOpMod;

import org.bukkit.*;
import org.bukkit.command.*;

public class FOP_Util {
    private FOP_Util() {
        throw new AssertionError();
    }
    
    public static void adminAction(CommandSender sender, String message, Boolean raw) {
        if (raw) {
            Bukkit.getServer().broadcastMessage(sender.getName() + " - " + message);
        } else {
            Bukkit.getServer().broadcastMessage(ChatColor.RED + sender.getName() + " - " + message);
        }
    }
    
    public static void adminAction(CommandSender sender, String message) {
        adminAction(sender, message, false);
    }
    
    public static void bcastMsg(String message, Boolean raw) {
        if (raw) {
            Bukkit.getServer().broadcastMessage(message);
        } else {
            Bukkit.getServer().broadcastMessage(ChatColor.RED + message);
        }
    }
    
    public static void bcastMsg(String message) {
        bcastMsg(message, false);
    }
}
