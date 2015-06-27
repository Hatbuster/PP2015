package control;

/**
 * Class that manages the interaction in the Ocean
 * 
 * @author Tobias
 *
 */
public class GameThread extends Thread {

    /**
     * Instance of the OceanLifeController the GameThrad is working on
     */
    OceanLifeController olc;

    /**
     * Calculations per second
     */
    private final long CPS = 30; // Calculations|step() per Seconds

    /**
     * Constructor for the GameThread
     * 
     * @param olc
     * 			Instance of OceanLifeController the GameThread should be working on
     */
    public GameThread(OceanLifeController olc) {
	this.olc = olc;
    }

    /**
     * A loop containing the step() method of the OceanLifeController and calling this Cycle
     * CPS times a second. Can be paused by a boolean.
     */
    @Override
    public void run() {
	while (true) {
	    try {
		Thread.sleep(100);
	    } catch (InterruptedException e1) {
		e1.printStackTrace();
	    }
	    while (olc.getRunning()) {
		long startTime = System.currentTimeMillis();
		// move all Objects, check for Collision...
		olc.step();
		try {
		    long endTime = System.currentTimeMillis();
		    long sleepTime = 1000 / CPS - (endTime - startTime);
		    System.out.println("GameThread going to sleep for:"
			    + sleepTime + "ms");
		    if (sleepTime > 0) {
			Thread.sleep(sleepTime);
		    }
		} catch (InterruptedException ex) {

		}
	    }
	}
    }
}
