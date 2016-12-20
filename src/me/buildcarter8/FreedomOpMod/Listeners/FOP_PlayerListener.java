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

import me.buildcarter8.FreedomOpMod.FOP_AdminList;
import me.buildcarter8.FreedomOpMod.FOP_Util;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.EventHandler;
/**
 *
 * @author FreedomOp Development
 */
public class FOP_PlayerListener implements Listener {
    public FOP_PlayerListener() {
        throw new UnsupportedOperationException("This method is not supported yet!");
    }
    
    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent e) {
        Player p = e.getPlayer();
        String name = p.getName().toLowerCase();
        if (FOP_AdminList.getAdminList().contains(name)) {
            if (!FOP_AdminList.getAdminList().getConfigurationSection(name).isString("login_message")) {
                FOP_Util.bcastMsg(name + " is " + FOP_Util.getRank(p));
            } 
            FOP_Util.bcastMsg(name + " is " + FOP_AdminList.getAdminList().getConfigurationSection(name).getString("login_message").trim());
        }
    }
}
