package model;

import java.io.Serializable;

/**
 * The abstract Class which every Object in the Ocean is based on
 * 
 * @author Tobias Gartmann, Benjamin Suhr
 *
 */
public abstract class OceanObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * X-Coordinate of an OceanObject
	 */
	private int x;
	/**
	 * Y-Coordinate of an OceanObject
	 */
	private int y;
	/**
	 * X-Velocity of an OceanObject
	 */
	private int xVelocity;
	/**
	 * Y-Velocity of an OceanObject
	 */
	private int yVelocity;
	/**
	 * Name of an OceanObject
	 */
	private String name;
	/**
	 * Width of an OceanObject
	 */
	private int width;
	/**
	 * Height of an OceanObject
	 */
	private int height;

	/**
	 * Tells if the Object should be removed (collided with shark, out of
	 * oceanrange, etc...
	 */
	private boolean toRemove;

	/**
	 * Constructor creating an OceanObject
	 * 
	 * @param x
	 *            The X-Coordinate the Object should have
	 * @param y
	 *            The Y-Coordinate the Object should have
	 * @param name
	 *            The Name the Object should have
	 */
	public OceanObject(int x, int y, String name) {
		this.x = x;
		this.y = y;
		this.name = name;
	}

	/**
	 * Moves the Object inside the Width/Depth
	 * 
	 * @param width
	 *            The Width to move within
	 * @param depth
	 *            The Depth to move within
	 */
	public abstract void move(int width, int depth);

	/**
	 * Returns a String containing the name and the position of an OceanObject
	 * 
	 * @return String, containing the name and the position of an OceanObject
	 */
	public String toString() {
		return "Name = " + name + "; position: x = " + x + "; y = " + y + "\n";
	}

	/**
	 * Returns the X-Coordinate of an OceanObject
	 * 
	 * @return x
	 * 		The X-Coordinate an OceanObject is at
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the X-Coordinate to the given value
	 * 
	 * @param x
	 *            The X-Coordinate the Object should be at
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * Gets the X-Velocity an OceanObject moves with
	 * 
	 * @return xVelocity
	 * 		The X-Velocity the Object should be at
	 */
	public int getxVelocity() {
	    return xVelocity;
	}
	/**
	 * Sets the X-Velocity to the given value
	 * 
	 * @param xVelocity
	 * 		The X-Velocity the Object moves with
	 */
	public void setxVelocity(int xVelocity) {
	    this.xVelocity = xVelocity;
	}
	/**
	 * Gets the Y-Velocity an OceanObject moves with
	 * 
	 * @return yVelocity
	 * 		The Y-Velocity the Object should be at
	 */
	public int getyVelocity() {
	    return yVelocity;
	}
	/**
	 * Sets the Y-Velocity to the given value
	 * 
	 * @param yVelocity
	 * 		The Y-Velocity the Object moves with
	 */
	public void setyVelocity(int yVelocity) {
	    this.yVelocity = yVelocity;
	}

	/**
	 * Returns the Y-Coordinate of the OceanObject
	 * 
	 * @return The Y-Coordinate the OceanObject is at
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the Y-Coordinate to the given value
	 * 
	 * @param y
	 *            The Y-Coordinate the Object should be at
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Returns the Name of an OceanObject
	 * 
	 * @return name
	 * 		The Name an OceanObject has
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the Width of an OceanObject
	 * 
	 * @return width
	 * 		Width of an OceanObject
	 * 					
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Returns the Height of an OceanObject
	 * 
	 * @return height
	 * 		Height of an OceanObject
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Returns a boolean flag whether the Object should be removed or not
	 * 
	 * @return toRemove
	 * 		Boolean Flag if this Object should be removed
	 */
	public boolean isToRemove() {
		return toRemove;
	}

	/**
	 * Sets boolean Flag if this Object should be removed
	 * 
	 * @param remove 
	 * 		flag the Object, so it gets removed
	 */
	public void setToRemove(boolean remove) {
		toRemove = remove;
	}
	
	/**
	 * Sets the Width of the OceanObject
	 * 
	 * @param width
	 * 		The Width the Object should have
	 */
	public void setWidth(int width) {
	    this.width = width;
	}
	
	/**
	 * Sets the Height of the OceanObject
	 * 
	 * @param height
	 * 		The Height the Object should have
	 */
	public void setHeight(int height) {
	    this.height = height;
	}

}
