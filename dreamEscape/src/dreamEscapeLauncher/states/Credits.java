package dreamEscapeLauncher.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import dreamEscapeLauncher.utils.Loader;

public class Credits extends State {

	// Every 5 milliseconds, move all text down 1 pixel
	Timer updatePos = new Timer(5, new ActionListener() {
		// Move down all components using scrollY
		public void actionPerformed(ActionEvent e) {
			scrollY += 1;
		}
	});

	JFrame frame;

	private JButton button = new JButton();

	private JTextPane label = new JTextPane();

	// Initializing it to nothing prevent a "null" from being added to creditsText
	String creditsText = "";

	private int scrollY;
	private int lineCount = 0;

	private void loadText() {
		// Loads the file containing the credits info.
		Scanner creditsFile = Loader.loadFileAsScanner("creditsText.txt");
		System.out.println("Credits file successfully retrieved");
		System.out.println();

		// Adds the contents of the script to a string, putting new lines after each
		// scan
		while (creditsFile.hasNextLine()) {
			creditsText = creditsText + creditsFile.nextLine() + "\n";
			lineCount++;
		}

		creditsFile.close();
		// isLoaded = true;
	}

	@Override
	public void tick() {
		label.setLocation(0, scrollY);
		if (scrollY < 600) {
			button.setLocation(325, scrollY - 200);
		}
	}

	@Override
	public void run(final JFrame frame) {
		final JPanel panel = this;
		this.frame = frame;
		setLayout(null);
		loadText();
		scrollY = lineCount * -50;
		setBackground(Color.black);
		label.setOpaque(false);
		label.setForeground(Color.WHITE);
		label.setFont(new Font(Font.DIALOG, Font.BOLD, 35));

		// Centers all JTextPane text
		StyledDocument doc = label.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);

		label.setEditable(false);
		label.setSize(1000, 1000);

		// Start the timer to move all components using scrollY downwards
		updatePos.start();
		label.setText(creditsText);
		add(label);

		// Add a listener to the button which causes the program to return to the
		// home screen
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button) {
					frame.remove(panel);
					State.setState(new HomeScreen());
				}
			}
		});
		button.setSize(350, 100);
		button.setText("Return to main screen");
		button.setFont(new Font(Font.SERIF, Font.ITALIC, 30));
		// Add button to the JPanel.
		add(button);
		setLayout(null);
		// Add the JPanel to the frame.
		frame.add(this);
	}
}
