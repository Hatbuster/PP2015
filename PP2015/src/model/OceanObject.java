package model;

/**
 * The abstract Class which every Object in the Ocean is based on
 * 
 * @author Tobias
 *
 */
public abstract class OceanObject {
	
	/**
	 * X-Coordinate of an OceanObject
	 */
	private int x;
	/**
	 * Y-Coordinate of an OceanObject
	 */
	private int y;
	/**
	 * Name of an OceanObject
	 */
	private String name;
	
	/**
	 * Constructor creating an OceanObject
	 * @param x
	 * 			The X-Coordinate the Object should have
	 * @param y
	 * 			The Y-Coordinate the Object should have
	 * @param name
	 * 			The Name the Object should have
	 */
	public OceanObject(int x, int y, String name) {
		this.x = x;
		this.y = y;
		this.name = name;
	}
	
	/**
	 * Moves the Object inside the Width/Depth
	 * @param width
	 * 				The Width to move within
	 * @param depth
	 * 				The Depth to move within
	 */
	public abstract void move(int width, int depth);
	
	/**
	 * @return A String containing the name and the position of an OceanObject
	 */
	public String toString() {
		return "Name = " + name + "; position: x = " + x + "; y = " + y + "\n";
	}

	/**
	 * 
	 * @return The X-Coordinate an OceanObject is at
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the X-Coordinate to the given value
	 * @param x
	 * 			The X-Coordinate the Object should be at
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * 
	 * @return The Y-Coordinate an OceanObject is at
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the Y-Coordinate to the given value
	 * @param x
	 * 			The Y-Coordinate the Object should be at
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * 
	 * @return The Name an OceanObject has
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the Name to the given String
	 * @param x
	 * 			The Name the Object should have
	 */
	public void setName(String name) {
		this.name = name;
	}

}
