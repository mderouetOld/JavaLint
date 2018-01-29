package structure;

import java.io.File;
import java.util.Date;

public abstract class FileAbstract {

	private String title;
	private File file;
	private Date lastModified;

	public FileAbstract() {
	}

	public FileAbstract(String title, File file) {
		this.title = title;
		this.file = file;
	}

	public String toString() {
		return this.title + " " + lastModified.toString();
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public String getName() {
		return title;
	}

	public void setName(String title) {
		this.title = title;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}
