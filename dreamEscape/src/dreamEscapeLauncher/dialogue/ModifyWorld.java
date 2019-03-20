package dreamEscapeLauncher.dialogue;

import java.awt.Color;

import javax.swing.JFrame;

import dreamEscapeLauncher.states.State;
import dreamEscapeLauncher.world.Tiles;

public class ModifyWorld extends State {

	Tiles tiles = new Tiles();

	protected Color color;

	private boolean showWorld = false;
	protected boolean runTiles = false;

	@Override
	public void tick() {
		repaint();
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
	
	protected void runTiles() {
		tiles.loadImage();
		runTiles = true;
	}
}
