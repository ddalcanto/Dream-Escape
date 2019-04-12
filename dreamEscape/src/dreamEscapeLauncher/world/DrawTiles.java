package dreamEscapeLauncher.world;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Scanner;

import javax.swing.JLabel;

import dreamEscapeLauncher.tiles.Tile;
import dreamEscapeLauncher.utils.Loader;
import dreamEscapeLauncher.utils.TestTile;

public class DrawTiles {
	protected BufferedImage buf;

	protected Image[][] map;
	protected boolean[][] boundary;
	public static Rectangle[][] rect;
	public static String test;

	protected JLabel[][] label;

	protected boolean hasRun = false;

	// ARGB allows transparency in the images
	protected BufferedImage tileBuff = new BufferedImage(1100, 1100, BufferedImage.TYPE_INT_ARGB);

	public void loadImage(String fileName) {
		int dialoguemapX = 0;
		int dialoguemapY = 0;

		// Create a Scanner with the contents of world.txt.
		Scanner gameMap = Loader.loadFileAsScanner(fileName);

		while (gameMap.hasNextLine()) {
			// Increase the value of dialoguemapX while navigating through each value in
			// gameMap.
			if (gameMap.hasNext()) {
				dialoguemapX++;
				gameMap.next();
			}
			// Increase the value of dialoguemapY while navigating through each value in
			// gameMap.
			gameMap.nextLine();
			dialoguemapY++;
		}

		// Set the size of these variables to the size of the loaded gameMap using
		// dialoguemapX and dialoguemapY - variables both set in the above loop.
		map = new Image[dialoguemapX][dialoguemapY];
		boundary = new boolean[dialoguemapX][dialoguemapY];
		label = new JLabel[dialoguemapX][dialoguemapY];
		rect = new Rectangle[dialoguemapX][dialoguemapY];

		// Re-initializes "gameMap", because it was processed by the while loop above.
		gameMap = Loader.loadFileAsScanner(fileName);

		for (int x = 0; x < dialoguemapX; x++) {
			for (int y = 0; y < dialoguemapY; y++) {
				if (gameMap.hasNext()) {
					if (gameMap.hasNextInt()) {
						int type = gameMap.nextInt();
						// Fill the current position of map and boundary based on the type and
						// fileName, which is passed into the Tile class.
						map[x][y] = Tile.getTile(type, fileName);
						boundary[x][y] = TestTile.isBoundary(type, fileName);
					} else {
						gameMap.next();
					}
				}
			}
		}
	}

	public void draw(Graphics g) {
		// map.length refers to up and down
		// If this loop hasn't run yet.
		if (!hasRun) {
			System.out.println("paint");
			for (int c = 0; c < map.length; c++) {
				// map[c].length refers to side to side
				for (int r = 0; r < map[c].length; r++) { // If less down y collum than x collumn, error occurs. FIX

					// Set the width and height based off of the height of the current row and
					// column of "map".
					int width = map[c][r].getWidth(null);
					int height = map[c][r].getHeight(null);

					// If the current tile is a boundary, create an invisible rectangle at that spot
					// (used for collision detection).
					if (boundary[c][r]) {
						// tileBuff.getGraphics().drawRect(r * width, (c * height), 30, 30);
						rect[c][r] = new Rectangle(r * width, (c * height), 30, 30);
					}
					// Draw the image to a BufferedImage
					tileBuff.getGraphics().drawImage(map[c][r], r * width, (c * height), null);
				}
			}
			// Makes this loop not run again.
			hasRun = true;
		} else {
			// Draw the BufferedImage to the screen.
			g.drawImage(tileBuff, 0, 0, null);
		}
	}
}