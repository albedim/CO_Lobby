package it.craftopoly.co_lobby.listener;

import it.craftopoly.co_lobby.gui.MenuGUI;
import it.craftopoly.co_lobby.utils.Utils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class ConsumeEvent implements Listener
{
    private MenuGUI gui;

    @EventHandler
    public void onConsume(PlayerInteractEvent e)
    {
        Player player = e.getPlayer();
        if(player.getInventory().getItemInMainHand().getType().equals(Material.COMPASS)){
            gui = new MenuGUI(player);
            gui.open();
        }
    }
}
