package com.enjin.angelcraftonomy.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.enjin.angelcraftonomy.MultiUseCore;
import com.enjin.angelcraftonomy.extenders.CommandExtender;
import com.enjin.angelcraftonomy.interfaces.CommandInterface;

public class VersionCommand extends CommandExtender implements CommandInterface {

	public VersionCommand(MultiUseCore multiuse, CommandSender sender,
			Command command, String label, String[] args) {
		super(multiuse, sender, command, label, args);
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		sendMessage("You are running MultiUse version 1.0");
	}

	@Override
	public void cleanup() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendNoPermMessage() {
		super.sendNoPermMessage();
	}

	@Override
	public void sendMessage(String message) {
		super.sendMessage(message);
	}

}
