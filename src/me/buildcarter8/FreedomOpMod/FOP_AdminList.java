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

import java.io.File;
import java.io.IOException;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.ConfigurationSection;

public class FOP_AdminList {
    private static boolean isAdmin;
    private static boolean isTelnetAdmin;
    private static boolean isSeniorAdmin;
    private static boolean isSystemAdmin;
    private static boolean isOfficer;
    
    protected static File ADMIN_LIST = new File("admins.yml");
    protected static YamlConfiguration yaml;
    
    public static void add(String name) {
        //methods
    }
    
    public static void remove(String name) {
        //methods
    }
    
    public static YamlConfiguration saveDefaultConfig() {
        yaml = YamlConfiguration.loadConfiguration(ADMIN_LIST);
        try {
            yaml.options().copyDefaults();
            yaml.save(ADMIN_LIST);
        } catch (IOException ex) {
            FOPMLog.severe(ex);
        }
        return yaml;
    }
    
    public static YamlConfiguration getAdminList() {
        yaml = YamlConfiguration.loadConfiguration(ADMIN_LIST);
        return yaml;
    }
    
    public static boolean isAdmin(CommandSender sender) {
        isAdmin = FOP_AdminList.getAdminList().contains(sender.getName());
        return isAdmin;
    }
    
    public static boolean isTelnetAdmin(CommandSender sender) {  
        if (!isAdmin(sender)) {
            isTelnetAdmin = false;
        }
        boolean is_telnet_admin = yaml.getConfigurationSection(sender.getName()).getBoolean("is_telnet_admin");
        isTelnetAdmin = is_telnet_admin;
        return isTelnetAdmin;
    }
    
    public static boolean isSeniorAdmin(CommandSender sender) {
        if (!isTelnetAdmin(sender)) {
            isSeniorAdmin = false;
        }
        
        boolean is_senior_admin = yaml.getConfigurationSection(sender.getName()).getBoolean("is_senior_admin");
        isSeniorAdmin = is_senior_admin;
        return isSeniorAdmin;
    }
    
    public static boolean isSystemAdmin(CommandSender sender) {
        if (!isSeniorAdmin(sender)) {
            isSystemAdmin = false;
        }
        boolean is_system_admin = yaml.getConfigurationSection(sender.getName()).getBoolean("is_system_admin");
        isSystemAdmin = is_system_admin;
        return isSystemAdmin;
    }
    
    public static boolean isOfficer(CommandSender sender) {
        if (!isSystemAdmin(sender)) {
            isOfficer = false;
        }
        boolean is_officer = yaml.getConfigurationSection(sender.getName()).getBoolean("is_officer");
        isOfficer = is_officer;
        return isOfficer;
    }
}
