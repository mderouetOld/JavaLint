package structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import logic.GestionRulesImpl;

public class Rules {
	GestionRulesImpl gestionRulesImpl = new GestionRulesImpl();
	
	public static final int LINE_SIZE_VALUE = 1;
	public static final int STRING_INSTANTIATION_VALUE = 2;
	public static final int CONSTANT_UPPERCASE_VALUE = 3;
	public static final int CLASS_NAME_FORMAT_VALUE = 4;
	public static final int PARAMS_FUNCTION_VALUE = 5;
	public static final int CHECK_NULL_INPUT_VALUE = 6;
	public static final int FINAL_DECLARATION_MISSING_VALUE = 7;
	public static final int NESTED_SPACES_VALUE = 8;


	public static final RuleEnum LINE_SIZE = new RuleEnum("LINE SIZE", LINE_SIZE_VALUE);
	public static final RuleEnum STRING_INSTANTIATION = new RuleEnum("STRING INSTANTIATION", STRING_INSTANTIATION_VALUE);
	public static final RuleEnum CONSTANT_UPPERCASE = new RuleEnum("CONSTANT UPPERCASE", CONSTANT_UPPERCASE_VALUE);
	public static final RuleEnum CLASS_NAME_FORMAT = new RuleEnum("CLASS NAME FORMAT", CLASS_NAME_FORMAT_VALUE);
	public static final RuleEnum PARAMS_FUNCTION = new RuleEnum("PARAMS FUNCTION", PARAMS_FUNCTION_VALUE);
	public static final RuleEnum CHECK_NULL_INPUT = new RuleEnum("CHECK NULL INPUT", CHECK_NULL_INPUT_VALUE);
	public static final RuleEnum FINAL_DECLARATION_MISSING = new RuleEnum("FINAL DECLARATION", FINAL_DECLARATION_MISSING_VALUE);
	public static final RuleEnum NESTED_SPACES = new RuleEnum("NESTED SPACES", NESTED_SPACES_VALUE);
	
	public static List<String> getRuleEnumVariables() {
		Field[] fields = Rules.class.getFields();
		List<String> ruleEnumList = new ArrayList<String>();

		for(int i = 0;i < fields.length;i++)
		{
			if(!(fields[i].getName().toString().contains("VALUE")))
			{
				ruleEnumList.add(fields[i].getName());
			}
		}
		return ruleEnumList;
	}
}
