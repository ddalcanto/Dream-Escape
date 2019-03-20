package dreamEscapeLauncher;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class WindowCreator {

	public static JFrame frame;

	public static int frameW;
	public static int frameH;

	private String title;

	protected WindowCreator(String title, int width, int height) {
		this.title = title;
		frameW = width;
		frameH = height;
	}

	protected void CreateWindow() {
		// Creates a JFrame.
		frame = new JFrame();
		frame.setTitle(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(frameW, frameH);
		frame.setLocationRelativeTo(null);

		frame.setVisible(true);
	}
}
