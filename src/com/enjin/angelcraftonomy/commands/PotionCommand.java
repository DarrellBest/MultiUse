package com.enjin.angelcraftonomy.commands;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.enjin.angelcraftonomy.MultiUseCore;
import com.enjin.angelcraftonomy.extenders.CommandExtender;
import com.enjin.angelcraftonomy.interfaces.CommandInterface;

public class PotionCommand extends CommandExtender implements CommandInterface {

	private ArrayList<Player> players;
	// 1200 times per minute
	private int timeMinutes;
	// 0 = self, 1 = all, 2 = others
	private int effectRange;
	// this is usually set from 1-10 depending on the effect
	private int intensity;
	private PotionEffectType potionEffectType;
	private int TICKS_PER_MINUTE = 1200;

	public PotionCommand(MultiUseCore multiuse, CommandSender sender,
			Command command, String label, String[] args) {
		super(multiuse, sender, command, label, args);
	}

	@Override
	public void initialize() {
		players = getOnlinePlayers();
		// default time is 1 minute
		timeMinutes = 1 * TICKS_PER_MINUTE;
		// default range is self
		effectRange = 0;
		// default intensity
		intensity = 1;
		// default potion effect set to speed
		potionEffectType = PotionEffectType.SPEED;

		// set range if specified otherwise
		if (getArgs().length >= 3) {
			if (getArgs()[2].toLowerCase().equals("all"))
				effectRange = 1;
			if (getArgs()[2].toLowerCase().equals("others"))
				effectRange = 2;
		}

		// set time in minutes if specified
		if (getArgs().length >= 4) {
			timeMinutes = Integer.parseInt(getArgs()[3]) * TICKS_PER_MINUTE;
		}

		// set intensity if specified
		if (getArgs().length >= 5) {
			intensity = Integer.parseInt(getArgs()[4]);
		}

		// set specific potion effect type
		if (getArgs().length >= 2)
			switch (getArgs()[1].toLowerCase()) {
			case ("speed"):
				potionEffectType = PotionEffectType.SPEED;
				break;
			case ("slowness"):
				potionEffectType = PotionEffectType.SLOW;
				break;
			case ("haste"):
				potionEffectType = PotionEffectType.FAST_DIGGING;
				break;
			case ("miningfatigue"):
				potionEffectType = PotionEffectType.SLOW_DIGGING;
				break;
			case ("strength"):
				potionEffectType = PotionEffectType.INCREASE_DAMAGE;
				break;
			case ("health"):
				potionEffectType = PotionEffectType.HEAL;
				break;
			case ("damage"):
				potionEffectType = PotionEffectType.HARM;
				break;
			case ("jumpboost"):
				potionEffectType = PotionEffectType.JUMP;
				break;
			case ("nausea"):
				potionEffectType = PotionEffectType.CONFUSION;
				break;
			case ("regeneration"):
				potionEffectType = PotionEffectType.REGENERATION;
				break;
			case ("resistance"):
				potionEffectType = PotionEffectType.DAMAGE_RESISTANCE;
				break;
			case ("fireresistance"):
				potionEffectType = PotionEffectType.FIRE_RESISTANCE;
				break;
			case ("waterbreathing"):
				potionEffectType = PotionEffectType.WATER_BREATHING;
				break;
			case ("invisibilty"):
				potionEffectType = PotionEffectType.INVISIBILITY;
				break;
			case ("blindness"):
				potionEffectType = PotionEffectType.BLINDNESS;
				break;
			case ("nightvision"):
				potionEffectType = PotionEffectType.NIGHT_VISION;
				break;
			case ("hunger"):
				potionEffectType = PotionEffectType.HUNGER;
				break;
			case ("weakness"):
				potionEffectType = PotionEffectType.WEAKNESS;
				break;
			case ("wither"):
				potionEffectType = PotionEffectType.WITHER;
				break;
			case ("healthboost"):
				potionEffectType = PotionEffectType.HEALTH_BOOST;
				break;
			case ("absorption"):
				potionEffectType = PotionEffectType.ABSORPTION;
				break;
			case ("saturation"):
				potionEffectType = PotionEffectType.SATURATION;
				break;
			case ("glowing"):
				potionEffectType = PotionEffectType.GLOWING;
				break;
			case ("levitation"):
				potionEffectType = PotionEffectType.LEVITATION;
				break;
			case ("luck"):
				potionEffectType = PotionEffectType.LUCK;
				break;
			case ("badluck"):
				potionEffectType = PotionEffectType.UNLUCK;
				break;
			}
	}

	@Override
	public void run() {

		if (getArgs().length <= 1) {
			sendMessage("/MultiUse Potion [EFFECT] <SELF/ALL/OTHERS> <MINUTES> <INTENSITY>"
					+ "                                            \n"
					+ "Potion Effects: Speed, Slowness, Haste, MiningFatigue,"
					+ " Strength, Health, Damage, JumpBoost, Nausea, Regeneration, "
					+ "Resistance, FireResistance, WaterBreathing, Invisibility, "
					+ "Blindness, Nightvision, Hunger, Weakness, Wither, HealthBoost,"
					+ " Absorption, Saturation, Glowing, Levitation, Luck, Badluck.");
			return;

		} else {
			PotionEffect potionEffect = potionEffectType.createEffect(
					timeMinutes, intensity);
			applyPotionEffect(effectRange, potionEffect);
		}
	}

	@Override
	public void cleanup() {
		players.clear();
	}

	@Override
	public void sendNoPermMessage() {
		super.sendNoPermMessage();
	}

	private void applyPotionEffect(int effectRange, PotionEffect potionEffect) {
		// 0 = self, 1 = all, 2 = others
		if (effectRange == 0) {
			getPlayer().addPotionEffect(potionEffect, true);

		} else {
			// if 2 then it removes the command sender, if 1, then it applies to
			// all players
			if (effectRange == 2)
				players.remove(getPlayer());

			for (Player player : players) {
				sendMessage("You have recieved "
						+ potionEffect.getType().getName() + " for "
						+ (potionEffect.getDuration() / TICKS_PER_MINUTE)
						+ " minutes" + " from " + ChatColor.GOLD
						+ getPlayer().getName(), player);
				player.addPotionEffect(potionEffect, true);
			}
		}
	}
}
