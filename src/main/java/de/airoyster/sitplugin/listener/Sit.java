package de.airoyster.sitplugin.listener;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.spigotmc.event.entity.EntityDismountEvent;

import java.util.HashMap;
import java.util.Map;

public class Sit implements Listener {
    public static Map<Player, ArmorStand> sit = new HashMap<>();

    @EventHandler
    public void dismountEvent(EntityDismountEvent event) {
        if(sit.containsKey((Player)event.getEntity())) {
            Player p = (Player) event.getEntity();
            sit.get(p).remove();
            sit.remove(p);
            p.teleport(p.getLocation().add(0,1,0));
        }
    }

}
