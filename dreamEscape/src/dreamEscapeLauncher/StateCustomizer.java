package dreamEscapeLauncher;

import dreamEscapeLauncher.dialogue.DialogueState;
import dreamEscapeLauncher.gameDetails.RequestDetails;
import dreamEscapeLauncher.states.Credits;
import dreamEscapeLauncher.states.HomeScreen;
import dreamEscapeLauncher.states.State;

public class StateCustomizer extends WindowCreator {

	private int state;
	
	public static boolean tilesDebug = false;

	public StateCustomizer(String title, int width, int height) {
		// super("Dream Escape", 1038, 1060); // Correct size for Windows
		super("Dream Escape", 1024, 1045); // Correct size for Mac
	}

	public void CreateWindow() {
		super.CreateWindow();
		state = 1;

		// Changes the starting State. Only for debug purposes.
		switch (state) {
		case 1:
			State.setState(new HomeScreen());
			break;
		case 2:
			State.setState(new RequestDetails());
			break;
		case 3:
			State.setState(new DialogueState());
			break;
		case 4:
			State.setState(new Credits());
			break;
		case 5:
			DialogueState dialogueState = new DialogueState();
			tilesDebug = true;
			dialogueState.tilesDebug();
			State.setState(dialogueState);
			break;
		default:
			System.out.println("Error: Valid state not set! Terminating program.");
			System.exit(0);
			break;
		}
		// Run the "run(JPanel)" method of whichever state "State" has been set to.
	}

	public void run() {
		State.getState().run(frame);
	}

	public void tick() {
		// Run the "tick()" method of whichever state "State" has been set to.
		State.getState().tick();
		// Make sure the frame is always visible, no matter which classes are being
		// called
		frame.setVisible(true);
	}

}
