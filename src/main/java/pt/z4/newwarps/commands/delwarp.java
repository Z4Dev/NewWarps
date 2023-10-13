package pt.z4.newwarps.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pt.z4.newwarps.utils.ChatColor;
import pt.z4.newwarps.utils.Config;

public class delwarp implements CommandExecutor {

    private final Config config;

    public delwarp(Config config) {
        this.config = config;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            System.out.println("You must be a player to use this command!");
            return true;
        }

        if(args.length != 1){
            sender.sendMessage(ChatColor.color("&cUsage: /delwarp <name>"));
            return true;
        }

        String warp_name = args[0];

        if(!config.warpExists(warp_name)){
            sender.sendMessage(ChatColor.color("&cThe warp &b" + warp_name + " &cdoes not exist!"));
            return true;
        }

        Player player = (Player) sender;

        config.delWarp(warp_name);

        player.sendMessage(ChatColor.color("&a&l[Newwarps] Warp &b" + warp_name + " &cdeleted!"));

        return true;
    }
}
