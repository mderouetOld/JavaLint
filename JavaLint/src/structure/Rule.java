package structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.enums.ValuedEnum;

import logic.GestionRulesImpl;

public class Rule extends ValuedEnum {
	protected Rule(String name, int value) {
		super(name, value);
	}

	GestionRulesImpl gestionRulesImpl = new GestionRulesImpl();
	
	public static final int LINE_SIZE_VALUE = 1;
	public static final int STRING_INSTANTIATION_VALUE = 2;
	public static final int CONSTANT_UPPERCASE_VALUE = 3;
	public static final int CLASS_NAME_FORMAT_VALUE = 4;
	public static final int PARAMS_FUNCTION_VALUE = 5;
	public static final int CHECK_NULL_INPUT_VALUE = 6;
	public static final int FINAL_DECLARATION_MISSING_VALUE = 7;
	public static final int NESTED_SPACES_VALUE = 8;


	public static final Rule LINE_SIZE = new Rule("LINE SIZE", LINE_SIZE_VALUE);
	public static final Rule STRING_INSTANTIATION = new Rule("STRING INSTANTIATION", STRING_INSTANTIATION_VALUE);
	public static final Rule CONSTANT_UPPERCASE = new Rule("CONSTANT UPPERCASE", CONSTANT_UPPERCASE_VALUE);
	public static final Rule CLASS_NAME_FORMAT = new Rule("CLASS NAME FORMAT", CLASS_NAME_FORMAT_VALUE);
	public static final Rule PARAMS_FUNCTION = new Rule("PARAMS FUNCTION", PARAMS_FUNCTION_VALUE);
	public static final Rule CHECK_NULL_INPUT = new Rule("CHECK NULL INPUT", CHECK_NULL_INPUT_VALUE);
	public static final Rule FINAL_DECLARATION_MISSING = new Rule("FINAL DECLARATION", FINAL_DECLARATION_MISSING_VALUE);
	public static final Rule NESTED_SPACES = new Rule("NESTED SPACES", NESTED_SPACES_VALUE);
	
	public static List<String> getRuleEnumVariables() {
		Field[] fields = Rule.class.getFields();
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
