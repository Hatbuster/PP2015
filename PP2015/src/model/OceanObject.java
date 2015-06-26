package model;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * The abstract Class which every Object in the Ocean is based on
 * 
 * @author Tobias
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
	 * Name of an OceanObject
	 */
	private String name;

	/**
	 * URL of the Image
	 */
	private URL pictureURL;
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
	 * @param url
	 * 			  The URL of the image the Object should have
	 */
	public OceanObject(int x, int y, String name, URL url) {
		this.x = x;
		this.y = y;
		this.name = name;
		this.pictureURL = url;
		try {
	    this.width = ImageIO.read(url).getWidth();
	    this.height = ImageIO.read(url).getHeight();
		} catch (IOException e) {
			// If no image could be loaded the hitbox is represented by a
			// 50x50pixel square
			this.width = 50;
			this.height = 50;
		}

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
	 * 
	 * @param x
	 *            The X-Coordinate the Object should be at
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
	 * 
	 * @param y
	 *            The Y-Coordinate the Object should be at
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
	 * 
	 * @param name
	 *            The Name the Object should have
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return The URL of the Image an OceanObject has
	 */
	public URL getPictureURL() {
		return pictureURL;
	}

	/**
	 * Set The URL of the Image an OceanObject has
	 * 
	 * @param pictureURL
	 *            The URL of the Image an OceanObject should have
	 */
	public void setPictureURL(URL pictureURL) {
		this.pictureURL = pictureURL;
	}

	/**
	 * 
	 * @return Width of an OceanObject
	 * 					
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * 
	 * @return Height of an OceanObject
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * 
	 * @return Boolean Flag if this Object should be removed
	 */
	public boolean isToRemove() {
		return toRemove;
	}

	/**
	 * Sets boolean Flag if this Object should be removed
	 * 
	 * @param remove flag the Object, so it gets removed
	 */
	public void setToRemove(boolean remove) {
		toRemove = remove;
	}

}
