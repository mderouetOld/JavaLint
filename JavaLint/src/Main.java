
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.PropertyConfigurator;

import thread.DaemonProcessing;
import utility.OSUtils;

public class Main {

	public static final String LOG4J_PROPERTY_FILE_NAME = "log4j.properties";

	public static void main(String[] args) {
		// Configure log4j
		Properties props = new Properties();
		try {
			String path = System.getProperty("user.dir") + "\\" + LOG4J_PROPERTY_FILE_NAME;
			if (OSUtils.isMac()) {
				path = OSUtils.windowsToLinuxPath(path);
			}

			props.load(new FileInputStream(path));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		PropertyConfigurator.configure(props);

		// Instantiation runnable process
		DaemonProcessing daemonProcessing = new DaemonProcessing();

		// Creating thread
		Thread thread1 = new Thread(daemonProcessing, "worker");
		thread1.start();
	}
}
