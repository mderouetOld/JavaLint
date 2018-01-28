package structure;

public class RuleError {
	private RuleEnum rule;
	private Integer line;
	private Integer column;
	private RuleEnum capitalizationStyle;
	private String lineDescriptionError;

	public RuleError(RuleEnum ruleError, Integer line, Integer column, RuleEnum capitalizationStyle,
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

	public RuleEnum getRuleError() {
		return rule;
	}

	public void setRuleError(RuleEnum ruleError) {
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

	public RuleEnum getCapitalizationStyle() {
		return capitalizationStyle;
	}

	public void setCapitalizationStyle(RuleEnum capitalizationStyle) {
		this.capitalizationStyle = capitalizationStyle;
	}
}
