package dreamEscapeLauncher.dialogue;

import java.awt.Color;

import javax.swing.JFrame;

import dreamEscapeLauncher.player.Player;
import dreamEscapeLauncher.states.State;
import dreamEscapeLauncher.world.DrawTiles;
import dreamEscapeLauncher.world.Foundation;
import dreamEscapeLauncher.world.Object;

public class ModifyWorld extends State {

	protected Foundation foundation = new Foundation();
	protected DrawTiles drawTiles = new DrawTiles();
	protected Object object = new Object();
	protected Player player = new Player();

	protected Color color;
	
	protected boolean runDrawTiles = false;

	@Override
	public void tick() {
		repaint();
		frame.requestFocusInWindow(); // Without this, after clicking on the chat bubble the player can no longer
										// move.
		if (runDrawTiles) {
			player.tick();
		}
	}

	@Override
	public void run(JFrame frame) {
		this.frame = frame;
		setLayout(null);
		frame.add(this);
	}

	protected void makeWhite() {
		System.out.println("set to white");
		setBackground(Color.WHITE);
	}

	protected void runDrawTiles() {
		 foundation.loadImage();
		 object.loadImage();
		 runDrawTiles = true;
	}
}
