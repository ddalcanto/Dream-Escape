package dreamEscapeLauncher;

public class Game implements Runnable {

	private boolean isRunning = true;

	private StateCustomizer stateCustomizer = new StateCustomizer("Message", 200, 200);

	public Game() {
		stateCustomizer.CreateWindow();
	}

	public void tick() {
		stateCustomizer.tick();
	}

	// Code from RealTutsGML
	// Limits the programs fps.
	public void run() {
		final double FPS = 60.0;
		final double timePerTick = 1000000000 / FPS;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		while (isRunning) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				tick();
				delta--;
			}

			if (timer >= 1000000000) {
				timer = 0;
			}
		}
	}
}