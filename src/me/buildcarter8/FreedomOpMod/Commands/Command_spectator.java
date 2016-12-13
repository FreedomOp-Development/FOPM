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
