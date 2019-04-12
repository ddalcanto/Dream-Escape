package dreamEscapeLauncher.dialogue;

import java.awt.Color;
import java.awt.Font;

public interface Chat {

	// TEXT

	// Player's text color when the screen is black.
	Color pColorBText = Color.BLACK;
	// Guide's text color when the screen is black.
	Color gColorBText = Color.RED;

	// Player's text color when the screen is white.
	Color pColorWText = Color.WHITE;
	// Guide's text color when the screen is white.
	Color gColorWText = Color.DARK_GRAY;

	// Position of the chat.
	int chatX = 80;
	int chatY = 35;
	// Size of the chat.
	int chatXSize = 850;
	int chatYSize = 160;

	// CHAT BUBBLES

	// Player's text color when the screen is black.
	Color pColorBBubble = Color.WHITE;
	// Guide's text color when the screen is black.
	Color gColorBBubble = Color.LIGHT_GRAY;

	// Player's chat bubble color when the screen is white.
	Color pColorWBubble = Color.BLACK;
	// Guide's chat bubble color when the screen is white.
	Color gColorWBubble = Color.CYAN;

	// The Font of the player's character.
	Font playerFont = new Font(Font.DIALOG, Font.BOLD, 15);
	// The Font of the guide.
	Font guideFont = new Font(Font.DIALOG, Font.ITALIC, 16);
	// Special Font used during click events.
	Font specialFont = new Font(Font.SANS_SERIF, Font.ITALIC, 18);
}
