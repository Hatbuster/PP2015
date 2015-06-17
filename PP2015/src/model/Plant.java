package model;

import java.net.URL;
import java.util.Random;

/**
 * The Class for a Plant
 * 
 * @author Tobias
 *
 */
public class Plant extends OceanObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Creating a Plant using the Constructor of the Superclass
     * 
     * @param x
     *            The x-Position of the Bubble
     * @param y
     *            The y-Position of the Bubble
     * @param name
     *            The Name of the Bubble
     */
	public Plant(int x, int y, String name,URL url) {
		super(x, y, name,url);
	}
	
	/**
	 * Moves a Plant inside the Ocean, a Plant moves slowly in any Direction
	 * 
	 * @param width
	 * 				The Width the Plant moves within
	 * @param depth
	 * 				The Depth the Plant moves within
	 */
	public void move(int width, int depth) {
		// get plant position
		int xPos = super.getX();
		int yPos = super.getY();
		// randomize delta to move plant
		Random rand = new Random();
		int xMove = rand.nextInt(16) - 8;
		int yMove = rand.nextInt(16) - 8;
		// if new location is valid, move plant accordingly
		if ((xPos + xMove >= 0) && (xPos + xMove <= width)) {
			super.setX(xPos + xMove);
		}
		if ((yPos + yMove >= 0) && (yPos + yMove <= depth)) {
			super.setY(yPos + yMove);
		}
	}
	
	/**
	 * @return A String containing the name and the position of an OceanObject, by calling method of Superclass
	 */
	public String toString() {
		return super.toString();
	}

}
