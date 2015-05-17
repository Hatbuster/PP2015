package control;

import model.Fish;
import model.Ocean;

public class OceanLifeMain {

	public static void main(String[] args) throws InterruptedException {
		Ocean ocean;

		int width = 1024;
		int depth = 768;

		Fish fish = new Fish(50, 50, "Fish 1");

		ocean = new Ocean(width, depth, fish);
		for (int i = 0; i < 100; i++) {
			ocean.move();
			System.out.println(ocean);
			//slow down output
			Thread.sleep(500);
		}
	}

}
