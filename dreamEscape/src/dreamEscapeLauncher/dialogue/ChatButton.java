package dreamEscapeLauncher.dialogue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import dreamEscapeLauncher.states.Menu;

public class ChatButton extends ChatDialogue implements Menu, Chat {

	private ActionListener buttonListener = new ButtonListener();

	private void createButton() {
		System.out.println("created");
		buttons[0] = new JButton();
		buttons[0].addActionListener(buttonListener);
		buttons[0].setBounds(chatX - 15, chatY, chatXSize - 130, chatYSize - 20);
		buttons[0].setOpaque(false);
		buttons[0].setContentAreaFilled(false);
		buttons[0].setBorderPainted(false); // Allows text to show through.
		add(buttons[0]);
	}

	private boolean clicked() {
		// When the button is clicked, run nextLine() from ChatText.
		nextLine();
		return true;
	}

	public void run(JFrame frame) {
		
		super.run(frame);
		// Display the dialogue line, and create a button over the text
		displayLine();
		createButton();
		setLayout(null);
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
