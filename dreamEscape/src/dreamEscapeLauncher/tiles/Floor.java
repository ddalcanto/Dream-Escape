package dreamEscapeLauncher.tiles;

import java.awt.image.BufferedImage;
import java.util.Random;

import dreamEscapeLauncher.utils.Loader;
import dreamEscapeLauncher.utils.SpriteSheet;

public class Floor extends Tile implements IsFoundation {

	private int wallNum;

	public BufferedImage loadTile(int type) {
		// Is a floor
		sheet = Loader.loadImage("Floors.png");
		xPos = new Random().nextInt(3);
		return new SpriteSheet(sheet).crop(tileWidth * xPos, tileHeight * yPos, tileWidth, tileHeight);
	}
}
