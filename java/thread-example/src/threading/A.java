package threading;

public class A {

	public void threadrun() {
		/*
		System.out.println(Thread.activeCount());
		Thread.currentThread().setName("veptor");
		System.out.println(Thread.currentThread().getName());
		
		Thread.currentThread().setPriority(10);
		System.out.println(Thread.currentThread().getPriority());
		System.out.println(Thread.currentThread().isAlive());
		*/
		
		/*
		
		for(int i = 3; i > 0; i--) {
			System.out.println(i);
			Thread.sleep(1000);
		}
		
		System.out.println("You are done!");
	
		*/

		Threading thread2 = new Threading(); 
		
		thread2.setDaemon(true);
		System.out.println(thread2.isDaemon());
		
		thread2.start();
		
		System.out.println(thread2.isAlive());

		thread2.setName("2nd thread");
		System.out.println(thread2.getName());
		
		thread2.setPriority(10);
		System.out.println(thread2.getPriority());
		
		System.out.println(Thread.activeCount());
		
	}
}
