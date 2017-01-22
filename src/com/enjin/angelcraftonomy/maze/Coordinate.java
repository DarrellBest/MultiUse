package com.enjin.angelcraftonomy.maze;

public class Coordinate {
	private int xCoord;
	private int yCoord;
	private int zCoord;

	public Coordinate(int xCoord, int yCoord, int zCoord) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.zCoord = zCoord;
	}

	public int getxCoord() {
		return xCoord;
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}

	public int getzCoord() {
		return zCoord;
	}

	public void setzCoord(int zCoord) {
		this.zCoord = zCoord;
	}

	public double calculateDistance(Coordinate Coords) {
		double retVal;
		int x, y, z;

		x = this.xCoord - Coords.getxCoord();
		x = x * x;

		y = this.yCoord - Coords.getyCoord();
		y = y * y;

		z = this.zCoord - Coords.getzCoord();
		z = z * z;

		retVal = Math.sqrt(x + y + z);

		return retVal;
	}

	public String calculateDirection(Coordinate coord) {
		String retVal = "";

		int xDiff = coord.getxCoord() - this.xCoord;
		int yDiff = coord.getyCoord() - this.yCoord;
		int zDiff = coord.getzCoord() - this.zCoord;

		if (zDiff < 0)
			retVal = retVal.concat("floor");
		else if (zDiff > 0)
			retVal = retVal.concat("celing");
		else if (xDiff < 0)
			retVal = retVal.concat("south");
		else if (xDiff > 0)
			retVal = retVal.concat("north");
		else if (yDiff < 0)
			retVal = retVal.concat("west");
		else if (yDiff > 0)
			retVal = retVal.concat("east");

		return retVal;
	}

	@Override
	public String toString() {
		String retVal = "";
		retVal = retVal.concat("(" + this.xCoord + ", " + this.yCoord + ", "
				+ this.zCoord + ")");
		return retVal;
	}

}
