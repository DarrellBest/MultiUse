package com.enjin.angelcraftonomy;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import com.enjin.angelcraftonomy.chatfilter.PlayerChatListener;

public class MultiUseCore extends JavaPlugin {

	public static MultiUseCore plugin;
	public static Logger logger;
	public final PlayerChatListener playerListener = new PlayerChatListener(
			this);

	private MultiUseCommandExecutor myCommands;

	// Fired when plugin is first enabled
	@Override
	public void onEnable() {
		System.out.println("[MultiUse] Enabling MultiUse v1.0");
		logger = this.getLogger();

		plugin = this;

		// PluginManager pm = getServer().getPluginManager();
		// pm.registerEvents(this.playerListener, this);

		myCommands = new MultiUseCommandExecutor(this);
		getCommand("MultiUse").setExecutor(myCommands);

		logger.info("Online.");
	}

	// Fired when plugin is disabled
	@Override
	public void onDisable() {
		System.out.println("[MultiUse] Disabling MultiUse v1.0");
		logger.info("--- END OF LINE ---");
	}

}

/*
 * 
 * Killing a hologram:
 * 
 * /minecraft:kill @e[type=ArmorStand,r=3]
 */