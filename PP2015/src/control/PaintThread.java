package control;

import view.OceanLifeGUI;

/**
 * Class that ensures the GUI is repainted at a given rate
 * 
 * @author Tobias
 *
 */
public class PaintThread extends Thread {

    /**
     * Instance of the GUI that is worked on
     */
    OceanLifeGUI gui;

    /**
     * Determines how often the GUI gets repainted per second
     */
    private final long FPS = 30; // repaints per Seconds

    /**
     * Constructor for the PaintThread
     * 
     * @param gui
     * 		Instance of the GUI the paintThread should be working on
     */
    public PaintThread(OceanLifeGUI gui) {
	this.gui = gui;
    }

    /**
     * A loop containing the repaint() method of the OceanLifeGUI and calling this Cycle
     * FPS times a second
     */
    @Override
    public void run() {
	while (true) {
	    long startTime = System.currentTimeMillis();
	    gui.getDrawPanel().repaint();
	    gui.getUserPanel().repaint();
	    try {
		long endTime = System.currentTimeMillis();
		long sleepTime = 1000 / FPS - (endTime - startTime);
		System.out.println("PaintThread going to sleep for:"
			+ sleepTime + "ms");
		if (sleepTime > 0) {
		    Thread.sleep(sleepTime);
		}
	    } catch (InterruptedException ex) {

	    }
	}
    }

}
