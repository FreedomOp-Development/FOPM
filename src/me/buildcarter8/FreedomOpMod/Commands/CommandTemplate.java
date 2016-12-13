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

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import me.buildcarter8.FreedomOpMod.*;
import org.bukkit.command.*;

public class CommandTemplate extends FOPCommand {
    Class cls;
    Object object;

    public CommandTemplate(String name, String usage, String description, SourceType source, AdminLevel level, List<String> aliases, Class cls) throws NoSuchMethodException {
        super(name, usage, description, source, level, aliases);
        this.cls = cls;
        try {
            this.object = cls.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            FOPMLog.severe(ex);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        try {
            return (boolean) cls.getMethod("onCommand", CommandSender.class, Command.class, String.class, String[].class).invoke(object, sender, cmd, label, args);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            FOPMLog.severe(ex);
        }
        return false;
    }
}
