package dreamEscapeLauncher.tiles;

import java.awt.image.BufferedImage;

import dreamEscapeLauncher.utils.Loader;
import dreamEscapeLauncher.utils.SpriteSheet;

public class Column extends Tile implements IsFoundation {

	@Override
	BufferedImage loadTile(int type) {
		sheet = Loader.loadImage("Column.png");
		switch (type) {
		// Column middle
		case 1:
			xPos = 0;
			break;
		// Column top
		case 2:
			xPos = 2;
			break;
		// Column middle
		default:
			xPos = 0;
			break;
		}
		// Return the desired tile, set by the switch statement above.
		return new SpriteSheet(sheet).crop(tileWidth * xPos, tileHeight * yPos, tileWidth, tileHeight);
	}

}
