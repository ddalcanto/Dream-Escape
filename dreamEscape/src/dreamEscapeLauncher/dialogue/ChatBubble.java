package dreamEscapeLauncher.dialogue;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class ChatBubble extends ModifyWorld implements Chat { // Change to extends runs.

	BufferedImage buf;

	boolean hasRun = false;

	// Draws the text bubble for character chat.
	public void draw(Graphics g) {
		g.setColor(color);
		// Soon to be implemented using info from Chat interface.
		g.fillRoundRect(0, 25, 850, 160, 180, 180);
		hasRun = true;
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	public void run(JFrame frame) {
		super.run(frame);
		this.frame = frame;
	}
}
