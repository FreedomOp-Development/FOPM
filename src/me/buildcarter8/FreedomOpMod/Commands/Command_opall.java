package me.buildcarter8.FreedomOpMod.Commands;

import java.util.Collection;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import me.buildcarter8.FreedomOpMod.*;

@CommandParameters(name="opall", description="Op all players on the server", usage="/<command> [-c, -s]", source=SourceType.BOTH, level=AdminLevel.SUPER)
public class Command_opall {
    public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
        Collection<? extends Player> players = Bukkit.getServer().getOnlinePlayers();
        
        if (args.length == 1) {
            switch (args[0]) {
                case "-c":
                    players.forEach((p) -> {
                        p.setOp(true);
                        p.setGameMode(GameMode.CREATIVE);
                    });
                    break;
                case "-s":
                    players.forEach((p) -> {
                        p.setOp(true);
                        p.setGameMode(GameMode.SURVIVAL);
                    });
                    break;
            }
        }
        
        if (args.length != 1) {
            players.forEach((p) -> {
               p.setOp(true); 
            });
        }
        
        FOP_Util.adminAction(sender, "Opping all players on the server.");
        
        return true;
    }
}
