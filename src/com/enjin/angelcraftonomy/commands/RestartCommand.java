package com.enjin.angelcraftonomy.commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.enjin.angelcraftonomy.MultiUseCore;
import com.enjin.angelcraftonomy.extenders.CommandExtender;
import com.enjin.angelcraftonomy.interfaces.CommandInterface;

public class RestartCommand extends CommandExtender implements CommandInterface {

	private ArrayList<Player> players;

	public RestartCommand(MultiUseCore multiuse, CommandSender sender,
			Command command, String label, String[] args) {
		super(multiuse, sender, command, label, args);
		this.players = new ArrayList<Player>();
	}

	@Override
	public void initialize() {
		players = getOnlinePlayers();
	}

	@Override
	public void run() {
		for (Player player : players) {
			player.kickPlayer("Restarting: Please wait 60 seconds before reconnecting.");
		}
		// if sh is set up correctly, stopping the server will restart it
		doCommand("stop");
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
