package org.smokeeaasd.mpowers.listeners;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.Arrays;
import java.util.List;

public class MobEventListener implements Listener {
    private List<EntityType> allowedMobs = Arrays.asList(
            EntityType.CHICKEN,
            EntityType.SPIDER,
            EntityType.RABBIT,
            EntityType.AXOLOTL
    );
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        LivingEntity livingEntity = event.getEntity();
        Player killer = livingEntity.getKiller();

        if (killer != null)
        {
            Location playerLoc = killer.getLocation();
            World playerWorld = playerLoc.getWorld();

            EntityType livingEntityType = livingEntity.getType();

            if (allowedMobs.contains(livingEntityType))
            {
                playerWorld.playSound(playerLoc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
            }
        }
    }
}
