package me.CaptainElliott.Commands;

import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import com.sk89q.minecraft.util.commands.CommandException;
import me.CaptainElliott.Parser.Modules.Name;
import me.CaptainElliott.Parser.Modules.Objective;
import me.CaptainElliott.Parser.Modules.Teams;
import me.CaptainElliott.Parser.Modules.Version;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Elliott on 21/09/2014.
 */
public class ModulesGet {

    @Command(aliases = {"name"}, desc = "Get Map Name", min = 0, max = 0)
    public static void nameModGet(final CommandContext args, CommandSender sender) throws CommandException {
        Player player = (Player) sender;
        player.sendMessage(ChatColor.AQUA + Name.getName());
    }

    @Command(aliases = {"version"}, desc = "Get Map Name", min = 0, max = 0)
    public static void versionModGet(final CommandContext args, CommandSender sender) throws CommandException {
        Player player = (Player) sender;
        player.sendMessage(ChatColor.AQUA + Version.getVersion());
    }

    @Command(aliases = {"objective"}, desc = "Get Map objective", min = 0, max = 0)
    public static void objectiveModGet(final CommandContext args, CommandSender sender) throws CommandException {
        Player player = (Player) sender;
        player.sendMessage(ChatColor.AQUA + Objective.getObjective());
    }

    @Command(aliases = {"teams"}, desc = "Get Map teams", min = 0, max = 0)
    public static void teamModGet(final CommandContext args, CommandSender sender) throws CommandException {
        Player player = (Player) sender;
        for (int i = 0; Teams.getNumberOfTeams() > i; i++) {
            String name = Teams.name.get(i + 1);
            player.sendMessage(ChatColor.RED + "Name: " + ChatColor.AQUA + Teams.name.get(i + 1));
            player.sendMessage(ChatColor.RED + "Color: " + ChatColor.AQUA + Teams.color.get(name));
            player.sendMessage(ChatColor.RED + "Max: " + ChatColor.AQUA + Teams.max.get(name));
            player.sendMessage(ChatColor.RED + "Max-Ovefill: " + ChatColor.AQUA + Teams.maxoverfill.get(name));
            player.sendMessage("");
        }
    }
}
