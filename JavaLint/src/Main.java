

import org.apache.log4j.BasicConfigurator;
import thread.DaemonProcessing;

public class Main {
	public static void main(String[] args) {
		// Configure log4j
		BasicConfigurator.configure();
		
		// Instantiation runnable process
		DaemonProcessing daemonProcessing = new DaemonProcessing();
		
		//Creating thread
		Thread thread1 = new Thread(daemonProcessing, "worker");
		thread1.start();	
	}
}
