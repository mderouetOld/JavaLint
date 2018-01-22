package thread;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class DaemonProcessing implements Runnable {
	
	// Asynchronous boolean (can be modificate by other classes)
	private volatile boolean running = true;
	
	// Time between two checks
	private final long THREAD_BREAK_TIME = 2000;
	
	private List<Files> javaFileList = new ArrayList<Files>();
	
	// Must be called to end the daemon processing
	public void stop() {
		this.running = false;
	}
	
	public void run() {
		while(running) {
			System.out.println("Working...");
			
			findFiles();
			processFiles();
			pause();
			
		}
	}
	
	// Refresh the tree path (check folder are created)
	private void findTreeByPath(String path)
	{
		
	}
	
	// Find java files and add to list
	private void findFiles() {
		
	}
	
	// Process all java files and handle errors
	private void processFiles() {
		
	}
	
	private void pause() {
		try {
			Thread.sleep(THREAD_BREAK_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
