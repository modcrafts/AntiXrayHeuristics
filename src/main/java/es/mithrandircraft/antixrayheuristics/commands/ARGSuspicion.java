package es.mithrandircraft.antixrayheuristics.commands;

import es.mithrandircraft.antixrayheuristics.AntiXrayHeuristics;
import es.mithrandircraft.antixrayheuristics.MiningSession;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ARGSuspicion {
    public static void S(CommandSender sender) {//Non-parametrized
        if (sender instanceof Player) { //Is player
            Player player = (Player) sender;
            MiningSession tempMS = AntiXrayHeuristics.sessions.get(player.getName());
            if (tempMS != null) player.sendMessage("Your suspicion level: " + tempMS.GetSuspicionLevel());
            else player.sendMessage("You are not suspicious of Xray usage. No suspicion level available.");
        }
        else System.out.println("You need to be a player in order to execute this command without arguments."); //Is console
    }
    public static void S(CommandSender sender, String arg) //Parametrized
    {
        if (sender instanceof Player) { //Is player
            Player player = (Player) sender;
            MiningSession tempMS = AntiXrayHeuristics.sessions.get(arg);
            if (tempMS != null)
                player.sendMessage(arg + "'s suspicion level: " + tempMS.GetSuspicionLevel());
            else
                player.sendMessage(arg + " Is not suspicious of Xray usage. No suspicion level available.");
        } else { //Is console
            MiningSession tempMS = AntiXrayHeuristics.sessions.get(arg);
            if (tempMS != null)
                System.out.println(arg + "'s suspicion level: " + tempMS.GetSuspicionLevel());
            else
                System.out.println(arg + " Is not suspicious of Xray usage. No suspicion level available.");
        }
    }
}