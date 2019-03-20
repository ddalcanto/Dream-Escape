package dreamEscapeLauncher.world;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;

import dreamEscapeLauncher.states.State;
import dreamEscapeLauncher.tiles.Tile;
import dreamEscapeLauncher.utils.Loader;

public class Tiles extends State {
	static BufferedImage buf;
	static JFrame frame;

	private static int types;

	private static BufferedImage imageType;

//	public enum Tilet {
//		TEST(1);
//
//		Tile(int type) {
//			types = type;
//		}
//
//		
//	}

	Image[][] MAP;

	JLabel[][] label;

	BufferedImage buff = new BufferedImage(1100, 1100, BufferedImage.TYPE_INT_RGB);
	
	public void getType(int types) {
		Tile.getTile(types);
	}

	public void loadImage() {
		int mapX = 0;
		int mapY = 0;

		// Create a Scanner with the contents of world.txt.
		Scanner creditsFile = Loader.loadFileAsScanner("world.txt");

		while (creditsFile.hasNextLine()) {
			if (creditsFile.hasNext()) {
				mapX++;
				creditsFile.next();
			}
			creditsFile.nextLine();
			mapY++;
		}

		MAP = new Image[mapX][mapY];
		label = new JLabel[mapX][mapY];

		// Re-initializes creditsFile, because it was processed by the while loop above.
		creditsFile = Loader.loadFileAsScanner("world.txt");

		for (int x = 0; x < mapX; x++) {
			for (int y = 0; y < mapY; y++) {
				if (creditsFile.hasNext()) {
					if (creditsFile.hasNextInt()) {
						MAP[x][y] = Tile.getTile(creditsFile.nextInt());
					} else {
						System.out.println("space");
						creditsFile.next();
					}
				}
			}
		}
	}

	boolean hasRun = false;
	JLabel labelTwo;

	public void draw(Graphics g) {
		// MAP.length refers to up and down
		if (!hasRun) {
			System.out.println("paint");
			for (int c = 0; c < MAP.length; c++) {
				// MAP[c].length refers to side to side
				for (int r = 0; r < MAP[c].length; r++) { // If less down y collum than x collumn, error occurs. FIX
					int offset;
					if (MAP[c][r] == Tile.getTile(2)) {
						offset = MAP[c][r].getHeight(null) / 2;
					} else {
						offset = 0;
					}

					buff.getGraphics().drawImage(MAP[c][r], r * MAP[c][r].getWidth(null),
							(c * MAP[c][r].getHeight(null)) - offset, null);
				}
			}
			hasRun = true;
		} else {
			g.drawImage(buff, 0, 0, null);
		}
	}

	public void tick() {
	}

	public void run(JFrame frame) {
		this.frame = frame;

		setLayout(null);
		loadImage();
	}
}