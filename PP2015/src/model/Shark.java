package model;

import java.net.URL;
import java.util.Random;

/**
 * The Class for a Shark
 * 
 * @author Tobias
 *
 */
public class Shark extends OceanObject {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    /**
     * Creating a Fish using the Constructor of the Superclass
     * 
     * @param x
     *            The x-Position of the Shark
     * @param y
     *            The y-Position of the Shark
     * @param name
     *            The Name of the Shark
     */
    public Shark(int x, int y, String name, URL url) {
	super(x, y, name, url);
    }

    /**
     * Moves a Shark inside the Ocean, for now the Shark has a random move,
     * moving in a range limited from -30/30 and can't move outside the Ocean
     * 
     * @param width
     *            The Width the Fish moves within
     * @param depth
     *            The Depth the Fish moves within
     */
    public void move(int width, int depth) {
	// get Shark position
	int xPos = super.getX();
	int yPos = super.getY();
	// randomize delta to move Shark
	Random rand = new Random();
	int xMove = rand.nextInt(61) - 30;
	int yMove = rand.nextInt(61) - 30;
	// if new location is valid, move Shark accordingly
	if ((xPos + xMove >= 0) && (xPos + xMove <= width)) {
	    super.setX(xPos + xMove);
	}
	if ((yPos + yMove >= 0) && (yPos + yMove <= depth)) {
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