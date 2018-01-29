package structure;

import java.io.File;
import java.util.Map;

public class ConfigFile extends FileAbstract {

	private Map<RuleEnum, Boolean> rulesEnabled = null;

	public ConfigFile(File file,String title) {
		super(title,file);
	}

	public Map<RuleEnum, Boolean> getRulesEnabled() {
		return rulesEnabled;
	}

	public void setRules(Map<RuleEnum, Boolean> rulesEnabled) {
		this.rulesEnabled = rulesEnabled;
	}
}
