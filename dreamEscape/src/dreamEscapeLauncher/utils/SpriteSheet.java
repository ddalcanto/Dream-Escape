package dreamEscapeLauncher.utils;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage sheet;

	public SpriteSheet(BufferedImage sheet) {
		// Set this classes "sheet" variable to the passed in BufferedImage.
		this.sheet = sheet;
	}

	public BufferedImage crop(int x, int y, int width, int height) {
		// Get a smaller part of the image passed in - is based on the passed in values.
		return sheet.getSubimage(x, y, width, height);
	}
}
