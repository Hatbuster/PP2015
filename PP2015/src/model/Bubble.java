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
     * Default UID
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
     * @param url
     * 		  The URL of the Picture the Bubble should have
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
	int yPos = super.getY();
	if (yPos + super.getHeight() > 0) {
	    yPos = yPos - 1;
	} else {
	    super.setToRemove(true);
	}
	super.setY(yPos);

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
