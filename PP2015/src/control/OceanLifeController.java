package control;

import java.awt.Rectangle;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import view.OceanLifeGUI;
import view.PaintThread;
import view.QuitFrame;
import model.Fish;
import model.Ocean;
import model.OceanInterface;
import model.OceanObject;
import model.Shark;

/**
 * Class that Starts the Game, interface between Model(Ocean) and
 * View(OceanLifeGUI)
 * 
 * @author Tobias Gartmann, Benjamin Suhr
 *
 */
public class OceanLifeController {

    /**
     * Interface of the Ocean to get the Data from the Ocean
     */
    private OceanInterface oceanInterface;
    /**
     * Instance of the GUI
     */
    private OceanLifeGUI gui;
    /**
     * Determines if the Game is running right now
     */
    private boolean running;

    /**
     * Initiates everything - Creates Ocean, GUI, GameThread and PaintThread
     * 
     * @throws InterruptedException
     *             -
     */
    public void start() throws InterruptedException {
	Ocean ocean;

	int width = 1024;
	int depth = 768;

	LinkedList<OceanObject> oceanObjects = new LinkedList<OceanObject>();

	ocean = new Ocean(width, depth, oceanObjects);
	oceanInterface = ocean;

	gui = new OceanLifeGUI(this);
	System.out.println(gui);

	GameThread gameThread = new GameThread(this);
	gameThread.start();

	PaintThread paintThread = new PaintThread(gui);
	paintThread.start();
    }

    /**
     * Moves all Objects in the Ocean, checks for Collision and removes collided
     * Objects
     */
    public synchronized void step() {
	oceanInterface.move();
	checkCollision();
	removeCollided();
	System.out.println(oceanInterface);
    }

    /**
     * Quits the Game
     */
    public void quit() {
	new QuitFrame(oceanInterface.getWidth(), oceanInterface.getDepth(),
		this);
    }

    /**
     * Adds an Object to the Ocean
     * 
     * @param oceanObject
     *            Removes the given Object from the Ocean
     */
    public void addObject(OceanObject oceanObject) {
	oceanInterface.addOceanObject(oceanObject);
    }

    /**
     * Removes an Object from the Ocean
     * 
     * @param oceanObject
     *            Removes the Object on the Given position
     * 
     */
    public void removeObject(int oceanObject) {
	oceanInterface.removeOceanObject(oceanObject);
    }

    /**
     * Returns the OceanInterface
     * 
     * @return oceanInterface return the OceanInterface
     */
    public OceanInterface getOceanInterface() {
	return oceanInterface;
    }

    /**
     * Sets the OceanInterface
     * 
     * @param oceanInterface
     *            sets the OceanInterface
     */
    public void setOceanInterface(OceanInterface oceanInterface) {
	this.oceanInterface = oceanInterface;
    }

    /**
     * Returns the OceanLifeGUI
     * 
     * @return gui returns the OceanLifeGUI
     */
    public OceanLifeGUI getOceanLifeGui() {
	return gui;
    }

    /**
     * Saves the Game, calling a JFileChooser to select place and name to save
     * to
     * @return returnVal
     * 			returns a boolean Flag whether the Save was completed and successful or not
     */
    public int save() {
	synchronized (oceanInterface.getOcean()) {
	    int returnVal = 1;
	    // bring up a file chooser
	    final JFileChooser chooser = new JFileChooser();
	    // set opening path to dir where this app runs
	    chooser.setCurrentDirectory(new File("."));
	    // get the state of selection
	    int selection = chooser.showSaveDialog(null);
	    // if the user approved his choice
	    if (selection == JFileChooser.APPROVE_OPTION) {
		try {
		    // make sure the file ends with .ocean
		    File selectedFile = chooser.getSelectedFile();
		    if (!selectedFile.getAbsolutePath().endsWith(".ocean")) {
			selectedFile = new File(selectedFile.getAbsolutePath()
				+ ".ocean");
		    }
		    // open File Stream
		    FileOutputStream os = new FileOutputStream(selectedFile);
		    // open object stream
		    ObjectOutputStream oos = new ObjectOutputStream(os);
		    // write the ocean to the file
		    oos.writeObject(oceanInterface.getOcean());
		    // close the stream
		    oos.close();
		    // inform user about success
		    final JOptionPane optionPane = new JOptionPane();
		    JOptionPane.showMessageDialog(optionPane,
			    "Succesfully saved ocean.", "Success",
			    JOptionPane.INFORMATION_MESSAGE);
		    returnVal = 0;

		} catch (Exception ex) {
		    // inform user about failed save process
		    final JOptionPane optionPane = new JOptionPane();
		    JOptionPane.showMessageDialog(optionPane,
			    "Failed to save Ocean.", "Save failed",
			    JOptionPane.ERROR_MESSAGE);
		    returnVal = 1;
		}
	    }
	    return returnVal;
	}
    }

