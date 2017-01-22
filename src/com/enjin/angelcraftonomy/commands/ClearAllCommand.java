package com.enjin.angelcraftonomy.commands;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.enjin.angelcraftonomy.MultiUseCore;
import com.enjin.angelcraftonomy.extenders.CommandExtender;
import com.enjin.angelcraftonomy.interfaces.CommandInterface;

public class ClearAllCommand extends CommandExtender implements
		CommandInterface {

	private ArrayList<Player> players;

	public ClearAllCommand(MultiUseCore multiuse, CommandSender sender,
			Command command, String label, String[] args) {
		super(multiuse, sender, command, label, args);
		players = new ArrayList<Player>();
	}

	@Override
	public void initialize() {
		players.addAll(getOnlinePlayers());
	}

	@Override
	public void run() {
		for (Player player : players) {
			for (int i = 0; i < 100; i++) {
				player.sendMessage("\n");
			}
			player.sendMessage(ChatColor.GREEN + "[MultiUse]"
					+ ChatColor.YELLOW + " Chat cleared by "
					+ getSender().getName());
		}
	}

	@Override
	public void cleanup() {
		players.clear();

	}

	@Override
	public void sendNoPermMessage() {
		super.sendNoPermMessage();
	}

}
