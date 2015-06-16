package control;

public class GameThread extends Thread {

	OceanLifeController olc;

	public GameThread(OceanLifeController olc) {
		this.olc = olc;
	}

	/*
	@Override
	public void run() {
		while (true) {
			//Holy shiet?
			System.out.println("Thread started");
			while (olc.getRunning()) {
				System.out.println("Next Step by Thread");
				olc.step();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}
	*/

}
