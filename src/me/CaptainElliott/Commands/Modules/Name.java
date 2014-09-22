package me.CaptainElliott.Commands.Modules;

import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import com.sk89q.minecraft.util.commands.CommandException;
import me.CaptainElliott.Commands.Commands;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Elliott on 22/09/2014.
 */
public class Name {

    @Command(aliases = { "set"}, desc = "set Map Name", min = 1)
    public static void nameSetCommand(final CommandContext args, CommandSender sender) throws CommandException {
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
                me.CaptainElliott.Parser.Modules.Name.setName(name);
                me.CaptainElliott.Parser.Modules.Name.setNameset(true);
                player.sendMessage(ChatColor.AQUA + name);
            } else {
                player.sendMessage("The name must be Alphanumeric!");
            }

        }
    }

    @Command(aliases = {"get"}, desc = "Get Map Name", min = 0, max = 0)
    public static void nameGetCommand(final CommandContext args, CommandSender sender) throws CommandException {
        Player player = (Player) sender;
        player.sendMessage(ChatColor.AQUA + me.CaptainElliott.Parser.Modules.Name.getName());
    }

}
