package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class threadSyncronization {

	private static Task1 tk1 = new Task1();
	private static Task2 tk2 = new Task2();
	private static Task3 tk3 = new Task3();
	private static Task4 tk4 = new Task4();
	
	public static void main(String[] args) {
		tk1.startThread();
		tk1.threadJoin();
		tk2.startThread();
		tk2.threadJoin();
		tk3.runExecutor();
		tk4.runExecutor();
	}
	
}

class Task1 {
	
	Runnable task1 = () -> {
		 System.out.println("Task 1 running in thread: " + Thread.currentThread().getName());
	};
	
	Thread thread1 = new Thread(task1, "Mythread1");
	
	public void startThread() {
		thread1.start();
	}
	
	public void threadJoin() {
		try {
			thread1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}


class Task2 {
	
    Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Task 2 running in thread: " + Thread.currentThread().getName());
        }
    }, "MyThread-2");
    
    public void startThread() {
    	thread2.start();
    }
	
    public void threadJoin() {
		try {
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
    
}


class Task3 {
	
	Counter sharedCounter = new Counter();
	int numThread = 1000;
	ExecutorService executor = Executors.newFixedThreadPool(10);
    
	public void runExecutor() {
		for (int i = 0; i < numThread; i++) {
	        executor.submit(() -> {
	            sharedCounter.incrementSynchronized();
	        });
	    }

	    executor.shutdown();
	    
	    try {
			executor.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    System.out.println("Final count (synchronized): " + sharedCounter.getCount());   
	}
	
}

class Task4 {
	
	int numThread = 1000;
	AtomicCounter atomicCounter = new AtomicCounter();
    ExecutorService atomicExecutor = Executors.newFixedThreadPool(10);
    
    public void runExecutor() {
    	for (int i = 0; i < numThread; i++) {
            atomicExecutor.submit(() -> {
                atomicCounter.increment();
            });
        }

        atomicExecutor.shutdown();
        try {
			atomicExecutor.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

        System.out.println("Final count (AtomicInteger): " + atomicCounter.getCount()); 

    }
	
}


class Counter {
	
	private int count = 0; 
	private final Object lock = new Object();
	
    // Method using synchronized keyword for thread safety
    public void incrementSynchronized() {
        synchronized (lock) { // Synchronize on a specific object
            count++;
        }
    }

    // Method using synchronized method for thread safety
    public synchronized void incrementSynchronizedMethod() {
        count++;
    }

    public int getCount() {
        return count;
    }
	
}

class AtomicCounter {
	
	private AtomicInteger count = new AtomicInteger(0);
	
	public void increment() {
		count.incrementAndGet();
	}
	
	public int getCount() {
		return count.get();
	}
}











