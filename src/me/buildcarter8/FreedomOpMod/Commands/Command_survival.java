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
