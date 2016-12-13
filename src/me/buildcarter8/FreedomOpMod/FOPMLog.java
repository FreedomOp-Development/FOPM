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

import java.util.logging.Logger;
import java.util.logging.Level;

public class FOPMLog {
    
    public static final Logger BACKUP = Logger.getLogger("Minecraft-Server");
    public static Logger pLogger = null;
    public static Logger sLogger = null;
    
    private FOPMLog() {
        throw new AssertionError();
    }
    
    // Logging level @ info
    public static void info(String message) {
        info(message, false);
    }
    
    public static void info(String message, Boolean raw) {
        log(Level.INFO, message, raw);
    }
    
    public static void info(Throwable ex) {
        log(Level.INFO, ex);
    }
    
    //Logging level @ warning
    public static void warning(String message) {
        warning(message, false);
    }
    
    public static void warning(String message, Boolean raw) {
        log(Level.WARNING, message, raw);
    }
    
    public static void warning(Throwable ex) {
        log(Level.WARNING, ex);
    }
    
    // Logging level @ Severe
    public static void severe(String message) {
        severe(message, false);
    }
    
    public static void severe(String message, Boolean raw) {
        log(Level.SEVERE, message, raw);
    }
    
    public static void severe(Throwable ex) {
        log(Level.SEVERE, ex);
    }
    
    // Utilities
    private static void log(Level level, String message, boolean raw)
    {
        getLogger(raw).log(level, message);
    }

    private static void log(Level level, Throwable throwable)
    {
        getLogger(false).log(level, null, throwable);
    }

    public static void setServerLogger(Logger logger) {
        sLogger = logger;
    }

    public static void setPluginLogger(Logger logger) {
        pLogger = logger;
    }

    private static Logger getLogger(boolean raw) {
        if (raw || pLogger == null) {
            return (sLogger != null ? sLogger : BACKUP);
        }
        else {
            return pLogger;
        }
    }

    public static Logger getPluginLogger() {
        return (pLogger != null ? pLogger : BACKUP);
    }

    public static Logger getServerLogger() {
        return (sLogger != null ? sLogger : BACKUP);
    }
}
