package unit.test;

import java.io.File;
import java.util.List;
import junit.framework.TestCase;
import logic.GestionRulesImpl;
import structure.JavaFile;
import structure.RuleError;
import structure.Rules;
import utility.FileTreeUtils;
import utility.OSUtils;

public class GestionRulesTest extends TestCase {
	GestionRulesImpl gestionRulesImpl = new GestionRulesImpl();

	public void testLineSize() {
		if (OSUtils.isWindows()) {
			FileTreeUtils.currentFileProcessing = new JavaFile(
					new File(System.getProperty("user.dir").toString() + "\\tests\\unit_test\\TestLineSize.java"),
					"TestLineSize");
		}
		if (OSUtils.isMac()) {
			FileTreeUtils.currentFileProcessing = new JavaFile(
					new File(System.getProperty("user.dir").toString() + "/tests/unit_test/TestLineSize.java"),
					"TestLineSize");
		}
		List<RuleError> errorList = gestionRulesImpl.lineSize(null);
		assertEquals("Number of line first error", 61, errorList.get(0).getLine().intValue());
		assertEquals("Number of column first error", 306, errorList.get(0).getColumn().intValue());
		assertEquals("Number of line second error", 82, errorList.get(1).getLine().intValue());
		assertEquals("Number of column first error", 315, errorList.get(1).getColumn().intValue());
		assertEquals("Constant rule first error", Rules.LINE_SIZE, errorList.get(0).getRuleError());
		assertEquals("Constant rule second error", Rules.LINE_SIZE, errorList.get(1).getRuleError());
	}
}
