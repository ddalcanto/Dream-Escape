package dreamEscapeLauncher.player;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

import javax.swing.JFrame;

import dreamEscapeLauncher.states.State;
import dreamEscapeLauncher.utils.Loader;
import dreamEscapeLauncher.world.DrawTiles;

public class Player extends State {

	private static int x = 496;
	private static int y = 480;
	private final int lineWidth = 24, lineHeight = 24;

	public static boolean canMove = true, canMoveUp = true, canMoveLeft = true, canMoveDown = true, canMoveRight = true;
	public static int rectPos, boundaryPos;

	protected static boolean moveUp, moveLeft, moveDown, moveRight;
	Image player;

	public Player() {
		System.out.println("Constructor = " + x);
		loadImage();
	}

	public void draw(Graphics g) {
		g.drawImage(player, x, y, null);
	}

	private void loadImage() {
		// Load the player image into the Image variable
		System.out.println("Load Character");
		player = Loader.loadImage("Player.png");
	}

	protected static void moveRight() {
		x = x + 4;
	}

	protected static void moveLeft() {
		x = x - 4;
	}

	protected static void moveDown() {
		y = y + 4;
	}

	protected static void moveUp() {
		y = y - 4;
	}

	@Override
	public void run(JFrame frame) {
		// Without this the KeyListener doesn't work.
		setFocusable(true);
	}

	public void tick() {
		Line2D topLine = new Line2D.Double(x + 5, y + 15, x + lineWidth, y + 15);
		Line2D rightLine = new Line2D.Double(x + 6 + lineWidth, y + 22, x + 6 + lineWidth, y + 22 + lineHeight);
		Line2D leftLine = new Line2D.Double(x, y + 22, x, y + 22 + lineHeight);
		Line2D bottomLine = new Line2D.Double(x + 5, y + 58, x + lineWidth, y + 58);
		canMoveUp = true;
		canMoveLeft = true;
		canMoveDown = true;
		canMoveRight = true;
		// These two enhanced for loops navigate through the 2d array of boundaries.
		for (Rectangle[] boundaries : DrawTiles.rect) {
			for (Rectangle boundary : boundaries) {
				if (boundary != null) {
					// If the top of the player is touching a boundary, they can't move up.
					if (boundary.intersectsLine(topLine)) {
						canMoveUp = false;
						System.out.println("top");
					}
					// If the right side of the player is touching a boundary, they can't move.
					// right.
					if (boundary.intersectsLine(rightLine)) {
						canMoveRight = false;
						System.out.println("right");
					}
					// If the left side of the player is touching a boundary, they can't move left.
					if (boundary.intersectsLine(leftLine)) {
						canMoveLeft = false;
						System.out.println("left");
					}
					// If the bottom side of the player is touching a boundary, they can't move.
					// down.
					if (boundary.intersectsLine(bottomLine)) {
						canMoveDown = false;
						System.out.println("bottom");
					}
				}
			}
		}
		if (canMove) {
			if (canMoveUp) {
				if (moveUp) {
					moveUp();
				}
			}
			if (canMoveLeft) {
				if (moveLeft) {
					moveLeft();
				}
			}
			if (canMoveDown) {
				if (moveDown) {
					moveDown();
				}
			}
			if (canMoveRight) {
				if (moveRight) {
					moveRight();
				}
			}
		}
	}
}
