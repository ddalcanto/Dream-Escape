package dreamEscapeLauncher.tiles;

import java.awt.image.BufferedImage;

import dreamEscapeLauncher.utils.Loader;
import dreamEscapeLauncher.utils.SpriteSheet;

public class Boundary extends Tile implements IsFoundation {

	public BufferedImage loadTile(int type) {
		// Is a boundary.
		sheet = Loader.loadImage("WallCorners.png");
		switch (type) {
		// Top left corner
		case 2:
			xPos = 6;
			break;
		// Left side
		case 3:
			xPos = 4;
			break;
		// Bottom left corner
		case 4:
			xPos = 1;
			break;
		// Bottom
		case 5:
			System.out.println(type);
			xPos = 0;
			break;
		// Bottom right corner
		case 6:
			xPos = 2;
			break;
		// Right side
		case 7:
			xPos = 5;
			break;
		// Top right corner
		case 8:
			xPos = 7;
			break;
		// Top side
		case 9:
			xPos = 8;
			break;
		}
		// Return the desired tile, set by the switch statement above.
		return new SpriteSheet(sheet).crop(tileWidth * xPos, tileHeight * yPos, tileWidth, tileHeight);
	}

}
