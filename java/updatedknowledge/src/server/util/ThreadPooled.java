package server.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPooled extends ThreadOperations implements Runnable {

	public ThreadPooled(int port, int threadPoolingQTD) {
		this.serverPort = port;
		this.threadPoolingQTD = threadPoolingQTD;
		this.threadPool = Executors.newFixedThreadPool(threadPoolingQTD);
	}
	
	@Override
	public void run() {
		synchronized (this) {
			this.runningThread = Thread.currentThread();
		}
		
		openServerSocket();
		while(!IsStopped()) {
			Socket clientSocket = null;
			try {
				clientSocket = this.serverSocket.accept();
			} catch(IOException e) {
				if(IsStopped()) {
					System.out.println("Server Stopped.");
					return;
				}
				throw new RuntimeException("Error accepting client connection", e);
			}
			this.threadPool.execute(new ThreadWorkerRunnable(clientSocket, "ThreadPooled Server"));
		}
		this.threadPool.shutdown();
		System.out.println("Server Stopped.");
	}
	
	
}

class ThreadVariables {
	
	protected int serverPort = 8080;
	protected ServerSocket serverSocket = null;
	protected boolean isStopped = false;
	protected Thread runningThread = null;
	protected int threadPoolingQTD = 0;
	protected ExecutorService threadPool;
	
	protected Socket clientSocket = null;
	protected String serverText = null;
	
}

class ThreadWorkerRunnable extends ThreadVariables implements Runnable {
	
	public ThreadWorkerRunnable(Socket clientSocker, String serverText) {
		this.clientSocket = clientSocker;
		this.serverText = serverText;
	}
	
	@Override
	public void run() {
		try {
			InputStream input = clientSocket.getInputStream();
			OutputStream output = clientSocket.getOutputStream();
			long time = System.currentTimeMillis();
			
			byte[] responseDocument = (
					"HTTP/1.1 200 OK\n\nWorkerRunnable: " +
					this.serverText + " - " + time + "").getBytes("UTF-8"); 
			
			output.write(responseDocument);
			output.close();
			input.close();
			System.out.println("Request processed: " + time);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}

class ThreadOperations extends ThreadVariables {

	protected void openServerSocket() {
		try {
			this.serverSocket = new ServerSocket(this.serverPort);
		} catch(IOException e) {
			throw new RuntimeException("Cannot open port " + serverPort, e);
		}
	}
	
	public synchronized void stop() {
		this.isStopped = true;
		try {
			this.serverSocket.close();
		} catch(IOException e) {
			throw new RuntimeException("Error closing server", e);
		}
	}
	
	public synchronized boolean IsStopped() {
		return this.isStopped;
	}
	
}

