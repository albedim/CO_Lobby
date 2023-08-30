package it.craftopoly.co_lobby.listener;

import it.craftopoly.co_lobby.CO_Lobby;
import it.craftopoly.co_lobby.utils.Utils;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryEvent implements Listener
{

    @EventHandler
    public void onClick(InventoryClickEvent e)
    {
        Player player = Bukkit.getPlayer(e.getWhoClicked().getName());

        if(player == null)
            return;

        if(e.getView().getTitle().equals("§7Menu"))
        {
            if(e.getCurrentItem().getType().equals(Material.LIME_STAINED_GLASS_PANE))
            {
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 300, 300);
                player.sendMessage("§8-------------------------------------");
                Utils.sendMessage(
                        player,
                        CO_Lobby.getInstance().getConfig().getString("messages.follow_social")
                                .replace("{username}", player.getName())
                );
                sendInteractiveMessages(player);
                player.sendMessage("§8-------------------------------------");
                e.getView().close();
            }
            e.setCancelled(true);
        }
    }

    private static void sendInteractiveMessages(Player player)
    {                TextComponent website = Utils.createInteractiveMessage(
            "§7Vai al nostro sito",
            ClickEvent.Action.OPEN_URL,
            "  §8• §aSito, Store & Forum_",
            CO_Lobby.getInstance().getConfig().getString("links.website")
    );
        TextComponent discord = Utils.createInteractiveMessage(
                "§7Entra nel nostro server discord",
                ClickEvent.Action.OPEN_URL,
                "  §8• §aDiscord",
                CO_Lobby.getInstance().getConfig().getString("links.discord")
        );
        TextComponent telegram = Utils.createInteractiveMessage(
                "§7Entra nel nostro canale telegram",
                ClickEvent.Action.OPEN_URL,
                "  §8• §aTelegram",
                CO_Lobby.getInstance().getConfig().getString("links.telegram")
        );
        TextComponent tiktok = Utils.createInteractiveMessage(
                "§7FSeguici su tiktok",
                ClickEvent.Action.OPEN_URL,
                "  §8• §aTikTok",
                CO_Lobby.getInstance().getConfig().getString("links.tiktok")
        );
        player.spigot().sendMessage(website);
        player.spigot().sendMessage(discord);
        player.spigot().sendMessage(telegram);
        player.spigot().sendMessage(tiktok);
    }
}


