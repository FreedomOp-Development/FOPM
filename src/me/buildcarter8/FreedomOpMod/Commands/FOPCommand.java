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

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import me.buildcarter8.FreedomOpMod.FOPMLog;
import me.buildcarter8.FreedomOpMod.FOP_AdminList;
import me.buildcarter8.FreedomOpMod.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.command.TabExecutor;

public abstract class FOPCommand implements CommandExecutor, TabExecutor
{

    protected static CommandMap cmap;
    protected final String command;
    protected final String description;
    protected final List<String> alias;
    protected final String usage;
    protected SourceType source;
    protected AdminLevel level;

    public FOPCommand(String command, String usage, String description, SourceType source, AdminLevel level, List<String> aliases)
    {
        this.command = command.toLowerCase();
        this.usage = usage;
        this.description = description;
        this.source = source;
        this.level = level;
        this.alias = aliases;
    }

    public void register()
    {
        ReflectCommand cmd = new ReflectCommand(this.command);
        if (this.alias != null) {
            cmd.setAliases(this.alias);
        }
        if (this.description != null) {
            cmd.setDescription(this.description);
        }
        if (this.usage != null) {
            cmd.setUsage(this.usage);
        }
        if (!getCommandMap().register("", cmd)) {
            this.unRegisterBukkitCommand(Bukkit.getPluginCommand(cmd.getName()));
            getCommandMap().register("", cmd);
        }
        cmd.setExecutor(this);
    }

    final CommandMap getCommandMap() {
        if (cmap == null) {
            try {
                final Field f = Bukkit.getServer().getClass().getDeclaredField("commandMap");
                f.setAccessible(true);
                cmap = (CommandMap) f.get(Bukkit.getServer());
                return getCommandMap();
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
                FOPMLog.severe(e);
            }
        }
        else if (cmap != null) {
            return cmap;
        }
        return getCommandMap();
    }

    @Override
    public abstract boolean onCommand(CommandSender sender, Command cmd, String label, String[] args);

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        return null;
    }

    private Object getPrivateField(Object object, String field) throws SecurityException,
            NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Class<?> cls = object.getClass();
        Field objectField = cls.getDeclaredField(field);
        objectField.setAccessible(true);
        Object result = objectField.get(object);
        objectField.setAccessible(false);
        return result;
    }

    private void unRegisterBukkitCommand(PluginCommand cmd) {
        try {
            Object result = getPrivateField(Main.plugin.getServer().getPluginManager(), "commandMap");
            SimpleCommandMap commandMap = (SimpleCommandMap) result;
            Object map = getPrivateField(commandMap, "knownCommands");
            @SuppressWarnings("unchecked")
            HashMap<String, Command> knownCommands = (HashMap<String, Command>) map;
            knownCommands.remove(cmd.getName());
            cmd.getAliases().forEach((registeredalias) -> {
                knownCommands.remove(registeredalias);
            });
        } catch (SecurityException | IllegalArgumentException | NoSuchFieldException | IllegalAccessException e) {
            FOPMLog.severe(e);
        }
    }

    public final class ReflectCommand extends Command {

        private FOPCommand exe = null;

        protected ReflectCommand(String command) {
            super(command);
        }

        public void setExecutor(FOPCommand exe) {
            this.exe = exe;
        }

        @Override
        public boolean execute(CommandSender sender, String commandLabel, String[] args) {
            if (exe != null) {
                if (!FOP_AdminList.isAdmin(sender) && (level == AdminLevel.SUPER)) {
                    sender.sendMessage(Main.MSG_NO_PERMS);
                    return true;
                }
                
                if (!FOP_AdminList.isSeniorAdmin(sender) && (level == AdminLevel.SENIOR)) {
                    sender.sendMessage(Main.MSG_NO_PERMS);
                    return true;
                }
                if (!exe.onCommand(sender, this, commandLabel, args)) {
                    sender.sendMessage(this.usageMessage.replaceAll("<command>", command));
                    return false;
                }
                return true;
            }
            return false;
        }

        @Override
        public List<String> tabComplete(CommandSender sender, String alias, String[] args) {
            if (exe != null) {
                return exe.onTabComplete(sender, this, alias, args);
            }
            return null;
        }
    }
}