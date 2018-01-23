package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import logic.GestionRules;
import logic.GestionRulesImpl;
import structure.CapitalizationStyle;
import structure.JavaFile;
import structure.RuleEnum;
import structure.Rules;
import utility.ConfigReader;
import utility.FileUtils;

public class Worker {
	private static List<JavaFile> javaFiles = new ArrayList<JavaFile>();
	private static List<RuleEnum> rulesToApply = new ArrayList<RuleEnum>();
	private static GestionRulesImpl gestionRules = new GestionRulesImpl();

	public static void work() {
		findFiles();
		processFiles();
	}

	// Find java files and add to list
	private static void findFiles() {
		FileUtils fileUtils = new FileUtils();
		javaFiles = fileUtils.findAllFiles(ConfigReader.getProjectProperty());
	}

	// Which rules should be apply on files ?
	// Process all java files and handle errors
	private static void processFiles() {
		Map ruleToEnable = ConfigReader.renderAuthorization();
		for (JavaFile currentFile : javaFiles) {
			System.out.println(currentFile);
			for (Object key : ruleToEnable.keySet()) {
				if ((boolean) ruleToEnable.get(key)) {
					applyRules((RuleEnum) key);
				}
			}
		}

	}

	private static void applyRules(RuleEnum rule) {
		if (rule.getValue() == Rules.LINE_SIZE_VALUE) {
			gestionRules.lineSize(null);
		}
		if (rule.getValue() == Rules.STRING_INSTANTIATION_VALUE) {
			gestionRules.stringInstantiation();
		}
		if (rule.getValue() == Rules.CONSTANT_UPPERCASE_VALUE) {
			gestionRules.constantUppercase(null);
		}
		if (rule.getValue() == Rules.CLASS_NAME_FORMAT_VALUE) {
			gestionRules.classNameFormat(null);
		}
		if (rule.getValue() == Rules.PARAMS_FUNCTION_VALUE) {
			gestionRules.paramsFunction(null);
		}
		if (rule.getValue() == Rules.CHECK_NULL_INPUT_VALUE) {
			gestionRules.checkNullInput();
		}
		if (rule.getValue() == Rules.FINAL_DECLARATION_MISSING_VALUE) {
			gestionRules.finalDeclarationMissing();
		}
		if (rule.getValue() == Rules.NESTED_SPACES_VALUE) {
			gestionRules.nestedSpaces();
		}
	}

}
