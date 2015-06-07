package model;

/**
 * The Class for a Plant
 * 
 * @author Tobias
 *
 */
public class Plant extends OceanObject {

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
	public Plant(int x, int y, String name) {
		super(x, y, name);
	}
	
	/**
	 * Moves a Plant inside the Ocean, ...
	 * 
	 * @param width
	 * 				The Width the Plant moves within
	 * @param depth
	 * 				The Depth the Plant moves within
	 */
	public void move(int width, int depth) {
		//TODO implement move-Method
	}
	
	/**
	 * @return A String containing the name and the position of an OceanObject, by calling method of Superclass
	 */
	public String toString() {
		return super.toString();
	}

}
