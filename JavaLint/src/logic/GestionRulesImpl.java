package logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

		/* EXAMPLE */
		List<RuleError> fileError = new ArrayList<RuleError>();

		return fileError;
	}

	@Override
	public List<RuleError> constantUppercase(CapitalizationStyle capitalizationStyle) {
		LOGGER.info("APPLYING RULE constantUppercase");

		/* EXAMPLE */
		List<RuleError> fileError = new ArrayList<RuleError>();


		return fileError;
	}

	@Override
	public List<RuleError> classNameFormat(CapitalizationStyle capitalizationStyle) {
		LOGGER.info("APPLYING RULE classNameFormat");


		return null;
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
							if ((compareNestedSpace(line.charAt(column - 1)) || compareNestedSpace(line.charAt(column + 1)))) {
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
		case '<':
		case '>':
			return true;
		}
		return false;
	}
}
