package logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.log4j.Logger;
import structure.CapitalizationStyle;
import structure.RuleError;
import structure.Rule;
import utility.FileTools;

public class GestionRulesImpl implements GestionRules {
	private static final Logger LOGGER = Logger.getLogger(GestionRulesImpl.class);

	@Override
	public List<RuleError> lineSize(Integer size) {
		LOGGER.info("APPLYING RULE lineSize");
		// Default value of String max size
		if (size == null) {
			size = 140;
		}
		// Creating error array
		List<RuleError> fileError = new ArrayList<RuleError>();
		// Iterate on file
		LineIterator it = null;
		try {
			it = FileUtils.lineIterator(FileTools.currentFileProcessing.getFile(), "UTF-8");
			int index = 0;
			while (it.hasNext()) {
				index++;
				String line = it.nextLine();
				if (line.length() > size.intValue()) {
					fileError.add(new RuleError(Rule.LINE_SIZE, index, line.length(), null, line));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				it.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return fileError;
	}

	@Override
	public List<RuleError> stringInstantiation() {
		LOGGER.info("APPLYING RULE stringInstantiation");
		/* Liste des erreurs */
		List<RuleError> fileError = new ArrayList<RuleError>();
		// Iterate on file
		LineIterator it = null;
			try {
				it = FileUtils.lineIterator(FileTools.currentFileProcessing.getFile(), "UTF-8");
				int index=0;				
				while (it.hasNext()) {
					index++;
					String line = it.nextLine();
					if (line.lastIndexOf("String") != -1) {
						StringTokenizer newStringTokenizer= new StringTokenizer(line);
						while(newStringTokenizer.hasMoreTokens()) {
							String actualString = newStringTokenizer.nextToken();
							if (actualString.equals("new") || actualString.contains("=new")) {
								if (newStringTokenizer.nextToken().startsWith("String(")) {
									fileError.add(new RuleError(Rule.STRING_INSTANTIATION, index, line.indexOf(actualString, 0), null, line));
									break;
								}
							}
						}
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
			try {
					it.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}		
		return fileError;
	}

	@Override
	public List<RuleError> constantUppercase(CapitalizationStyle capitalizationStyle) {
		LOGGER.info("APPLYING RULE constantUppercase");
		/* Liste des erreurs */
		List<RuleError> fileError = new ArrayList<RuleError>();
		// Iterate on file
		LineIterator it = null;
		try {
			it = FileUtils.lineIterator(FileTools.currentFileProcessing.getFile(), "UTF-8");
			int index=0;
			String constantName = "";
			while(it.hasNext()) {
				index++;
				String line = it.nextLine();
				if(line.lastIndexOf("static final") != -1) {
					StringTokenizer newTokenizer = new StringTokenizer(line);
					while(newTokenizer.hasMoreTokens()) {
						if(newTokenizer.nextToken().equals("final")) {
							constantName = newTokenizer.nextToken();						
							break;
						}
					}					
					constantName = newTokenizer.nextToken();
					Character currentChar;
					for (int i = 0; i < constantName.length(); i++) {
						currentChar = constantName.charAt(i);
						if(Character.isLowerCase(currentChar)) {
							fileError.add(new RuleError(Rule.CONSTANT_UPPERCASE, index, line.indexOf(constantName, 0), null, line));
							break;
						}
					}
				}
				if(line.lastIndexOf("final static") != -1) {
					StringTokenizer newTokenizer = new StringTokenizer(line);
					while(newTokenizer.hasMoreTokens()) {
						if(newTokenizer.nextToken().equals("static")) {
							constantName = newTokenizer.nextToken();						
							break;
						}
					}					
					constantName = newTokenizer.nextToken();
					Character currentChar;
					for (int i = 0; i < constantName.length(); i++) {
						currentChar = constantName.charAt(i);
						if(Character.isLowerCase(currentChar)) {
							fileError.add(new RuleError(Rule.CONSTANT_UPPERCASE, index, line.indexOf(constantName, 0), null, line));
							break;
						}
					}
				}
				
			}
		}		
		catch (IOException e) {
				e.printStackTrace();
		}
		finally {
		try {
				it.close();
			} 
		catch (IOException e) {
				e.printStackTrace();
			}
		}		
		return fileError;
	}

	@Override
	public List<RuleError> classNameFormat(CapitalizationStyle capitalizationStyle) {
		LOGGER.info("APPLYING RULE classNameFormat");
		// Creating error array
		List<RuleError> fileError = new ArrayList<RuleError>();
		// Iterate on file
		LineIterator it = null;
		try {
			it = FileUtils.lineIterator(FileTools.currentFileProcessing.getFile(), "UTF-8");
			int index = 0;
			String className = "";
			while (it.hasNext()) {
				index++;
				String line = it.nextLine();
					if(line.lastIndexOf("class") != -1) {
						StringTokenizer newTokenizer = new StringTokenizer(line);
						while(newTokenizer.hasMoreTokens()) {
							if(newTokenizer.nextToken().equals("class")) {
								className = newTokenizer.nextToken();
								break;
							}
						}
						if(!Character.isUpperCase(className.charAt(0))) {
							fileError.add(new RuleError(Rule.CLASS_NAME_FORMAT, index, line.indexOf(className, 0), null, line));
						}
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
		try {
				it.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return fileError;
	}

	@Override
	public List<RuleError> paramsFunction(CapitalizationStyle capitalizationStyle) {
		LOGGER.info("APPLYING RULE paramsFunction");
		return null;
	}

	@Override
	public List<RuleError> checkNullInput() {
		LOGGER.info("APPLYING RULE checkNullInput");
		return null;
	}

	@Override
	public List<RuleError> finalDeclarationMissing() {
		LOGGER.info("APPLYING RULE finalDeclarationMissing");
		return null;
	}

	@Override
	public List<RuleError> nestedSpaces() {
		LOGGER.info("APPLYING RULE nestedSpaces");
		
		// Creating error array
		List<RuleError> fileError = new ArrayList<RuleError>();

		// Iterate on file
		LineIterator it = null;
		try {
			it = FileUtils.lineIterator(FileTools.currentFileProcessing.getFile(), "UTF-8");
			int index = 0;
			
			while (it.hasNext()) {
				index++;
				String line = it.nextLine(); 
				for (int column = 0; column < line.length(); column++) {
					// The char is empty
					if (Character.isWhitespace(line.charAt(column))) {
						// Check whether we are out of bound (in order to check nested space)
						if ((column+1 < line.length() && column > 1)) {
							// Find if there is a nested space at the current location
							if (compareNestedSpace(line.charAt(column - 1)))  {
								if(compareNestedSpace(line.charAt(column + 1))){
									fileError.add(new RuleError(Rule.NESTED_SPACES, index, column, null, line));
								}
							}
							if(line.charAt(column - 1) == ' ' || line.charAt(column + 1) == ' ' ){
								fileError.add(new RuleError(Rule.NESTED_SPACES, index, column, null, line));
							}
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				it.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return fileError;
	}
	private boolean compareNestedSpace(Character c) {
		switch (c) {
		case '(':
		case ')':
		case '{':
		case '}':
		case '[':
		case ']':
			return true;
		}
		return false;
	}
}
