package com.enjin.angelcraftonomy.commands;

import java.util.ArrayList;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.enjin.angelcraftonomy.MultiUseCore;
import com.enjin.angelcraftonomy.extenders.CommandExtender;
import com.enjin.angelcraftonomy.interfaces.CommandInterface;

public class PotionCommand extends CommandExtender implements CommandInterface {

	public PotionCommand(MultiUseCore multiuse, CommandSender sender,
			Command command, String label, String[] args) {
		super(multiuse, sender, command, label, args);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {

		if (getArgs().length == 1) {
			sendMessage("/MultiUse Potion [EFFECT] <ALL>");
			return;
		} else if (getArgs().length == 2) {

			if (getArgs()[1].toLowerCase().equals("speed")
					&& getPlayer().hasPermission(
							"multiuse.command.potion.speed")) {
				PotionEffect speed = PotionEffectType.SPEED.createEffect(10000,
						7);
				getPlayer().addPotionEffect(speed, true);
				sendMessage("Your speed has been increased!");
			} else if (getArgs()[1].toLowerCase().equals("invisibility")
					&& getPlayer().hasPermission(
							"multiuse.command.potion.invisibility")) {
				PotionEffect invisibility = PotionEffectType.INVISIBILITY
						.createEffect(10000, 0);
				getPlayer().addPotionEffect(invisibility, true);
				sendMessage("Your have been turned invisible!");
			}

		} else if (getArgs().length == 3
				&& getArgs()[2].toLowerCase().equals("all")) {

			ArrayList<Player> players = getOnlinePlayers();

			if (getArgs()[1].toLowerCase().equals("speed")
					&& getPlayer().hasPermission(
							"multiuse.command.potion.speed.all")) {

				PotionEffect speed = PotionEffectType.SPEED.createEffect(1000,
						7);

				for (Player player : players) {
					player.addPotionEffect(speed, true);
					sendMessage("Your speed has been increased thanks to "
							+ ChatColor.GOLD + getPlayer().getName(), player);
				}

			} else if (getArgs()[1].toLowerCase().equals("invisibility")
					&& getPlayer().hasPermission(
							"multiuse.command.potion.invisibility.all")) {
				PotionEffect invisibility = PotionEffectType.INVISIBILITY
						.createEffect(10000, 0);
				for (Player player : players) {
					sendMessage("Your have been turned invisible by "
							+ ChatColor.GOLD + getPlayer().getName(), player);
				}
			}

		} else if (getArgs().length == 3) {

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
