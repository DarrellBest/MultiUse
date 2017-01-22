package com.enjin.angelcraftonomy.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.enjin.angelcraftonomy.MultiUseCore;
import com.enjin.angelcraftonomy.extenders.CommandExtender;
import com.enjin.angelcraftonomy.interfaces.CommandInterface;

public class GamemodeCommand extends CommandExtender implements
		CommandInterface {

	String gm;

	public GamemodeCommand(MultiUseCore multiuse, CommandSender sender,
			Command command, String label, String[] args) {
		super(multiuse, sender, command, label, args);
	}

	@Override
	public void initialize() {
		gm = "";
		// check to see if argument was provided
		if (getArgs()[1] != null) {
			gm = getArgs()[1];
		}

	}

	@Override
	public void run() {

		if (gm.equals("")) {
			sendMessage("Incorrect formating. Please use the following");
			sendMessage("/MultiUse gamemode <gamemode>");
			return;
		}
		// check to see if argument was provided
		if (getArgs()[1] != null) {
			gm = getArgs()[1];
		} else {
			sendMessage("Incorrect formating. Please use the following");
			sendMessage("/MultiUse gamemode <gamemode>");
			return;
		}

		// Survival mode 0
		if (getSender().hasPermission("multiuse.command.gamemode.survival")
				&& (gm.toLowerCase().equals("survival") || gm.toLowerCase()
						.equals("0"))) {

			getPlayer().setGameMode(GameMode.SURVIVAL);

			sendMessage("You are in Survival mode");
			sendMessage("Command has been" + " logged and reported");
			System.out.println((getPlayer().getName()
					+ " Entered survival mode in " + getPlayer().getWorld()
					.getName()));
			return;
		}
		// Creative mode 1
		else if (getSender()
				.hasPermission("multiuse.command.gamemode.creative")
				&& (gm.toLowerCase().equals("creative") || gm.toLowerCase()
						.equals("1"))) {

			getPlayer().setGameMode(GameMode.CREATIVE);

			sendMessage("You are in Creative mode");
			sendMessage("Command has been" + " logged and reported");
			System.out.println((getPlayer().getName()
					+ " Entered creative mode in " + getPlayer().getWorld()
					.getName()));
			return;
		}
		// Spectator mode 3
		else if (getSender().hasPermission(
				"multiuse.command.gamemode.spectator")
				&& (gm.toLowerCase().equals("spectator") || gm.toLowerCase()
						.equals("3"))) {

			getPlayer().setGameMode(GameMode.SPECTATOR);

			sendMessage("You are in Spectator mode");
			sendMessage("Command has been logged and reported");
			System.out.println((getPlayer().getName()
					+ " Entered spectator mode in " + getPlayer().getWorld()
					.getName()));
			return;
		} else if (getSender().hasPermission(
				"multiuse.command.gamemode.adventure")
				&& (gm.toLowerCase().equals("adventure") || gm.toLowerCase()
						.equals("2"))) {

			getPlayer().setGameMode(GameMode.ADVENTURE);

			sendMessage("You are in Adventure mode");
			sendMessage("Command has been logged and reported");
			System.out.println((getPlayer().getName()
					+ " Entered adventure mode in " + getPlayer().getWorld()
					.getName()));
			return;
		} else {
			sendNoPermMessage();
			return;
		}

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
