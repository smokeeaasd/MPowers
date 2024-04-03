package org.smokeeaasd.mpowers;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.smokeeaasd.mpowers.listeners.MobEventListener;

import java.io.File;

public final class MPowers extends JavaPlugin {

    private Listener[] listeners = {
            new MobEventListener(),
    };

    @Override
    public void onEnable() {
        getLogger().info("smokeeaasd/MPowers [ATIVADO]");

        for (Listener listener : listeners) {
            getServer().getPluginManager().registerEvents(listener, this);
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("smokeeaasd/MPowers [ATIVADO]");
    }
}
