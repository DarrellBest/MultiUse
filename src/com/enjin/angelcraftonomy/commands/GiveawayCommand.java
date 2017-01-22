package com.enjin.angelcraftonomy.commands;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.enjin.angelcraftonomy.MultiUseCore;
import com.enjin.angelcraftonomy.extenders.CommandExtender;
import com.enjin.angelcraftonomy.interfaces.CommandInterface;

public class GiveawayCommand extends CommandExtender implements
		CommandInterface {

	private ArrayList<Player> players;
	private ArrayList<String> rewards;

	public GiveawayCommand(MultiUseCore multiuse, CommandSender sender,
			Command command, String label, String[] args) {
		super(multiuse, sender, command, label, args);
		rewards = new ArrayList<String>();
		players = new ArrayList<Player>();
	}

	@Override
	public void initialize() {
		addRewards(rewards);
		players.addAll(getOnlinePlayers());
		players.remove(players.indexOf(getSender()));
	}

	@Override
	public void run() {
		String player = "";
		int randInt = -1;
		Random randGenerator = new Random();

		if (players.size() == 0) {
			sendMessage(" There are no players online besides you silly!");
			return;
		}

		// If player is specified, use that instead of random
		if (getArgs().length == 2) {
			for (Player p : players) {
				if (p.getName().toLowerCase()
						.equals(getArgs()[1].toLowerCase())) {
					player = getArgs()[1];
					break;
				}
			}

		} else if (getArgs().length == 1) {
			// get a random player
			randInt = randGenerator.nextInt(players.size());
			player = players.get(randInt).getName();
		} else if (player.equals("")) {
			sendMessage("You cannot enter your own name");
			return;
		} else {
			ArrayList<String> message = new ArrayList<String>();
			message.add("Please use the format:");
			message.add("/MultiUse Giveaway <PLAYER>");
			sendMessage(message);
			return;
		}

		// get random reward
		randInt = randGenerator.nextInt(rewards.size());
		String reward = rewards.get(randInt);

		// replace %player% with actual player
		reward = reward.replace("%player%", player);

		doCommand(reward);

		for (Player p : getOnlinePlayers()) {
			p.sendMessage(player + " got lucky and recieved a giveaway!");
		}

		sendMessage("Reward Command: " + reward);

	}

	@Override
	public void cleanup() {

	}

	@Override
	public void sendNoPermMessage() {
		super.sendNoPermMessage();
	}

	private void addRewards(ArrayList<String> rewards) {
		rewards.add("give %player% diamond 5");
		rewards.add("give %player% diamond 10");
		rewards.add("give %player% diamond 20");
		rewards.add("give %player% diamond 30");
		rewards.add("give %player% diamondblock 1");
		rewards.add("give %player% diamondblock 5");
		rewards.add("give %player% diamondblock 10");
		rewards.add("give %player% emerald 5");
		rewards.add("give %player% emerald 10");
		rewards.add("give %player% emerald 20");
		rewards.add("give %player% emerald 30");
		rewards.add("give %player% emeraldblock 1");
		rewards.add("give %player% emeraldblock 5");
		rewards.add("give %player% emeraldblock 10");
		rewards.add("give %player% nametag 5");
		rewards.add("give %player% nametag 10");
		rewards.add("give %player% nametag 20");
		rewards.add("give %player% nametag 30");
		rewards.add("give %player% packedice 64");
		rewards.add("give %player% packedice 128");
		rewards.add("give %player% packedice 256");
		rewards.add("give %player% packedice 512");
		rewards.add("give %player% quartzblock 64");
		rewards.add("give %player% quartzblock 128");
		rewards.add("give %player% quartzblock 256");
		rewards.add("give %player% quartzblock 512");
		rewards.add("give %player% purpurblock 64");
		rewards.add("give %player% purpurblock 128");
		rewards.add("give %player% purpurblock 256");
		rewards.add("give %player% purpurblock 512");
		rewards.add("give %player% dragonegg 1");
		rewards.add("give %player% dragonegg 2");
		rewards.add("give %player% elytra 1");
		rewards.add("give %player% elytra 2");
		rewards.add("give %player% goldenapple:0 5");
		rewards.add("give %player% goldenapple:0 10");
		rewards.add("give %player% goldenapple:1 5");
		rewards.add("give %player% goldenapple:1 10");
		rewards.add("give %player% experience_bottle 32");
		rewards.add("give %player% experience_bottle 64");
		rewards.add("give %player% experience_bottle 128");
		rewards.add("give %player% experience_bottle 256");
		rewards.add("sf give %player% LUCKY_BLOCK");
		rewards.add("sf give %player% LUCKY_BLOCK");
		rewards.add("sf give %player% LUCKY_BLOCK");
		rewards.add("sf give %player% LUCKY_BLOCK");
		rewards.add("sf give %player% LUCKY_BLOCK");
		rewards.add("sf give %player% LUCKY_BLOCK");
		rewards.add("sf give %player% LUCKY_BLOCK");
		rewards.add("sf give %player% LUCKY_BLOCK");
		rewards.add("sf give %player% LUCKY_BLOCK");
		rewards.add("sf give %player% LUCKY_BLOCK");
		rewards.add("sf give %player% soulbound_sword");
		rewards.add("sf give %player% soulbound_pickaxe");
		rewards.add("sf give %player% soulbound_bow");
		rewards.add("sf give %player% soulbound_shovel");
		rewards.add("sf give %player% soulbound_axe");
	}

}
