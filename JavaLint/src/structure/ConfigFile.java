package structure;

import java.io.File;
import java.util.Map;

public class ConfigFile extends FileAbstract {

	private Map<Rule, Boolean> rulesEnabled = null;

	public ConfigFile(File file,String title) {
		super(title,file);
	}

	public Map<Rule, Boolean> getRulesEnabled() {
		return rulesEnabled;
	}

	public void setRules(Map<Rule, Boolean> rulesEnabled) {
		this.rulesEnabled = rulesEnabled;
	}
}
