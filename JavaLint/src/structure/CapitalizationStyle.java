package structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.enums.ValuedEnum;

public class CapitalizationStyle extends ValuedEnum {

	protected CapitalizationStyle(String name, int value) {
		super(name, value);
	}

	public static final Integer CAMEL_CASE_VALUE = 1;
	public static final Integer PASCAL_CASE_VALUE = 2;
	public static final Integer UPPER_CASE_VALUE = 3;
	
	public static final CapitalizationStyle CAMEL_CASE = new CapitalizationStyle("Camel Case", CAMEL_CASE_VALUE);
	public static final CapitalizationStyle PASCAL_CASE = new CapitalizationStyle("Pascal Case", PASCAL_CASE_VALUE);
	public static final CapitalizationStyle UPPER_CASE = new CapitalizationStyle("Upper Case", UPPER_CASE_VALUE);
	
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
