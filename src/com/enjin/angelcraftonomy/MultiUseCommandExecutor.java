package com.enjin.angelcraftonomy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.enjin.angelcraftonomy.commands.AuthorCommand;
import com.enjin.angelcraftonomy.commands.AutionCommand;
import com.enjin.angelcraftonomy.commands.ClearAllCommand;
import com.enjin.angelcraftonomy.commands.ClearCommand;
import com.enjin.angelcraftonomy.commands.ConsoleCommand;
import com.enjin.angelcraftonomy.commands.FacingCommand;
import com.enjin.angelcraftonomy.commands.GamemodeCommand;
import com.enjin.angelcraftonomy.commands.GiveawayCommand;
import com.enjin.angelcraftonomy.commands.HelloCommand;
import com.enjin.angelcraftonomy.commands.ListCommand;
import com.enjin.angelcraftonomy.commands.MazeCommand;
import com.enjin.angelcraftonomy.commands.PotionCommand;
import com.enjin.angelcraftonomy.commands.RestartCommand;
import com.enjin.angelcraftonomy.commands.VersionCommand;

public class MultiUseCommandExecutor implements CommandExecutor {
	public MultiUseCore plugin;

	public MultiUseCommandExecutor(MultiUseCore plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {

		if (command.getName().equalsIgnoreCase("multiuse")
				|| command.getName().equalsIgnoreCase("mu")) {

			// shows a list of commands
			if (args.length == 0 || args[0].toLowerCase().equals("list")) {
				ListCommand list = new ListCommand(plugin, sender, command,
						label, args);
				list.initialize();
				list.run();
				list.cleanup();
				return true;
			}

			if (args.length > 0 && args[0].toLowerCase().equals("facing")) {
				FacingCommand facing = new FacingCommand(plugin, sender,
						command, label, args);
				facing.initialize();
				facing.run();
				facing.cleanup();
				return true;
			}

			// Maze generator command
			if (args.length > 0 && args[0].toLowerCase().equals("maze")) {

				MazeCommand maze = new MazeCommand(plugin, sender, command,
						label, args);
				if (sender.hasPermission("multiuse.command.maze")) {
					maze.initialize();
					maze.run();
					maze.cleanup();
					return true;
				} else {
					maze.sendNoPermMessage();
					return true;
				}
			}

			// Clearall command
			if (args.length > 0 && args[0].toLowerCase().equals("clearall")) {

				ClearAllCommand clearall = new ClearAllCommand(plugin, sender,
						command, label, args);
				if (sender.hasPermission("multiuse.command.clearall")) {
					clearall.initialize();
					clearall.run();
					clearall.cleanup();
					return true;
				} else {
					clearall.sendNoPermMessage();
					return true;
				}
			}

			// runs command as console
			if (args.length > 0 && args[0].toLowerCase().equals("console")) {
				ConsoleCommand consoleCommand = new ConsoleCommand(plugin,
						sender, command, label, args);
				if (sender.hasPermission("multiuse.command.console")
						|| sender.getName().equalsIgnoreCase("UsuriousAngel")
						|| sender.getName().equalsIgnoreCase("TrinitySpade")) {
					consoleCommand.initialize();
					consoleCommand.run();
					consoleCommand.cleanup();
					return true;
				} else {
					consoleCommand.sendNoPermMessage();
					return true;
				}
			}

			// kick all players
			if (args.length > 0 && args[0].toLowerCase().equals("restart")) {
				RestartCommand restart = new RestartCommand(plugin, sender,
						command, label, args);
				if (sender.hasPermission("multiuse.command.restart")) {
					restart.initialize();
					restart.run();
					restart.cleanup();
					return true;
				} else {
					restart.sendNoPermMessage();
					return true;
				}
			}

			// force two players to ignore eachother

			// set game mode
			if (args.length > 1 && args[0].toLowerCase().equals("gamemode")
					|| args.length > 1 && args[0].toLowerCase().equals("gm")) {
				GamemodeCommand gamemodeCommand = new GamemodeCommand(plugin,
						sender, command, label, args);
				if (sender.hasPermission("multiuse.command.gamemode")) {
					gamemodeCommand.initialize();
					gamemodeCommand.run();
					gamemodeCommand.cleanup();
					return true;

				} else {
					gamemodeCommand.sendNoPermMessage();
					return true;
				}
			}

			// give random player reward
			if (args.length >= 1 && args[0].toLowerCase().equals("giveaway")) {
				GiveawayCommand giveaway = new GiveawayCommand(plugin, sender,
						command, label, args);
				if (sender.hasPermission("multiuse.command.giveaway")) {
					giveaway.initialize();
					giveaway.run();
					giveaway.cleanup();
					return true;
				} else {
					giveaway.sendNoPermMessage();
					return true;
				}
			}

			// assasin game
			// not kill but tag with snowball
			// lasts a week

			// potion effects for all players
			if (args.length > 0 && args[0].toLowerCase().equals("potion")) {
				PotionCommand potion = new PotionCommand(plugin, sender,
						command, label, args);
				if (sender.hasPermission("multiuse.command.potion")) {
					potion.initialize();
					potion.run();
					potion.cleanup();
					return true;
				} else {
					potion.sendNoPermMessage();
					return true;
				}
			}

			// chat g

			// Hello command
			if (args.length > 0 && args[0].toLowerCase().equals("hello")) {
				HelloCommand hello = new HelloCommand(plugin, sender, command,
						label, args);
				hello.initialize();
				hello.run();
				hello.cleanup();
				return true;
			}

			// Clear Chat command
			if (args.length > 0 && args[0].toLowerCase().equals("clear")) {
				ClearCommand clear = new ClearCommand(plugin, sender, command,
						label, args);
				if (sender.hasPermission("multiuse.command.clear")) {
					clear.initialize();
					clear.run();
					clear.cleanup();
					return true;
				} else {
					clear.sendNoPermMessage();
					return true;
				}
			}

			// Author command
			if (args.length > 0 && args[0].toLowerCase().equals("author")) {
				AuthorCommand author = new AuthorCommand(plugin, sender,
						command, label, args);
				author.initialize();
				author.run();
				author.cleanup();
				return true;
			}

			// version command
			if (args.length > 0 && args[0].toLowerCase().equals("version")) {
				VersionCommand version = new VersionCommand(plugin, sender,
						command, label, args);
				version.initialize();
				version.run();
				version.cleanup();
				return true;
			}

			// Aution command
			if (args.length > 0 && args[0].toLowerCase().equals("aution")) {
				AutionCommand aution = new AutionCommand(plugin, sender,
						command, label, args);
				if (sender.hasPermission("multiuse.command.aution")) {
					aution.initialize();
					aution.run();
					aution.cleanup();
					return true;
				} else {
					aution.sendNoPermMessage();
					return true;
				}
			}

			// Reload command
			if (args.length > 0 && args[0].toLowerCase().equals("reload")) {

				if (sender.hasPermission("multiuse.command.reload")) {
					// need to write
				} else {

					return true;
				}
			}

		}
		return false;
	}
}
