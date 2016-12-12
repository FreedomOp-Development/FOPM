/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.buildcarter8.FreedomOpMod;

import org.bukkit.*;
import org.bukkit.command.*;

public class FOP_AdminList {
    private static boolean isAdmin;
    private static boolean isSeniorAdmin;
    
    public static void add(String name) {
        
    }
    
    public static boolean isAdmin(CommandSender sender) {
        
        
        return isAdmin;
    }
    
    public static boolean isSeniorAdmin(CommandSender sender) {
        if (isAdmin(sender)) {
            
        }
        
        return isSeniorAdmin;
    }
    
    
}
