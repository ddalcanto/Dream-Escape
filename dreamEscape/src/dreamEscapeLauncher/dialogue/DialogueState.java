package dreamEscapeLauncher.dialogue;

import java.awt.Graphics;

import dreamEscapeLauncher.StateCustomizer;

public class DialogueState extends ChatButton {

	private boolean tilesDebug = false;

	// Used for debug purposes only
	public void tilesDebug() {
		if (StateCustomizer.tilesDebug) {
			foundation.loadImage();
			object.loadImage();
			tilesDebug = true;
			runDrawTiles = true;
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// If runDrawTiles is true, draw the world onto the screen
		if (runDrawTiles) {
			foundation.draw(g);
			object.draw(g);
			player.draw(g);
		}
		// Used for debug purposes only
		if (!tilesDebug) {
			this.draw(g);
		}
	}
}
