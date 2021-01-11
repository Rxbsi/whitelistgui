package de.rxbsi.whitelistgui;

import de.rxbsi.whitelistgui.commands.WhitelistGUICommand;
import de.rxbsi.whitelistgui.commands.WhitelistGUIPlayerCommand;
import de.rxbsi.whitelistgui.listeners.InventoryClickListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {

    public static final String PREFIX = "§7[§6Whitelist§7-§6GUI§7] ";
    private static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        Bukkit.getConsoleSender().sendMessage(PREFIX + "§aPlugin aktiviert!");

        registerCommand();
        registerListener();
    }

    private void registerCommand() {
        this.getCommand("whitelistgui").setExecutor(new WhitelistGUICommand());
        this.getCommand("whitelistguiplayers").setExecutor(new WhitelistGUIPlayerCommand());
    }

    private void registerListener() {
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
    }

    public static Plugin getPlugin() {
        return plugin;
    }
}
