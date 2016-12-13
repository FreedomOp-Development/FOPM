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
