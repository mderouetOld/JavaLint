package export;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import structure.JavaFile;
import structure.RuleError;
import utility.OSUtils;

public class ExportHtml {

	private static Document doc;
	private static List<JavaFile> javaFiles;
	private static final String templateLogFile = "template_logs.html";
	private static final String logsFile = "logs.html";
	private static final Logger LOGGER = Logger.getLogger(ExportHtml.class);
	
	public static void generateHtmlLogError(List<JavaFile> files) {
		String pathLogs = System.getProperty("user.dir") + "\\export\\bin\\" + logsFile;

		javaFiles = files;
		// Default path for windowd
		String pathTemplate = System.getProperty("user.dir") + "\\export\\template\\" + templateLogFile;
		if (OSUtils.isMac()) {
			pathTemplate = pathTemplate.replace("\\", "/");
		}

		File input = new File(pathTemplate);

		try {
			doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
			fillBodyContent();
			if (OSUtils.isMac()) {
				pathLogs = pathLogs.replace("\\", "/");
			}
			// Delete file if exists
			try {
				Files.delete(Paths.get(pathLogs));
			} catch (NoSuchFileException x) {
				System.err.format("%s: no such" + " file or directory%n", pathLogs);
			} catch (DirectoryNotEmptyException x) {
				System.err.format("%s not empty%n", pathLogs);
			} catch (IOException x) {
				// File permission problems are caught here.
				System.err.println(x);
			}

			// Write doc in file
			writeToFile(doc.toString(), pathLogs);
		} catch (IOException e) {
			e.printStackTrace();
		}

		LOGGER.info("LOGS UPDATED IN : " + pathLogs);
	}

	private static void fillBodyContent() {
		doc.body().appendElement("div").addClass("container");
		doc.body().getElementsByClass("container").append("<h2>JavaLint logs export</h2>")
				.append("<table class=\"table\">");
		constructTableContent("table");
	}

	private static void constructTableContent(String element) {
		doc.body().getElementsByClass(element).append("<thead id=thead0>");
		doc.body().getElementById("thead0").append("<tr> Regle");
		doc.body().getElementById("thead0").append("<tr> Description");
		doc.body().getElementById("thead0").append("<tr> Ligne/Colonne");
		doc.body().getElementById("thead0").append("<tr> Fichier");

		doc.body().getElementsByClass(element).append("<tbody id=tbody0>");
		int indexRules = 0;
		for (JavaFile javaFile : javaFiles) {
			for (RuleError ruleError : javaFile.getRuleError()) {
				doc.body().getElementById("tbody0").append("<tr id=" + "tr" + String.valueOf(indexRules) + " class="
						+ colorByRule(ruleError) + ">" + "</tr>");
				doc.body().getElementById("tr" + String.valueOf(indexRules))
						.append("<td>" + ruleError.getRuleError().getName() + "</td>");
				doc.body().getElementById("tr" + String.valueOf(indexRules))
				.append("<td>" + ruleError.getLineDescriptionError() + "</td>");
				doc.body().getElementById("tr" + String.valueOf(indexRules))
						.append("<td>" + "(" + ruleError.getLine() + "," + ruleError.getColumn() + ")" + "</td>");
				doc.body().getElementById("tr" + String.valueOf(indexRules))
						.append("<td>" + javaFile.getName() + "</td>");
				doc.body().getElementById("tbody0").append("</tr>");

				// On incremente l'index de la ligne
				indexRules++;
			}
		}
	}

	private static String colorByRule(RuleError rule) {
		String hexa = "default";
		switch (rule.getRuleError().getValue()) {
		case 1:
			return "success";
		case 2:
			return "danger";
		case 3:
			return "default";
		case 4:
			return "warning";
		case 5:
			return "default";
		case 6:
			return "default";
		case 7:
			return "default";
		case 8:
			return "info";
		}
		return hexa;
	}

	private static void writeToFile(String text, String targetFilePath) throws IOException {
		Path targetPath = Paths.get(targetFilePath);
		byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
		Files.write(targetPath, bytes, StandardOpenOption.CREATE);
	}
}
