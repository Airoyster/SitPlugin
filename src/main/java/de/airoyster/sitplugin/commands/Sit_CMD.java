package de.airoyster.sitplugin.commands;

import de.airoyster.sitplugin.Main;
import de.airoyster.sitplugin.listener.Sit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

public class Sit_CMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] arg3) {

        if(sender instanceof Player p) {
            if(Sit.sit.containsKey(p)) {
           //     p.sendMessage(Main.prefix + "§6You are already seated!");
                Location l = p.getLocation();
                World w = p.getWorld();
                ArmorStand arrow = w.spawn(l, ArmorStand.class, stand ->{
                    stand.setMarker(true);
                    stand.setInvisible(true);
                    stand.setCustomNameVisible(false);

                });
                Sit.sit.put(p, arrow);
                arrow.addPassenger(p);
                return true;
            }

            if (p.hasPermission("system.sit")){
                if (arg3.length == 0) {
                    Location l = p.getLocation();
                    World w = p.getWorld();
                    ArmorStand arrow = w.spawn(l, ArmorStand.class, stand ->{
                        stand.setMarker(true);
                        stand.setInvisible(true);
                        stand.setCustomNameVisible(false);

                    });
                    Sit.sit.put(p, arrow);
                    arrow.addPassenger(p);
                } else {
                    sender.sendMessage(Main.prefix + "§cError! §aPlease us '/sit'");
                }
            } else{
                p.sendMessage(Main.noPerms);
            }

        } else {
            sender.sendMessage(ChatColor.RED + "The console can't use this command.");
        }
        return false;
    }

}