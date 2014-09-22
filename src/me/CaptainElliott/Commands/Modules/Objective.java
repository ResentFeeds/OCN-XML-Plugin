package me.CaptainElliott.Commands.Modules;

import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import com.sk89q.minecraft.util.commands.CommandException;
import me.CaptainElliott.Commands.Commands;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Elliott on 22/09/2014.
 */
public class Objective {
    @Command(aliases = { "set"}, desc = "set Map Objective", min = 1)
    public static void objectiveCommand(final CommandContext args, CommandSender sender) throws CommandException {
        Player player = (Player) sender;
        if(!Commands.getInit())
            player.sendMessage(ChatColor.RED + "You have not yet initialized! (/xml init)");
        else {
            String objective = "";

            for (int i = 0; i < args.argsLength(); i++) {
                String arg = args.getString(i) + " ";
                objective += arg;
            }
            objective = objective.trim();
            me.CaptainElliott.Parser.Modules.Objective.setObjective(objective);
            me.CaptainElliott.Parser.Modules.Objective.setObjectiveset(true);
            player.sendMessage(ChatColor.AQUA + objective);
        }

    }

    @Command(aliases = {"get"}, desc = "Get Map objective", min = 0, max = 0)
    public static void objectiveGetCommand(final CommandContext args, CommandSender sender) throws CommandException {
        Player player = (Player) sender;
        player.sendMessage(ChatColor.AQUA + me.CaptainElliott.Parser.Modules.Objective.getObjective());
    }
}
