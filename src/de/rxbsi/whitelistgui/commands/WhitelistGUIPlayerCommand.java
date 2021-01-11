package de.rxbsi.whitelistgui.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.SkullType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class WhitelistGUIPlayerCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player))
            return false;

        final Player player = (Player) sender;

        if (player.hasPermission("whitelistgui.listplayers")) {
            Inventory whitelistguiplayers = Bukkit.createInventory(player, 54, "§7Whitelisted Players");

            for (OfflinePlayer all : Bukkit.getWhitelistedPlayers()) {
                ItemStack listedPlayer = new ItemStack(Material.SKELETON_SKULL, 1, (short) SkullType.PLAYER.ordinal());
                ItemMeta listedPlayerMeta = listedPlayer.getItemMeta();
                listedPlayerMeta.setDisplayName(all.getName());
                List<String> playerLore = new ArrayList<String>();
                playerLore.add("§c§lRightclick to unwhitelist this Player!");
                listedPlayerMeta.setLore(playerLore);
                listedPlayer.setItemMeta(listedPlayerMeta);

                whitelistguiplayers.addItem(listedPlayer);

                player.openInventory(whitelistguiplayers);
            }

        }

        return false;
    }
}
