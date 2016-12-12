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
