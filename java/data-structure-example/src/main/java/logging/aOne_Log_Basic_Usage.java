package logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class aOne_Log_Basic_Usage {

	private static final Logger log = Logger.getLogger(aOne_Log_Basic_Usage.class.getName());
	
	@SuppressWarnings("unused")
	public void logMaster() {
		log.entering(getClass().getName(), "Data entering");
		
		int[] value = {1, 2, 3};
		try {
			int x = value[5];
		} catch (IndexOutOfBoundsException e) {
			log.log(Level.SEVERE, "Error doing task", e);
		}
		
		log.exiting(getClass().getName(), "Data exiting");
	}

}
