package dreamEscapeLauncher.tiles;

import java.awt.image.BufferedImage;

public abstract class Tile {

	protected int xPos = 0;
	protected int yPos = 0;
	int type;

	BufferedImage sheet;

	abstract BufferedImage loadTile(int type);

	// Checks the passed in number and .txt file to draw the world accordingly.
	public static BufferedImage getTile(int type, String fileName) {
		if (fileName.equals("objects.txt")) {
			if (type >= 1 && type <= 2) {
				return new Column().loadTile(type);
			} else {
				// Small invisible BufferedImage takes the spot in the 2d Array
				return new BufferedImage(1, 1, 2);
			}
		}
		if (fileName.equals("world.txt")) {
			if (type == 0) {
				// Loads a floor tile.
				return new Floor().loadTile(type);
			} else if (type >= 2 && type <= 9) {
				// Loads a boundary tile based on the value of "type".
				return new Boundary().loadTile(type);
			}

		}
		// Print out an error and terminate the program
		System.out.println("ERROR READING WORLD INFO. TERMINATING PROGRAM");
		System.exit(0);
		return null;
	}

}
