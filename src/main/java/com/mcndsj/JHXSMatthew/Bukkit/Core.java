package com.mcndsj.JHXSMatthew.Bukkit;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Matthew on 2016/4/14.
 */
public class Core extends JavaPlugin{
    private static Core instance;
    public void onEnable(){
        instance = this;
    }

    public Core getInstance(){
        return instance;
    }


}
