package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Bubble;
import model.Fish;
import model.OceanObject;
import model.Plant;
import model.Stone;
import view.OceanLifeGUI;

public class MyButtonListener implements ActionListener {

	OceanLifeController olc;
	OceanLifeGUI gui;

	public MyButtonListener(OceanLifeController c, OceanLifeGUI gui) {
		olc = c;
		this.gui = gui;
	}

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

	private void save() {
		olc.save();
	}

	private void load() {
		// TODO Auto-generated method stub

	}

	private void start() {
		// TODO Auto-generated method stub

	}

	private void stop() {
		// TODO Auto-generated method stub

	}

	/**
	 * Adds the Object created in the GUI to the Ocean
	 */
	private void add() {
		// Get name x- and y-coordinates
		String name = gui.getUserPanel().getName();
		int x = gui.getUserPanel().getX_Coord();
		int y = gui.getUserPanel().getY_Coord();
		// Create an OceanObject with given arguments
		OceanObject oceanObject = null;
		switch (gui.getUserPanel().getSelectedClass()) {
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
		}
		//add the Object to Ocean
		olc.addObject(oceanObject);
		gui.getUserPanel().addObject(oceanObject);
	}

	/**
	 * Removes the Object from the Ocean, which is selected in the GUI
	 */
	private void remove() {
		olc.removeObject(gui.getUserPanel().getSelectedObject());
		gui.getUserPanel().removeSelectedObject();
	}

	private void step() {
		olc.step();
	}

	private void quit() {
		olc.quit();
	}

}
