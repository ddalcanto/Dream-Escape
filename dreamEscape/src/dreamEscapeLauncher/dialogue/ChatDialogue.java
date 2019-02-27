package dreamEscapeLauncher.dialogue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import dreamEscapeLauncher.gameDetails.EnterText;

public class ChatDialogue extends ChatBubble implements Chat {

	private Scanner Script;

	private String currentLine;

	// Which line of the map is being accessed.
	private int lineNum = 0;
	// How many of the characters of a line are being displayed.
	private int index = 0;

	// If the background color is currently set to white.
	private boolean whiteBackground = false;
	// If the file has been loaded.
	private boolean isLoaded = false;

	private JLabel label = new JLabel("");

	// The default text font.
	private Font font = new Font(Font.DIALOG, Font.BOLD, 15);

	// Used to hold the game's script.
	private Map<Integer, String> map = new HashMap<>();
	// Used to retrieve the line # associated with a line of
	// dialogue text.
	private Map<String, Integer> reverseMap = new HashMap<>();

	// Increments the displayed letter of the text bubble.
	private ActionListener updateIndex = new TimerListener();
	private Timer textTimer = new Timer(30, updateIndex);

	private void loadScript() {
		try {
			// Loads the file containing the games script.
			Script = new Scanner(new File("res/Dialogue.txt"));
			System.out.println("File successfully retrieved");
			System.out.println();
			int loop = 0;

			// Adds the contents of the script to the map line by line.
			while (Script.hasNextLine()) {
				String dialogue = Script.nextLine();
				dialogue = dialogue.replace("[PLAYER]", EnterText.playerName);
				map.put(loop, dialogue);
				reverseMap.put(dialogue, loop);
				loop++;
			}
			Script.close();
			isLoaded = true;

			// In case the Scanner fails to locate the file.
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: FILE NOT FOUND");
		}
	}

	public void nextLine() {
		// Increase the current line of the map which is being accessed.
		lineNum++;
		// Reset the index.
		index = 0;
		// Set "currentLine" to the current line of the script.
		displayLine();
	}

	public void displayLine() {
		currentLine = map.get(lineNum);
		// Run "currentLine" through the checks.
		checkState();
		label.setFont(font);
		label.setForeground(color);
		label.setText(currentLine.substring(0, index));
		panel.add(label);
	}

	// Checks the contents of "currentLine" for special statements.
	private void checkState() { // Should I use a switch statement here?

		// If the current line is blank, go to the next line.
		if (currentLine.equals("")) {
			nextLine();
		}

		// If the current line is a section, go to the next line.
		if (currentLine.contains("[SECTION")) {
			nextLine();
		}

		// If the current line is "[whiteBackground]", set the background to white and
		// go to the next line.
		if (currentLine.equals("[whiteBackground]")) {
			whiteBackground = true;
			whiteBackround();
			nextLine();
			checkState();
		}

		// Changes the current text and chat bubble color based on the current
		// background color as well as which character is talking.
		if (currentLine.equals("P:") && !whiteBackground) {
			color = pColorB;
			label.setForeground(color);
			nextLine();
		} else if (currentLine.equals("G:") && !whiteBackground) {
			color = gColorB;
			label.setForeground(color);
			nextLine();
		}

		if (currentLine.equals("P:") && whiteBackground) {
			System.out.println("WHITE");
			color = pColorW;
			label.setForeground(color);
			nextLine();
		} else if (currentLine.equals("G:") && whiteBackground) {
			System.out.println("WHITE");
			color = gColorW;
			label.setForeground(color);
			nextLine();
		}
	}

	// Checks the entered section, and starts them at that section.
	// In the future the user will enter a section code, and that code will be
	// checked.
	public void checkSec(String sec) {
		if (map.containsValue(sec)) {
			System.out.println("step 1");
			if (map.containsValue(sec)) {
				lineNum = reverseMap.get(sec);
				color = Color.GREEN;
				map.put(lineNum + 1, "Running sec 2. Please click to continue.");
				System.out.println(lineNum);
				System.out.println("SUCCESS");
			}
			nextLine();
			checkState();
		} else {
			System.out.println("ERROR: SECTION NOT VERIFIED");
			System.out.println("RUNNING FROM BEGINNING");
		}
	}

	public void tick() {
		super.tick();
		// If the script file has been loaded, display "currentLine".
		if (isLoaded) {
			displayLine();
		}
	}

	public void run(JPanel panel) {
		// Retrieve the applications main panel.
		super.run(panel);
		loadScript();
		checkSec(EnterText.startingSection);
		// The -45 under width is to stop the JLabel from clipping through the rounded edges of the chat bubble.
		label.setSize(chatXSize - 45, 100);
		label.setHorizontalAlignment(JLabel.LEFT);
		label.setLocation(80, 50);
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
