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
public class Version {

    @Command(aliases = { "set"}, desc = "set Map Version", min = 1)
    public static void versionCommand(final CommandContext args, CommandSender sender) throws CommandException {
        Player player = (Player) sender;
        if(!Commands.getInit())
            player.sendMessage(ChatColor.RED + "You have not yet initialized! (/xml init)");
        else {
            String version = "";

            for (int i = 0; i < args.argsLength(); i++) {
                String arg = args.getString(i) + " ";
                version += arg;
            }
            version = version.trim();
            me.CaptainElliott.Parser.Modules.Version.setVersion(version);
            me.CaptainElliott.Parser.Modules.Version.setVersionset(true);
            player.sendMessage(ChatColor.AQUA + version);
        }

    }

    @Command(aliases = {"get"}, desc = "Get Map Name", min = 0, max = 0)
    public static void versionGetCommand(final CommandContext args, CommandSender sender) throws CommandException {
        Player player = (Player) sender;
        player.sendMessage(ChatColor.AQUA + me.CaptainElliott.Parser.Modules.Version.getVersion());
    }
}
