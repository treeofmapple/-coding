package server.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThread extends MultiOperations implements Runnable {

	public MultiThread(int port) {
		this.serverPort = port;
	}
	
	@Override
	public void run() {
		synchronized (this) {
			this.runningThread = Thread.currentThread();
		}

		openServerSocket();
		while (!IsStopped()) {
			Socket clientSocket = null;
			try {
				clientSocket = this.serverSocket.accept();
			} catch (IOException e) {
				if (IsStopped()) {
					System.out.println("Server Stopped.");
					return;
				}
				throw new RuntimeException("Error accepting client connection", e);
			}
			new Thread(new MultiWorkerRunnable(clientSocket, "Multithreaded Server")).start();
		}
		System.out.println("Server Stopped.");
	}

}

class MultiVariables {
	
	protected int serverPort = 8080;
	protected ServerSocket serverSocket = null;
	protected boolean isStopped = false;
	protected Thread runningThread = null;
	
	protected Socket clientSocket = null;
	protected String serverText = null;
	
}

class MultiWorkerRunnable extends MultiVariables implements Runnable {
	
	public MultiWorkerRunnable(Socket clientSocket, String serverText) {
		this.clientSocket = clientSocket;
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

class MultiOperations extends MultiVariables {
	
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
