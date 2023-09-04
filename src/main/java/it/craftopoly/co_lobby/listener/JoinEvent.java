package it.craftopoly.co_lobby.listener;

import it.craftopoly.co_lobby.CO_Lobby;
import it.craftopoly.co_lobby.utils.ElementsUtils;
import org.bukkit.Location;
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

        player.teleport(
                new Location(
                    player.getWorld(),
                        (
                                Double.parseDouble(CO_Lobby.getInstance().getConfig().getString("lobby.min_x")) +
                                Double.parseDouble(CO_Lobby.getInstance().getConfig().getString("lobby.max_x"))
                        ) / 2,
                        Double.parseDouble(CO_Lobby.getInstance().getConfig().getString("lobby.y")),
                        (
                                Double.parseDouble(CO_Lobby.getInstance().getConfig().getString("lobby.min_z")) +
                                Double.parseDouble(CO_Lobby.getInstance().getConfig().getString("lobby.max_z"))
                        ) / 2
                )
        );
        player.getInventory().setItem(4, itemStack);
    }
}
