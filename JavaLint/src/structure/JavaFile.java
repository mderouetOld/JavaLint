package structure;

import java.io.File;

public class JavaFile extends File{
	
	private String title = null;
	private File file = null;
	private String globalVariablesPart = null;
	private String constructorPart = null;
	private String functionPart = null;
	
	public JavaFile(File file, String title) {
		super(file, title);
		this.file = file;
		this.title = title;
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

	public String getGlobalVariablesPart() {
		return globalVariablesPart;
	}

	public void setGlobalVariablesPart(String globalVariablesPart) {
		this.globalVariablesPart = globalVariablesPart;
	}

	public String getConstructorPart() {
		return constructorPart;
	}

	public void setConstructorPart(String constructorPart) {
		this.constructorPart = constructorPart;
	}

	public String getFunctionPart() {
		return functionPart;
	}

	public void setFunctionPart(String functionPart) {
		this.functionPart = functionPart;
	}

}
