/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.buildcarter8.FreedomOpMod.Commands;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

@Retention(RetentionPolicy.RUNTIME)
public @interface CommandParameters {
    String name();
    
    String description();
    
    String usage();
    
    SourceType source() default SourceType.BOTH;
    
    AdminLevel level() default AdminLevel.OP;
    
    String aliases() default "";
}
