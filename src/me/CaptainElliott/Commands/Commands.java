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
	
	/*public static class ParentCommand {
		@Command(aliases = { "xml" }, desc = "XML Plugin commands", min = 0, max = -1)
		@NestedCommand(Commands.class)// All commands will get passed on to Commands.class
		public static void xml(final CommandContext args, CommandSender sender) throws CommandException {
		}
	} */
	 @Command(aliases = { "init", "initialize" }, desc = "Initializes the XML creation process", usage = "xml init", min = 0, max = 0)
	  public static void init(final CommandContext args, CommandSender sender) throws CommandException {
		 Player player = (Player) sender;
		 player.sendMessage(ChatColor.GOLD + "You have initializes the process the generated the XML for your map!");
		 player.sendMessage(ChatColor.GREEN + "Type /xml modules for a list of commands to run!");
		 player.sendMessage(ChatColor.RED + "Or type /xml stop to exit out");
		 setInit(true);

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
        if(getInit()){
            player.sendMessage(ChatColor.AQUA + "--- List Currently Supported XML Modules ---");
            player.sendMessage(ChatColor.RED + "NAME" + ChatColor.AQUA + " - " + ChatColor.YELLOW + "Sets the name for the map" );
        } else {
            player.sendMessage(ChatColor.RED + "You have not yet initialized! (/xml init)");
        }
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


	 
	 public static void setInit(boolean i){
		 init = i;
		}
	 
	 public static boolean getInit(){
		 return init;
	 }

}
