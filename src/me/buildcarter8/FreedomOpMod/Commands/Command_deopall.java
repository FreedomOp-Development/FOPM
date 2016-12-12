package me.buildcarter8.FreedomOpMod.Commands;

import java.util.Collection;
import me.buildcarter8.FreedomOpMod.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

@CommandParameters(name="deopall", description="Deop all players on the server.", usage="/<command> [-s]", source=SourceType.BOTH, level=AdminLevel.SUPER)
public class Command_deopall {
    public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
        Collection<? extends Player> players = Bukkit.getOnlinePlayers();
        
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("-s")) {
                players.forEach((p) -> {
                   p.setOp(false);
                   p.setGameMode(GameMode.SURVIVAL);
                });
            }
        }
        
        if (args.length != 1) {
            players.forEach((p) -> {
               p.setOp(false); 
            });
        }
        
        FOP_Util.adminAction(sender, "Opping all players on the server.");
        return true;
    }
}
