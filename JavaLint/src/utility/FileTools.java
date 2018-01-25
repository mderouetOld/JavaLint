package utility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import structure.JavaFile;

public class FileTools {

	private List<JavaFile> javaFilePath = new ArrayList<JavaFile>();

	/* FILE CURRENTLY SCANNED */
	public static JavaFile currentFileProcessing = null;

	public List<JavaFile> findAllFiles(String path) {
		walk(path);
		return javaFilePath;
	}

	private void walk(String path) {
		File root = new File(path);
		File[] list = root.listFiles();

		if (list == null)
			return;

		for (File f : list) {
			if (f.isDirectory()) {
				walk(f.getAbsolutePath());
			} else {
				if (f.getAbsoluteFile().toString().toUpperCase().contains(".JAVA")) {
					String pathCurrentFile = f.getPath();
					javaFilePath
							.add(new JavaFile(f.getAbsoluteFile(), OSUtils.extractFileNameFromPath(pathCurrentFile)));
				}
			}
		}
	}

}
