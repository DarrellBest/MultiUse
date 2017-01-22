package com.enjin.angelcraftonomy.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.enjin.angelcraftonomy.MultiUseCore;
import com.enjin.angelcraftonomy.extenders.CommandExtender;
import com.enjin.angelcraftonomy.interfaces.CommandInterface;

public class ConsoleCommand extends CommandExtender implements CommandInterface {

	public ConsoleCommand(MultiUseCore multiuse, CommandSender sender,
			Command command, String label, String[] args) {
		super(multiuse, sender, command, label, args);
	}

	@Override
	public void initialize() {
		// nothing to init

	}

	@Override
	public void run() {
		StringBuilder cmd = new StringBuilder();

		if (getArgs().length <= 1) {
			sendMessage("/MultiUse Console <command>");
			return;
		}

		for (int i = 1; i < getArgs().length; i++) {
			cmd.append(getArgs()[i] + " ");
		}

		String finalCmd = cmd.toString().trim();
		doCommand(finalCmd);
		sendMessage(" Command has been logged and reported.");

	}

	@Override
	public void cleanup() {
		// nothing to clean up

	}

	@Override
	public void sendNoPermMessage() {
		super.sendNoPermMessage();
	}

}
