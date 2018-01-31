package structure;

public class RuleError {
	private Rule rule;
	private Integer line;
	private Integer column;
	private CapitalizationStyle capitalizationStyle;
	private String lineDescriptionError;

	public RuleError(Rule ruleError, Integer line, Integer column, CapitalizationStyle capitalizationStyle,
			String lineDescriptionError) {
		this.rule = ruleError;
		this.line = line;
		this.column = column;
		this.capitalizationStyle = capitalizationStyle;
		this.lineDescriptionError = lineDescriptionError;
	}

	public String getLineDescriptionError() {
		return lineDescriptionError;
	}

	public void setLineDescriptionError(String lineDescriptionError) {
		this.lineDescriptionError = lineDescriptionError;
	}

	public Rule getRuleError() {
		return rule;
	}

	public void setRuleError(Rule ruleError) {
		this.rule = ruleError;
	}

	public Integer getLine() {
		return line;
	}

	public void setLine(Integer line) {
		this.line = line;
	}

	public Integer getColumn() {
		return column;
	}

	public void setColumn(Integer column) {
		this.column = column;
	}

	public CapitalizationStyle getCapitalizationStyle() {
		return capitalizationStyle;
	}

	public void setCapitalizationStyle(CapitalizationStyle capitalizationStyle) {
		this.capitalizationStyle = capitalizationStyle;
	}
}
