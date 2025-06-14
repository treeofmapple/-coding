package threading;

public class Threading extends Thread {

	@Override
	public void run() {
		if(this.isDaemon()) {
			System.out.println("This thread is running with daemon");
		} else {
			System.out.println("This is a user thread");
		}
	}
	
}
