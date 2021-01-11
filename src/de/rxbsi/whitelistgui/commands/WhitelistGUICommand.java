package de.rxbsi.whitelistgui.commands;

import de.rxbsi.whitelistgui.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.Material;
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

public class WhitelistGUICommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player))
            return false;

        final Player player = (Player) sender;

        if (player.hasPermission("whitelistgui.command")) {
            if (args.length == 0) {
                Inventory whitelistGui = Bukkit.createInventory(player, 9, "§7Manage Whitelist");

                ItemStack emeraldBlock = new ItemStack(Material.EMERALD_BLOCK);
                ItemMeta emeraldBlockMeta = emeraldBlock.getItemMeta();
                emeraldBlockMeta.setDisplayName("§a§lActivate Whitelist");
                emeraldBlock.setItemMeta(emeraldBlockMeta);

                ItemStack skull = new ItemStack(Material.SKELETON_SKULL);
                ItemMeta skullMeta = skull.getItemMeta();
                skullMeta.setDisplayName("§bWhitelisted Players");
                skull.setItemMeta(skullMeta);

                ItemStack redstoneBlock = new ItemStack(Material.REDSTONE_BLOCK);
                ItemMeta redstoneBlockMeta = redstoneBlock.getItemMeta();
                redstoneBlockMeta.setDisplayName("§c§lDeavtivate Whitelist");
                redstoneBlock.setItemMeta(redstoneBlockMeta);

                whitelistGui.setItem(2, emeraldBlock);
                whitelistGui.setItem(4, skull);
                whitelistGui.setItem(6, redstoneBlock);

                player.openInventory(whitelistGui);

            } else {
                player.sendMessage(Plugin.PREFIX + "§8Bitte benutze §c/whitelistgui§8!");
            }
        }
        return false;
    }
}
