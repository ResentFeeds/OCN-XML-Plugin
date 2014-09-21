package me.CaptainElliott.Commands;

import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import com.sk89q.minecraft.util.commands.CommandException;
import me.CaptainElliott.Parser.Modules.Name;
import me.CaptainElliott.Parser.Modules.Version;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Elliott on 21/09/2014.
 */
public class ModulesGet {

    @Command(aliases = { "name"}, desc = "Get Map Name", min = 0, max = 0)
    public static void nameModGet(final CommandContext args, CommandSender sender) throws CommandException {
     Player player = (Player) sender;
        player.sendMessage(ChatColor.AQUA + Name.getName());
    }

    @Command(aliases = { "version"}, desc = "Get Map Name", min = 0, max = 0)
    public static void versionModGet(final CommandContext args, CommandSender sender) throws CommandException {
        Player player = (Player) sender;
        player.sendMessage(ChatColor.AQUA + Version.getVersion());
    }
}
