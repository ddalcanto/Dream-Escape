package dreamEscapeLauncher.states;

public abstract class State extends Runs {

	public static final String HomeScreen = null;

	private static State currentState = null;

	public static void setState(State state) {
		currentState = state;
	}

	public static State getState() {
		return currentState;
	}

}
