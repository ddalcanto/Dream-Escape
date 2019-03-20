package dreamEscapeLauncher.states;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dreamEscapeLauncher.gameDetails.RequestDetails;

public class HomeScreen extends State implements Menu {

	private ActionListener buttonListener = new ButtonListener();

	private int thisButtonAmount;

	JFrame frame;

	// Not useful as of now; required due to abstract method.
	public void tick() {

	}

	public void run(JFrame frame) {
		repaint();
		setLayout(null);
		System.out.println("ticking");
		// Retrieve the applications main
		this.frame = frame;
		setBackground(Color.DARK_GRAY);
		createButtons();
		frame.add(this);

	}

	// Create all buttons on the home screen.
	private void createButtons() {
		thisButtonAmount = originalButtonAmount;
		for (int i = 0; i < thisButtonAmount; i++) {
			buttons[i] = new JButton(String.valueOf(i));
			buttons[i].setFont(defaultFont);
			buttons[i].setBounds(100, i * 200 + 40, 300, 100);
			buttons[i].addActionListener(buttonListener);
			add(buttons[i]);
		}
		buttons[0].setText("Run Game");
		buttons[1].setText("Run Credits");
		repaint();
	}

	// Remove all buttons from this class
	private void removeButtons() {
		for (int i = 0; i < thisButtonAmount; i++) {
			System.out.println("Removing button " + i);
			remove(buttons[i]);
			this.tick();
		}
//		setBackground(Color.BLACK);
	}

	// Remove all buttons from all classes which are currently displaying a button.
	// on the home screen
	private void removeAllButtons() {
		// Will also call other "removeButtons()" for future buttons,
		// such as a "Credits" button. For now has no extra use.
		this.removeButtons();
		frame.remove(this);
	}

	// Run "RequestDetails" class, and set State to it.
	private void requestDetailsRun() {
		State.setState(new RequestDetails());
	}

	private void creditsRun() {
		State.setState(new Credits());
	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Maybe delete run methods, instead just calling the .setState()?
			// If the first button is clicked, remove all of the buttons being displayed and
			// run RequestDetails
			if (e.getSource() == buttons[0]) {
				removeAllButtons();
				requestDetailsRun();
			}

			if (e.getSource() == buttons[1]) {
				removeAllButtons();
				creditsRun();
			}
		}
	}
}
