package dreamEscapeLauncher.dialogue;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ChatBubble extends ModifyWorld implements Chat{ // Change to extends runs.

	private Graphics g;

	BufferedImage buf;

	//Draws the text bubble for character chat.
	private void drawChatBubble(Graphics g) {
		g.setColor(color);
		// Soon to be implemented using info from Chat interface.
		g.drawArc(-20, 25, 300, 300, 90, 60);
		g.drawArc(-20, -125, 300, 300, -90, -60);
		g.drawLine(130, 25, 755, 25);
		g.drawLine(130, 175, chatXSize, 175);
		g.drawArc(680, 25, 150, 150, -90, 180);
	}

	@Override
	public void tick() {
		// Draw the chat bubble.	
		drawChatBubble(g);
		super.tick();
	}

	@Override
	public void run(JPanel panel) {
		// Retrieve the application's main JPanel, and set "g" to it.
		setPanel(panel);
		g = panel.getGraphics();

//		tick();
	}

	@Override
	public void setPanel(JPanel panel) {
		// Retrieve the application's main JPanel, and set this classes "panel" to it.
		this.panel = panel;
	}
}
