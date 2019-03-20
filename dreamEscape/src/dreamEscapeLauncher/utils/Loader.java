package dreamEscapeLauncher.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Loader {

	public static BufferedImage loadImage(String path) { // path = name of photo
		try {
			return ImageIO.read(new File("res/" + path));
		} catch (IOException e) {
			System.out.println("ERROR: UNABLE TO LOAD IMAGE");
		}
		return null;
	}

	public static Scanner loadFileAsScanner(String path) {
		try {
			return new Scanner(new File("res/" + path));
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: UNABLE TO LOAD FILE");
		}
		return null;
	}
}
