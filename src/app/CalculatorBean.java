package app;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "calculatorBean", eager = true)
@SessionScoped
public class CalculatorBean {
	private String operation;
	private String result;
	private String oldValue;
	private String cssColor;
	private String cssError;
	
	public CalculatorBean() {
		this.operation = "";
		this.result = "";
		this.oldValue = "";
		this.cssColor = "dark.css";
		this.cssError = "errorDark.css";
	}
	
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public String getOldValue() {
		return oldValue;
	}
	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getCssColor() {
		return cssColor;
	}
	public void setCssColor(String cssColor) {
		this.cssColor = cssColor;
	}

	public String getCssError() {
		return cssError;
	}
	public void setCssError(String cssError) {
		this.cssError = cssError;
	}
	
}
