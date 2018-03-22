package com.nukeit5093.tntcalc;

import org.bukkit.plugin.java.JavaPlugin;

public class TntCalc extends JavaPlugin{

    @Override
    public void onEnable(){
        getCommand("tntcalc").setExecutor(new CommandHandler());
    }



}
