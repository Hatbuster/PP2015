package model;

import java.net.URL;

/**
 * The Class for a Plant
 * 
 * @author Tobias
 *
 */
public class Plant extends OceanObject {

    /**
     * Default UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Creating a Plant using the Constructor of the Superclass
     * 
     * @param x
     *            The x-Position of the Plant
     * @param y
     *            The y-Position of the Plant
     * @param name
     *            The Name of the Plant
     */
    public Plant(int x, int y, String name, URL url) {
	super(x, y, name, url);
    }

    /**
     * Moves a Plant inside the Ocean, a Plant slowly descends
     * 
     * @param width
     *            The Width the Plant moves within
     * @param depth
     *            The Depth the Plant moves within
     */
    public void move(int width, int depth) {
	int yPos = super.getY();
	if (yPos + super.getHeight() < depth){
	    yPos = yPos + 3;
	}
	super.setY(yPos);
    }

    /**
     * @return A String containing the name and the position of an OceanObject,
     *         by calling method of Superclass
     */
    public String toString() {
	return super.toString();
    }

}
