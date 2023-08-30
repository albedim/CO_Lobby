package it.craftopoly.co_lobby.gui;

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
        User user = HttpCall.getUser(this.player.getName());
        inv.setItem(
                20,
                ElementsUtils.createCustomElement(
                        Material.SLIME_BLOCK,
                        (short) 1,
                        1,
                        ElementsUtils.createLore(
                                "§8• §7Guadagna soldi e investi nelle tue proprietà",
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
                                "§8• §7Nome: §a"+user.getUsername(),
                                "§8• §7Gioca dal: §a"+ DateUtils.fixDate(user.getCreatedOn()),
                                "§8• §7Livello: §a"+user.getLevel()
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
                                "§8• §7Premi qui se vuoi rimanere aggiornato ",
                                        "  §8su tutti gli eventi e le novità del server!"
                        ),
                        "§aResta aggiornato"
                )
        );
        this.player.openInventory(inv);
    }



}
