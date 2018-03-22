package com.nukeit5093.tntcalc;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String s, String[] args) {

        if(!(commandSender instanceof Player)){
            commandSender.sendMessage(ChatColor.RED + "You must be a player to use this command.");
        }

        Player player = (Player) commandSender;

        if(cmd.getName().equalsIgnoreCase("tntcalc")){
            if(args.length == 2){
                if(args[0].equalsIgnoreCase("chunk")){
                    double chunks = Double.valueOf(args[1]);
                    player.sendMessage("[TnTCalc] Power needed to shoot " + chunks + " chunks: " + calculateChunks(chunks));
                    return true;
                }else if(args[0].equalsIgnoreCase("hammer")){
                    double hammer = Double.valueOf(args[1]);
                    player.sendMessage("[TnTCalc] Hammer needed to stack " + hammer + " sand: " + calculateHammer(hammer));
                    return true;
                }
            }

            player.sendMessage("[TnTCalc] usage: \n/tntcalc chunk <X> (Calculate the amount of power needed to shoot X chunks\n/tntcalc hammer <X> (Calculate the amount of power needed to stack <X> sand");
            return true;
        }

        return true;
    }

    public double calculateChunks(double chunk){
        return ((chunk * 16 ) / 3.5);
    }

    public double calculateHammer(double hammer){
        return ((hammer * 1.141 )+ 1);
    }
}
