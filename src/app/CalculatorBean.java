package app;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "calculatorBean", eager = true)
@SessionScoped
public class CalculatorBean {
	private String operation;
	private String result;
	private String oldValue;
	
	public CalculatorBean() {
		this.operation = "";
		this.result = "";
		this.oldValue = "";
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
}
