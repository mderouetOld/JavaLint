package structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CapitalizationStyle {

	public static final Integer CAMEL_CASE_VALUE = 1;
	public static final Integer PASCAL_CASE_VALUE = 2;
	public static final Integer UPPER_CASE_VALUE = 3;
	
	public static final RuleEnum CAMEL_CASE = new RuleEnum("Camel Case", CAMEL_CASE_VALUE);
	public static final RuleEnum PASCAL_CASE = new RuleEnum("Pascal Case", PASCAL_CASE_VALUE);
	public static final RuleEnum UPPER_CASE = new RuleEnum("Upper Case", UPPER_CASE_VALUE);
	
	public static List<String> returnCapititalizationStyles() {
		Field[] fields = CapitalizationStyle.class.getFields();
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
