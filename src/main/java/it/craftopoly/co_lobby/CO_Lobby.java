package it.craftopoly.co_lobby;

import it.craftopoly.co_lobby.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

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
        sendBroadcastMessages();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static CO_Lobby getInstance()
    {
        return plugin;
    }

    private void sendBroadcastMessages()
    {
        List<String> broadcastMessages = CO_Lobby.getInstance().getConfig().getStringList("bcs");
        List<Integer> sentBroadcastMessages = new ArrayList<>();

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                int counter = (int) Math.floor(Math.random() * broadcastMessages.size());

                while(!sentBroadcastMessages.contains(counter) &&
                        sentBroadcastMessages.size() != broadcastMessages.size()) {
                    Bukkit.broadcastMessage(broadcastMessages.get(counter));
                    sentBroadcastMessages.add(counter);
                }

                if(sentBroadcastMessages.size() == broadcastMessages.size())
                    sentBroadcastMessages.clear();
            }
        }.runTaskTimerAsynchronously(
                this,
                Long.parseLong(this.getConfig().getString("bcs_time")),
                Long.parseLong(this.getConfig().getString("bcs_time"))
        );
    }
}
