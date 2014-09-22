package me.CaptainElliott.Commands;

import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import com.sk89q.minecraft.util.commands.CommandException;
import com.sk89q.minecraft.util.commands.NestedCommand;
import me.CaptainElliott.Commands.Modules.ModuleUtils;
import me.CaptainElliott.Parser.Generate;
import me.CaptainElliott.Parser.Modules.Name;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Commands {
	
	private static boolean init = false;

	 @Command(aliases = { "init", "initialize" }, desc = "Initializes the XML creation process", usage = "xml init", min = 0, max = 0)
	  public static void init(final CommandContext args, CommandSender sender) throws CommandException {
		 Player player = (Player) sender;
         if(!getInit()) {
             player.sendMessage(ChatColor.GOLD + "You have initializes the process the generated the XML for your map!");
             player.sendMessage(ChatColor.GREEN + "Type /xml modules for a list of commands to run!");
             player.sendMessage(ChatColor.RED + "Or type /xml stop to exit out");
             setInit(true);
         } else {
             player.sendMessage("You are already initialized the xml process, use /xml stop to abort!");
         }

	  }
	 @Command(aliases = { "stop", "exit" }, desc = "stop the XML creation process", usage = "xml stop", min = 0, max = 0)
	  public static void stop(final CommandContext args, CommandSender sender) throws CommandException {
		 Player player = (Player) sender;
		 if(!getInit()){
			 player.sendMessage(ChatColor.RED + "You have not yet initialized");
		 } else {
		 player.sendMessage(ChatColor.RED + "XML creation aborted!");
             setInit(false);
             ModuleUtils.ResetModules();

		 }
	  }

    @Command(aliases = { "modules" }, desc = "list of the XML modules", usage = "xml modules", min = 0, max = 0)
    public static void modules(final CommandContext args, CommandSender sender) throws CommandException {
        Player player = (Player) sender;
            player.sendMessage(ChatColor.AQUA + "--- List Currently Supported XML Modules ---");
            player.sendMessage(ChatColor.RED + "NAME" + ChatColor.AQUA + " - " + ChatColor.YELLOW + "Sets the name for the map");
            player.sendMessage(ChatColor.RED + "VERSION" + ChatColor.AQUA + " - " + ChatColor.YELLOW + "Sets the map version");
            player.sendMessage(ChatColor.RED + "OBJECTIVE" + ChatColor.AQUA + " - " + ChatColor.YELLOW + "Sets the map objective");
            player.sendMessage(ChatColor.RED + "TEAMS" + ChatColor.AQUA + " - " + ChatColor.YELLOW + "Adds teams");
            player.sendMessage(ChatColor.AQUA + "----------------" + ChatColor.RED + "/xml commads" + ChatColor.AQUA + "----------------");
    }

    @Command(aliases = { "commands" }, desc = "list of the XML commands", usage = "xml commands", min = 0, max = 0)
    public static void commands(final CommandContext args, CommandSender sender) throws CommandException {
        Player player = (Player) sender;
            player.sendMessage(ChatColor.AQUA + "--- List Currently Supported XML Modules ---");
            player.sendMessage(ChatColor.RED + "Set Map Name" + ChatColor.AQUA + " - " + ChatColor.AQUA + "/xml name set");
            player.sendMessage(ChatColor.RED + "Get Map Name" + ChatColor.AQUA + " - " + ChatColor.AQUA + "/xml name get");
            player.sendMessage(ChatColor.RED + "set Map Version" + ChatColor.AQUA + " - " + ChatColor.AQUA + "/xml version set");
            player.sendMessage(ChatColor.RED + "Get Map Version" + ChatColor.AQUA + " - " + ChatColor.AQUA + "/xml version get");
            player.sendMessage(ChatColor.RED + "set Map Objective" + ChatColor.AQUA + " - " + ChatColor.AQUA + "/xml objective set");
            player.sendMessage(ChatColor.RED + "Get Map Objective" + ChatColor.AQUA + " - " + ChatColor.AQUA + "/xml objective get");
            player.sendMessage(ChatColor.RED + "Add a Team" + ChatColor.AQUA + " - " + ChatColor.AQUA + "/xml teams add <name, color, max, max-overfill> to make spaces use _ in the team name");
            player.sendMessage(ChatColor.RED + "List Teams" + ChatColor.AQUA + " - " + ChatColor.AQUA + "/xml teams get");
    }

    @Command(aliases = { "generate" }, desc = "generates the XML file", usage = "xml generate", min = 0, max = 0)
    public static void generate(final CommandContext args, CommandSender sender) throws CommandException {
        Player player = (Player) sender;
        if(getInit()){
            if(Name.isNameset()) {
                Generate.GenerateFile();
                player.sendMessage(ChatColor.GREEN + "Generated!");
            } else {
                player.sendMessage(ChatColor.RED + "You must add a name");
            }
        } else {
            player.sendMessage(ChatColor.RED + "You have not yet initialized! (/xml init)");
        }
    }

    @Command(aliases = { "name" }, desc = "commands for the name module", min = 0, max = -1)
    @NestedCommand(me.CaptainElliott.Commands.Modules.Name.class)// All commands will get passed on to Commands.class
    public static void name(final CommandContext args, CommandSender sender) throws CommandException {
        Player player = (Player) sender;
        if(!getInit())
            player.sendMessage(ChatColor.RED + "You have not yet initialized! (/xml init)");
    }

    @Command(aliases = { "version" }, desc = "commands for the version module", min = 0, max = -1)
    @NestedCommand(me.CaptainElliott.Commands.Modules.Version.class)// All commands will get passed on to Commands.class
    public static void verson(final CommandContext args, CommandSender sender) throws CommandException {
        Player player = (Player) sender;
        if(!getInit())
            player.sendMessage(ChatColor.RED + "You have not yet initialized! (/xml init)");
    }

    @Command(aliases = { "objective" }, desc = "commands for the objective module", min = 0, max = -1)
    @NestedCommand(me.CaptainElliott.Commands.Modules.Objective.class)// All commands will get passed on to Commands.class
    public static void objective(final CommandContext args, CommandSender sender) throws CommandException {
        Player player = (Player) sender;
        if(!getInit())
            player.sendMessage(ChatColor.RED + "You have not yet initialized! (/xml init)");
    }

    @Command(aliases = { "teams" }, desc = "commands for the objective module", min = 0, max = -1)
    @NestedCommand(me.CaptainElliott.Commands.Modules.Teams.class)// All commands will get passed on to Commands.class
    public static void teams(final CommandContext args, CommandSender sender) throws CommandException {
        Player player = (Player) sender;
        if(!getInit())
            player.sendMessage(ChatColor.RED + "You have not yet initialized! (/xml init)");
    }

	 public static void setInit(boolean i){
		 init = i;
		}
	 
	 public static boolean getInit(){
		 return init;
	 }

}
