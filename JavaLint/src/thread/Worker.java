package thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import logic.GestionRulesImpl;
import structure.RuleError;
import structure.JavaFile;
import structure.RuleEnum;
import structure.Rules;
import utility.ConfigReader;
import utility.FileTools;
import utility.OSUtils;

public class Worker {
	private List<JavaFile> javaFiles = new ArrayList<JavaFile>();
	private GestionRulesImpl gestionRules = new GestionRulesImpl();
	private Boolean shouldDisplayErrors = false;

	public void work() {
		findFiles();
		processFiles();
	}

	// Find java files and add to list
	private void findFiles() {
		FileTools fileUtils = new FileTools();
		List<JavaFile> refreshList = fileUtils.findAllFiles(ConfigReader.getProjectProperty());
		if (refreshList.size() != javaFiles.size()) {
			this.javaFiles = refreshList;
		}
	}

	// Which rules should be apply on files ?
	// Process all java files and handle errors
	private void processFiles() {
		Map<RuleEnum, Boolean> ruleToEnable = ConfigReader.getAuthorization();
		for (JavaFile currentFile : javaFiles) {
			// Only process the file if the date of last modified is new
			if (fileMustBeChecked(currentFile)) {
				// A file has been modificate, logs must display
				shouldDisplayErrors = true;
				// Clear current rules we will check it again
				currentFile.getRuleError().clear();
				// Update date (we don't need to check the file since we are up to date now)
				currentFile.setLastModified((new Date(currentFile.getFile().getAbsoluteFile().lastModified())));

				/* IMPORTANT, SETTING FILE WE ARE CURRENTLY WORKING ON */
				FileTools.currentFileProcessing = currentFile;
				System.out.println(currentFile.getFile().getAbsolutePath());
				for (Object key : ruleToEnable.keySet()) {
					if ((boolean) ruleToEnable.get(key)) {
						applyRules((RuleEnum) key, currentFile);
					}
				}
			}
		}
		// Check has been done, logging errors on files
		logError();
	}

	private boolean fileMustBeChecked(JavaFile javaFile) {
		if (javaFile.getLastModified() != null) {
			if (!new Date(javaFile.getFile().getAbsoluteFile().lastModified()).after(javaFile.getLastModified())) {
				return false;
			}
		}
		return true;
	}

	// Log error
	private void logError() {
		if (this.shouldDisplayErrors) {
			// Reset boolean
			this.shouldDisplayErrors = false;
			for (JavaFile currentFile : javaFiles) {
				for (RuleError ruleError : currentFile.getRuleError()) {
					System.out.println("File : " + OSUtils.extractFileNameFromPath(currentFile.getAbsolutePath())
							+ " Rule : " + ruleError.getRuleError().getName() + " at Line (" + ruleError.getLine() + ","
							+ ruleError.getColumn() + ")");
				}
			}
		} else {
			System.out.println("No modifications on " + ConfigReader.getProjectProperty() + System.lineSeparator());
		}
	}

	// Apply rules and handle error (adding to javafiles errors)
	private void applyRules(RuleEnum rule, JavaFile currentFile) {
		if (rule.getValue() == Rules.LINE_SIZE_VALUE) {
			currentFile.addRuleError(gestionRules.lineSize(null));
		}
		if (rule.getValue() == Rules.STRING_INSTANTIATION_VALUE) {
			currentFile.addRuleError(gestionRules.stringInstantiation());
		}
		if (rule.getValue() == Rules.CONSTANT_UPPERCASE_VALUE) {
			currentFile.addRuleError(gestionRules.constantUppercase(null));
		}
		if (rule.getValue() == Rules.CLASS_NAME_FORMAT_VALUE) {
			currentFile.addRuleError(gestionRules.classNameFormat(null));
		}
		if (rule.getValue() == Rules.PARAMS_FUNCTION_VALUE) {
			currentFile.addRuleError(gestionRules.paramsFunction(null));
		}
		if (rule.getValue() == Rules.CHECK_NULL_INPUT_VALUE) {
			currentFile.addRuleError(gestionRules.checkNullInput());
		}
		if (rule.getValue() == Rules.FINAL_DECLARATION_MISSING_VALUE) {
			currentFile.addRuleError(gestionRules.finalDeclarationMissing());
		}
		if (rule.getValue() == Rules.NESTED_SPACES_VALUE) {
			currentFile.addRuleError(gestionRules.nestedSpaces());
		}
	}

}
