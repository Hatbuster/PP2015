package model;

/**
 * The Class for a Stone
 * 
 * @author Tobias Gartmann, Benjamin Suhr
 *
 */
public class Stone extends OceanObject {

    /**
     * Default UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Creating a Stone using the Constructor of the Superclass
     * 
     * @param x
     *            The x-Position of the Stone
     * @param y
     *            The y-Position of the Stone
     * @param name
     *            The Name of the Stone
     */
    public Stone(int x, int y, String name) {
	super(x, y, name);
	super.setWidth(45);
	super.setHeight(22);
    }

    /**
     * Moves a Stone inside the Ocean, a Stone sinks to the ground and moves
     * slightly on X-Axis
     * 
     * @param width
     *            The Width the Stone moves within
     * @param depth
     *            The Depth the Stone moves within
     */
    public void move(int width, int depth) {
	int yPos = super.getY();
	if (yPos + super.getHeight() < depth){
	    yPos = yPos + 3;
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
