package com.enjin.angelcraftonomy.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.enjin.angelcraftonomy.MultiUseCore;
import com.enjin.angelcraftonomy.extenders.CommandExtender;
import com.enjin.angelcraftonomy.interfaces.CommandInterface;

public class FacingCommand extends CommandExtender implements CommandInterface {

	public FacingCommand(MultiUseCore multiuse, CommandSender sender,
			Command command, String label, String[] args) {
		super(multiuse, sender, command, label, args);
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		long x = Math.round(getPlayer().getLocation().getDirection().getX());
		long z = Math.round(getPlayer().getLocation().getDirection().getZ());

		if ((x == 0 || x == -1) && z == 1)
			sendMessage("south");
		if (x == -1 && (z == 0 || z == -1))
			sendMessage("west");
		if ((x == 0 || x == 1) && z == -1)
			sendMessage("north");
		if (x == 1 && (z == 0 || z == 1))
			sendMessage("east");

	}

	@Override
	public void cleanup() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendNoPermMessage() {
		super.sendNoPermMessage();
	}

}
