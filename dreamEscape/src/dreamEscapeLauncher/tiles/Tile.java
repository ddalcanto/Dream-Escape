package dreamEscapeLauncher.tiles;

import java.awt.image.BufferedImage;

public abstract class Tile {

	int xPos = 0;
	int yPos = 0;
	int type;
	
	BufferedImage sheet;

	abstract BufferedImage loadTile(int type);

	public static BufferedImage getTile(int type) {
		if (type == 0) {
			return new Floor().loadTile(type);
		}
		else if (type >= 2 && type <= 9) {
			return new Boundary().loadTile(type);
		}
		return null;
	}

}
