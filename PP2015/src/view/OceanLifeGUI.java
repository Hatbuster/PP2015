package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;

import javax.imageio.ImageIO;
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
import model.OceanInterface;
import model.OceanObject;
import model.Plant;
import model.Shark;
import model.Stone;

public class OceanLifeGUI {

	private JFrame frame;
	private DrawGUI drawPanel;
	private UserGUI userPanel;
	private OceanInterface oi;
	MyButtonListener mbl;

	public OceanLifeGUI(OceanLifeController oceanLifeController) {
		oi = oceanLifeController.getOceanInterface();
		frame = new JFrame();

		frame.setLayout(null);
		frame.setSize(oi.getWidth(), oi.getDepth());
		frame.setTitle("Ocean Life");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.black);

		mbl = new MyButtonListener(oceanLifeController, this);

		drawPanel = new DrawGUI(oi.getWidth(), oi.getDepth(), 300,
				oi.getOceanObjects());
		userPanel = new UserGUI(300, oi.getDepth(), mbl);

		frame.add(drawPanel);
		frame.add(userPanel);
		frame.repaint();

	}

	public DrawGUI getDrawPanel() {
		return drawPanel;
	}

	public void setDrawPanel(DrawGUI drawPanel) {
		this.drawPanel = drawPanel;
	}

	public UserGUI getUserPanel() {
		return userPanel;
	}

	public void setUserPanel(UserGUI userPanel) {
		this.userPanel = userPanel;
	}

	public class DrawGUI extends JPanel {

		private static final long serialVersionUID = 1L;
		private LinkedList<OceanObject> oceanObjects;

		public DrawGUI(int width, int depth, int margin,
				LinkedList<OceanObject> oceanObjects) {
			this.setBounds(margin, 0, width, depth);
			this.oceanObjects = oceanObjects;
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			try {
				Graphics2D g2 = (Graphics2D) g;
				g2.drawImage(ImageIO.read(OceanLifeGUI.class
						.getResource("/res/Ocean.png")), 0, 0, null);
				for (OceanObject o : oceanObjects) {
					if (o.getClass().equals(Fish.class)) {
						g2.drawImage(ImageIO.read(o.getPictureURL()), o.getX(),
								o.getY(), null);
					} else if (o.getClass().equals(Bubble.class)) {
						g2.drawImage(ImageIO.read(o.getPictureURL()), o.getX(),
								o.getY(), null);
					} else if (o.getClass().equals(Stone.class)) {
						g2.drawImage(ImageIO.read(o.getPictureURL()), o.getX(),
								o.getY(), null);
					} else if (o.getClass().equals(Plant.class)) {
						g2.drawImage(ImageIO.read(o.getPictureURL()), o.getX(),
								o.getY(), null);
					} else if (o.getClass().equals(Shark.class)) {
						g2.drawImage(ImageIO.read(o.getPictureURL()), o.getX(),
								o.getY(), null);
					}
				}

			} catch (Exception e) {

			}
		}
	}

	public class UserGUI extends JPanel {

		private static final long serialVersionUID = 1L;

		private JTextField x_coord;
		private JTextField y_coord;
		private JTextField nameField;
		private JComboBox<String> classBox;
		private JComboBox<OceanObject> oceanObjectBox;

		public int getX_Coord() {
			try {
				return Integer.parseInt(x_coord.getText());
			} catch (NumberFormatException e) {
				// return a default value when no value is given
				return 200;
			}
		}

		public int getY_Coord() {
			try {
				return Integer.parseInt(y_coord.getText());
			} catch (NumberFormatException e) {
				// return a default value when no value is given
				return 200;
			}
		}

		public String getName() {
			if (nameField.getText().equals("")) {
				// If no name given, name the Object like the class it is
				return (String) classBox.getSelectedItem();
			} else {
				return nameField.getText();
			}
		}

		public String getSelectedClass() {
			return (String) classBox.getSelectedItem();
		}

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
			this.add(classBox);

			JButton addButton = new JButton("Add");
			addButton.setBounds(10, 170, 280, 25);
			addButton.setActionCommand("add");
			addButton.addActionListener(mbl);
			this.add(addButton);

			oceanObjectBox = new JComboBox<OceanObject>();
			oceanObjectBox.setBounds(10, 210, 280, 25);
			for (OceanObject o : oi.getOceanObjects()) {
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

		public void addObject(OceanObject oceanObject) {
			oceanObjectBox.addItem(oceanObject);
		}

		public void removeSelectedObject() {
			oceanObjectBox.removeItemAt(oceanObjectBox.getSelectedIndex());
		}

		public int getSelectedObject() {
			return oceanObjectBox.getSelectedIndex();
		}

		public void setOceanObjects(LinkedList<OceanObject> oceanObjects) {
			oceanObjectBox.removeAllItems();
			for (OceanObject o : oceanObjects) {
				oceanObjectBox.addItem(o);
			}

		}

	}

}
