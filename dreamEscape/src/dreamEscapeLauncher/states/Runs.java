package dreamEscapeLauncher.states;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dreamEscapeLauncher.dialogue.ChatBubble;

public abstract class Runs extends JPanel {

	protected JFrame frame;

	public abstract void tick();

	public abstract void run(JFrame frame);

}
