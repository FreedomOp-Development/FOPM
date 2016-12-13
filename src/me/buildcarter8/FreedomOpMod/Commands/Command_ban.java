package me.buildcarter8.FreedomOpMod.Commands;

import me.buildcarter8.FreedomOpMod.*;
import me.buildcarter8.FreedomOpMod.Banning.BanList;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

@CommandParameters(name="ban", description="Bans a player.", usage="/<command> <player> [reason]", source=SourceType.BOTH, level=AdminLevel.SUPER)
public class Command_ban {
    public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
        if (args.length > 2) {
            Player t = Bukkit.getPlayer(args[0]);
            String reason = StringUtils.join(args[1].split(" "));
            if (t == null) {
                sender.sendMessage("That player cannot be found!");
                return true;
            }
            if (t == sender) {
                sender.sendMessage("Please, don't try to ban yourself.");
                return true;
            }
            if (FOP_AdminList.isAdmin(t)) {
                sender.sendMessage("That player is an admin, and cannot be banned. Use /doom for that.");
                return true;
            }
            String name = t.getName().trim();
            String IP = t.getAddress().getAddress().getHostAddress().trim();
            FOP_Util.bcastMsg(name + " has been a VERY naughty, naughty boy!");
            FOP_Util.adminAction(sender, "Banning: " + name + " and IP(s):" + IP);
            BanList.add(name, IP, reason, sender.getName());
            t.kickPlayer(reason + "\n" + "Banned by: " + sender.getName());
        }
        if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            String reason = "You have been temporarily banned from this server.\n" + "Banned by: " + sender.getName();
            if (target == null) {
                sender.sendMessage("That player cannot be found!");
                return true;
            }
            if (target == sender) {
                sender.sendMessage("Please, don't try to ban yourself.");
                return true;
            }
            if (FOP_AdminList.isAdmin(target)) {
                sender.sendMessage("That player is an admin, and cannot be banned. Use /doom instead.");
                return true;
            }
            String name = target.getName().trim();
            String IP = target.getAddress().getAddress().getHostAddress().trim();
            FOP_Util.bcastMsg(name + " has been a VERY bitchy boy!");
            FOP_Util.adminAction(sender, "Banning: " + name + " and IP(s): " + IP);
            BanList.add(name, IP, reason, sender.getName());
            target.kickPlayer(reason + "\n" + "Banned by: " + sender.getName());
        }
        else { return false; }
        
        return true;
    }
}
