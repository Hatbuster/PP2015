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
import model.Shark;
import model.Stone;

public class OceanLifeController {

	private OceanInterface oi;
	private OceanLifeGUI gui;

	private boolean running;

	public void start() throws InterruptedException {
		Ocean ocean;

		int width = 1024;
		int depth = 768;

		LinkedList<OceanObject> oceanObjects = new LinkedList<OceanObject>();

		Fish fish = new Fish(50, 50, "Fish",
				OceanLifeController.class.getResource("/res/fish (2).png"));
		Bubble bubble = new Bubble(200, 768, "Bubble",
				OceanLifeController.class.getResource("/res/bubble.png"));
		Stone stone = new Stone(100, 0, "Stone",
				OceanLifeController.class.getResource("/res/stone.png"));
		Plant plant = new Plant(500, 600, "Plant",
				OceanLifeController.class.getResource("/res/plant.png"));
		Shark shark = new Shark(500, 600, "Shark",
				OceanLifeController.class.getResource("/res/shark.png"));

		oceanObjects.add(fish);
		oceanObjects.add(bubble);
		oceanObjects.add(stone);
		oceanObjects.add(plant);
		oceanObjects.add(shark);

		ocean = new Ocean(width, depth, oceanObjects);
		oi = ocean;

		gui = new OceanLifeGUI(this);
		System.out.println(gui);

		step();
		step();

		GameThread thread = new GameThread(this);
		thread.start();
	}

	public void step() {
		oi.move();
		System.out.println(oi);
		gui.getUserPanel().repaint();
		gui.getDrawPanel().repaint();
	}

	public void quit() {
		new QuitFrame(oi.getWidth(), oi.getDepth(), this);
	}

	public void addObject(OceanObject o) {
		oi.addOceanObject(o);
		gui.getUserPanel().repaint();
		gui.getDrawPanel().repaint();
	}

	public void removeObject(int o) {
		oi.removeOceanObject(o);
		gui.getUserPanel().repaint();
		gui.getDrawPanel().repaint();
	}

	public OceanInterface getOceanInterface() {
		return oi;
	}

	public void setOceanInterface(OceanInterface oi) {
		this.oi = oi;
	}

	public OceanLifeGUI getOceanLifeGui() {
		return gui;
	}

	public void setOceanLifeGui(OceanLifeGUI gui) {
		this.gui = gui;
	}

	/*
	 * public void save() { // bring up a file chooser final JFileChooser
	 * chooser = new JFileChooser(); // set opening path to dir where this app
	 * runs chooser.setCurrentDirectory(new File(".")); // get the state of
	 * selection int selection = chooser.showSaveDialog(null); // if the usere
	 * approved his choice if (selection == JFileChooser.APPROVE_OPTION) { try {
	 * // make sure the file ends with .ocean File selectedFile =
	 * chooser.getSelectedFile(); if
	 * (!selectedFile.getAbsolutePath().endsWith(".ocean")) { selectedFile = new
	 * File(selectedFile.getAbsolutePath() + ".ocean"); } // open File Stream
	 * FileOutputStream os = new FileOutputStream(selectedFile); // open object
	 * stream ObjectOutputStream oos = new ObjectOutputStream(os); // write the
	 * ocean to the file oos.writeObject(oi.getOcean()); // close the stream
	 * oos.close(); // inform user about success final JOptionPane optionPane =
	 * new JOptionPane(); JOptionPane.showMessageDialog(optionPane,
	 * "Succesfully saved ocean.", "Success", JOptionPane.INFORMATION_MESSAGE);
	 * 
	 * } catch (Exception ex) { // infrom user about failed save process final
	 * JOptionPane optionPane = new JOptionPane();
	 * JOptionPane.showMessageDialog(optionPane, "Failed to save Ocean.",
	 * "Success", JOptionPane.ERROR_MESSAGE); } } }
	 */

	/*
	 * public void load() { JFileChooser chooser = new JFileChooser();
	 * FileNameExtensionFilter filter = new FileNameExtensionFilter(
	 * "Ocean SaveFiles", "ocean"); chooser.setFileFilter(filter);
	 * chooser.setCurrentDirectory(new File(".")); int returnVal =
	 * chooser.showOpenDialog(null); if (returnVal ==
	 * JFileChooser.APPROVE_OPTION) { try { // open new FIle stream from the
	 * selected file FileInputStream is = new FileInputStream(
	 * chooser.getSelectedFile()); // create new object stream with this stream
	 * ObjectInputStream ois = new ObjectInputStream(is);
	 * 
	 * // read the new Ocean Ocean newOcean = (Ocean) ois.readObject(); { //
	 * change the current ocean oi = newOcean;
	 * gui.getUserPanel().setOceanObjects(oi.getOceanObjects());
	 * gui.getUserPanel().repaint(); } // close the stream ois.close();
	 * 
	 * // Inform user about success final JOptionPane optionPane = new
	 * JOptionPane(); JOptionPane.showMessageDialog(optionPane,
	 * "Succesfully loaded ocean.", "Success", JOptionPane.INFORMATION_MESSAGE);
	 * } catch (Exception ex) { // inform user if there was a error reading form
	 * the file final JOptionPane optionPane = new JOptionPane();
	 * JOptionPane.showMessageDialog(optionPane,
	 * "Could not deserialize selection.\n" + "Please choose a correct File!\n",
	 * "ERROR", JOptionPane.ERROR_MESSAGE); } } }
	 */

	public void startGameLoop() {
		running = true;
	}

	public void stopGameLoop() {
		running = false;
	}

	public boolean getRunning() {
		return running;
	}
}
