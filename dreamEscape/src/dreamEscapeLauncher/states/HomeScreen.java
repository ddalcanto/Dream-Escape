package dreamEscapeLauncher.states;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import dreamEscapeLauncher.gameDetails.RequestDetails;

public class HomeScreen extends State implements Menu {

	private ActionListener buttonListener = new ButtonListener();

	private RequestDetails requestDetails = new RequestDetails();

	private int thisButtonAmount;

	@Override
	public void setPanel(JPanel panel) {
		// Retrieve the application's main JPanel, and set this classes "panel" to it.
		this.panel = panel;

	}

	// Not useful as of now; required due to abstract method.
	public void tick() {

	}

	public void run(JPanel panel) {
		// Retrieve the applications main panel.
		setPanel(panel);
		panel.setBackground(Color.DARK_GRAY);
		createButtons();

	}

	// Create all buttons on the home screen.
	private void createButtons() {
		thisButtonAmount = originalButtonAmount;
		for (int i = 0; i < thisButtonAmount; i++) {
			buttons[i] = new JButton(String.valueOf(i));
			buttons[i].setFont(defaultFont);
			buttons[i].setBounds(100, i * 60 + 40, 300, 100);
			buttons[i].addActionListener(buttonListener);
			panel.add(buttons[i]);
		}
		buttons[0].setText("Run Game");
	}

	// Remove all buttons from this class
	private void removeButtons() {
		for (int i = 0; i < thisButtonAmount; i++) {
			System.out.println("Removing button " + i);
			panel.remove(buttons[i]);
			this.tick();
		}
		panel.setBackground(Color.BLACK);
	}

	// Remove all buttons from all classes which are currently displaying a button.
	// on the home screen
	private void removeAllButtons() {
		// Will also call other "removeButtons()" for future buttons,
		// such as a "Credits" button. For now has no extra use.
		this.removeButtons();

	}

	// Run "RequestDetails" class, and set State to it.
	private void requestDetailsRun() {
		requestDetails.run(panel);
		State.setState(requestDetails);
	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// If the first button is clicked, remove all of the buttons being displayed and run RequestDetails
			if (e.getSource() == buttons[0]) {
				removeAllButtons();
				requestDetailsRun();
			}
		}
	}
}
