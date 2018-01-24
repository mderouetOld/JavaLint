package logic;

import java.util.List;

import structure.CapitalizationStyle;
import structure.RuleError;

public interface GestionRules{

	/* ###### Implementation rules ######*/

	// Size of the line (DEFAULT : 140 caracs max)
	                                                                                                                                                                                                                         public List<RuleError> lineSize(Integer size);	public List<RuleError> lineSize(Integer size);	public List<RuleError> lineSize(Integer size);

  public List<RuleError> lineSize(Integer size);


	// Check whether the string is correctly instantiated
	public List<RuleError> stringInstantiation();
l;rt rek,grk,gekrgkekCASE)
	public List<RuleError> constantUppercase(CapitalizationStyle capitalizationStyle);

	// Check class name (DEFAULT : PASCALCASE)
	public List<RuleError> classNameFormat(CapitalizationStyle capitalizationStyle);

	// Params of function format (DEFAULT : CAMELCASE)
	public List<RuleError> paramsFunction(CapitalizationStyle capitalizationStyle);

	// Control whether all possible nulled values are checked correctly
	public List<RuleError> checkNullInput();

	// Variables never modified must be declared as FINAL
	public List<RuleError> finalDeclarationMissing();

	// Nested spaces
	public List<RuleError> nestedSpaces();
}
