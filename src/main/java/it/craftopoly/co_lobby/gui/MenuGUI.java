package it.craftopoly.co_lobby.gui;

import com.google.gson.JsonObject;
import it.craftopoly.co_lobby.schema.User;
import it.craftopoly.co_lobby.utils.DateUtils;
import it.craftopoly.co_lobby.utils.ElementsUtils;
import it.craftopoly.co_lobby.utils.HttpCall;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;


public class MenuGUI
{
    private Player player;


    public MenuGUI(Player player) { this.player = player; }

    public void open()
    {
        Inventory inv = Bukkit.createInventory(null, 45, "§7Menu");
        JsonObject user = HttpCall.getUser(this.player.getName());
        inv.setItem(
                20,
                ElementsUtils.createCustomElement(
                        Material.SLIME_BLOCK,
                        (short) 1,
                        1,
                        ElementsUtils.createLore(
                                "§8▪ §7Guadagna soldi e investi nelle tue proprietà",
                                        "  §7passa alla città successiva e supera le task con gli",
                                        "  §7altri giocatori, Sei pronto a diventare il più ricco",
                                        "  §7della città? Il §a1° §7Monopoly su minecraft è arrivato!"
                        ),
                        "§aEntra su Craftopoly"
                )
        );
        inv.setItem(
                22,
                ElementsUtils.createCustomSkull(
                        player.getName(),
                        ElementsUtils.createLore(
                                "§8▪ §7Nome: §a"+user.get("username").getAsString(),
                                "§8▪ §7Gioca dal: §a"+ DateUtils.fixDate(user.get("created_on").getAsString()),
                                "§8▪ §7Livello: §a"+user.get("level")
                        ),
                        "§aInfo giocatore"
                )
        );
        inv.setItem(
                24,
                ElementsUtils.createCustomElement(
                        Material.LIME_STAINED_GLASS_PANE,
                        (short) 1,
                        1,
                        ElementsUtils.createLore(
                                "§8▪ §7Premi qui se vuoi rimanere aggiornato ",
                                        "  §7su tutti gli eventi e le novità del server!"
                        ),
                        "§aResta aggiornato"
                )
        );
        this.player.openInventory(inv);
    }



}
