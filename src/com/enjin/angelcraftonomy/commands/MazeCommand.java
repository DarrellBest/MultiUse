package com.enjin.angelcraftonomy.commands;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.enjin.angelcraftonomy.MultiUseCore;
import com.enjin.angelcraftonomy.extenders.CommandExtender;
import com.enjin.angelcraftonomy.interfaces.CommandInterface;
import com.enjin.angelcraftonomy.maze.Maze;

public class MazeCommand extends CommandExtender implements CommandInterface {

	private Material material;
	private Maze maze;
	private int length;
	private int width;
	private int height;
	private int scale;

	public MazeCommand(MultiUseCore multiuse, CommandSender sender,
			Command command, String label, String[] args) {
		super(multiuse, sender, command, label, args);
		length = 0;
		width = 0;
		height = 0;
		material = null;
		scale = 0;
	}

	@Override
	public void initialize() {
		if (getArgs().length == 6) {
			length = Integer.parseInt(getArgs()[1]);
			width = Integer.parseInt(getArgs()[2]);
			height = Integer.parseInt(getArgs()[3]);
			material = Material.getMaterial(getArgs()[4].toUpperCase());
			scale = Integer.parseInt(getArgs()[5]);
		} else {
			ArrayList<String> messages = new ArrayList<String>();
			messages.add("Please use the following format: ");
			messages.add("/MultiUse Maze [LENGTH] [WIDTH] [HEIGHT] [MATERIAL] [SCALE]");
			sendMessage(messages);
		}
	}

	@Override
	public void run() {
		// if the material is not solid then do not build
		if (material == null) {
			sendMessage("Please choose a building block i.e. STONE, or STAINED_GLASS");
			return;
		}
		if (!material.isSolid()) {
			sendMessage("Please use a physical building block");
			return;
		}
		// if scale is less than 4 then players cannot walk in them
		if (scale < 3) {
			sendMessage("Please choose a scale larger than 2");
			return;
		}
		if (length < 1) {
			sendMessage("Please choose a length of 1 or larger");
			return;
		}
		if (width < 1) {
			sendMessage("Please choose a width of 1 or larger");
			return;
		}
		if (height < 1) {
			sendMessage("Please choose a height of 1 or larger");
			return;
		}
		maze = new Maze(this, length, width, height, material, scale);
		sendMessage("Generating " + length + "x" + width + "x" + height
				+ " Maze");
		sendMessage("Generation Completed");
		maze.generate();
		sendMessage("Building Structure...");
		maze.build(getPlayer());
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
