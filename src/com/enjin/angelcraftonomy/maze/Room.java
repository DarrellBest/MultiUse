package com.enjin.angelcraftonomy.maze;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;

import com.enjin.angelcraftonomy.MultiUseCore;

public class Room {

	private int order;
	private Boolean visited;
	private Coordinate coord;
	private ArrayList<Room> neighbors;
	private Boolean celing;
	private Boolean floor;
	private Boolean northWall;
	private Boolean southWall;
	private Boolean eastWall;
	private Boolean westWall;

	// Length, width, and height refers to the number of blocks
	public Room(int length, int width, int height) {
		visited = false;
		neighbors = new ArrayList<Room>();
		this.coord = new Coordinate(length, height, width);
		celing = true;
		floor = true;
		northWall = true;
		southWall = true;
		eastWall = true;
		westWall = true;
		order = 0;
	}

	public Room() {
		visited = false;
		neighbors = new ArrayList<Room>();
		this.coord = new Coordinate(-1, -1, -1);
	}

	// Default is false, when this room is visited this method should return
	// true
	public Boolean isVisited() {
		return visited;
	}

	// Set if this room has been visited
	public void setVisited(Boolean visited) {
		this.visited = visited;
	}

	@Override
	public String toString() {
		String retVal = "";
		retVal = retVal.concat("[Visited: " + visited);
		retVal = retVal.concat(" Coord: " + coord.toString() + "]");
		return retVal;
	}

	public Coordinate getCoord() {
		return coord;
	}

	public void setCoord(Coordinate coord) {
		this.coord = coord;
	}

	public void addNeighbor(Room room) {
		neighbors.add(room);
	}

	public Boolean getCeling() {
		return celing;
	}

	public Boolean getFloor() {
		return floor;
	}

	public Boolean getNorthWall() {
		return northWall;
	}

	public Boolean getSouthWall() {
		return southWall;
	}

	public Boolean getEastWall() {
		return eastWall;
	}

	public Boolean getWestWall() {
		return westWall;
	}

	public int getSizeNeighbors() {
		return this.neighbors.size();
	}

	public void setCeling(Boolean celing) {
		this.celing = celing;
	}

	public void setFloor(Boolean floor) {
		this.floor = floor;
	}

	public void setNorthWall(Boolean northWall) {
		this.northWall = northWall;
	}

	public void setSouthWall(Boolean southWall) {
		this.southWall = southWall;
	}

	public void setEastWall(Boolean eastWall) {
		this.eastWall = eastWall;
	}

	public void setWestWall(Boolean westWall) {
		this.westWall = westWall;
	}

	public Boolean hasUnvisited() {
		boolean retVal = false;
		for (Room room : this.neighbors)
			if (!room.isVisited())
				retVal = true;
		return retVal;
	}

	public Room getRandomNeighbor() {
		Room retVal = new Room();
		Random random = new Random();
		int rand;
		ArrayList<Room> unvisited = new ArrayList<Room>();
		for (Room room : this.neighbors)
			if (!room.isVisited())
				unvisited.add(room);

		if (unvisited.size() > 0) {
			rand = random.nextInt(unvisited.size());
			retVal = unvisited.get(rand);
		}
		return retVal;
	}

	public void removeWall(String direction) {
		if (direction.equals("celing")) {
			this.setCeling(false);
		} else if (direction.equals("floor")) {
			this.setFloor(false);
		} else if (direction.equals("north")) {
			this.setNorthWall(false);
		} else if (direction.equals("south")) {
			this.setSouthWall(false);
		} else if (direction.equals("east")) {
			this.setEastWall(false);
		} else if (direction.equals("west")) {
			this.setWestWall(false);
		}
	}

	public void buildRoom(Location loc, int scale, Material material,
			Server server, MultiUseCore multiUse, CommandSender commandSender) {

		Block block;
		// material = Material.STAINED_GLASS;
		for (double x = 0; x < scale; x++) {
			for (double y = 0; y < scale; y++) {
				for (double z = 0; z < scale; z++) {

					loc.add(x, y, z);

					// build north wall
					if (northWall && x == (scale - 1)) {
						block = loc.getBlock();
						if (block.getType() != material)
							block.setType(material);
					}
					// build east wall
					else if (eastWall && z == (scale - 1)) {
						block = loc.getBlock();
						if (block.getType() != material)
							block.setType(material);
					}
					// build south wall
					else if (southWall && x == 0) {
						block = loc.getBlock();
						if (block.getType() != material)
							block.setType(material);
					}
					// build west wall
					else if (westWall && z == 0) {
						block = loc.getBlock();
						if (block.getType() != material)
							block.setType(material);
					}
					// build celing wall
					else if (celing && y == (scale - 1)) {
						block = loc.getBlock();
						if (block.getType() != material)
							block.setType(material);
					}
					// build floor wall
					else if (floor && y == 0) {
						block = loc.getBlock();
						if (block.getType() != material)
							block.setType(material);
					}

					// makes sure there is air in the center
					block = loc.getBlock();
					if (block.getType() != Material.AIR
							&& block.getType() != material) {
						block.setType(Material.AIR);
					}

					loc.subtract(x, y, z);
				}
			}
		}
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

}
