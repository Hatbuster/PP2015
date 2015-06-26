package control;

public class GameThread extends Thread {

    OceanLifeController olc;

    private final long CPS = 30; // Calculations|step() per Seconds

    public GameThread(OceanLifeController olc) {
	this.olc = olc;
    }

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
		// move all Objects
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
