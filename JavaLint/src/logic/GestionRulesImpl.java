package logic;

import structure.CapitalizationStyle;
import structure.RuleEnum;

public class GestionRulesImpl implements GestionRules {

	@Override
	public boolean lineSize(Integer size) {
		// TODO Auto-generated method stub
		System.out.println("Appying rule lineSize");
		return false;
	}

	@Override
	public boolean stringInstantiation() {
		// TODO Auto-generated method stub
		System.out.println("Appying rule stringInstantiation");
		return false;
	}

	@Override
	public boolean constantUppercase(RuleEnum camelCase) {
		// TODO Auto-generated method stub
		System.out.println("Appying rule constantUppercase");
		return false;
	}

	@Override
	public boolean classNameFormat(CapitalizationStyle capitalizationStyle) {
		// TODO Auto-generated method stub
		System.out.println("Appying rule classNameFormat");
		return false;
	}

	@Override
	public boolean paramsFunction(CapitalizationStyle capitalizationStyle) {
		// TODO Auto-generated method stub
		System.out.println("Appying rule paramsFunction");
		return false;
	}

	@Override
	public boolean checkNullInput() {
		// TODO Auto-generated method stub
		System.out.println("Appying rule checkNullInput");
		return false;
	}

	@Override
	public boolean finalDeclarationMissing() {
		// TODO Auto-generated method stub
		System.out.println("Appying rule finalDeclarationMissing");
		return false;
	}

	@Override
	public boolean nestedSpaces() {
		// TODO Auto-generated method stub
		System.out.println("Appying rule nestedSpaces");
		return false;
	}

}
