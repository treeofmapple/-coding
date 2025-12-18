package logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Filter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class SecondPart {

	private static final Logger logger = Logger.getLogger(SecondPart.class.getName());
	private static final Logger logger1 = Logger.getLogger("");
	// private static final Logger logger2 = Logger.getLogger("com");
	// private static final Logger logger3 = Logger.getLogger("com.jenkov");
	
	@SuppressWarnings("unused")
	private static final Logger logger4 = Logger.getLogger("logging");
	
	public static void main(String[] args) {
		logger1.addHandler(new ConsoleHandler());
		logger1.setFilter(new Filter() {
			public boolean isLoggable(LogRecord record) {
				return false;
			}
		});
		logger.info("Msg: wawa");
	}
	
	
	
	
}
