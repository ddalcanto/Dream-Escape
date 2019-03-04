package dreamEscapeLauncher.states;

import java.awt.Font;

import javax.swing.JButton;

public interface Menu {

	// Create an array of buttons used on all Classes drawing to the home screen.
	JButton[] buttons = new JButton[20];
	
	// Amount of buttons the starting screen will contain.
	int originalButtonAmount = 2;

	Font defaultFont = new Font(Font.SERIF, Font.PLAIN, 30);

}
