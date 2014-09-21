package me.CaptainElliott.Commands;

import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import com.sk89q.minecraft.util.commands.CommandException;
import me.CaptainElliott.Parser.Modules.Name;
import me.CaptainElliott.Parser.Modules.Version;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.apache.commons.lang.StringUtils;

/**
 * Created by Elliott on 20/09/2014.
 */
public class Modules {

    @Command(aliases = { "name"}, desc = "Map Name", min = 1)
    public static void nameMod(final CommandContext args, CommandSender sender) throws CommandException {
        Player player = (Player) sender;
        if(!Commands.getInit())
            player.sendMessage(ChatColor.RED + "You have not yet initialized! (/xml init)");
        else {

            String name = "";

            for (int i = 0; i < args.argsLength(); i++) {
                String arg = args.getString(i) + " ";
                name += arg;
            }
            name = name.trim();

            if (StringUtils.isAlphanumericSpace(name)) {
                Name.setName(name);
                Name.setNameset(true);
                player.sendMessage(ChatColor.AQUA + name);
            } else {
                player.sendMessage("The name must be Alphanumeric!");
            }

        }
    }

    @Command(aliases = { "version"}, desc = "Map Version", min = 1)
    public static void versionMod(final CommandContext args, CommandSender sender) throws CommandException {
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
            Version.setVersion(version);
            Version.setVersionset(true);
            player.sendMessage(ChatColor.AQUA + version);
        }

    }

    public static void ResetModules(){
        Name.setName(null);
        Name.setNameset(false);

        Version.setVersion(null);
        Version.setVersionset(false);
    }



}
