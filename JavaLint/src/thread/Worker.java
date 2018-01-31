package thread;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import export.ExportHtml;
import logic.GestionRulesImpl;
import structure.RuleError;
import structure.ConfigFile;
import structure.FileAbstract;
import structure.JavaFile;
import structure.Rule;
import utility.ConfigReader;
import utility.FileTools;
import utility.OSUtils;

public class Worker {
	private List<JavaFile> javaFiles = new ArrayList<JavaFile>();
	private GestionRulesImpl gestionRules = new GestionRulesImpl();
	private Boolean shouldDisplayErrors = false;
	private ConfigFile properties = null;
	
	public void work() {
		loadAuthorization();
		findFiles();
		processFiles();
	}

	private void loadAuthorization() {
		
		// Load property file for the first time
		if(properties == null)
			properties = new ConfigFile(new File(ConfigReader.getConfigFilePath()), ConfigReader.PROPERTY_FILE_NAME);
		
		// If property has changed
		if(fileMustBeChecked(properties)) {
			// Retrieve rules
			properties.setRules(ConfigReader.getAuthorization());
			// Update the date
			properties.setLastModified(new Date(properties.getFile().getAbsoluteFile().lastModified()));
			
			
			// Clear the list, properties has changed, we need to check again all files
			for(JavaFile currentFile : javaFiles) {
				currentFile.setLastModified(null);
			}
			
			System.out.println("Le fichier de propriété a changé");
		}
	}
	
	// Find java files and add to list
	private void findFiles() {
		FileTools fileUtils = new FileTools();
		List<JavaFile> updatedJavaFileList = fileUtils.findAllFiles(ConfigReader.getProjectPropertyFolderPath());
		if (updatedJavaFileList.size() != javaFiles.size()) {
			this.javaFiles = updatedJavaFileList;
		}
	}
	

	// Which rules should be apply on files ?
	// Process all java files and handle errors
	private void processFiles() {
		for (JavaFile currentFile : javaFiles) {
			// Only process the file if the date of last modified is new
			if (fileMustBeChecked(currentFile)) {
				// A file has been modified, logs must be displayed
				shouldDisplayErrors = true;
				// Clear current rules we will check it again
				currentFile.getRuleError().clear();
				// Update date (we don't need to check the file since we are up to date now)
				currentFile.setLastModified((new Date(currentFile.getFile().getAbsoluteFile().lastModified())));

				/* IMPORTANT, SETTING FILE WE ARE CURRENTLY WORKING ON */
				FileTools.currentFileProcessing = currentFile;
				System.out.println(currentFile.getFile().getAbsolutePath());
				for (Object key : properties.getRulesEnabled().keySet()) {
					if ((boolean) properties.getRulesEnabled().get(key)) {
						applyRules((Rule) key, currentFile);
					}
				}
			}
		}
		// Check has been done, logging errors on files
		logErrorConsole();
	}

	// Check whether the last modification is newer than our JavaFile stocked last modified value
	private boolean fileMustBeChecked(FileAbstract file) {
		if (file.getLastModified() != null) {
			if (!new Date(file.getFile().getAbsoluteFile().lastModified()).after(file.getLastModified())) {
				return false;
			}
		}
		return true;
	}

	// Log error
	private void logErrorConsole() {
		if (this.shouldDisplayErrors) {
			// Reset boolean
			this.shouldDisplayErrors = false;
			for (JavaFile currentFile : javaFiles) {
				for (RuleError ruleError : currentFile.getRuleError()) {
					System.out.println("File : " + OSUtils.extractFileNameFromPath(currentFile.getFile().getAbsolutePath())
							+ " Rule : " + ruleError.getRuleError().getName() + " at Line (" + ruleError.getLine() + ","
							+ ruleError.getColumn() + ")");
				}
			}
			// Export html
			ExportHtml.generateHtmlLogError(javaFiles);
		} else {
			System.out.println("No modifications on " + ConfigReader.getProjectPropertyFolderPath() + System.lineSeparator());
		}
	}

	// Apply rules and handle error (adding to javafiles errors)
	private void applyRules(Rule rule, JavaFile currentFile) {
		if (rule.getValue() == Rule.LINE_SIZE_VALUE) {
			currentFile.addRuleError(gestionRules.lineSize(null));
		}
		if (rule.getValue() == Rule.STRING_INSTANTIATION_VALUE) {
			currentFile.addRuleError(gestionRules.stringInstantiation());
		}
		if (rule.getValue() == Rule.CONSTANT_UPPERCASE_VALUE) {
			currentFile.addRuleError(gestionRules.constantUppercase(null));
		}
		if (rule.getValue() == Rule.CLASS_NAME_FORMAT_VALUE) {
			currentFile.addRuleError(gestionRules.classNameFormat(null));
		}
		if (rule.getValue() == Rule.PARAMS_FUNCTION_VALUE) {
			currentFile.addRuleError(gestionRules.paramsFunction(null));
		}
		if (rule.getValue() == Rule.CHECK_NULL_INPUT_VALUE) {
			currentFile.addRuleError(gestionRules.checkNullInput());
		}
		if (rule.getValue() == Rule.FINAL_DECLARATION_MISSING_VALUE) {
			currentFile.addRuleError(gestionRules.finalDeclarationMissing());
		}
		if (rule.getValue() == Rule.NESTED_SPACES_VALUE) {
			currentFile.addRuleError(gestionRules.nestedSpaces());
		}
	}

}
