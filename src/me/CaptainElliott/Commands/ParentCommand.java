package me.CaptainElliott.Commands;

import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import com.sk89q.minecraft.util.commands.CommandException;
import com.sk89q.minecraft.util.commands.NestedCommand;
import org.bukkit.command.CommandSender;

/**
 * Created by Elliott on 20/09/2014.
 */
public class ParentCommand {
    @Command(aliases = { "xml" }, desc = "XML Plugin commands", min = 0, max = -1)
    @NestedCommand(Commands.class)// All commands will get passed on to Commands.class
    public static void xml(final CommandContext args, CommandSender sender) throws CommandException {
    }
}
