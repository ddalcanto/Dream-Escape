package dreamEscapeLauncher.dialogue;

import java.awt.Color;

import javax.swing.JPanel;

import dreamEscapeLauncher.states.State;

public class ModifyWorld extends State {

	protected Color color;

	@Override
	public void tick() {
		panel.revalidate();
	}

	@Override
	public void run(JPanel panel) {
		// Retrieve the applications main panel.
		setPanel(panel);
	}

	@Override
	public void setPanel(JPanel panel) {
		// Retrieve the application's main JPanel, and set this classes "panel" to it.
		this.panel = panel;

	}

	protected void whiteBackround() {
		panel.setBackground(Color.WHITE);
	}
}
