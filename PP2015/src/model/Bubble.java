package model;

import java.net.URL;

/**
 * The Class for a Bubble
 * 
 * @author Tobias
 *
 */
public class Bubble extends OceanObject {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    /**
     * Creating a Bubble using the Constructor of the Superclass
     * 
     * @param x
     *            The x-Position of the Bubble
     * @param y
     *            The y-Position of the Bubble
     * @param name
     *            The Name of the Bubble
     */
    public Bubble(int x, int y, String name, URL url) {
	super(x, y, name, url);
    }

    /**
     * Moves a Bubble inside the Ocean, a Bubble just moves up until it reaches
     * the top of the Ocean
     * 
     * @param width
     *            The Width the Bubble moves within
     * @param depth
     *            The Depth the Bubble moves within
     */
    public void move(int width, int depth) {
	if (this.getY() < 0) {
	    // remove?
	} else {
	    this.setY(this.getY() - 50);
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
