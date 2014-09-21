package me.CaptainElliott;


import com.sk89q.bukkit.util.CommandsManagerRegistration;
import com.sk89q.minecraft.util.commands.*;
import me.CaptainElliott.Commands.Modules;
import me.CaptainElliott.Commands.ModulesAdd;
import me.CaptainElliott.Commands.ModulesGet;
import me.CaptainElliott.Commands.ParentCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class XMLPlugin extends JavaPlugin{

	public static XMLPlugin plugin;
	
	private CommandsManager<CommandSender> commands;

	public void onEnable() {
        plugin = this;
		setupCommands();

	}
	
	public void onDisable(){
		
	}
	
	private void setupCommands() {
        this.commands = new CommandsManager<CommandSender>() {
            @Override
            public boolean hasPermission(CommandSender sender, String perm) {
                return sender instanceof ConsoleCommandSender || sender.hasPermission(perm);
            }
        };
        CommandsManagerRegistration cmdRegister = new CommandsManagerRegistration(this, this.commands);
        cmdRegister.register(ParentCommand.class);
        cmdRegister.register(Modules.class);
        cmdRegister.register(ModulesGet.class);
        cmdRegister.register(ModulesAdd.class);

	}
	
	 @Override
	    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd,
	            String commandLabel, String[] args) {
	        try {
	            this.commands.execute(cmd.getName(), args, sender, sender);
	        } catch (CommandPermissionsException e) {
	            sender.sendMessage(ChatColor.RED + "You don't have permission.");
	        } catch (MissingNestedCommandException e) {
	            sender.sendMessage(ChatColor.RED + e.getUsage());
	        } catch (CommandUsageException e) {
	            sender.sendMessage(ChatColor.RED + e.getMessage());
	            sender.sendMessage(ChatColor.RED + e.getUsage());
	        } catch (WrappedCommandException e) {
	            if (e.getCause() instanceof NumberFormatException) {
	                sender.sendMessage(ChatColor.RED + "Number expected, string received instead.");
	            } else if (e.getCause() instanceof IllegalArgumentException) {
	                sender.sendMessage(ChatColor.RED
	                        + e.getMessage().replace("java.lang.IllegalArgumentException: ", ""));
	            } else {
	                sender.sendMessage(ChatColor.RED + "An error has occurred. See console.");
	                e.printStackTrace();
	            }
	        } catch (CommandException e) {
	            sender.sendMessage(ChatColor.RED + e.getMessage());
	        }
	        return true;
	    }

}
