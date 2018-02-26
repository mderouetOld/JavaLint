package unit.test;

import java.io.File;
import java.util.List;
import junit.framework.TestCase;
import logic.GestionRulesImpl;
import structure.JavaFile;
import structure.RuleError;
import structure.Rule;
import utility.FileTools;
import utility.OSUtils;

public class GestionRulesTest extends TestCase {
	GestionRulesImpl gestionRulesImpl = new GestionRulesImpl();

	public void testLineSize() {
		if (OSUtils.isWindows()) {
			FileTools.currentFileProcessing = new JavaFile(
					new File(System.getProperty("user.dir").toString() + "\\tests\\unit_test\\TestLineSize.java"),
					"TestLineSize");
		}
		if (OSUtils.isMac()) {
			FileTools.currentFileProcessing = new JavaFile(
					new File(System.getProperty("user.dir").toString() + "/tests/unit_test/TestLineSize.java"),
					"TestLineSize");
		}
		List<RuleError> errorList = gestionRulesImpl.lineSize(null);
		assertEquals("Number of line first error", 61, errorList.get(0).getLine().intValue());
		assertEquals("Number of column first error", 306, errorList.get(0).getColumn().intValue());
		assertEquals("Number of line second error", 82, errorList.get(1).getLine().intValue());
		assertEquals("Number of column first error", 315, errorList.get(1).getColumn().intValue());
		assertEquals("Constant rule first error", Rule.LINE_SIZE, errorList.get(0).getRuleError());
		assertEquals("Constant rule second error", Rule.LINE_SIZE, errorList.get(1).getRuleError());
	}
	// Test de classNameFormat
	public void classNameFormat() {
		if (OSUtils.isWindows()) {
			FileTools.currentFileProcessing = new JavaFile(
					new File(System.getProperty("user.dir").toString() + "\\tests\\unit_test\\ClassNameFormat.java"),
					"ClassNameFormat");
		}
		if (OSUtils.isMac()) {
			FileTools.currentFileProcessing = new JavaFile(
					new File(System.getProperty("user.dir").toString() + "/tests/unit_test/ClassNameFormat.java"),
					"ClassNameFormat");
		}
		List<RuleError> errorList = gestionRulesImpl.classNameFormat(null);
		assertEquals("Number of line first error", 61, errorList.get(0).getLine().intValue());
		assertEquals("Number of column first error", 306, errorList.get(0).getColumn().intValue());
		assertEquals("Number of line second error", 82, errorList.get(1).getLine().intValue());
		assertEquals("Number of column first error", 315, errorList.get(1).getColumn().intValue());
		assertEquals("Constant rule first error", Rule.CLASS_NAME_FORMAT, errorList.get(0).getRuleError());
		assertEquals("Constant rule second error", Rule.CLASS_NAME_FORMAT, errorList.get(1).getRuleError());
	}
	// Test de ConstantUpperCase
	public void constantUpperCase() {
		if (OSUtils.isWindows()) {
			FileTools.currentFileProcessing = new JavaFile(
					new File(System.getProperty("user.dir").toString() + "\\tests\\unit_test\\ConstantUpperCase.java"),
					"ConstantUpperCase");
		}
		if (OSUtils.isMac()) {
			FileTools.currentFileProcessing = new JavaFile(
					new File(System.getProperty("user.dir").toString() + "/tests/unit_test/ConstantUpperCase.java"),
					"ConstantUpperCase");
		}
		List<RuleError> errorList = gestionRulesImpl.classNameFormat(null);
		assertEquals("Number of line first error", 61, errorList.get(0).getLine().intValue());
		assertEquals("Number of column first error", 306, errorList.get(0).getColumn().intValue());
		assertEquals("Number of line second error", 82, errorList.get(1).getLine().intValue());
		assertEquals("Number of column first error", 315, errorList.get(1).getColumn().intValue());
		assertEquals("Constant rule first error", Rule.CONSTANT_UPPERCASE, errorList.get(0).getRuleError());
		assertEquals("Constant rule second error", Rule.CONSTANT_UPPERCASE, errorList.get(1).getRuleError());
	}
	// Test de StringInstanciation
	public void stringInstanciation() {
		if (OSUtils.isWindows()) {
			FileTools.currentFileProcessing = new JavaFile(
					new File(System.getProperty("user.dir").toString() + "\\tests\\unit_test\\StringInstanciation.java"),
					"StringInstanciation");
		}
		if (OSUtils.isMac()) {
			FileTools.currentFileProcessing = new JavaFile(
					new File(System.getProperty("user.dir").toString() + "/tests/unit_test/StringInstanciation.java"),
					"StringInstanciation");
		}
		List<RuleError> errorList = gestionRulesImpl.classNameFormat(null);
		assertEquals("Number of line first error", 61, errorList.get(0).getLine().intValue());
		assertEquals("Number of column first error", 306, errorList.get(0).getColumn().intValue());
		assertEquals("Number of line second error", 82, errorList.get(1).getLine().intValue());
		assertEquals("Number of column first error", 315, errorList.get(1).getColumn().intValue());
		assertEquals("Constant rule first error", Rule.STRING_INSTANTIATION, errorList.get(0).getRuleError());
		assertEquals("Constant rule second error", Rule.STRING_INSTANTIATION, errorList.get(1).getRuleError());
	}
}
