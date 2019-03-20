package dreamEscapeLauncher.states;

import java.awt.Graphics;

import dreamEscapeLauncher.StateCustomizer;
import dreamEscapeLauncher.dialogue.ChatBubble;
import dreamEscapeLauncher.world.Tiles;

public abstract class State extends Runs {

	public static final String HomeScreen = null;

	private static State currentState = null;

	private static StateCustomizer stateCustomizer = new StateCustomizer(null, 0, 0);

	public static void setState(State state) {
		currentState = state;
		stateCustomizer.run();
	}

	public static State getState() {
		return currentState;
	}
}
