package it.craftopoly.co_lobby.listener;

import it.craftopoly.co_lobby.utils.ElementsUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class JoinEvent implements Listener
{
    @EventHandler
    public void onJoin(PlayerJoinEvent e)
    {
        Player player = e.getPlayer();

        ItemStack itemStack = ElementsUtils.createCustomElement(
                Material.COMPASS,
                (short) 1,
                1,
                null,
                "§7Menu"
        );

        player.getInventory().setItem(4, itemStack);
    }
}
