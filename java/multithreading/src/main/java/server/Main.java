package server;

import server.util.MultiThread;
import server.util.SingleThread;
import server.util.ThreadPooled;

public class Main extends Operationss {

	public static void main(String[] args) {
		// SingleThreadServer();
		// MultiThreadServer();
		ThreadPooledServer();
	}

}

class Operationss {

	public static void SingleThreadServer() {

		int ip = 9000;

		SingleThread st = new SingleThread(ip);
		new Thread(st).start();

		try {
			System.out.println("Server Started: " + ip);
			Thread.sleep(60 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Stopping Server");
		st.stop();
	}

	public static void MultiThreadServer() {

		int ip = 9001;

		MultiThread mt = new MultiThread(ip);
		new Thread(mt).start();

		try {
			System.out.println("Server Started: " + ip);
			Thread.sleep(60 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Stopping Server");
		mt.stop();

	}

	public static void ThreadPooledServer() {

		int ip = 9002;
		int threadLimit = 2;

		ThreadPooled tp = new ThreadPooled(ip, threadLimit);
		new Thread(tp).start();

		try {
			System.out.println("Server Started: " + ip);
			Thread.sleep(10 * 10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Stopping Server");
		tp.stop();
	}

}