package com.mcndsj.JHXSMatthew.SQL_Lib;

import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin{
	private static Core instance ;
	
	public void onEnable(){
		instance = this;
		iniMoney();
	}
	
	public static Core getApi(){
		return instance;
	}
	
	public void iniMoney(){
		MoneyManager.getInstance();
	}

}
