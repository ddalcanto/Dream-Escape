package dreamEscapeLauncher.utils;

public class TestTile {

	public static boolean isBoundary(int type, String fileName) {
		if (fileName.equals("world.txt")) {
			if (type == 0) {
				return false;
			} else if (type >= 2 && type <= 9) {
				return true;
			}
		} else if (fileName.equals("objects.txt")) {
			if (type >= 1 && type <= 2) {
				return false;
			}
		}
		return false;
	}
}
