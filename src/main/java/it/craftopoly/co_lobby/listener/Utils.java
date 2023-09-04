package it.craftopoly.co_lobby.listener;

import it.craftopoly.co_lobby.CO_Lobby;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Utils
{

    private static final FileConfiguration LOBBY_CONFIG = CO_Lobby.getInstance().getConfig();

    public static boolean isInLobby(Player player)
    {
        return player.getLocation().getX() > Double.parseDouble(LOBBY_CONFIG.getString("lobby.min_x")) &&
                player.getLocation().getX() < Double.parseDouble(LOBBY_CONFIG.getString("lobby.max_x")) &&
                player.getLocation().getZ() > Double.parseDouble(LOBBY_CONFIG.getString("lobby.min_z")) &&
                player.getLocation().getZ() < Double.parseDouble(LOBBY_CONFIG.getString("lobby.max_z"));
    }
}
