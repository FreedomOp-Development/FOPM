package me.buildcarter8.FreedomOpMod.Commands;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.bukkit.command.CommandMap;
import me.buildcarter8.FreedomOpMod.FOPMLog;
import me.buildcarter8.FreedomOpMod.Main;
import org.bukkit.*;

public class CommandLoader {
    private static CommandMap cmap = getCommandMap();
    private static final ArrayList<String> COMMANDS = new ArrayList<>();
    
    public CommandLoader() {
        registerCommands();
    }
    
    public static void unregisterCommands() {
        COMMANDS.stream().map((name) -> cmap.getCommand(name)).forEachOrdered((cmd) -> {
            cmd.unregister(cmap);
        });
            
    }
    
    public static void registerCommands() {
        try {
            Pattern PATTERN = Pattern.compile("me/buildcarter8/FreedomOpMod/Commands/(Command_[^\\$])\\.class");
            CodeSource cs = Main.class.getProtectionDomain().getCodeSource();
            if (cs != null) {
                ZipInputStream zip = new ZipInputStream(cs.getLocation().openStream());
                ZipEntry zipEntry;
                while ((zipEntry = zip.getNextEntry()) != null) {
                    String entryName = zipEntry.getName();
                    Matcher matcher = PATTERN.matcher(entryName);
                    if (matcher.find()) {
                        try {
                            Class<?> cmdClass = Class.forName("ns.jovial.althuen.commands." + matcher.group(1));
                            if (cmdClass.isAnnotationPresent(CommandParameters.class)) {
                                Annotation annotation = cmdClass.getAnnotation(CommandParameters.class);
                                CommandParameters params = (CommandParameters) annotation;
                                FOPCommand cmd = new CommandTemplate(params.name(), params.description(), params.usage(), params.source(), params.level(), Arrays.asList(params.aliases().split(", ")), cmdClass);
                                cmd.register();
                                COMMANDS.add(cmd.command);
                            }
                            else {
                                Constructor construct = cmdClass.getConstructor();
                                FOPCommand command = (FOPCommand) construct.newInstance();
                                command.register();
                                COMMANDS.add(command.command);
                            }
                        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                            FOPMLog.severe(ex);
                        }
                    }
                }
            }
        } catch (IOException ex) {
            FOPMLog.severe(ex);
        }
    }
    
    private static CommandMap getCommandMap() {
        if (cmap == null) {
            try {
                final Field f = Bukkit.getServer().getClass().getDeclaredField("commandMap");
                f.setAccessible(true);
                cmap = (CommandMap) f.get(Bukkit.getServer());
                return getCommandMap();
            } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
                FOPMLog.severe(e);
            }
        }
        else if (cmap != null) {
            return cmap;
        }
        return getCommandMap();
    }
    
}
