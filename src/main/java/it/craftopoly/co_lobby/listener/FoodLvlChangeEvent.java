package it.craftopoly.co_lobby.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLvlChangeEvent implements Listener
{

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent e)
    {
        if(e.getEntity() instanceof Player)
            e.setCancelled(Utils.isInLobby(((Player) e.getEntity())));
    }
}
