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

import java.util.List;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.*;

public class Main extends JavaPlugin
{
    public static Main plugin;
    protected static String pName;
    protected static String pVersion;
    protected static List<String> pAuthors;
    public static final String CONFIG_FILE = "config.yml";
    public static final String MSG_NO_PERMS = ChatColor.RED + "You don't have permission to use this command!";
    
    @Override
    public void onLoad() {
        Main.plugin = this;
        pName = this.getDescription().getName();
        pVersion = this.getDescription().getVersion();
        pAuthors = this.getDescription().getAuthors();
    }
    
    @Override
    public void onEnable()
    {
        FOPMLog.info(String.format("[%s] version %s by %s has been enabled!", pName, pVersion, pAuthors.toString()));
        FOP_Services.start();
    }
    @Override
    public void onDisable()
    {
        FOP_Services.stop();
        FOPMLog.info(String.format("[%s] has been disabled", pName));
    }
}