package com.enjin.angelcraftonomy.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.enjin.angelcraftonomy.MultiUseCore;
import com.enjin.angelcraftonomy.extenders.CommandExtender;
import com.enjin.angelcraftonomy.interfaces.CommandInterface;

public class AuthorCommand extends CommandExtender implements CommandInterface {

	public AuthorCommand(MultiUseCore multiuse, CommandSender sender,
			Command command, String label, String[] args) {
		super(multiuse, sender, command, label, args);
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		sendMessage(" Created and designed by UsuriousAngel.");
	}

	@Override
	public void cleanup() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendNoPermMessage() {
		// No perms required
	}

}
