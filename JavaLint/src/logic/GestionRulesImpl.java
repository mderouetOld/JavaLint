package logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import structure.CapitalizationStyle;
import structure.RuleError;
import structure.Rules;
import utility.FileTools;

public class GestionRulesImpl implements GestionRules {

	@Override
	public List<RuleError> lineSize(Integer size) {
		// Default value of String max size
		if (size == null) {
			size = 140;
		}

		// Creating error array
		List<RuleError> fileError = new ArrayList<RuleError>();

		System.out.println("Applying rule lineSize");

		// Iterate on file
		LineIterator it = null;
		try {
			it = FileUtils.lineIterator(FileTools.currentFileProcessing.getFile(), "UTF-8");
			int index = 0;
			while (it.hasNext()) {
				index++;
				String line = it.nextLine();
				if (line.length() > size.intValue()) {
					fileError.add(new RuleError(Rules.LINE_SIZE, index, line.length(), null, line));
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
		// TODO Auto-generated method stub
		System.out.println("Applying rule stringInstantiation");

		/* EXAMPLE */
		List<RuleError> fileError = new ArrayList<RuleError>();

		return fileError;
	}

	@Override
	public List<RuleError> constantUppercase(CapitalizationStyle capitalizationStyle) {
		// TODO Auto-generated method stub
		System.out.println("Applying rule constantUppercase");

		/* EXAMPLE */
		List<RuleError> fileError = new ArrayList<RuleError>();


		return fileError;
	}

	@Override
	public List<RuleError> classNameFormat(CapitalizationStyle capitalizationStyle) {
		// TODO Auto-generated method stub
		System.out.println("Applying rule classNameFormat");


		return null;
	}

	@Override
	public List<RuleError> paramsFunction(CapitalizationStyle capitalizationStyle) {
		// TODO Auto-generated method stub
		System.out.println("Applying rule paramsFunction");
		return null;
	}

	@Override
	public List<RuleError> checkNullInput() {
		// TODO Auto-generated method stub
		System.out.println("Applying rule checkNullInput");
		return null;
	}

	@Override
	public List<RuleError> finalDeclarationMissing() {
		// TODO Auto-generated method stub
		System.out.println("Applying rule finalDeclarationMissing");
		return null;
	}

	@Override
	public List<RuleError> nestedSpaces() {
		// TODO Auto-generated method stub
		System.out.println("Applying rule nestedSpaces");
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
								fileError.add(new RuleError(Rules.NESTED_SPACES, index, column, null, line));
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
