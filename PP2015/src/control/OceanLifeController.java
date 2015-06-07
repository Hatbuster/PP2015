package control;

import java.util.LinkedList;

import view.OceanLifeGUI;
import view.QuitFrame;
import model.Bubble;
import model.Fish;
import model.Ocean;
import model.OceanInterface;
import model.OceanObject;
import model.Plant;
import model.Stone;

public class OceanLifeController {
	
	private OceanInterface oi;

	public void start() throws InterruptedException {
		Ocean ocean;

		int width = 1024;
		int depth = 768;

		LinkedList<OceanObject> oceanObjects = new LinkedList<OceanObject>();

		Fish fish = new Fish(50, 50, "Fish");
		Bubble bubble = new Bubble(200,768,"Bubble");
		Stone stone = new Stone(100,0,"Stone");
		Plant plant = new Plant(800,750,"Plant");

		oceanObjects.add(fish);
		oceanObjects.add(bubble);
		oceanObjects.add(stone);
		oceanObjects.add(plant);

		ocean = new Ocean(width, depth, oceanObjects);
		oi = ocean;
		
		step();
		step();
		
		new OceanLifeGUI(ocean,this);
	}
	
	public void step() {
		oi.move();
		System.out.println(oi);
	}
	
	public void quit() {
		new QuitFrame(oi.getWidth(),oi.getDepth(),this);
	}
	
	public void addObject(OceanObject o) {
		oi.addOceanObject(o);
	}
	
	public void removeObject(int o) {
		oi.removeOceanObject(o);
	}

	public void save() {
		// TODO Auto-generated method stub
		
	}

}
