package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigReader {

	private final String propertyFileName = "config.properties";
	private Properties prop = new Properties();
	private InputStream input = null;

	public Map loadProperties() {

		try {
			Map<String, Boolean> propertyMap = new HashMap<String, Boolean>();
			String filePropertyPath = System.getProperty("user.dir")+ "\\src\\" + propertyFileName;
			input = new FileInputStream(filePropertyPath);
			
			// load our property file
			prop.load(input);

			// get values and return map
			propertyMap.put("LINE_SIZE", readValueProp("LINE_SIZE"));
			propertyMap.put("STRING_INSTANTIATION",readValueProp("STRING_INSTANTIATION"));
			propertyMap.put("CONSTANT_UPPERCASE",readValueProp("CONSTANT_UPPERCASE"));
			propertyMap.put("CLASS_NAME_FORMAT",readValueProp("CLASS_NAME_FORMAT"));
			propertyMap.put("PARAMS_FUNCTION",readValueProp("PARAMS_FUNCTION"));
			propertyMap.put("CHECK_NULL_INPUT",readValueProp("CHECK_NULL_INPUT"));
			propertyMap.put("FINAL_DECLARATION_MISSING",readValueProp("FINAL_DECLARATION_MISSING"));
			propertyMap.put("NESTED_SPACES",readValueProp("NESTED_SPACES"));

			return propertyMap;
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	private Boolean readValueProp(String propertyName) {
		return (prop.getProperty(propertyName).equals("true") ? true : false);
	}
	
}