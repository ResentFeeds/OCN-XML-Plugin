package me.CaptainElliott.Commands;

import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import com.sk89q.minecraft.util.commands.CommandException;
import me.CaptainElliott.Parser.Modules.Teams;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Elliott on 21/09/2014.
 */
public class ModulesAdd {

    private static int TeamCalledTimes = 0; //Amount of times the team command has been called

    public static void setTeamCalledTimes(int teamCalledTimes) {
        TeamCalledTimes = teamCalledTimes;
    }

    @Command(aliases = {"team"}, desc = "Map Teams", usage = "name color max max-overfill", min = 4, max = 4)
    public static void TeamMod(final CommandContext args, CommandSender sender) throws CommandException {
        Player player = (Player) sender;
        if (!Commands.getInit())
            player.sendMessage(ChatColor.RED + "You have not yet initialized! (/xml init)");
        else {
            TeamCalledTimes++;
            String name = args.getString(0);
            Bukkit.broadcastMessage(ChatColor.GOLD + name);
            Teams.name.put(TeamCalledTimes, name);
            Teams.color.put(name, args.getString(1));
            Teams.max.put(name, args.getString(2));
            Teams.maxoverfill.put(name, args.getString(3));

            Teams.setTeamsset(true);
            Teams.setNumberOfTeams(Teams.getNumberOfTeams() + 1);

        }
    }
}