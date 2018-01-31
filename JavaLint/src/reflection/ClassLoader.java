package reflection;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.CodeSource;
import java.security.ProtectionDomain;

import org.apache.log4j.Logger;

public class ClassLoader {
	private static final Logger LOGGER = Logger.getLogger(ClassLoader.class);

	public static Class<?> load(String folderPath) {
 		Class cls = null;
		try {

			File file = new File("C:\\Users\\Warp\\git\\JavaLint\\JavaLint\\tests\\dev");

			// convert the file to URL format
			URL url = file.toURI().toURL();
			URL[] urls = new URL[] { url };

			// load this folder into Class loader
			URLClassLoader cl = new URLClassLoader(urls);

			// load the Address class in 'c:\\other_classes\\'
			 cls = cl.loadClass("reflection.myClass");
			 cl.close();
			// print the location from where this class was loaded
			ProtectionDomain pDomain = cls.getProtectionDomain();
			CodeSource cSource = pDomain.getCodeSource();
			URL urlfrom = cSource.getLocation();
			LOGGER.info(urlfrom.getFile());

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return cls;
	}

}
