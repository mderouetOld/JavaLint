package rules;

import structure.CapitalizationStyle;

public interface GestionRules{

	/* ###### Implementation rules ######*/
	
	// Size of the line (DEFAULT : 140 caracs max)
	public boolean lineSize(Integer size);
	
	// Check whether the string is correctly instantiated
	public boolean stringInstantiation();
	
	// Check constant format (DEFAULT : UPPERCASE)
	public boolean constantUppercase(CapitalizationStyle capitalizationStyle);
	
	// Check class name (DEFAULT : PASCALCASE)
	public boolean classNameFormat(CapitalizationStyle capitalizationStyle);
	
	// Params of function format (DEFAULT : CAMELCASE)
	public boolean paramsFunction(CapitalizationStyle capitalizationStyle);
	
	// Control whether all possible nulled values are checked correctly
	public boolean checkNullInput();
	
	// Variables never modified must be declared as FINAL
	public boolean finalDeclarationMissing();
	
	// Nested spaces
	public boolean nestedSpaces();
}
