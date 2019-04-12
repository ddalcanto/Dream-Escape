package dreamEscapeLauncher.tiles;

import java.awt.image.BufferedImage;
import java.util.Random;

import dreamEscapeLauncher.utils.Loader;
import dreamEscapeLauncher.utils.SpriteSheet;

public class Floor extends Tile implements IsFoundation {

	public BufferedImage loadTile(int type) {
		// Is a floor
		sheet = Loader.loadImage("Floors.png");
		// Generates a random number between 0 and 4. Causes a variety of floor tiles.
		xPos = new Random().nextInt(4);
		// Return the desired tile, set by the Random int above
		return new SpriteSheet(sheet).crop(tileWidth * xPos, tileHeight * yPos, tileWidth, tileHeight);
	}
}