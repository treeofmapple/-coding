package multithread;

public class B {

	public void threadrun() throws InterruptedException {

		MyRunnable ar = new MyRunnable();
		Multithread thread1 = new Multithread();
		Thread thread2 = new Thread(ar);
		
		/*.setDeamon(true);  
			if you set the thread to daemon
			when occur error on thread it will stop
		*/
		thread1.start();
		thread1.join(3000);
		thread2.start();
		
		// other commands like
		
		/* 
		 * .wait() thread on waiting state
		 * .notify() notify the thread that is on waiting state
		 * .notifyAll() notify all the threads that are all on waiting state
		 * .stop() stop the execution of the thread
		 * .resume() return the suspended thread 
		 * */
		
		
		System.out.println(1/0);
	}
}
