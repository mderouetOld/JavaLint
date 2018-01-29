package structure;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JavaFile extends FileAbstract{

	private String globalVariablesPart;
	private String constructorPart;
	private String functionPart;
	private List<RuleError> ruleError = null;

	public JavaFile(File file, String title) {
		super(title,file);
		ruleError = new ArrayList<RuleError>();
	}

	public JavaFile() {
		super();
		ruleError = new ArrayList<RuleError>();
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

	public List<RuleError> getRuleError() {
		return ruleError;
	}

	public void addRuleError(RuleError ruleError) {
		this.ruleError.add(ruleError);
	}

	public void addRuleError(List<RuleError> rules) {
		if (rules != null) {
			for (RuleError rule : rules) {
				this.ruleError.add(rule);
			}
		}
	}

}
