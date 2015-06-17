package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import control.OceanLifeController;


public class QuitFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private QuitFrameListener qfl;
	@SuppressWarnings("unused")
	private OceanLifeController olc;
	
	public QuitFrame(int width, int depth, OceanLifeController olc) {
		this.setLayout(null);
		this.setSize(380, 100);
		this.setLocation(width/2-380/2, depth/2-100/2);
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
	
	class QuitFrameListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String event = e.getActionCommand();
			if (event.equals("save")) {
				save();
			}
			else if (event.equals("cancel")) {
	        	cancel();
	        }
			else if (event.equals("quitConfirmed")) {
	        	quitConfirmed();
	        }
		}

		private void save() {
			
			//olc.save();
		}
		
		private void cancel() {
			dispose();
		}
		
		private void quitConfirmed() {
			System.exit(0);
		}
	}

}
