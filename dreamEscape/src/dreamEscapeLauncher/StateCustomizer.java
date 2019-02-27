package dreamEscapeLauncher;

import java.awt.Color;

import dreamEscapeLauncher.dialogue.ChatButton;
import dreamEscapeLauncher.gameDetails.EnterText;
import dreamEscapeLauncher.states.HomeScreen;
import dreamEscapeLauncher.states.State;

public class StateCustomizer extends WindowCreator {

	private HomeScreen homeScreen = new HomeScreen();
	private EnterText enterText = new EnterText();
	private ChatButton chatButton = new ChatButton();

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
			State.setState(homeScreen);
			break;
		case 2:
			State.setState(enterText);
			break;
		case 3:
			panel.setBackground(Color.BLACK);
			State.setState(chatButton);
			break;
		default:
			System.out.println("Error: Valid state not set! Terminating program.");
			System.exit(0);
			break;
		}
		// Run the "run(JPanel)" method of whichever state "State" has been set to.
		State.getState().run(panel);
	}

	public void tick() {
		// Run the "tick()" method of whichever state "State" has been set to.
		State.getState().tick();
	}
}
