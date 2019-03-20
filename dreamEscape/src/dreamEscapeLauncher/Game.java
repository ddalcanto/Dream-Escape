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
		int ticks = 0; // Used for displaying current fps.
		while (isRunning) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				tick();
				ticks++;
				delta--;
			}

			if (timer >= 1000000000) {
//			 System.out.println("fps = " + ticks); //Display current fps.
				ticks = 0;
				timer = 0;

			}

		}
	}
}