package me.CaptainElliott.Commands;

import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import com.sk89q.minecraft.util.commands.CommandException;
import com.sk89q.minecraft.util.commands.NestedCommand;
import me.CaptainElliott.Parser.Generate;
import me.CaptainElliott.Parser.Modules.Name;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Commands extends Modules{
	
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
             Modules.ResetModules();

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
            player.sendMessage(ChatColor.RED + "Set Map Name" + ChatColor.AQUA + " - " + ChatColor.AQUA + "/xml set name");
            player.sendMessage(ChatColor.RED + "Get Map Name" + ChatColor.AQUA + " - " + ChatColor.AQUA + "/xml get name");
            player.sendMessage(ChatColor.RED + "set Map Version" + ChatColor.AQUA + " - " + ChatColor.AQUA + "/xml set version");
            player.sendMessage(ChatColor.RED + "Get Map Version" + ChatColor.AQUA + " - " + ChatColor.AQUA + "/xml get version");
            player.sendMessage(ChatColor.RED + "set Map Objective" + ChatColor.AQUA + " - " + ChatColor.AQUA + "/xml set objective");
            player.sendMessage(ChatColor.RED + "Get Map Objective" + ChatColor.AQUA + " - " + ChatColor.AQUA + "/xml get objective");
            player.sendMessage(ChatColor.RED + "Add a Team" + ChatColor.AQUA + " - " + ChatColor.AQUA + "/xml add team <name, color, max, max-overfill>");
            player.sendMessage(ChatColor.RED + "List Teams" + ChatColor.AQUA + " - " + ChatColor.AQUA + "/xml get teams");
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

    @Command(aliases = { "set" }, desc = "Set XML Moduel value", min = 0, max = -1)
    @NestedCommand(Modules.class)// All commands will get passed on to Commands.class
    public static void set(final CommandContext args, CommandSender sender) throws CommandException {
        Player player = (Player) sender;
        if(!getInit())
            player.sendMessage(ChatColor.RED + "You have not yet initialized! (/xml init)");
    }

    @Command(aliases = { "get" }, desc = "get XML Moduel values", min = 0, max = -1)
    @NestedCommand(ModulesGet.class)// All commands will get passed on to Commands.class
    public static void get(final CommandContext args, CommandSender sender) throws CommandException {
        Player player = (Player) sender;
        if(!getInit())
            player.sendMessage(ChatColor.RED + "You have not yet initialized! (/xml init)");
    }

    @Command(aliases = { "add" }, desc = "add a XML Moduel with more than one element (teams, fillers)", min = 0, max = -1)
    @NestedCommand(ModulesAdd.class)// All commands will get passed on to Commands.class
    public static void add(final CommandContext args, CommandSender sender) throws CommandException {
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
