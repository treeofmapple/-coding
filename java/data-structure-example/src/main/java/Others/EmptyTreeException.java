package Others;

public class EmptyTreeException extends Exception {

	public EmptyTreeException() {
		super("Heya, got an error");
	}
	
	public EmptyTreeException(String message) {
		super(message);
	}
	
	public EmptyTreeException(String message, Throwable cause) {
		super(message, cause);	
	}
	
}
