package model;

import java.util.LinkedList;

/**
 * The Interface for an Ocean.
 * 
 * @author Tobias
 */
public interface OceanInterface {

    /**
     * 
     * @return The Width of an Ocean
     */
    public int getWidth();

    /**
     * Sets the Width of an Ocean
     * 
     * @param width
     *            The Width an Ocean should have
     */
    public void setWidth(int width);

    /**
     * 
     * @return The Depth of an Ocean
     */
    public int getDepth();

    /**
     * Sets the Depth of an Ocean
     * 
     * @param depth
     *            The Depth an Ocean should have
     */
    public void setDepth(int depth);

    /**
     * 
     * @return The LinkedList containing all Elements of an Ocean
     */
    public LinkedList<OceanObject> getOceanObjects();

    /**
     * Sets the LinkedList containing all Elements of an Ocean
     * 
     * @param oceanObjects
     *            The List of Elements the Ocean should contain
     */
    public void setOceanObjects(LinkedList<OceanObject> oceanObjects);

    /**
     * Adds an OceanObject to an Ocean
     * 
     * @param The
     *            Object to add
     */
    public void addOceanObject(OceanObject oceanObject);

    /**
     * Removes an OceanObject from an Ocean
     * 
     * @param Integer
     *            of the Object to remove
     */
    public void removeOceanObject(int oceanObject);

    /**
     * Moves all Objects in the Ocean
     */
    public void move();

    /**
     * 
     * @return A String containing Information about the Ocean
     */
    @Override
    public String toString();

    /**
     * Returns the Ocean
     * 
     * @return Ocean
     * 		returns the Ocean
     */
    public Ocean getOcean();

}
