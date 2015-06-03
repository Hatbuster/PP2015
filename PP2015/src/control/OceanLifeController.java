package control;

import java.util.LinkedList;

import model.Fish;
import model.Ocean;
import model.OceanObject;

public class OceanLifeController {

	public void start() throws InterruptedException {
		Ocean ocean;

		int width = 1024;
		int depth = 768;

		LinkedList<OceanObject> oceanObjects = new LinkedList<OceanObject>();

		Fish fish = new Fish(50, 50, "Fish 1");
		Fish fish2 = new Fish(100, 100, "Fish 2");

		oceanObjects.add(fish);
		oceanObjects.add(fish2);

		ocean = new Ocean(width, depth, oceanObjects);
		for (int i = 0; i < 100; i++) {
			ocean.move();
			System.out.println(ocean);
			// slow down output
			Thread.sleep(500);
		}
	}

}
