package control;

import java.util.LinkedList;

import model.Bubble;
import model.Fish;
import model.Ocean;
import model.OceanObject;
import model.Plant;
import model.Stone;

public class OceanLifeController {

	public void start() throws InterruptedException {
		Ocean ocean;

		int width = 1024;
		int depth = 768;

		LinkedList<OceanObject> oceanObjects = new LinkedList<OceanObject>();

		Fish fish = new Fish(50, 50, "Fish 1");
		Fish fish2 = new Fish(100, 100, "Fish 2");
		Bubble bubble = new Bubble(200,768,"Bubble");
		Stone stone = new Stone(100,750,"Stone");
		Plant plant = new Plant(800,750,"Plant");

		oceanObjects.add(fish);
		oceanObjects.add(fish2);
		oceanObjects.add(bubble);
		oceanObjects.add(stone);
		oceanObjects.add(plant);

		ocean = new Ocean(width, depth, oceanObjects);
		for (int i = 0; i < 100; i++) {
			ocean.move();
			System.out.println(ocean);
			// slow down output
			Thread.sleep(500);
		}
	}

}
