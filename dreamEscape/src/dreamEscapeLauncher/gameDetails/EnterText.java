package dreamEscapeLauncher.gameDetails;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dreamEscapeLauncher.dialogue.ChatButton;
import dreamEscapeLauncher.states.State;

public class EnterText extends State {

	private ChatButton chatButton = new ChatButton();

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
			chatButton.run(panel);
			State.setState(chatButton);
			clearAll();
		}
	}

	public void clearAll() {
		panel.remove(textField);
		panel.remove(label);
		panel.setBackground(Color.BLUE); // Without this old contents don't clear.
		panel.setBackground(Color.BLACK);
		
	}

	@Override
	public void run(JPanel panel) {
		// Retrieve the applications main panel
		setPanel(panel);
		textField.setSize(500, 100);
		textField.setLocation(250, 400);
		textField.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.addKeyListener(keyList);
		panel.add(textField);
	}

	@Override
	public void setPanel(JPanel panel) {
		// Retrieve the application's main JPanel, and set this classes "panel" to it
		this.panel = panel;
	}

	class KeyTest implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
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
