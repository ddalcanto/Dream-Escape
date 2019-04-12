package dreamEscapeLauncher.world;

public class Foundation extends DrawTiles implements WorldImage {
	
	@Override
	public void loadImage() {
		super.loadImage("world.txt");
	}
}
