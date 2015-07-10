package model;

import java.util.LinkedList;

/**
 * The Interface for an Ocean.
 * 
 * @author Tobias Gartmann, Benjamin Suhr
 */
public interface OceanInterface {

    /**
     * Returns the Width of an Ocean
     * 
     * @return The Width of an Ocean
     */
    public int getWidth();

    /**
     * Returns the Depth of an Ocean
     * 
     * @return The Depth of an Ocean
     */
    public int getDepth();

    /**
     * Returns a List containing all Elements of an Ocean
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
     * @param oceanObject
     * 		The Object to add
     */
    public void addOceanObject(OceanObject oceanObject);

    /**
     * Removes an OceanObject from an Ocean
     * 
     * @param oceanObject
     * 		Integer of the Object to remove
     */
    public void removeOceanObject(int oceanObject);

    /**
     * Moves all Objects in the Ocean
     */
    public void move();

    /**
     * Returns A String containing Information about the Ocean
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
