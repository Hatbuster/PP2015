package model;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * The Class that contains all Objects
 * 
 * @author Tobias Gartmann, Benjamin Suhr
 *
 */
public class Ocean implements OceanInterface, Serializable {

    /**
     * Default UID
     */
    private static final long serialVersionUID = 1L;
    /**
     * The Width of an Ocean
     */
    private int width;
    /**
     * The Depth of an Ocean
     */
    private int depth;
    /**
     * The LinkedList containing all Objects of an Ocean
     */
    private LinkedList<OceanObject> oceanObjects;

    /**
     * Constructor creating an Ocean with the given Width,Depth and List of
     * OceanObjects
     * 
     * @param width
     *            The Width the Ocean should have
     * @param depth
     *            The Depth the Ocean should have
     * @param oceanObjects
     *            The List of Objects the Ocean should contain
     */
    public Ocean(int width, int depth, LinkedList<OceanObject> oceanObjects) {
	this.width = width;
	this.depth = depth;
	this.oceanObjects = oceanObjects;
    }

    /**
     * Calls the move-Method on every Element in oceanObjects
     */
    public void move() {
	for (OceanObject o : oceanObjects) {
	    o.move(width, depth);
	}
    }

    /**
     * Removes an OceanObject from the List
     * 
     * @param o
     *            The OceanObject to remove
     */
    public void removeObject(OceanObject o) {
	this.oceanObjects.remove(o);
    }

    /**
     * Returns a String containing a formatted list of all Names and Positions
     *         in the List
     * 
     * @return ret
     * 		A String containing a formatted list of all Names and Positions in the List
     */
    public String oceanObjectsToString() {
	String ret = "";
	for (OceanObject o : oceanObjects) {
	    ret = ret + o.toString();
	}
	return ret;
    }

    /**
     * Returns a String containing Width, Depth and all Elements in the Ocean
     * 
     * @return String, containing Width, Depth and all Elements in the Ocean
     */
    public String toString() {
	return "Ocean: Width: " + this.width + ", Depth: " + this.depth
		+ "\nObjects: \n" + oceanObjectsToString();
    }

    /**
     * Returns the Width of the Ocean
     * 
     * @return width returns the Width of the Ocean
     */
    public int getWidth() {
	return width;
    }

    /**
     * Returns the Depth of the Ocean
     * 
     * @return depth returns the depth of the Ocean
     */
    public int getDepth() {
	return depth;
    }

    /**
     * Return a LinkedList containing all Elements of the Ocean
     * 
     * @return The LinkedList containing all Elements of the Ocean
     */
    public LinkedList<OceanObject> getOceanObjects() {
	return oceanObjects;
    }

    /**
     * Sets the LinkedList containing all Elements of the Ocean
     * 
     * @param oceanObjects
     *            The List of Elements the Ocean should contain
     */
    public void setOceanObjects(LinkedList<OceanObject> oceanObjects) {
	this.oceanObjects = oceanObjects;
    }

    /**
     * Adds an OceanObject to an Ocean
     * 
     * @param oceanObject
     *            Object to add
     */
    public void addOceanObject(OceanObject oceanObject) {
	this.oceanObjects.add(oceanObject);
    }

    /**
     * Removes an OceanObject from an Ocean
     * 
     * @param oceanObject
     *            Integer of the Object to remove
     */
    public void removeOceanObject(int oceanObject) {
	this.oceanObjects.remove(oceanObject);
    }

    /**
     * Returns the Ocean
     * 
     * @return ocean
     * 		returns the Ocean
     */
    public Ocean getOcean() {
	return this;
    }

}
