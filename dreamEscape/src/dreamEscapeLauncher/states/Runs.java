package dreamEscapeLauncher.states;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Runs extends JPanel {

	protected JFrame frame;

	public abstract void run(JFrame frame);

}
