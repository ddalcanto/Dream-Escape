package dreamEscapeLauncher.states;

import dreamEscapeLauncher.StateCustomizer;

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
