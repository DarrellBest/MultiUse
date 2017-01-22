package com.enjin.angelcraftonomy.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.enjin.angelcraftonomy.MultiUseCore;
import com.enjin.angelcraftonomy.extenders.CommandExtender;
import com.enjin.angelcraftonomy.interfaces.CommandInterface;

public class HelloCommand extends CommandExtender implements CommandInterface {

	public HelloCommand(MultiUseCore multiuse, CommandSender sender,
			Command command, String label, String[] args) {
		super(multiuse, sender, command, label, args);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize() {
		// nothing to initialize

	}

	@Override
	public void run() {
		sendMessage(" Hi, " + getSender().getName() + "! "
				+ "MultiUse is Functioning properly!");

	}

	@Override
	public void cleanup() {
		// nothing to clean up

	}

	@Override
	public void sendNoPermMessage() {
		// No perms required
	}

}
