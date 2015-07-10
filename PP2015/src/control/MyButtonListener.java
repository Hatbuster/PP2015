package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Bubble;
import model.Fish;
import model.OceanObject;
import model.Plant;
import model.Shark;
import model.Stone;

/**
 * Class that handles all Buttons in the UserGUI class
 * 
 * @author Tobias Gartmann, Benjamin Suhr
 *
 */
public class MyButtonListener implements ActionListener {

    /**
     * Instance of the OceanLifeController the GameThrad is working on
     */
    OceanLifeController olc;

    /**
     * 
     * @param c
     * 		Instance of OceanLifeController the MyButtonListener should be working on
     */
    public MyButtonListener(OceanLifeController c) {
	olc = c;
    }

    /**
     * Whenever a Button is pressed this method checks which command the Button has 
     * and calls the equivalent method
     */
    @Override
    public void actionPerformed(ActionEvent e) {
	String event = e.getActionCommand();
	if (event.equals("save")) {
	    save();
	} else if (event.equals("load")) {
	    load();
	} else if (event.equals("start")) {
	    start();
	} else if (event.equals("stop")) {
	    stop();
	} else if (event.equals("add")) {
	    add();
	} else if (event.equals("remove")) {
	    remove();
	} else if (event.equals("step")) {
	    step();
	} else if (event.equals("quit")) {
	    quit();
	}
    }

    /**
     * Saves Game
     */
    private void save() {
	olc.save();
    }

    /**
     * Loads Game
     */
    private void load() {
	olc.load();
    }

    /**
     * Starts Game
     */
    private void start() {
	olc.startGameLoop();
    }

    /**
     * Pauses Game
     */
    private void stop() {
	olc.stopGameLoop();
    }

    /**
     * Adds the Object created in the GUI to the Ocean
     */
    private void add() {
	// Get name x- and y-coordinates
	String name = olc.getOceanLifeGui().getUserPanel().getName();
	int x = olc.getOceanLifeGui().getUserPanel().getX_Coord();
	int y = olc.getOceanLifeGui().getUserPanel().getY_Coord();
	int width = olc.getOceanInterface().getWidth();
	int depth = olc.getOceanInterface().getDepth();
	if (x < 0 || x > width || y < 0 || y > depth) {
	    JOptionPane optionPane = new JOptionPane();
	    JOptionPane.showMessageDialog(optionPane,
		    "Cannot create OceanObject outside of ocean boundaries.",
		    "Out of Bounds", JOptionPane.ERROR_MESSAGE);

	} else {
	    // Create an OceanObject with given arguments
	    OceanObject oceanObject = null;
	    switch (olc.getOceanLifeGui().getUserPanel().getSelectedClass()) {
	    case "Fish":
		oceanObject = new Fish(x, y, name);
		break;
	    case "Bubble":
		oceanObject = new Bubble(x, y, name);
		break;
	    case "Plant":
		oceanObject = new Plant(x, y, name);
		break;
	    case "Stone":
		oceanObject = new Stone(x, y, name);
		break;
	    case "Shark":
		oceanObject = new Shark(x, y, name);
		break;
	    }
	    // add the Object to Ocean
	    olc.addObject(oceanObject);
	    olc.getOceanLifeGui().getUserPanel().addObject(oceanObject);
	}
    }

    /**
     * Removes the Object from the Ocean, which is selected in the GUI
     */
    private void remove() {
	try {
	    olc.removeObject(olc.getOceanLifeGui().getUserPanel().getSelectedObject());
	    olc.getOceanLifeGui().getUserPanel().removeSelectedObject();
	} catch (IndexOutOfBoundsException ex) {
	    JOptionPane optionPane = new JOptionPane();
	    JOptionPane.showMessageDialog(optionPane,
		    "Cannot remove any Object.", "Empty Ocean",
		    JOptionPane.ERROR_MESSAGE);
	}
    }

    /**
     * Calls a single move() on every OceanObejct, checks for Collision,...
     */
    private void step() {
	olc.step();
    }

    /**
     * Game is quit
     */
    private void quit() {
	olc.quit();
    }

}
