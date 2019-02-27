package dreamEscapeLauncher.dialogue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import dreamEscapeLauncher.states.Menu;
import dreamEscapeLauncher.states.State;

public class ChatButton extends ChatDialogue implements Menu, Chat {

	private ActionListener buttonListener = new ButtonListener();

	private void createButton() {
		System.out.println("created");
		buttons[0] = new JButton();
		buttons[0].addActionListener(buttonListener);
		// The -45 under width is to stop the button from clipping through the rounded edges of the chat bubble.
		buttons[0].setBounds(chatX, chatY, chatXSize - 45, chatYSize);
		buttons[0].setOpaque(false);
		buttons[0].setContentAreaFilled(false);
		buttons[0].setBorderPainted(false); // Allows text to show through.
		panel.add(buttons[0]);
	}

	private boolean clicked() {
		// When the button is clicked, run nextLine() from ChatText.
		nextLine();
		return true;
	}

	public void run(JPanel panel) {
		// Retrieve the applications main panel.
		// Display the dialogue line, and create a button over the text
		State.setState(this);
		super.run(panel);
		displayLine();
		createButton();
	}

	// May not need a tick method, except to redraw buttons.
	public void tick() {
		super.tick();
	}

	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttons[0]) {
				clicked();
			}
		}
	}
}
