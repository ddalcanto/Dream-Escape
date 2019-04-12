package dreamEscapeLauncher.gameDetails;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dreamEscapeLauncher.dialogue.DialogueState;
import dreamEscapeLauncher.states.State;

public class EnterText extends State {

	private static JTextField textField = new JTextField();
	protected JLabel label = new JLabel();

	public static String startingSection = "[SECTION 02]";
	public static String playerName = "FillerName";

	private KeyListener keyList = new KeyTest();

	private int times = 0;

	@Override
	public void tick() {
		// If the screen has advanced one time, clear the screen and run begin the game.
		if (times == 1) {
			State.setState(new DialogueState());
			clearAll();
		}
	}

	public void clearAll() {
		// Moves this class's panel from the JFrame
		System.out.println("clear all");
		frame.remove(this);
	}

	@Override
	public void run(JFrame frame) {
		// Retrieve the applications main panel
		this.frame = frame;
		// Set the details of the JTextField
		textField.setSize(500, 100);
		textField.setLocation(250, 400);
		textField.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.addKeyListener(keyList);
		// Add the JTextField and JLabel to the JPanel
		add(textField);
		add(label);
		// Add the panel to the JFrame
		setLayout(null);
		frame.add(this);
	}

	class KeyTest implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// When the user hits enter, set "playerName" to the name they entered
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				playerName = (textField.getText());
				textField.setText("");
				times++;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
		}
	}
}
