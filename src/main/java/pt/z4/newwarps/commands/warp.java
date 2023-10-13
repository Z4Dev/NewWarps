package pt.z4.newwarps.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import pt.z4.newwarps.utils.ChatColor;
import pt.z4.newwarps.utils.Config;

public class warp implements CommandExecutor {

    private final Config config;

    public warp(Config config) {
        this.config = config;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            System.out.println("You must be a player to use this command!");
            return true;
        }

        Player player = (Player) sender;

        if(args.length != 1){
            player.sendMessage(ChatColor.color("&cUsage: /warp <name>"));
            return true;
        }

        String warp_name = args[0];

        if(!config.warpExists(warp_name)){
            player.sendMessage(ChatColor.color("&cThe warp &b" + warp_name + " &cdoes not exist!"));
            return true;
        }

        String locationString = config.getWarp(warp_name);

        String[] locationArray = locationString.split(",");

        int x = Integer.parseInt(locationArray[0]);
        int y = Integer.parseInt(locationArray[1]);
        int z = Integer.parseInt(locationArray[2]);

        player.teleport(player.getWorld().getBlockAt(x, y, z).getLocation());

        player.sendMessage(ChatColor.color("&a&l[Newwarps] &bTeleported to &f" + warp_name + "&b!"));

        return true;
    }
}
