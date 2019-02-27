package dreamEscapeLauncher.gameDetails;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RequestDetails extends EnterText{
	
	private Font creationFont = new Font(Font.SERIF, Font.PLAIN, 30);
	
	@Override
	public void tick() {
		super.tick();	
	}

	@Override
	public void run(JPanel panel) {
		// Retrieve the applications main panel.
		panel.setBackground(Color.DARK_GRAY);
		label.setForeground(Color.WHITE);
		label.setText("Please enter your name");
		label.setFont(creationFont);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setLocation(SwingConstants.CENTER, 200);
		label.setSize(1000, 100);
		panel.add(label);
		super.run(panel);
		
	}

	@Override
	public void setPanel(JPanel panel) {
		// Retrieve the application's main JPanel, and set this classes "panel" to it.
		this.panel = panel;
		
	}

}
