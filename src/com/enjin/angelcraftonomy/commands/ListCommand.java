package com.enjin.angelcraftonomy.commands;

import java.util.ArrayList;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.enjin.angelcraftonomy.MultiUseCore;
import com.enjin.angelcraftonomy.extenders.CommandExtender;
import com.enjin.angelcraftonomy.interfaces.CommandInterface;

public class ListCommand extends CommandExtender implements CommandInterface {

	private ArrayList<String> messages;
	private ChatColor colorOne;

	public ListCommand(MultiUseCore multiuse, CommandSender sender,
			Command command, String label, String[] args) {
		super(multiuse, sender, command, label, args);
		messages = new ArrayList<String>();
	}

	@Override
	public void initialize() {
		colorOne = getRandomColor();
	}

	@Override
	public void run() {
		messages.add("---------------- MultiUse v1.0 ----------------");
		messages.add("Created and Designed by UsuriousAngel");
		messages.add(" /" + getCommand().getName() + " list : " + colorOne
				+ "Shows the commands");
		messages.add(" /" + getCommand().getName() + " version : " + colorOne
				+ "Shows the current version");
		messages.add(" /" + getCommand().getName() + " clear : " + colorOne
				+ "Clears your chat");
		messages.add(" /" + getCommand().getName() + " potion : " + colorOne
				+ "Adds potion effect");
		messages.add(" /" + getCommand().getName() + " clearall : " + colorOne
				+ "Clears everyones chat");
		messages.add(" /" + getCommand().getName() + " giveaway : " + colorOne
				+ "Gives a random player a reward");
		messages.add(" /" + getCommand().getName() + " maze : " + colorOne
				+ "generates a maze");
		messages.add(" /" + getCommand().getName() + " reload : " + colorOne
				+ "Reloads the plugin");
		messages.add(" /" + getCommand().getName() + " restart : " + colorOne
				+ "Kicks all players and restarts");
		messages.add(" /" + getCommand().getName() + " author : " + colorOne
				+ "Displays the author");
		messages.add(" /" + getCommand().getName() + " hello : " + colorOne
				+ "Tests to see if the plugin is working");
		messages.add(" /" + getCommand().getName() + " console: " + colorOne
				+ "Performs command");
		messages.add(" /" + getCommand().getName() + " gamemode: " + colorOne
				+ "Changes your gamemode");
		messages.add(" /" + getCommand().getName() + " aution : " + colorOne
				+ "Shows the commands");
		messages.add("--------------------------------------------");
		sendMessage(messages);
	}

	@Override
	public void cleanup() {
		messages.clear();
	}

	@Override
	public void sendNoPermMessage() {
		super.sendNoPermMessage();
	}

}
