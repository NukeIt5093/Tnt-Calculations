package com.nukeit5093.tntcalc;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor{

    private String prefix = ChatColor.DARK_RED + "" + ChatColor.BOLD + "[" + ChatColor.RED + "TnTCalc" + ChatColor.DARK_RED + "" + ChatColor.BOLD + "] " + ChatColor.WHITE;

    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String s, String[] args) {

        if(!(commandSender instanceof Player)){
            commandSender.sendMessage(ChatColor.RED + "You must be a player to use this command.");
        }

        Player player = (Player) commandSender;

        if(cmd.getName().equalsIgnoreCase("tntcalc")){
            if(args.length == 2){
                try{
                    if(args[0].equalsIgnoreCase("chunk")){
                        double chunks = Double.valueOf(args[1]);
                        player.sendMessage(prefix + "Power needed to shoot " + chunks + " chunks: " + calculateChunks(chunks));
                        return true;
                    }else if(args[0].equalsIgnoreCase("hammer")){
                        double hammer = Double.valueOf(args[1]);
                        player.sendMessage(prefix + "Hammer needed to stack " + hammer + " sand: " + calculateHammer(hammer));
                        return true;
                    }
                }catch(NumberFormatException e){
                    player.sendMessage(prefix + ChatColor.DARK_RED + "" + ChatColor.BOLD + "Please give a numeric input.");
                    return true;
                }
            }

            player.sendMessage(prefix + ChatColor.RED + "Usage: \n/tntcalc chunk <X> " + ChatColor.GRAY + "(Calculate the amount of power needed to shoot X chunks)" + ChatColor.RED + "\n/tntcalc hammer <X> " + ChatColor.GRAY + "(Calculate the amount of power needed to stack <X> sand)");
            return true;
        }

        return true;
    }

    public int calculateChunks(double chunk){
        double c = ((chunk * 16 ) / 3.5);
        return (((int) c) + 1);
    }

    public int calculateHammer(double hammer){
        double h = ((hammer * 1.141 )+ 1);
        return (((int) h) + 1);
    }
}
