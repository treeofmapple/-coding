package logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class bTwo_Log_Logger {

	private static final Logger log = Logger.getLogger(bTwo_Log_Logger.class.getName());

	public void getLogName() {
		String name1 = log.getName();
		Logger name2 = Logger.getLogger("Hello Logging");

		name2.log(Level.SEVERE, "Hello system log {0}", "P1");
		System.out.println();
		name2.log(Level.SEVERE, "Hello logging: {0}, {1}",
			    new Object[] {"P1", "P2"});
		
		
		// Run exception
		/*
		name2.log(log.log(Level.SEVERE, "Hello logging",
				new RuntimeException("Error")));
		
		*/
		
		
		/*
		 * logger.logrb(Level.SEVERE, "logging.LoggingExamples", "main",
        	"resources.myresources", "key1");
		 * This returns on the source bundle
		 *
		 *  key1 : This is message 1
		 *	key2 : this is message 2
		 *
		 * */
		
		System.out.println(name1);
		System.out.println(name2);
	}

	
	
	
	
	
	/*
	 * log (Level level, String message); log (Level level, String message, Object
	 * param1); log (Level level, String message, Object[] params);
	 * 
	 * log (Level level, String message, Throwable t);
	 * 
	 * log (LogRecord record);
	 * 
	 * logp (Level level, String sourceClass, String sourceMethod, String msg); logp
	 * (Level level, String sourceClass, String sourceMethod, String msg, Object
	 * param1); logp (Level level, String sourceClass, String sourceMethod, String
	 * msg, Object[] params); logp (Level level, String sourceClass, String
	 * sourceMethod, String msg, Throwable t);
	 * 
	 * logrb(Level level, String sourceClass, String sourceMethod, String bundle,
	 * String msg); logrb(Level level, String sourceClass, String sourceMethod,
	 * String bundle, String msg, Object param1); logrb(Level level, String
	 * sourceClass, String sourceMethod, String bundle, String msg, Object[]
	 * params); logrb(Level level, String sourceClass, String sourceMethod, String
	 * bundle, String msg, Throwable t);
	 * 
	 * 
	 * entering(String sourceClass, String sourceMethod); entering(String
	 * sourceClass, String sourceMethod, Object param1); entering(String
	 * sourceClass, String sourceMethod, Object[] params);
	 * 
	 * exiting (String sourceClass, String sourceMethod); exiting (String
	 * sourceClass, String sourceMethod, Object result);
	 * 
	 * fine (String message); finer (String message); finest (String message);
	 * 
	 * config (String message); info (String message); warning (String message);
	 * severe (String message);
	 * 
	 * throwing(String sourceClass, String sourceMethod, Throwable t);
	 *
	 */

	
}
