/*
 * Copyright 2016 FreedomOp Development.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.buildcarter8.FreedomOpMod;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class FOP_Util {
    protected static String prefix;
    protected static final List<String> DEVELOPERS = Arrays.asList("Mafrans");
    protected static boolean isConsole;
    protected static String rank;
    
    private FOP_Util() {
        throw new AssertionError();
    }
    
    public static boolean isConsole(CommandSender sender) {
        isConsole = !(sender instanceof Player);
        return isConsole;
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
    
    public static void adminChat(CommandSender sender, String message) {
        Collection<? extends Player> players = Bukkit.getOnlinePlayers();
        players.forEach((p) -> {
            if (FOP_AdminList.isAdmin(p)) {
                p.sendMessage(ChatColor.WHITE 
                        + "[" 
                        + ChatColor.DARK_AQUA 
                        + "ADMIN" 
                        + ChatColor.WHITE 
                        + "]" 
                        + sender.getName() 
                        + " " 
                        + prefix(sender)
                        + ChatColor.RESET 
                        + ": " 
                        + ChatColor.AQUA 
                        + message);
            } else { /* do nothing */ }
        });
    }
    
    public static String prefix(CommandSender sender) {
        if (DEVELOPERS.contains(sender.getName())) {
            prefix = ChatColor.DARK_GRAY
                    + "[" 
                    + ChatColor.LIGHT_PURPLE
                    + "Developer"
                    + ChatColor.DARK_GRAY
                    + "]";
        }
        
        if (FOP_AdminList.isAdmin(sender)) {
            prefix  = ChatColor.DARK_GRAY 
                    + "[" 
                    + ChatColor.GOLD 
                    + "SA" 
                    + ChatColor.DARK_GRAY 
                    + "]";
        }
        else if (FOP_AdminList.isTelnetAdmin(sender)) {
            prefix = ChatColor.DARK_GRAY 
                    + "[" 
                    + ChatColor.GREEN 
                    + "STA" 
                    + ChatColor.DARK_GRAY 
                    + "]";
        }
        
        else if (FOP_AdminList.isSeniorAdmin(sender)) {
            prefix = ChatColor.DARK_GRAY 
                    + "[" 
                    + ChatColor.LIGHT_PURPLE 
                    + "SrA" 
                    + ChatColor.DARK_GRAY 
                    + "]";
        }
        
        else if (FOP_AdminList.isSystemAdmin(sender)) {
            prefix = ChatColor.DARK_GRAY 
                    + "[" 
                    + ChatColor.DARK_RED 
                    + "SysAdmin" 
                    + ChatColor.DARK_GRAY 
                    + "]";
        }
        
        else if (FOP_AdminList.isOfficer(sender)) {
            if (sender.getName().equalsIgnoreCase("Paldiu")) {
                prefix = ChatColor.DARK_GRAY 
                        + "["
                        + ChatColor.DARK_BLUE
                        + "CEO" 
                        + ChatColor.DARK_GRAY
                        + "]";
            }
            else if (sender.getName().equalsIgnoreCase("CrafterSmith12")) {
                prefix = ChatColor.DARK_GRAY 
                        + "["
                        + ChatColor.DARK_AQUA
                        + "COO"
                        + ChatColor.DARK_GRAY
                        + "]";
            }
            else if (sender.getName().equalsIgnoreCase("EnderLolzeh")) { 
                prefix = ChatColor.DARK_GRAY
                        + "["
                        + ChatColor.DARK_RED 
                        + "CFO" 
                        + ChatColor.DARK_GRAY 
                        + "]";
            }
            else if (sender.getName().equalsIgnoreCase("buildcarter8")) {
                prefix = ChatColor.DARK_GRAY 
                        + "["
                        + ChatColor.DARK_PURPLE
                        + "CDO"
                        + ChatColor.DARK_GRAY
                        + "]";
            }
            else { 
                    prefix = ChatColor.DARK_GRAY 
                    + "[" 
                    + ChatColor.DARK_GREEN 
                    + "Officer" 
                    + ChatColor.DARK_GRAY 
                    + "]"; }
        }
        
        else {
            prefix = ChatColor.DARK_GRAY 
                    + "[" 
                    + ChatColor.RED 
                    + "OP" 
                    + ChatColor.DARK_GRAY 
                    + "]";
        }
        
        return prefix;
    }
    
    public static String getRank(Player p) {
        if (FOP_AdminList.isOfficer(p)) {
            if (p.getName().equalsIgnoreCase("paldiu")) {
                rank = ChatColor.AQUA 
                    + "the " 
                    + ChatColor.DARK_BLUE 
                    + "Chief Executive Officer" 
                    + ChatColor.AQUA 
                    + ".";
            } else if (p.getName().equalsIgnoreCase("craftersmith12")) {
                rank = ChatColor.AQUA 
                    + "the " 
                    + ChatColor.DARK_AQUA 
                    + "Chief Operations Officer" 
                    + ChatColor.AQUA 
                    + ".";
            } else if (p.getName().equalsIgnoreCase("enderlolzeh")) {
                rank = ChatColor.AQUA 
                    + "the " 
                    + ChatColor.DARK_RED 
                    + "Chief Forums Officer" 
                    + ChatColor.AQUA 
                    + ".";
            } else if (p.getName().equalsIgnoreCase("buildcarter8")) {
                rank = ChatColor.AQUA 
                    + "the " 
                    + ChatColor.DARK_PURPLE 
                    + "Chief Development Officer" 
                    + ChatColor.AQUA 
                    + ".";
            } else {
                rank = ChatColor.AQUA 
                    + "an " 
                    + ChatColor.DARK_GREEN 
                    + "Officer" 
                    + ChatColor.AQUA 
                    + ".";
            }
            
        } 
        else if (FOP_AdminList.isSystemAdmin(p)) {
            rank = ChatColor.AQUA 
                    + "a " 
                    + ChatColor.DARK_RED 
                    + "System Admin" 
                    + ChatColor.AQUA 
                    + ".";
        }
        else if (FOP_AdminList.isSeniorAdmin(p)) {
            rank = ChatColor.AQUA 
                    + "a " 
                    + ChatColor.LIGHT_PURPLE 
                    + "Senior Admin" 
                    + ChatColor.AQUA 
                    + ".";
        } 
        else if (FOP_AdminList.isTelnetAdmin(p)) {
            rank = ChatColor.AQUA 
                    + "a " 
                    + ChatColor.GREEN 
                    + "Telnet Admin" 
                    + ChatColor.AQUA 
                    + ".";
        }
        else if (FOP_AdminList.isAdmin(p)) {
            rank = ChatColor.AQUA 
                    + "a " 
                    + ChatColor.GOLD 
                    + "Super Admin" 
                    + ChatColor.AQUA 
                    + ".";
        }
        else {
            if (p.isOp()) {
                rank = ChatColor.AQUA 
                    + "an " 
                    + ChatColor.RED 
                    + "OP" 
                    + ChatColor.AQUA 
                    + ".";
            } else {
                rank = ChatColor.AQUA 
                    + "an " 
                    + ChatColor.WHITE 
                    + "NON-OP" 
                    + ChatColor.AQUA 
                    + ".";
            }
            
        }
        
        return rank;
    }
}
