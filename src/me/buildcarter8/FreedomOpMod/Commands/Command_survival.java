/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.buildcarter8.FreedomOpMod.Commands;

import me.buildcarter8.FreedomOpMod.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

@CommandParameters(name="survival", description="Set your or another player's gamemode to survival.", usage="/<command> [player]", source=SourceType.ONLY_IN_GAME, level=AdminLevel.OP, aliases="gms")
public class Command_survival {
    public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
        Player p = (Player) sender;
        
        if (args.length == 1) {
            if (!FOP_AdminList.isAdmin(p)) {
                p.sendMessage(Main.MSG_NO_PERMS);
                return true;
            }
            Player t = Bukkit.getPlayer(args[0]);
            if (t == null) {
                p.sendMessage("That player is not online!");
                return true;
            }
            t.setGameMode(GameMode.SURVIVAL);
            t.sendMessage("Your gamemode has been set to SURVIVAL by " + p.getName());
            p.sendMessage("You have successfully changed " + t.getName() + "\'s gamemode to SURVIVAL.");
            return true;
        }
        
        p.setGameMode(GameMode.SURVIVAL);
        p.sendMessage("You have successfully changed your gamemode to SURVIVAL.");
        return true;
    }
}
