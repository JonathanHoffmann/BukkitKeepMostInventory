package me.Jonnyfant.KeepMostInventory;

import org.bukkit.plugin.java.JavaPlugin;

public class KeepMostInventory extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new DeathListener(),this);
    }
}
