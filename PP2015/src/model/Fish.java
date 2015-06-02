package model;

import java.util.Random;

public class Fish extends OceanObject {

	public Fish(int x, int y, String name) {
		super(x, y, name);
	}

	public void move(int width, int depth) {
		// get fish position
		int xPos = super.getX();
		int yPos = super.getY();
		// randomize delta to move fish
		Random rand = new Random();
		int xMove = rand.nextInt(61) - 30;
		int yMove = rand.nextInt(61) - 30;
		// if new location is valid, move fish accordingly
		if ((xPos + xMove >= 0) && (xPos + xMove <= width)) {
			super.setX(xPos + xMove);
		}
		if ((yPos + yMove >= 0) && (yPos + yMove <= depth)) {
			super.setY(yPos + yMove);
		}
	}
}
