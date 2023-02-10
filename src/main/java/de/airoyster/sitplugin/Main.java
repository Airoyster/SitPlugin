package de.airoyster.sitplugin;

import de.airoyster.sitplugin.commands.Sit_CMD;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static String noPerms = ChatColor.AQUA + "Sit §a| §cYou don't have the permissions for this command!";
    public static String prefix = ChatColor.AQUA + "Sit §a| ";

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("sit").setExecutor(new Sit_CMD());
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "Sit Plugin Started!");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "Sit Plugin stopped!");
    }
}
