package dreamEscapeLauncher.utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import dreamEscapeLauncher.player.Player;

public class MoveCharacter extends Player {

	public static KeyListener MoveListener() {
		return new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_W) {
					System.out.println("up");
					moveUp = true;
				}

				if (e.getKeyCode() == KeyEvent.VK_A) {
					System.out.println("left");
					moveLeft = true;
				}

				if (e.getKeyCode() == KeyEvent.VK_S) {
					System.out.println("down");
					moveDown = true;
				}

				if (e.getKeyCode() == KeyEvent.VK_D) {
					System.out.println("right");
					moveRight = true;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_W) {
					System.out.println("up");
					moveUp = false;
				}

				if (e.getKeyCode() == KeyEvent.VK_A) {
					System.out.println("left");
					moveLeft = false;
				}

				if (e.getKeyCode() == KeyEvent.VK_S) {
					System.out.println("down");
					moveDown = false;
				}

				if (e.getKeyCode() == KeyEvent.VK_D) {
					System.out.println("right");
					moveRight = false;
				}

			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		};

	}
}
