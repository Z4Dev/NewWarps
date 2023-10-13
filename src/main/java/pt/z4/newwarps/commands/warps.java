package pt.z4.newwarps.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pt.z4.newwarps.utils.ChatColor;
import pt.z4.newwarps.utils.Config;
import pt.z4.newwarps.utils.Config;

public class warps implements CommandExecutor {

    private final Config config;

    public warps(Config config) {
        this.config = config;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            System.out.println("You must be a player to use this command!");
            return true;
        }
        Player player = (Player) sender;

        String getWarps = config.getWarps();
        player.sendMessage(ChatColor.color("&a&l[Newwarps] &bWarps: &f" + getWarps));

        return true;
    }
}
