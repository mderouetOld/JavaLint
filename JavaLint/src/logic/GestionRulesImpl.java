package logic;

import java.util.ArrayList;
import java.util.List;
import structure.CapitalizationStyle;
import structure.JavaFile;
import structure.RuleError;
import structure.Rules;
import utility.FileUtils;

public class GestionRulesImpl implements GestionRules {

	@Override
	public List<RuleError> lineSize(Integer size) {
		System.out.println("Appying rule lineSize");
		List<RuleError> fileError = new ArrayList<RuleError>();
		JavaFile f = FileUtils.currentFileProcessing;
		//EXAMPLE RULE
		fileError.add(new RuleError(Rules.LINE_SIZE,10,20, CapitalizationStyle.CAMEL_CASE));

		return fileError;
	}

	@Override
	public List<RuleError> stringInstantiation() {
		// TODO Auto-generated method stub
		System.out.println("Appying rule stringInstantiation");
		return null;
	}

	@Override
	public List<RuleError> constantUppercase(CapitalizationStyle capitalizationStyle) {
		// TODO Auto-generated method stub
		System.out.println("Appying rule constantUppercase");
		return null;
	}

	@Override
	public List<RuleError> classNameFormat(CapitalizationStyle capitalizationStyle) {
		// TODO Auto-generated method stub
		System.out.println("Appying rule classNameFormat");
		return null;
	}

	@Override
	public List<RuleError> paramsFunction(CapitalizationStyle capitalizationStyle) {
		// TODO Auto-generated method stub
		System.out.println("Appying rule paramsFunction");
		return null;
	}

	@Override
	public List<RuleError> checkNullInput() {
		// TODO Auto-generated method stub
		System.out.println("Appying rule checkNullInput");
		return null;
	}

	@Override
	public List<RuleError> finalDeclarationMissing() {
		// TODO Auto-generated method stub
		System.out.println("Appying rule finalDeclarationMissing");
		return null;
	}

	@Override
	public List<RuleError> nestedSpaces() {
		// TODO Auto-generated method stub
		System.out.println("Appying rule nestedSpaces");
		return null;
	}

}
