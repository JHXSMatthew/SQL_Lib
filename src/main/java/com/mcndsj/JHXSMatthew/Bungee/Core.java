package com.mcndsj.JHXSMatthew.Bungee;

import net.md_5.bungee.api.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Matthew on 2016/4/14.
 */
public class Core extends Plugin{
    private static Core instance;
    public void onEnable(){
        instance = this;
    }

    public Core getInstance(){
        return instance;
    }


}
