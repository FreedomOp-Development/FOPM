/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.buildcarter8.FreedomOpMod.Commands;

import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

@CommandParameters(name="spectator", description="Set your gamemode to spectator.", usage="/<command>", source=SourceType.ONLY_IN_GAME, level=AdminLevel.SUPER, aliases="gmsp")
public class Command_spectator {
    public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
        Player p = (Player) sender;
        p.setGameMode(GameMode.SPECTATOR);
        p.sendMessage("Successfully changed your gamemode to SPECTATOR.");
        return true;
    }
}
