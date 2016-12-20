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
