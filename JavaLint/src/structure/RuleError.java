package structure;


public class RuleError {
	private RuleEnum rule;
	private Integer line;
	private Integer column;
	private RuleEnum capitalizationStyle;

	public RuleError(RuleEnum ruleError,Integer line,Integer column,RuleEnum capitalizationStyle) {
		this.rule = ruleError;
		this.line = line;
		this.column = column;
		this.capitalizationStyle = capitalizationStyle;
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
