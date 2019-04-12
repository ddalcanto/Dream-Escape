package dreamEscapeLauncher.world;

public class Object extends DrawTiles implements WorldImage {

	@Override
	public void loadImage() {
		super.loadImage("objects.txt");
	}
}
