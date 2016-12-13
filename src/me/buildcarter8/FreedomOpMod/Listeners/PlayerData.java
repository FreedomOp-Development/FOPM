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

import org.bukkit.entity.Player;
/**
 *
 * @author FreedomOp Development
 */
public class PlayerData {
    protected static boolean adminChat;
    
    public static PlayerData getPlayerData(Player p) {
        
        return null;
    }
    
    public void setAdminChat(boolean admin_chat) {
        adminChat = admin_chat;
    }
    
    public boolean inAdminChat() {
        return adminChat;
    }
}
