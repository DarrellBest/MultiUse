package com.enjin.angelcraftonomy.extenders;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.enjin.angelcraftonomy.MultiUseCore;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;

// To be extended!

@SuppressWarnings("unused")
public class CommandExtender {

	private MultiUseCore multiuse;
	protected CommandSender sender;
	private Command command;
	private String label;
	private String[] args;

	public CommandExtender(MultiUseCore multiuse, CommandSender sender,
			Command command, String label, String[] args) {
		this.multiuse = multiuse;
		this.sender = sender;
		this.command = command;
		this.label = label;
		this.args = args;
	}

	// Executes a command from the console
	protected void doCommand(String command) {
		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), command);
	}

	// sends the no perm message
	protected void sendNoPermMessage() {
		// ChatComponent
		Player player = getPlayer();
		ArrayList<String> messages = new ArrayList<>();
		player.sendMessage(ChatColor.GREEN + "[MultiUse] " + ChatColor.YELLOW
				+ "You do not have permission to use this command.");
	}

	// send player a message
	protected void sendMessage(String message) {
		Player player = getPlayer();
		ChatColor colorOne = ChatColor.GREEN;
		ChatColor colorTwo = ChatColor.YELLOW;
		player.spigot().sendMessage(new ComponentBuilder("[MultiUse] ")
				.color(colorOne).append(message).color(colorTwo).create());
	}

	// send player a message
	protected void sendMessage(String message, Player p) {
		ChatColor colorOne = ChatColor.GREEN;
		ChatColor colorTwo = ChatColor.YELLOW;
		p.spigot().sendMessage(new ComponentBuilder("[MultiUse] ")
				.color(colorOne).append(message).color(colorTwo).create());
	}

	protected void sendMessage(ArrayList<String> messages) {
		Player player = getPlayer();
		ChatColor colorOne = getRandomColor();
		ChatColor colorTwo = getRandomColor();
		for (String message : messages) {
			player.spigot().sendMessage(new ComponentBuilder(" ")
					.color(colorOne).append(message).color(colorTwo).create());
		}
	}

	// returns a random color code
	protected ChatColor getRandomColor() {
		ChatColor retVal;
		ArrayList<ChatColor> colors = new ArrayList<>();
		colors.add(ChatColor.AQUA);
		colors.add(ChatColor.BLUE);
		colors.add(ChatColor.GOLD);
		colors.add(ChatColor.GREEN);
		colors.add(ChatColor.LIGHT_PURPLE);
		colors.add(ChatColor.RED);
		colors.add(ChatColor.YELLOW);

		Random randGen = new Random();
		int randInt = randGen.nextInt(colors.size());

		retVal = colors.get(randInt);
		return retVal;
	}

	// get a list of online players
	protected ArrayList<Player> getOnlinePlayers() {
		ArrayList<Player> players = new ArrayList<>(
				Bukkit.getOnlinePlayers());
		return players;
	}

	protected Player getPlayer() {
		ArrayList<Player> players = getOnlinePlayers();
		Player player = players.get(players.indexOf(sender));
		return player;
	}

	public MultiUseCore getMultiuse() {
		return multiuse;
	}

	public CommandSender getSender() {
		return sender;
	}

	public Command getCommand() {
		return command;
	}

	public String getLabel() {
		return label;
	}

	public String[] getArgs() {
		return args;
	}

}
