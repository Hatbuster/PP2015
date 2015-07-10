package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import control.OceanLifeController;

/**
 * Class the creates a JFrame which gets opened when you press the "Quit" Button
 * 
 * @author Tobias Gartmann, Benjamin Suhr
 *
 */
public class QuitFrame extends JFrame {

    /**
     * Default UID
     */
    private static final long serialVersionUID = 1L;
    /**
     * ButtonListener for the Buttons
     */
    private QuitFrameListener qfl;
    /**
     * Instance of the OceanLifeController to work with
     */
    private OceanLifeController olc;

    /**
     * Constructor creating the QuitFrame
     * 
     * @param width
     *            The Width of the Ocean
     * @param depth
     *            The Depth of the Ocean
     * @param olc
     *            The OceanLifeController
     */
    public QuitFrame(int width, int depth, OceanLifeController olc) {
	this.setLayout(null);
	this.setSize(380, 100);
	this.setLocation((width + 300) / 2 - 380 / 2, depth / 2 - 100 / 2);
	this.setTitle("Quit?");
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	this.olc = olc;

	qfl = new QuitFrameListener();

	JButton cancelButton = new JButton("Cancel");
	cancelButton.setBounds(20, 20, 80, 25);
	cancelButton.setActionCommand("cancel");
	cancelButton.addActionListener(qfl);
	this.add(cancelButton);

	JButton saveButton = new JButton("Save and Quit");
	saveButton.setBounds(120, 20, 120, 25);
	saveButton.setActionCommand("save");
	saveButton.addActionListener(qfl);
	this.add(saveButton);

	JButton quitButton = new JButton("Quit");
	quitButton.setBounds(260, 20, 80, 25);
	quitButton.setActionCommand("quitConfirmed");
	quitButton.addActionListener(qfl);
	this.add(quitButton);
    }

    /**
     * Class for ButtonHandling in the QuitFrame
     * 
     * @author Tobias Gartmann, Benjamin Suhr
     *
     */
    class QuitFrameListener implements ActionListener {

	/**
	 * Whenever a Button is pressed this method checks which command the
	 * Button has and calls the equivalent method
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
	    String event = e.getActionCommand();
	    if (event.equals("save")) {
		save();
	    } else if (event.equals("cancel")) {
		cancel();
	    } else if (event.equals("quitConfirmed")) {
		quitConfirmed();
	    }
	}

	/**
	 * Saves the Game and exits the Game after it got saved successfully
	 */
	private void save() {
	    int success = olc.save();
	    if (success == 0) {
		//if the User saved the File the Program exits
		System.exit(0);
	    } else {
		//otherswise the window gets closed
		cancel();
	    }

	}

	/**
	 * Closes the QuitFrame
	 */
	private void cancel() {
	    dispose();
	}

	/**
	 * Quits the Game
	 */
	private void quitConfirmed() {
	    System.exit(0);
	}
    }

}
