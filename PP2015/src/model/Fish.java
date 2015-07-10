package model;

import java.util.Random;

/**
 * The Class for a Fish
 * 
 * @author Tobias Gartmann, Benjamin Suhr
 *
 */
public class Fish extends OceanObject {

    /**
     * Default UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Creating a Fish using the Constructor of the Superclass
     * 
     * @param x
     *            The x-Position of the Fish
     * @param y
     *            The y-Position of the Fish
     * @param name
     *            The Name of the Fish
     */
    public Fish(int x, int y, String name) {
	super(x, y, name);
	super.setWidth(100);
	super.setHeight(66);
    }

    /**
     * Moves a Fish inside the Ocean, for now the Fish has a random move, moving
     * in a range limited from -30/30 and can't move outside the Ocean
     * 
     * @param width
     *            The Width the Fish moves within
     * @param depth
     *            The Depth the Fish moves within
     */
    public void move(int width, int depth) {
	int xPos = super.getX();
	int yPos = super.getY();
	int xVel = super.getxVelocity();
	int yVel = super.getyVelocity();
	int maxVel = 8;
	Random rand = new Random();
	xVel = xVel + rand.nextInt(5) - 2;
	yVel = yVel + rand.nextInt(5) - 2;
	xPos = xPos + xVel;
	yPos = yPos + yVel;
	if (xPos <= 0 || xPos + super.getWidth() >= width) {
	    xVel = -xVel;
	    xPos = xPos + xVel;
	}
	if (yPos <= 0 || yPos + super.getHeight() >= depth) {
	    yVel = -yVel;
	    yPos = yPos + yVel;
	}
	if (Math.abs(xVel) > maxVel) {
	    xVel = xVel / 2;
	}
	if (Math.abs(yVel) > maxVel) {
	    yVel = yVel / 2;
	}
	super.setX(xPos);
	super.setY(yPos);
	super.setxVelocity(xVel);
	super.setyVelocity(yVel);
    }

    /**
     * Returns a String containing the name and the position of an OceanObject
     * 
     * @return A String containing the name and the position of an OceanObject,
     *         by calling method of Superclass
     */
    public String toString() {
	return super.toString();
    }

}
