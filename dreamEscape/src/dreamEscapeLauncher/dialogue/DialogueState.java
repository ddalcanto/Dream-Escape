package dreamEscapeLauncher.dialogue;

import java.awt.Graphics;

import dreamEscapeLauncher.StateCustomizer;

public class DialogueState extends ChatButton {
	
	private boolean tilesDebug = false;
	
	public void tilesDebug() {
		if(StateCustomizer.tilesDebug) {
			tiles.loadImage();
			tilesDebug = true;
			runTiles = true;
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// If runTiles is true, draw the world onto the screen
		if (runTiles) {
			tiles.draw(g);
		}
		// Used only for debug purposes
		if (!tilesDebug) {
			this.draw(g);
		}
	}
}
