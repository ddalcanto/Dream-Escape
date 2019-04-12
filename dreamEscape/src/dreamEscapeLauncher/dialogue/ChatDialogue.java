package dreamEscapeLauncher.dialogue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import dreamEscapeLauncher.gameDetails.EnterText;
import dreamEscapeLauncher.player.Player;
import dreamEscapeLauncher.utils.Loader;

public class ChatDialogue extends ChatBubble implements Chat {

	private Scanner Script;

	private String currentLine;

	// Which line of the dialogueMap is being accessed.
	private int lineNum = 0;
	// How many of the characters of a line are being displayed.
	private int index = 0;

	// If the background textColor is currently set to white.
	private boolean isBlack = true;

	// If the file has been loaded.
	private boolean isLoaded = false;

	private Color textColor;

	private JLabel label = new JLabel("");

	// The default text font.
	private Font font = new Font(Font.DIALOG, Font.BOLD, 15);

	// Used to hold the game's script.
	private Map<Integer, String> dialogueMap = new HashMap<>();
	// Used to retrieve the line # associated with a line of
	// dialogue text.
	private Map<String, Integer> reverseDialogueMap = new HashMap<>();

	// Increments the displayed letter of the text bubble.
	private ActionListener updateIndex = new TimerListener();
	private Timer textTimer = new Timer(30, updateIndex);

	private void loadScript() {
		// Loads the file containing the games script.
		Script = Loader.loadFileAsScanner("Dialogue.txt");
		System.out.println("File successfully retrieved");
		System.out.println();
		int loop = 0;

		// Adds the contents of the script to the dialogueMap line by line.
		while (Script.hasNextLine()) {
			String dialogue = Script.nextLine();
			dialogue = dialogue.replace("[PLAYER]", EnterText.playerName);
			dialogueMap.put(loop, dialogue);
			reverseDialogueMap.put(dialogue, loop);
			loop++;
		}
		Script.close();
		isLoaded = true;
	}

	public void nextLine() {
		// Increase the current line of the dialogueMap which is being accessed.
		lineNum++;
		// Reset the index.
		index = 0;
		// Set "currentLine" to the current line of the script.
		displayLine();
	}

	public void displayLine() {
		currentLine = dialogueMap.get(lineNum);
		// Run "currentLine" through the checks.
		checkState();
		label.setFont(font);
		label.setForeground(textColor);
		label.setText(currentLine.substring(0, index));
		add(label);
	}

	// Checks the contents of "currentLine" for special statements.
	private void checkState() { // Should I use a switch statement here?
		checkSpecial();
		checkWhoTalk(checkColor());
	}

	private void checkSpecial() {
		// If the current line is blank, go to the next line.
		if (currentLine.equals("")) {
			nextLine();
		}

		// If the current line is a section, go to the next line.
		if (currentLine.contains("[SECTION")) {
			nextLine();
		}

		// If the current line is "[makeWhite]", set the background to white and
		// go to the next line.
		if (currentLine.equals("[makeWhite]")) {
			isBlack = false;
			makeWhite();
			nextLine();
		}

		// If the current line is "[showWorld]", go to the next line and show the world
		if (currentLine.equals("[showWorld]")) {
			nextLine();
			runDrawTiles();
		}

		if (currentLine.contains("[SPECIAL]")) {
			font = specialFont;
			nextLine();
		}

		if (currentLine.contains("CANMOVE]")) {
			if (currentLine.contains("!")) {
				Player.canMove = false;
			} else {
				Player.canMove = true;
			}
			nextLine();
		}
	}

	private void checkWhoTalk(boolean isBlack) {
		// Changes the current text and chat bubble textColor based on the current
		// background color as well as which character is talking.
		if (currentLine.equals("P:") && isBlack) {
			textColor = pColorBText;
			color = pColorBBubble;
			font = playerFont;
			label.setForeground(textColor);
			nextLine();
		} else if (currentLine.equals("G:") && isBlack) {
			textColor = gColorBText;
			color = gColorBBubble;
			font = guideFont;
			label.setForeground(textColor);
			nextLine();
		}

		if (currentLine.equals("P:") && !isBlack) {
			textColor = pColorWText;
			color = pColorWBubble;
			font = playerFont;
			label.setForeground(textColor);
			nextLine();
		} else if (currentLine.equals("G:") && !isBlack) {
			textColor = gColorWText;
			color = gColorWBubble;
			font = guideFont;
			label.setForeground(textColor);
			nextLine();
		}
	}

	private boolean checkColor() {
		return isBlack;
	}

	// Checks the entered section, and starts them at that section.
	// In the future the user will enter a section code, and that code will be
	// checked.
	public void checkSec(String sec) {
		// If the dialogueMap of the dialogue contains the section being checked.
		if (dialogueMap.containsValue(sec)) {
			// Set the current line number being processed to the corresponding section.
			lineNum = reverseDialogueMap.get(sec);
			textColor = Color.GREEN;
			dialogueMap.put(lineNum + 1, "Running sec 2. Please click to continue.");
			System.out.println(lineNum);
			System.out.println("SUCCESS");
			nextLine();
			checkState();
		} else {
			System.out.println("VALID SECTION NOT ENTERED");
			System.out.println("RUNNING FROM BEGINNING");
			setBackground(Color.BLACK);
		}
	}

	public void tick() {
		super.tick();
		// If the script file has been loaded, display "currentLine".
		if (isLoaded) {
			displayLine();
		}
	}

	public void run(JFrame frame) {
		// Retrieve the applications main
		super.run(frame);
		loadScript();
		checkSec(EnterText.startingSection);
		// label.setSize(chatXSize - 200, 100);
		label.setSize(chatXSize + 200, 100);
		label.setHorizontalAlignment(JLabel.LEFT);
		label.setLocation(80, 55);
		label.setOpaque(false);
		textTimer.start();
	}

	class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// If "index" is less than the length of 'currentLine", increment index.
			if (index < currentLine.length())
				index++;
		}
	}
}
