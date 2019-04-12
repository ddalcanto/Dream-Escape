package dreamEscapeLauncher.gameDetails;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class RequestDetails extends EnterText {

	private Font creationFont = new Font(Font.SERIF, Font.PLAIN, 30);

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	public void run(JFrame frame) {
		super.run(frame);
		// Retrieve the applications main
		setBackground(Color.DARK_GRAY);
		label.setForeground(Color.WHITE);
		label.setText("Please enter your name");
		label.setFont(creationFont);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setLocation(SwingConstants.CENTER, 200);
		label.setSize(1000, 100);
		// Add the label to the JPanel
		add(label);
	}
}
