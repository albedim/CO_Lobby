package it.craftopoly.co_lobby.listener;

import it.craftopoly.co_lobby.gui.MenuGUI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class ItemDropEvent implements Listener
{

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent e)
    {
        e.setCancelled(Utils.isInLobby(e.getPlayer()));
    }
}
