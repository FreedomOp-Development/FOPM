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

package me.buildcarter8.FreedomOpMod.Banning;

import java.io.File;
import java.util.Date;
import org.bukkit.*;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.Configuration;

public class BanList {
    private static final File BANLIST = new File("banned-players.yml");
    protected static final YamlConfiguration YAML = YamlConfiguration.loadConfiguration(BANLIST);
    protected static Configuration defaults;
    
    public static void add(String name, String IP, String reason, String adminName) {
        //methods here
    }
}
