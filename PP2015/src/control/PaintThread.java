package control;

import view.OceanLifeGUI;

public class PaintThread extends Thread {

    OceanLifeGUI gui;

    private final long FPS = 30; // repaints per Seconds

    public PaintThread(OceanLifeGUI gui) {
	this.gui = gui;
    }

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
