package dreamEscapeLauncher.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Credits extends State implements Menu {

	// Every 5 milliseconds, move all text down 1 pixel
	Timer updatePos = new Timer(5, new ActionListener() {
		// Move down all components using scrollY
		public void actionPerformed(ActionEvent e) {
			scrollY += 1;
		}
	});

	private JButton button = new JButton();

	private JTextPane label = new JTextPane();

	// Initializing it to nothing prevent a "null" from being added to creditsText
	String creditsText = "";

	private int scrollY;
	private int lineCount = 0;

	private void loadText() {
		try {
			// Loads the file containing the credits info.
			Scanner creditsFile = new Scanner(new File("res/creditsText.txt"));
			System.out.println("Credits file successfully retrieved");
			System.out.println();
			int loop = 0;

			// Adds the contents of the script to a string, putting new lines after each
			// scan
			while (creditsFile.hasNextLine()) {
				creditsText = creditsText + creditsFile.nextLine() + "\n";
				lineCount++;
			}

			creditsFile.close();
			// isLoaded = true;

			// In case the Scanner fails to locate the file.
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: FILE NOT FOUND");
		}
	}

	@Override
	public void tick() {
		label.setLocation(0, scrollY);
		if (scrollY < 600) {
			button.setLocation(325, scrollY - 200);
		}
		// panel.revalidate();
	}

	@Override
	public void run(final JPanel panel) {
		setPanel(panel);
		loadText();
		scrollY = lineCount * -50;
		panel.setBackground(Color.black);
		label.setOpaque(false);
		label.setForeground(Color.WHITE);
		label.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
		// TODO Understand later

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
		panel.add(label);

		// Add a listener to the button which causes the program to return to the
		// home screen
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button) {
					State.setState(new HomeScreen());
					panel.remove(label);
					panel.remove(button);
				}
			}
		});
		button.setSize(350, 100);
		button.setText("Return to main screen");
		button.setFont(new Font(Font.SERIF, Font.ITALIC, 30));
		panel.add(button);
	}

	@Override
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
}
