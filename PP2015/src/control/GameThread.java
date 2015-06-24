package control;

public class GameThread extends Thread {

	OceanLifeController olc;

	private final long FPS = 30; //Calculations|step() per Seconds 

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
				synchronized (olc.getOceanInterface().getOcean()) {
					long startTime = System.currentTimeMillis();
					System.out.println("Next Step by Thread");
					olc.step();
					try {
						long endTime = System.currentTimeMillis();
						long sleepTime = 1000 / FPS - (endTime - startTime);
						System.out.println(sleepTime);
						if (sleepTime > 0) {
							Thread.sleep(sleepTime);
						}
					} catch (InterruptedException ex) {

					}
				}
			}
		}
	}
}
