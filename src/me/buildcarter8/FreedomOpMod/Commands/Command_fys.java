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

package me.buildcarter8.FreedomOpMod.Commands;

import me.buildcarter8.FreedomOpMod.*;
import me.buildcarter8.FreedomOpMod.Banning.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

@CommandParameters(name="fys", description="For the bad admins.", usage="/<command> <player>", source=SourceType.ONLY_CONSOLE, level=AdminLevel.SENIOR, aliases="oblivion")
public class Command_fys {
    public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
        if (args.length != 1) {
            return false;
        }
        
        Player t = Bukkit.getPlayer(args[0]);
        
        if (t == null) {
            sender.sendMessage("That player is not online!");
            return true;
        }
        
        FOP_Util.adminAction(sender, "Preparing " + t.getName() + "\'s anus for destruction.");
        FOP_Util.bcastMsg(t.getName() + " will be completely humiliated!");
        
        //Remove player from admin list
        if (FOP_AdminList.isAdmin(t)) {
            FOP_AdminList.remove(t.getName());
        }
        
        t.setOp(false);
        
        new BukkitRunnable() {
            @Override
            public void run() {
                int x = 0;
                do {
                    t.getWorld().strikeLightning(t.getLocation());
                    x++;
                } while (x <= 20);
                t.setFireTicks(1000);
                t.setHealth(0.0);
            }
        }.runTaskLater(Main.plugin, 2L * 20L);
        
        new BukkitRunnable() {
            @Override
            public void run() {
                String name = t.getName().trim();
                String IP = t.getAddress().getAddress().getHostAddress().trim();
                String reason = "Chill the fuck out and go fuck yourself you cunt.";
                String adminName = sender.getName();
                BanList.add(name, IP, reason, adminName);
                t.kickPlayer(ChatColor.RED + "Chill the fuck out and go fuck yourself you cunt.");
            }
        }.runTaskLater(Main.plugin, 4L * 20L);
        return true;
    }
}
