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
import me.buildcarter8.FreedomOpMod.Listeners.PlayerData;
import org.apache.commons.lang.StringUtils;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
/**
 *
 * @author FreedomOp Development
 */
@CommandParameters(name="adminchat", description="Toggle adminchat, or send a message.", usage="/<command> [message]", source=SourceType.BOTH, level=AdminLevel.SUPER, aliases="ac, ct")
public class Command_adminchat {
    public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
        if (args.length == 0) {
            if (FOP_Util.isConsole(sender)) {
                sender.sendMessage("Only in-game players can toggle admin chat.");
                return true;
            }
            Player  p = (Player) sender;
            PlayerData pd = PlayerData.getPlayerData(p);
            if (!pd.inAdminChat()) {
                pd.setAdminChat(true);
                sender.sendMessage("Now talking in admin chat.");
                return true;
            }
            pd.setAdminChat(false);
            sender.sendMessage("Now talking in regular chat.");
            return true;
        }
        
        FOP_Util.adminChat(sender, StringUtils.join(args));
        return true;
    }
}
