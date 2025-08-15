package frame;

import java.io.File;
import java.io.IOException;

public class LockInstance {

	private static final String LOCK_FILE = "app.lock";

	public static boolean isAlreadyRunning() {
		File file = new File(LOCK_FILE);
		if (file.exists()) {
			return true;
		} else {
			try {
				file.createNewFile();
				file.deleteOnExit();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		}

	}

}
