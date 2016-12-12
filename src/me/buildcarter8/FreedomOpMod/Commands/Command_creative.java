package me.buildcarter8.FreedomOpMod.Commands;

import me.buildcarter8.FreedomOpMod.FOP_AdminList;
import me.buildcarter8.FreedomOpMod.Main;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

@CommandParameters(name="creative", description="Set your or another player's gamemode to creative.", usage="/<command> [player]", source=SourceType.ONLY_IN_GAME, level=AdminLevel.OP, aliases="gmc")
public class Command_creative {
    public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
        Player p = (Player) sender;
        
        if (args.length == 1) {
            if (!FOP_AdminList.isAdmin(p)) {
                p.sendMessage(Main.MSG_NO_PERMS);
                return true;
            }
            
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                p.sendMessage("The player specified is not online!");
                return true;
            }
            target.setGameMode(GameMode.CREATIVE);
            target.sendMessage("Your gamemode has been set to creative by " + p.getName());
            p.sendMessage("Successfully set " + target.getName() + "\'s gamemode to CREATIVE");
            return true;
        }
        p.setGameMode(GameMode.CREATIVE);
        p.sendMessage("Changed your gamemode to CREATIVE");
        
        return true;
    }
}
