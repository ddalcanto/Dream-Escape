package dreamEscapeLauncher.dialogue;

import java.awt.Color;

public interface Chat {
	/*
	 * int chatX = 15; int chatY = 20; int chatXSize = 590; int chatYSize = 160;
	 */

	// Player's color when the screen is black.
	Color pColorB = Color.WHITE;
	// Guide's color when the screen is black.
	Color gColorB = Color.RED;

	// Player's color when the screen is white.
	Color pColorW = Color.BLACK;
	// Guide's color when the screen is white.
	Color gColorW = Color.BLUE;

	// Position of the chat.
	int chatX = 80;
	int chatY = 35;
	// Size of the chat.
	int chatXSize = 755;
	int chatYSize = 130;

}
