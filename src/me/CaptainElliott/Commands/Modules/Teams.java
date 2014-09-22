package me.CaptainElliott.Commands.Modules;

import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import com.sk89q.minecraft.util.commands.CommandException;
import me.CaptainElliott.Commands.Commands;
import org.apache.commons.lang.math.NumberUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

/**
 * Created by Elliott on 22/09/2014.
 */
public class Teams {

    private static int TeamCalledTimes = 0; //Amount of times the team command has been called

    private static HashMap<String, Integer> NameAndIDHasMap = new HashMap<String, Integer>();

    public static void setTeamCalledTimes(int teamCalledTimes) {
        TeamCalledTimes = teamCalledTimes;
    }

    @Command(aliases = {"add"}, desc = "Add Map Teams", usage = "name color max max-overfill", min = 4, max = 4)
    public static void TeamAddCommand(final CommandContext args, CommandSender sender) throws CommandException {
        Player player = (Player) sender;
        if (!Commands.getInit())
            player.sendMessage(ChatColor.RED + "You have not yet initialized! (/xml init)");
        else if(NumberUtils.isNumber(args.getString(2)) && NumberUtils.isNumber(args.getString(3))){
            TeamCalledTimes++;
            String name = args.getString(0).replace('_', ' ');
            NameAndIDHasMap.put(name, TeamCalledTimes);
            Bukkit.broadcastMessage(ChatColor.GOLD + name);
            me.CaptainElliott.Parser.Modules.Teams.name.put(TeamCalledTimes, name);
            me.CaptainElliott.Parser.Modules.Teams.color.put(TeamCalledTimes, args.getString(1));
            me.CaptainElliott.Parser.Modules.Teams.max.put(TeamCalledTimes, args.getString(2));
            me.CaptainElliott.Parser.Modules.Teams.maxoverfill.put(TeamCalledTimes, args.getString(3));

            me.CaptainElliott.Parser.Modules.Teams.setTeamsset(true);
            me.CaptainElliott.Parser.Modules.Teams.setNumberOfTeams(me.CaptainElliott.Parser.Modules.Teams.getNumberOfTeams() + 1);

            player.sendMessage(ChatColor.RED + "Name: " + ChatColor.AQUA + name);
            player.sendMessage(ChatColor.RED + "Color: " + ChatColor.AQUA + args.getString(1));
            player.sendMessage(ChatColor.RED + "Max: " + ChatColor.AQUA + args.getString(2));
            player.sendMessage(ChatColor.RED + "Max-Ovefill: " + ChatColor.AQUA + args.getString(3));
            player.sendMessage("");

        } else {
            player.sendMessage(ChatColor.RED + "The team max sizes must be integers!");
        }
    }

    @Command(aliases = {"get"}, desc = "Get Map teams", min = 0, max = 0)
    public static void teamGetCommand(final CommandContext args, CommandSender sender) throws CommandException {
        Player player = (Player) sender;
        for (int i = 0; me.CaptainElliott.Parser.Modules.Teams.getNumberOfTeams() > i; i++) {
            String name = me.CaptainElliott.Parser.Modules.Teams.name.get(i + 1);
            player.sendMessage(ChatColor.RED + "Name: " + ChatColor.AQUA + me.CaptainElliott.Parser.Modules.Teams.name.get(i + 1));
            player.sendMessage(ChatColor.RED + "Color: " + ChatColor.AQUA + me.CaptainElliott.Parser.Modules.Teams.color.get(i + 1));
            player.sendMessage(ChatColor.RED + "Max: " + ChatColor.AQUA + me.CaptainElliott.Parser.Modules.Teams.max.get(i + 1));
            player.sendMessage(ChatColor.RED + "Max-Ovefill: " + ChatColor.AQUA + me.CaptainElliott.Parser.Modules.Teams.maxoverfill.get(i + 1));
            player.sendMessage("");
        }
    }

    @Command(aliases = {"edit"}, desc = "Edit Map Teams", usage = "old_name name color max max-overfill", min = 5, max = 5)
    public static void TeamEditCommand(final CommandContext args, CommandSender sender) throws CommandException {
        Player player = (Player) sender;
        if (!Commands.getInit())
            player.sendMessage(ChatColor.RED + "You have not yet initialized! (/xml init)");
        else if (me.CaptainElliott.Parser.Modules.Teams.name.containsValue(args.getString(0))) {
            if (NumberUtils.isNumber(args.getString(3)) && NumberUtils.isNumber(args.getString(4))) {
                String old_name = args.getString(0).replace('_', ' ');
               // Bukkit.broadcastMessage("OLD NAME: " +args.getString(0));
                String name = args.getString(1).replace('_', ' ');
               /* Bukkit.broadcastMessage("Name+ " + args.getString(1));
                Bukkit.broadcastMessage(me.CaptainElliott.Parser.Modules.Teams.color.get(old_name));
                Bukkit.broadcastMessage(me.CaptainElliott.Parser.Modules.Teams.max.get(old_name));
                Bukkit.broadcastMessage(me.CaptainElliott.Parser.Modules.Teams.maxoverfill.get(old_name));*/
                me.CaptainElliott.Parser.Modules.Teams.ReplaceNameValue(NameAndIDHasMap.get(old_name), name);
                me.CaptainElliott.Parser.Modules.Teams.ReplaceColorValue(NameAndIDHasMap.get(old_name), args.getString(2));
                me.CaptainElliott.Parser.Modules.Teams.ReplaceMaxValue(NameAndIDHasMap.get(old_name), args.getString(3));

                me.CaptainElliott.Parser.Modules.Teams.ReplaceMaxOverfillValue(NameAndIDHasMap.get(old_name), args.getString(4));

                player.sendMessage(ChatColor.RED + "Name: " + ChatColor.AQUA + name);
                player.sendMessage(ChatColor.RED + "Color: " + ChatColor.AQUA + args.getString(2));
                player.sendMessage(ChatColor.RED + "Max: " + ChatColor.AQUA + args.getString(3));
                player.sendMessage(ChatColor.RED + "Max-Ovefill: " + ChatColor.AQUA + args.getString(4));
                player.sendMessage("");


            } else {
                player.sendMessage(ChatColor.RED + "The team max sizes must be integers!");
            }
        } else {
            player.sendMessage(ChatColor.RED + "That teams does not exist yet, use " + ChatColor.GOLD + "/xml teams add" + ChatColor.RED + " to create one!");
        }
    }
}
