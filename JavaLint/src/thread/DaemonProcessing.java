package thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import structure.JavaFile;
import structure.RuleEnum;
import structure.Rules;
import utility.ConfigReader;
import utility.FileTreeUtils;

public class DaemonProcessing implements Runnable {

	// Asynchronous boolean (can be modificate by other classes)
	private volatile boolean running = true;

	// Time between two checks
	private final long THREAD_BREAK_TIME = 2000;

	// Use to process files
	private Worker worker;

	public DaemonProcessing() {
		worker = new Worker();
	}

	// Must be called to end the daemon processing
	public void stop() {
		this.running = false;
	}

	public void run() {
		while (running) {
			worker.work();
			pause();
		}
	}

	private void pause() {
		try {
			Thread.sleep(THREAD_BREAK_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
