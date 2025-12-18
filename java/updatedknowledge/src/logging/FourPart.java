package logging;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.MemoryHandler;
import java.util.logging.SimpleFormatter;
import java.util.logging.SocketHandler;
import java.util.logging.StreamHandler;

public class FourPart {

	private static final Logger logger = Logger.getLogger(FirstPart.class.getName());
	
	public static void main(String[] args) {
		readFile();
		
	}
	
	public static void readFile() {
		FirstPart firstPart = new FirstPart();
		firstPart.doIt();
	}

	public FileHandler storeMessage(String fileName, String message) throws IOException {
		FileHandler fileHandler = new FileHandler(fileName + ".%u.%g");
		return fileHandler;
	}
	
	public StreamHandler streamHandler() {
		StreamHandler streamHandler = new StreamHandler();
		return streamHandler;
	}
	
	public SocketHandler socketHandler(String host, int port) throws IOException {
		SocketHandler socketHandler = new SocketHandler(host, port);
		return socketHandler;
	}
	
	public MemoryHandler memoryHandler(Handler targetHandler) {
		MemoryHandler memoryHandler = new MemoryHandler(targetHandler, 10, Level.WARNING);
		return memoryHandler;
	}
	
	public void addContentHandler() {
		logger.addHandler(new ConsoleHandler());
		
		ConsoleHandler handler = new ConsoleHandler();
		handler.setFormatter(new SimpleFormatter());
		
		try {
			logger.addHandler(new FileHandler());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		logger.addHandler(new StreamHandler());
		
		try {
			logger.addHandler(new SocketHandler());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		logger.addHandler(new MemoryHandler());
		
	}
	
	public void doIt() {
		logger.entering(getClass().getName(), "doIt");
		
		try {
			logger.setLevel(Level.WARNING);
			throw new IllegalArgumentException("Invalid Argument");
			
		} catch(Exception e) {
			logger.log(Level.SEVERE, "Error doing XYZ", e);
		}
		
		logger.exiting(getClass().getName(), "doIt");
	}
	
}
