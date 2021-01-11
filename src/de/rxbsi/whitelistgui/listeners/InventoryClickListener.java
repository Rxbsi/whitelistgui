package de.rxbsi.whitelistgui.listeners;

import de.rxbsi.whitelistgui.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        final Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equalsIgnoreCase("§7Manage Whitelist")) {
            event.setCancelled(true);

            switch (event.getCurrentItem().getType()) {
                case EMERALD_BLOCK:
                    Bukkit.setWhitelist(true);
                    player.sendMessage(Plugin.PREFIX + "§aYou activated the whitelist!");
                    break;

                case SKELETON_SKULL:
                    player.performCommand("whitelistguiplayers");
                    break;

                case REDSTONE_BLOCK:
                    Bukkit.setWhitelist(false);
                    player.sendMessage(Plugin.PREFIX + "§cYou deactivated the whitelist!");
                    break;
            }

        } else if (event.getView().getTitle().equalsIgnoreCase("§7Whitelisted Players")) {
            switch (event.getCurrentItem().getType()) {
                case SKELETON_SKULL:
                    if (event.isRightClick()) {
                        player.performCommand("whitelist remove " + event.getCurrentItem().getItemMeta().getDisplayName());
                        player.sendMessage(Plugin.PREFIX + "§eYou unwhitelisted §b" + event.getCurrentItem().getItemMeta().getDisplayName() + "§e!");
                        player.closeInventory();
                    }
                    break;
            }
        }

    }

}
