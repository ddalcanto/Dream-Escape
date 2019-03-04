package dreamEscapeLauncher;

import java.awt.Color;

import dreamEscapeLauncher.dialogue.ChatDialogue;
import dreamEscapeLauncher.gameDetails.EnterText;
import dreamEscapeLauncher.states.Credits;
import dreamEscapeLauncher.states.HomeScreen;
import dreamEscapeLauncher.states.State;

public class StateCustomizer extends WindowCreator {

	private int state;

	public StateCustomizer(String title, int width, int height) {
		super("Dream Escape", 1000, 1000);
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
			State.setState(new EnterText());
			break;
		case 3:
			panel.setBackground(Color.BLACK);
			State.setState(new ChatDialogue());
			break;
		case 4:
			State.setState(new Credits());
			break;
		default:
			System.out.println("Error: Valid state not set! Terminating program.");
			System.exit(0);
			break;
		}
//		State.getState().run(panel);
		// Run the "run(JPanel)" method of whichever state "State" has been set to.
	}

	public void run() {
		System.out.println(State.getState());
		State.getState().run(panel);
//		panel.revalidate();
	}

	public void tick() {
//		System.out.println(State.getState());
		// Run the "tick()" method of whichever state "State" has been set to.
		State.getState().tick();
	}
}
