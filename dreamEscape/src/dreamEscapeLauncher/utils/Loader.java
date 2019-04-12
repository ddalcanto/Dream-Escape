package dreamEscapeLauncher.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Loader {

	public static BufferedImage loadImage(String fileName) { // fileName = name of photo
		try {
			// Return a BufferedImage based on the fileName entered
			return ImageIO.read(new File("res/" + fileName));
		} catch (IOException e) {
			// Print out an error and terminate the program.
			System.out.println("ERROR: UNABLE TO LOAD IMAGE");
			System.exit(1);
		}
		return null;
	}

	public static Scanner loadFileAsScanner(String fileName) {
		try {
			// Return a Scanner object based on the fileName entered
			return new Scanner(new File("res/" + fileName));
		} catch (FileNotFoundException e) {
			// Print out an error and terminate the program.
			System.out.println("ERROR: UNABLE TO LOAD FILE");
			System.exit(1);
		}
		return null;
	}
}
