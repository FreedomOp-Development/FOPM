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
package me.buildcarter8.FreedomOpMod;

import me.buildcarter8.FreedomOpMod.Commands.CommandLoader;
import me.buildcarter8.FreedomOpMod.Listeners.*;
import org.bukkit.plugin.PluginManager;

/**
 *
 * @author FreedomOp Development
 */
public class FOP_Services {
    protected static PluginManager pm = Main.plugin.getServer().getPluginManager();
    protected static CommandLoader cload;
    protected static FOP_ChatListener cl;
    protected static FOP_ServerListener sl;
    protected static FOP_WorldListener wl;
    protected static FOP_PlayerListener pl;
    
    public static void start() {
        cload = new CommandLoader();
        pm.registerEvents(cl, Main.plugin);
        pm.registerEvents(sl, Main.plugin);
        pm.registerEvents(pl, Main.plugin);
        pm.registerEvents(wl, Main.plugin);
        
    }
    
    public static void stop() {
        //methods
    } 
}
