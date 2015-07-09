package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.MyButtonListener;
import control.OceanLifeController;
import model.Bubble;
import model.Fish;
import model.OceanGraphics;
import model.OceanObject;
import model.Plant;
import model.Shark;
import model.Stone;

/**
 * Class that draw the Ocean and the Input-Panel
 * 
 * @author Tobias
 *
 */
public class OceanLifeGUI {

    /**
     * The Frame to be drawn
     */
    private JFrame frame;
    /**
     * The Panel where the Ocean and its Objects get drawn
     */
    private DrawGUI drawPanel;
    /**
     * The Panel where the User can do Inputs
     */
    private UserGUI userPanel;
    /**
     * The Interface for Access to the Ocean
     */
    private OceanLifeController oceanLifeController;
    /**
     * The ButtonListener handling the Buttons in the UserGUI
     */
    MyButtonListener mbl;

    /**
     * Constructor for creating a OceanLifeGUI
     * 
     * @param oceanLifeController
     * 			The Instance of the OceanLifeController the GUI should be working with
     */
    public OceanLifeGUI(OceanLifeController oceanLifeController) {
	this.oceanLifeController = oceanLifeController;
	frame = new JFrame();

	int width = oceanLifeController.getOceanInterface().getWidth();
	int depth = oceanLifeController.getOceanInterface().getDepth();
	frame.setLayout(null);
	frame.setSize(width + 300, depth + 30);
	frame.setTitle("Ocean Life");
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);

	mbl = new MyButtonListener(oceanLifeController);

	drawPanel = new DrawGUI(width, depth, 300,oceanLifeController);
	userPanel = new UserGUI(300, depth, mbl);

