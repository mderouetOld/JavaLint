package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import logic.GestionRulesImpl;
import structure.RuleError;
import structure.JavaFile;
import structure.RuleEnum;
import structure.Rules;
import utility.ConfigReader;
import utility.FileUtils;

public class Worker {
	private  List<JavaFile> javaFiles = new ArrayList<JavaFile>();
	private  GestionRulesImpl gestionRules = new GestionRulesImpl();
	private List<RuleError> fileError = new ArrayList<RuleError>();
	
	public  void work() {
		findFiles();
		processFiles();
	}

	// Find java files and add to list
	private  void findFiles() {
		FileUtils fileUtils = new FileUtils();
		javaFiles = fileUtils.findAllFiles(ConfigReader.getProjectProperty());
	}

	// Which rules should be apply on files ?
	// Process all java files and handle errors
	private  void processFiles() {
		Map<RuleEnum, Boolean> ruleToEnable = ConfigReader.renderAuthorization();
		for (JavaFile currentFile : javaFiles) {
			/* IMPORTANT, SETTING FILE WE ARE CURRENTLY WORKING ON */
			FileUtils.currentFileProcessing = currentFile;
			System.out.println(currentFile);
			for (Object key : ruleToEnable.keySet()) {
				if ((boolean) ruleToEnable.get(key)) {
					applyRules((RuleEnum) key,currentFile);
				}
			}
		}
	}

	//Apply rules and handle error (adding to javafiles errors)
	private  void applyRules(RuleEnum rule, JavaFile currentFile) {
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
