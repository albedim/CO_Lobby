package it.craftopoly.co_lobby;

import it.craftopoly.co_lobby.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CO_Lobby extends JavaPlugin {

    private static CO_Lobby plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new InventoryEvent(), this);
        Bukkit.getPluginManager().registerEvents(new DamageGetEvent(), this);
        Bukkit.getPluginManager().registerEvents(new FoodLvlChangeEvent(), this);
        Bukkit.getPluginManager().registerEvents(new ItemDropEvent(), this);
        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new ConsumeEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static CO_Lobby getInstance()
    {
        return plugin;
    }
}
