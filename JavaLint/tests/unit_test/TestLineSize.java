package logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import structure.CapitalizationStyle;
import structure.RuleError;
import structure.Rules;
import utility.FileTreeUtils;

public class GestionRulesImpl implements GestionRules {

	@Override
	public List<RuleError> lineSize(Integer size) {
		//Default value of String max size
		if (size == null) {
			size = 140;
		}

		//Creating error array
		List<RuleError> fileError = new ArrayList<RuleError>();

		System.out.println("Applying rule lineSize");

		// Iterate on file
		LineIterator it = null;
		try {
			it = FileUtils.lineIterator(FileTreeUtils.currentFileProcessing.getFile(), "UTF-8");
			int index = 0;
			while (it.hasNext()) {
				index++;
				String line = it.nextLine();
				if (line.length() > size.intValue()) {
					fileError.add(new RuleError(Rules.LINE_SIZE, index, line.length(), null));
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
		return null;
	}

	@Override
	public List<RuleError> constantUppercase(CapitalizationStyle capitalizationStyle) {
		// TODO Auto-generated method stub
		System.out.println("Too Long Too LongToo LongToo LongToo LongToo LongToo LongToo LongToo LongToo LongToo LongToo LongToo LongToo LongToo LongToo LongToo LongToo LongToo LongToo LongToo LongToo LongToo LongToo LongToo LongToo LongToo LongToo LongToo LongToo LongToo LongToo LongToo LongToo LongToo Long");
		return null;
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
		System.out.println(" Applying rule checkNullInput Applying rule checkNullInput Applying rule checkNullInput Applying rule checkNullInput Applying rule checkNullInput Applying rule checkNullInput Applying rule checkNullInput Applying rule checkNullInput Applying rule checkNullInput Applying rule checkNullInput");
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
		return null;
	}

}
