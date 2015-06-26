package control;

import java.awt.Rectangle;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

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
	
	ocean = new Ocean(width, depth, oceanObjects);
	oi = ocean;

	gui = new OceanLifeGUI(this);
	System.out.println(gui);

	GameThread gameThread = new GameThread(this);
	gameThread.start();
	
	PaintThread paintThread = new PaintThread(gui);
	paintThread.start();
    }

    public void step() {
	synchronized (oi.getOcean()) {
	    oi.move();
	    checkCollision();
	    removeCollided();
	    System.out.println(oi);
	}
    }

    public void quit() {
	new QuitFrame(oi.getWidth(), oi.getDepth(), this);
    }

    public void addObject(OceanObject o) {
	synchronized (oi.getOcean()) {
	    oi.addOceanObject(o);
	}
    }

    public void removeObject(int o) {
	synchronized (oi.getOcean()) {
	    oi.removeOceanObject(o);
	}
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

    public void save() {
	synchronized (oi.getOcean()) {
	    // bring up a file chooser
	    final JFileChooser chooser = new JFileChooser();
	    // set opening path to dir where this app runs
	    chooser.setCurrentDirectory(new File("."));
	    // get the state of selection
	    int selection = chooser.showSaveDialog(null);
	    // if the usere approved his choice
	    if (selection == JFileChooser.APPROVE_OPTION) {
		try {
		    // make sure the file ends with .ocean
		    File selectedFile = chooser.getSelectedFile();
		    if (!selectedFile.getAbsolutePath().endsWith(".ocean")) {
			selectedFile = new File(selectedFile.getAbsolutePath()
				+ ".ocean");
		    }
		    // open File Stream
		    FileOutputStream os = new FileOutputStream(selectedFile);
		    // open object stream
		    ObjectOutputStream oos = new ObjectOutputStream(os);
		    // write the ocean to the file
		    oos.writeObject(oi.getOcean());
		    // close the stream
		    oos.close();
		    // inform user about success
		    final JOptionPane optionPane = new JOptionPane();
		    JOptionPane.showMessageDialog(optionPane,
			    "Succesfully saved ocean.", "Success",
			    JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception ex) {
		    // infrom user about failed save process
		    final JOptionPane optionPane = new JOptionPane();
		    JOptionPane.showMessageDialog(optionPane,
			    "Failed to save Ocean.", "Save failed",
			    JOptionPane.ERROR_MESSAGE);
		}
	    }
	}
    }

    public void load() {
	synchronized (oi.getOcean()) {
	    JFileChooser chooser = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		    "Ocean SaveFiles", "ocean");
	    chooser.setFileFilter(filter);
	    chooser.setCurrentDirectory(new File("."));
	    int returnVal = chooser.showOpenDialog(null);
	    if (returnVal == JFileChooser.APPROVE_OPTION) {
		try {
		    // open new FIle stream from the selected file
		    FileInputStream is = new FileInputStream(
			    chooser.getSelectedFile());
		    // create new object stream with this stream
		    ObjectInputStream ois = new ObjectInputStream(is);

		    // read the new Ocean
		    Ocean newOcean = (Ocean) ois.readObject();
		    {
			// change the current ocean
			oi = newOcean;
			gui.getUserPanel()
				.setOceanObjects(oi.getOceanObjects());
			gui.getDrawPanel()
				.setOceanObjects(oi.getOceanObjects());
			gui.getUserPanel().repaint();
			gui.getDrawPanel().repaint();
		    }
		    // close the stream
		    ois.close();

		    // Inform user about success
		    final JOptionPane optionPane = new JOptionPane();
		    JOptionPane.showMessageDialog(optionPane,
			    "Succesfully loaded ocean.", "Success",
			    JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception ex) {
		    // inform user if there was a error reading form the file
		    final JOptionPane optionPane = new JOptionPane();
		    JOptionPane.showMessageDialog(optionPane,
			    "Could not deserialize selection.\n"
				    + "Please choose a correct File!\n",
			    "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	    }
	}
    }

    public void startGameLoop() {
	running = true;
    }

    public void stopGameLoop() {
	running = false;
    }

    public boolean getRunning() {
	return running;
    }

    public void checkCollision() {
	synchronized (oi.getOcean()) {
	    for (OceanObject o : oi.getOceanObjects()) {
		if (o.getClass().equals(Shark.class)) {
		    int x = o.getX();
		    int y = o.getY();
		    int width = 0;
		    int height = 0;
		    width = o.getWidth();
		    height = o.getHeight();
		    Rectangle hitBox = new Rectangle(x, y, width, height);
		    for (OceanObject o2 : oi.getOceanObjects()) {
			if (o2.getClass().equals(Fish.class)) {
			    int x2 = o2.getX();
			    int y2 = o2.getY();
			    int width2 = 0;
			    int height2 = 0;
			    width2 = o2.getWidth();
			    height2 = o2.getHeight();
			    Rectangle hitBox2 = new Rectangle(x2, y2, width2,
				    height2);
			    if (hitBox.intersects(hitBox2)) {
				o2.setToRemove(true);
			    }
			}
		    }
		}
	    }
	}
    }

    public void removeCollided() {
	synchronized (oi.getOcean()) {
	    LinkedList<OceanObject> remove = new LinkedList<>();
	    for (OceanObject o : oi.getOceanObjects()) {
		if (o.isToRemove()) {
		    remove.add(o);
		}
	    }
	    for (OceanObject o : remove) {
		if (oi.getOceanObjects().contains(o)) {
		    oi.getOceanObjects().remove(o);
		    gui.getUserPanel().removeOceanObject(o);
		}
	    }
	}
    }
}
