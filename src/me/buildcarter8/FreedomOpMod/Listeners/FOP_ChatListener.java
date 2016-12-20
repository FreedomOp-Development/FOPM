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
package me.buildcarter8.FreedomOpMod.Listeners;

import me.buildcarter8.FreedomOpMod.FOP_Util;
import me.buildcarter8.FreedomOpMod.PlayerData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.entity.Player;
/**
 *
 * @author FreedomOp Development
 */
public class FOP_ChatListener implements Listener {
    public FOP_ChatListener() {
        throw new UnsupportedOperationException("This method has not been implemented yet!");
    }
    
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        PlayerData pd = PlayerData.getPlayerData(p);
        if (pd.inAdminChat()) {
            e.setCancelled(true);
            FOP_Util.adminChat(p, e.getMessage());
        }
    }
}
