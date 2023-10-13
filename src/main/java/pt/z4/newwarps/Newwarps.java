package pt.z4.newwarps;

import org.bukkit.plugin.java.JavaPlugin;
import pt.z4.newwarps.commands.delwarp;
import pt.z4.newwarps.commands.setwarp;
import pt.z4.newwarps.commands.warp;
import pt.z4.newwarps.commands.warps;
import pt.z4.newwarps.utils.Config;

public final class Newwarps extends JavaPlugin {

    private Config config;

    @Override
    public void onEnable() {
        config = new Config(this);

        getCommand("setwarp").setExecutor(new setwarp(config));
        getCommand("warps").setExecutor(new warps(config));
        getCommand("warp").setExecutor(new warp(config));
        getCommand("delwarp").setExecutor(new delwarp(config));
        saveDefaultConfig();
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
