package dreamEscapeLauncher.states;

import javax.swing.JPanel;

public abstract class Runs {

	protected JPanel panel;

	public abstract void tick();

	public abstract void run(JPanel panel);

	public abstract void setPanel(JPanel panel);

}
