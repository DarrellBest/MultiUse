package com.enjin.angelcraftonomy.chatfilter;

import java.util.ArrayList;
import java.util.Random;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.enjin.angelcraftonomy.MultiUseCore;

public class PlayerChatListener implements Listener {
	private ChatFilter chatFilter;

	public PlayerChatListener(MultiUseCore multiUse) {
		this.chatFilter = new ChatFilter();
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerChat(AsyncPlayerChatEvent chat) {

		if (chat.isCancelled()) {
			return;
		}

		String message = chat.getMessage();

		if (!chat.getPlayer().isOp()) {
			message = chatFilter.removeSymbols(message);
		}

		if (chat.getPlayer().isOp()) {
			message = ChatColor.YELLOW + message;
		}

		message = chatFilter.upperCase(message);

		if (!chat.getPlayer().hasPermission("multiuse.chat.canswear"))
			message = chatFilter.replaceSwearWords(message);

		chat.setMessage(message);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerCommand(PlayerCommandPreprocessEvent chat) {

		if (chat.isCancelled()) {
			return;
		}

		String message = chat.getMessage();
		if (message.contains("sphere 10 ") || message.contains("sphere 11 ")) {
			message = "";
			chat.getPlayer()
					.sendMessage(
							getRandomColor()
									+ "[MultiUse] Lava spheres are not allowed on this server.");
			return;

		}

		chat.setMessage(message);
	}

	// returns a random color code
	private ChatColor getRandomColor() {
		ChatColor retVal;
		ArrayList<ChatColor> colors = new ArrayList<ChatColor>();
		colors.add(ChatColor.AQUA);
		colors.add(ChatColor.BLUE);
		colors.add(ChatColor.GOLD);
		colors.add(ChatColor.GREEN);
		colors.add(ChatColor.LIGHT_PURPLE);
		colors.add(ChatColor.RED);
		colors.add(ChatColor.YELLOW);

		Random randGen = new Random();
		int randInt = randGen.nextInt(colors.size());

		retVal = colors.get(randInt);
		return retVal;
	}
}
