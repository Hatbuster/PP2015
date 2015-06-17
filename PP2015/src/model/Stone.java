package model;

import java.net.URL;
import java.util.Random;

public class Stone extends OceanObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creating a Stone using the Constructor of the Superclass
	 * 
	 * @param x
	 *            The x-Position of the Bubble
	 * @param y
	 *            The y-Position of the Bubble
	 * @param name
	 *            The Name of the Bubble
	 */
	public Stone(int x, int y, String name,URL url) {
		super(x, y, name,url);
	}

	/**
	 * Moves a Stone inside the Ocean, a Stone sinks to the ground and moves
	 * slightly on X-Axis
	 * 
	 * @param width
	 *            The Width the Stone moves within
	 * @param depth
	 *            The Depth the Stone moves within
	 */
	public void move(int width, int depth) {
		// get stone position
		int xPos = super.getX();
		int yPos = super.getY();
		// randomize delta to move stone
		Random rand = new Random();
		int yMove = 5;
		int xMove = rand.nextInt(10) - 5;
		// if new location is valid, move stone accordingly
		if ((xPos + xMove >= 0) && (xPos + xMove <= width)) {
			super.setX(xPos + xMove);
		}
		if ((yPos + yMove <= depth)) {
			super.setY(yPos + yMove);
		}
	}

	/**
	 * @return A String containing the name and the position of an OceanObject,
	 *         by calling method of Superclass
	 */
	public String toString() {
		return super.toString();
	}

}
