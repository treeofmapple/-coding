package logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FirstPart {

	private static final Logger logger = Logger.getLogger(FirstPart.class.getName());
	
	public static void main(String[] args) {
		readFile();
		
	}
	
	public static void readFile() {
		FirstPart firstPart = new FirstPart();
		firstPart.doIt();
	}
	
	public void doIt() {
		logger.entering(getClass().getName(), "doIt");
		
		try {
			
			throw new IllegalArgumentException("Invalid Argument");
			
		} catch(Exception e) {
			logger.log(Level.SEVERE, "Error doing XYZ", e);
		}
		
		logger.exiting(getClass().getName(), "doIt");
	}
	
}
