package main;

import multithread.B;
import threading.A;

public class Main {
	
	static final A a = new A();
	static final B b = new B();
	
	public static void main(String[] args) throws InterruptedException {
		
		a.threadrun();
		b.threadrun();
		System.out.println("\nFinished");
		
	}
}