    /**
     * Load the Game, calling a JFileChooser to select place and name to load
     * from
     */
    public void load() {
	synchronized (oceanInterface.getOcean()) {
	    JFileChooser chooser = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		    "Ocean SaveFiles", "ocean");
	    chooser.setFileFilter(filter);
	    chooser.setCurrentDirectory(new File("."));
	    int returnVal = chooser.showOpenDialog(null);
	    if (returnVal == JFileChooser.APPROVE_OPTION) {
		try {
		    // open new File stream from the selected file
		    FileInputStream is = new FileInputStream(
			    chooser.getSelectedFile());
		    // create new object stream with this stream
		    ObjectInputStream ois = new ObjectInputStream(is);

		    // read the new Ocean
		    Ocean newOcean = (Ocean) ois.readObject();
		    {
			// change the current ocean
			oceanInterface = newOcean;
			gui.getUserPanel().setOceanObjects(
				oceanInterface.getOceanObjects());
			gui.getUserPanel().repaint();
			gui.getDrawPanel().repaint();
		    }
		    // close the stream
		    ois.close();

		    // Inform user about success
		    final JOptionPane optionPane = new JOptionPane();
		    JOptionPane.showMessageDialog(optionPane,
			    "Succesfully loaded ocean.", "Success",
			    JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception ex) {
		    // inform user if there was a error reading form the file
		    final JOptionPane optionPane = new JOptionPane();
		    JOptionPane.showMessageDialog(optionPane,
			    "Could not deserialize selection.\n"
				    + "Please choose a correct File!\n",
			    "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	    }
	}
    }

    /**
     * Sets running to true, starting/unpausing the Game
     */
    public void startGameLoop() {
	running = true;
    }

    /**
     * Sets running to false, pausing the Game
     */
    public void stopGameLoop() {
	running = false;
    }

    /**
     * Returns if the Game is Running
     * 
     * @return running
     * 			The Boolean Flag whether the Game is running or not
     */
    public boolean getRunning() {
	return running;
    }

    /**
     * Checks for Collision between Sharks and Fishes A Fish which collided with
     * a Shark gets marked
     */
    public void checkCollision() {
	for (OceanObject oceanObject : oceanInterface.getOceanObjects()) {
	    if (oceanObject.getClass().equals(Shark.class)) {
		int x = oceanObject.getX();
		int y = oceanObject.getY();
		int width = 0;
		int height = 0;
		width = oceanObject.getWidth();
		height = oceanObject.getHeight();
		Rectangle hitBox = new Rectangle(x, y, width, height);
		for (OceanObject oceanObject2 : oceanInterface
			.getOceanObjects()) {
		    if (oceanObject2.getClass().equals(Fish.class)) {
			int x2 = oceanObject2.getX();
			int y2 = oceanObject2.getY();
			int width2 = 0;
			int height2 = 0;
			width2 = oceanObject2.getWidth();
			height2 = oceanObject2.getHeight();
			Rectangle hitBox2 = new Rectangle(x2, y2, width2,
				height2);
			if (hitBox.intersects(hitBox2)) {
			    oceanObject2.setToRemove(true);
			}
		    }
		}
	    }
	}
    }

    /**
     * Removes all marked Objects(Fishes,Bubbles) from the Ocean
     */
    public void removeCollided() {
	LinkedList<OceanObject> removeList = new LinkedList<>();
	for (OceanObject oceanObject : oceanInterface.getOceanObjects()) {
	    if (oceanObject.isToRemove()) {
		removeList.add(oceanObject);
	    }
	}
	for (OceanObject ooceanObject : removeList) {
	    if (oceanInterface.getOceanObjects().contains(ooceanObject)) {
		oceanInterface.getOceanObjects().remove(ooceanObject);
		gui.getUserPanel().removeOceanObject(ooceanObject);
	    }
	}
    }
}
