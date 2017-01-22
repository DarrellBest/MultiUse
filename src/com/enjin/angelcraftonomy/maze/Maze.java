package com.enjin.angelcraftonomy.maze;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.enjin.angelcraftonomy.commands.MazeCommand;

@SuppressWarnings("unused")
public class Maze {

	private ArrayList<ArrayList<ArrayList<Room>>> rooms;
	private int length;
	private int width;
	private int height;
	private Material material;
	private MazeCommand mazeCommand;
	private int scale;

	// length, width, and height refers to the number of rooms in those
	// directions
	public Maze(MazeCommand mazeCommand, int length, int width, int height,
			Material material, int scale) {

		this.length = length;
		this.width = width;
		this.height = height;
		this.material = material;
		this.mazeCommand = mazeCommand;
		this.scale = scale;
		this.rooms = new ArrayList<ArrayList<ArrayList<Room>>>();

		Room tempRoom;
		Coordinate coord;
		for (int x = 0; x < length; x++) {
			ArrayList<ArrayList<Room>> xList = new ArrayList<ArrayList<Room>>();
			rooms.add(xList);
			for (int y = 0; y < height; y++) {
				ArrayList<Room> yList = new ArrayList<Room>();
				rooms.get(x).add(yList);
				for (int z = 0; z < width; z++) {
					Room zRoom = new Room(x, y, z);
					rooms.get(x).get(y).add(zRoom);
				}
			}
		}

		for (int x = 0; x < length; x++) {
			for (int y = 0; y < height; y++) {
				for (int z = 0; z < width; z++) {

					Room temp = rooms.get(x).get(y).get(z);

					if (x - 1 >= 0)
						temp.addNeighbor(rooms.get(x - 1).get(y).get(z));
					if (x + 1 < length)
						temp.addNeighbor(rooms.get(x + 1).get(y).get(z));
					if (y - 1 >= 0)
						temp.addNeighbor(rooms.get(x).get(y - 1).get(z));
					if (y + 1 < height)
						temp.addNeighbor(rooms.get(x).get(y + 1).get(z));
					if (z - 1 >= 0)
						temp.addNeighbor(rooms.get(x).get(y).get(z - 1));
					if (z + 1 < width)
						temp.addNeighbor(rooms.get(x).get(y).get(z + 1));
				}
			}
		}

	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void generate() {
		long startTime = System.nanoTime();
		int order = 1;
		String direction;
		// get random starting room
		Random random = new Random();

		int x = random.nextInt(length);
		int y = random.nextInt(height);
		int z = random.nextInt(width);

		Room current = rooms.get(x).get(y).get(z);
		current.setVisited(true);
		current.setOrder(order);

		Stack<Room> stack = new Stack<Room>();
		stack.add(current);

		CommandSender sender = this.mazeCommand.getSender();

		/* while there are unvisited cells */
		while (!stack.isEmpty()) {
			// if current room has an unvisited neighbor
			if (current.hasUnvisited()) {
				// not needed but I like to see the order
				if (current.getOrder() == 0)
					current.setOrder(order);

				// choose one room randomly
				Room randRoom = current.getRandomNeighbor();

				// push current room onto a stack
				stack.add(current);

				// remove wall between current room and chosen room
				direction = current.getCoord().calculateDirection(
						randRoom.getCoord());
				current.removeWall(direction);

				// remove wall between chosen room and current room
				direction = randRoom.getCoord().calculateDirection(
						current.getCoord());
				randRoom.removeWall(direction);

				// make the chosen room the current room
				current = randRoom;

				// mark it as visited
				current.setVisited(true);
				order++;
			} else if (!stack.isEmpty() /* stack not empty */) {
				// pop a cell from the stack and make it the current cell
				current = stack.pop();
			}
		}
		this.mazeCommand.sendMessage("Generation Completed");
	}

	public void build(Player player) {
		// build maze
		Location loc = player.getLocation();
		loc.add(1, 0, 1);

		Room currentRoom;
		int totalRooms = length * width * height;
		int roomCount = 0;
		double percentComplete = 0;

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < length; x++) {
				for (int z = 0; z < width; z++) {
					roomCount++;

					loc.add(x * (scale - 1), y * (scale - 1), z * (scale - 1));
					currentRoom = rooms.get(x).get(y).get(z);
					percentComplete = (roomCount / (double) totalRooms) * 100;

					if (percentComplete % 10 == 0)
						mazeCommand.getSender().sendMessage(
								ChatColor.GREEN + "[MultiUse] "
										+ ChatColor.YELLOW + "Building: %"
										+ ChatColor.RED + percentComplete
										+ ChatColor.YELLOW + " Completed.");

					currentRoom.buildRoom(loc, scale, material, mazeCommand
							.getSender().getServer(),
							mazeCommand.getMultiuse(), mazeCommand.getSender());
					loc.subtract(x * (scale - 1), y * (scale - 1), z
							* (scale - 1));
				}
			}
		}
	}

	private void delay(int time) {
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			System.out.println("Could not sleep for 1 second.");
		}
	}

	@Override
	public String toString() {
		return "< " + this.length + " " + this.width + " " + this.height + " >";
	}

}
