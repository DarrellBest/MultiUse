package com.enjin.angelcraftonomy.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.enjin.angelcraftonomy.MultiUseCore;
import com.enjin.angelcraftonomy.extenders.CommandExtender;
import com.enjin.angelcraftonomy.interfaces.CommandInterface;

public class ClearCommand extends CommandExtender implements CommandInterface {

	Player player;

	public ClearCommand(MultiUseCore multiuse, CommandSender sender,
			Command command, String label, String[] args) {
		super(multiuse, sender, command, label, args);

	}

	@Override
	public void initialize() {
		player = getPlayer();

	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			player.sendMessage("\n");
		}
	}

	@Override
	public void cleanup() {
		player.sendMessage(ChatColor.GREEN + "[MultiUse] " + ChatColor.YELLOW
				+ "Chat cleared ");
	}

	@Override
	public void sendNoPermMessage() {
		super.sendNoPermMessage();
	}

}
