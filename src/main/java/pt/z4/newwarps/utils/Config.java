package pt.z4.newwarps.utils;

import org.bukkit.Location;
import pt.z4.newwarps.Newwarps;

public class Config {
    private final Newwarps plugin;

    public Config(Newwarps plugin) {
        this.plugin = plugin;
    }

    public void saveWarp(String warpname, String position) {
        plugin.getConfig().set("warps." + warpname + ".position", position);
        plugin.saveConfig();
    }

    public String getWarps() {
        String warps = plugin.getConfig().getConfigurationSection("warps").getKeys(false).toString();
        return warps.replace("[", "").replace("]", "");
    }

    public String getWarp(String warpname) {
        return plugin.getConfig().getString("warps." + warpname + ".position");
    }

    public boolean warpExists(String warpname) {
        return plugin.getConfig().contains("warps." + warpname);
    }

    public void delWarp(String warpname) {
        plugin.getConfig().set("warps." + warpname, null);
        plugin.saveConfig();
    }
}