	frame.add(drawPanel);
	frame.add(userPanel);

    }

    /**
     * Returns the DrawGUI
     * 
     * @return drawPanel
     * 		returns the Panel where the Ocean and Objects get drawn
     */
    public DrawGUI getDrawPanel() {
	return drawPanel;
    }

    /**
     * Sets the DrawGUI to the given DrawGUI
     * 
     * @param drawPanel
     * 			the DrawGUI the OceanLifeGUI should have
     */
    public void setDrawPanel(DrawGUI drawPanel) {
	this.drawPanel = drawPanel;
    }

    /**
     * Returns the UserGUI
     * 
     * @return userPanel
     * 		returns the Panel the User can interact with
     */
    public UserGUI getUserPanel() {
	return userPanel;
    }

    /**
     * Sets the UserGUI to the given UserGUI
     * 
     * @param userPanel
     * 			the UserGUI the OceanLifeGUI should have
     */
    public void setUserPanel(UserGUI userPanel) {
	this.userPanel = userPanel;
    }


    /**
     * Class(Panel) where the Ocean gets drawn
     * 
     * @author Tobias
     *
     */
    public class DrawGUI extends JPanel {

	/**
	 * Default UID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * LinkedList containing all OceanObjects
	 */
	private OceanLifeController oceanLifeController;
	
	OceanGraphics oceanGraphics;

	/**
	 * Constructor creating a DrawGUI
	 * 
	 * @param width
	 * 		The Width of the Ocean
	 * @param depth
	 * 		The Depth of the Ocean
	 * @param margin
	 * 		The Width of the UserPanel
	 * @param oceanLifeController
	 * 		The Instance of the OceanLifeController
	 */
	public DrawGUI(int width, int depth, int margin,
		OceanLifeController oceanLifeController) {
	    this.setBounds(margin, 0, width, depth);
	    this.oceanLifeController = oceanLifeController;
	    OceanGraphics.loadAllImages();
	}

	/**
	 * Paints the Background and all Objects in the Ocean, gets called whenever repaint() is called
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    try {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(OceanGraphics.getOceanImage(), 0, 0, null);
		//clone list to avoid working on a changing list (will abort repaint)
		LinkedList<OceanObject> oceanObjectsCopy = (LinkedList<OceanObject>) oceanLifeController.getOceanInterface().getOceanObjects().clone();
		for (OceanObject o : oceanObjectsCopy) {
		    // g2.drawRect(o.getX(), o.getY(), o.getWidth(),
		    // o.getHeight());
		    if (o.getClass().equals(Fish.class)) {
			g2.drawImage(OceanGraphics.getImage(o), o.getX(),
				o.getY(), null);
		    } else if (o.getClass().equals(Bubble.class)) {
			g2.drawImage(OceanGraphics.getImage(o), o.getX(),
				o.getY(), null);
		    } else if (o.getClass().equals(Stone.class)) {
			g2.drawImage(OceanGraphics.getImage(o), o.getX(),
				o.getY(), null);
		    } else if (o.getClass().equals(Plant.class)) {
			g2.drawImage(OceanGraphics.getImage(o), o.getX(),
				o.getY(), null);
		    } else if (o.getClass().equals(Shark.class)) {
			g2.drawImage(OceanGraphics.getImage(o), o.getX(),
				o.getY(), null);
		    }
		}

	    } catch (Exception e) {
		System.out.println ("paintComponent failed");
	    }
	}
    }

    /**
     * Class(Panel) the User interacts with
     * 
     * @author Tobias
     *
     */
    public class UserGUI extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * TextField where the X-Coordinate is entered for creating OceanObjects
	 */
	private JTextField x_coord;
	/**
	 * TextField where the Y-Coordinate is entered for creating OceanObjects
	 */
	private JTextField y_coord;
	/**
	 * TextField where the Name is entered for creating OceanObjects
	 */
	private JTextField nameField;
	/**
	 * ComboBox where the desired Object to create is taken from
	 */
	private JComboBox<String> classBox;
	/**
	 * ComboBox containing all OceanObjects of the Ocean
	 */
	private JComboBox<OceanObject> oceanObjectBox;

	/**
	 * Returns the X-Coordinate where the OceanObject should spawn
	 * 
	 * @return x
	 * 		returns the X-Coordinate of the OceanObject
	 */
	public int getX_Coord() {
	    try {
		return Integer.parseInt(x_coord.getText());
	    } catch (NumberFormatException e) {
		// return a default value when no value is given
		Random rand = new Random();
		return rand.nextInt(oceanLifeController.getOceanInterface().getWidth() - 200);
	    }
	}

	/**
	 * Returns the Y-Coordinate where the OceanObject should spawn
	 * 
	 * @return y
	 * 		returns the Y-Coordinate of the OceanObject
	 */
	public int getY_Coord() {
	    try {
		return Integer.parseInt(y_coord.getText());
	    } catch (NumberFormatException e) {
		// return a default value when no value is given
		Random rand = new Random();
		return rand.nextInt(oceanLifeController.getOceanInterface().getDepth() - 100);
	    }
	}

	/**
	 * Returns the Name the OceanObject should have
	 * 
	 * @return name
	 * 		returns the Name of the OceanObject
	 */
	public String getName() {
	    if (nameField.getText().equals("")) {
		// If no name given, name the Object like the class it is
		return (String) classBox.getSelectedItem();
	    } else {
		return nameField.getText();
	    }
	}

	/**
	 * Returns the Class the OceanObject should have
	 * 
	 * @return class
	 * 		returns the Class of the OceanObject
	 */
	public String getSelectedClass() {
	    return (String) classBox.getSelectedItem();
	}

	/**
	 * Constructor for creating a UserGUI
	 * 
	 * @param width
	 * 		The Width of the UserGUI
	 * @param depth
	 * 		The Depth of the UserGUI
	 * @param mbl
	 * 		The MyButtonListener that handles the Buttonclicks
	 */
	public UserGUI(int width, int depth, MyButtonListener mbl) {
	    this.setLayout(null);
	    this.setBounds(0, 0, width, depth);
	    this.setBackground(Color.WHITE);

	    JButton saveButton = new JButton("Save");
	    saveButton.setBounds(10, 10, 130, 25);
	    saveButton.setActionCommand("save");
	    saveButton.addActionListener(mbl);
	    this.add(saveButton);

	    JButton loadButton = new JButton("Load");
	    loadButton.setBounds(160, 10, 130, 25);
	    loadButton.setActionCommand("load");
	    loadButton.addActionListener(mbl);
	    this.add(loadButton);

	    JButton startButton = new JButton("Start");
	    startButton.setBounds(10, 50, 130, 25);
	    startButton.setActionCommand("start");
	    startButton.addActionListener(mbl);
	    this.add(startButton);

	    JButton stopButton = new JButton("Stop");
	    stopButton.setBounds(160, 50, 130, 25);
	    stopButton.setActionCommand("stop");
	    stopButton.addActionListener(mbl);
	    this.add(stopButton);

	    JLabel x_label = new JLabel("X:");
	    x_label.setBounds(10, 90, 20, 25);
	    this.add(x_label);

	    x_coord = new JTextField();
	    x_coord.setBounds(30, 90, 110, 25);
	    this.add(x_coord);

	    JLabel y_label = new JLabel("Y:");
	    y_label.setBounds(160, 90, 20, 25);
	    this.add(y_label);

	    y_coord = new JTextField();
	    y_coord.setBounds(180, 90, 110, 25);
	    this.add(y_coord);

	    JLabel nameLabel = new JLabel("Name:");
	    nameLabel.setBounds(10, 130, 40, 25);
	    this.add(nameLabel);

	    nameField = new JTextField();
	    nameField.setBounds(55, 130, 85, 25);
	    this.add(nameField);

	    classBox = new JComboBox<String>();
	    classBox.setBounds(160, 130, 130, 25);
	    classBox.addItem("Fish");
	    classBox.addItem("Bubble");
	    classBox.addItem("Stone");
	    classBox.addItem("Plant");
	    classBox.addItem("Shark");
	    this.add(classBox);

	    JButton addButton = new JButton("Add");
	    addButton.setBounds(10, 170, 280, 25);
	    addButton.setActionCommand("add");
	    addButton.addActionListener(mbl);
	    this.add(addButton);

	    oceanObjectBox = new JComboBox<OceanObject>();
	    oceanObjectBox.setBounds(10, 210, 280, 25);
	    for (OceanObject o : oceanLifeController.getOceanInterface().getOceanObjects()) {
		oceanObjectBox.addItem(o);
	    }
	    this.add(oceanObjectBox);

	    JButton removeButton = new JButton("Remove");
	    removeButton.setBounds(10, 250, 280, 25);
	    removeButton.setActionCommand("remove");
	    removeButton.addActionListener(mbl);
	    this.add(removeButton);

	    JButton stepButton = new JButton("Step");
	    stepButton.setBounds(10, 290, 130, 25);
	    stepButton.setActionCommand("step");
	    stepButton.addActionListener(mbl);
	    this.add(stepButton);

	    JButton quitButton = new JButton("Quit");
	    quitButton.setBounds(160, 290, 130, 25);
	    quitButton.setActionCommand("quit");
	    quitButton.addActionListener(mbl);
	    this.add(quitButton);
	}

	/**
	 * Adds an Object to the List of OceanObject
	 * 
	 * @param oceanObject
	 * 		The OceanObject to add
	 */
	public void addObject(OceanObject oceanObject) {
	    oceanObjectBox.addItem(oceanObject);
	}

	/**
	 * Removes the OceanObject which is selected in the ComboBox
	 */
	public void removeSelectedObject() {
	    oceanObjectBox.removeItemAt(oceanObjectBox.getSelectedIndex());
	}
	
	/**
	 * Removes the given OceanObject from the List
	 * 
	 * @param victim
	 * ^		The OceanObject to remove
	 */
	public void removeOceanObject(OceanObject victim){
	    oceanObjectBox.removeItem(victim);
	}

	/**
	 * Returns the Index of the selected OceanObject of the ComboBox
	 * 
	 * @return index
	 * 		The index of the OceanObject selected
	 */
	public int getSelectedObject() {
	    return oceanObjectBox.getSelectedIndex();
	}

	/**
	 * Sets the LinkedList of all OceanObjects to the given List
	 * 
	 * @param oceanObjects
	 * 		The LinkedList the GUI should be working with
	 */
	public void setOceanObjects(LinkedList<OceanObject> oceanObjects) {
	    oceanObjectBox.removeAllItems();
	    for (OceanObject o : oceanObjects) {
		oceanObjectBox.addItem(o);
	    }

	}

    }

}
