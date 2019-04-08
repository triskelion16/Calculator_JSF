package app;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "calculatorController", eager = true)
@SessionScoped
public class CalculatorController {
	
	@ManagedProperty(value = "#{calculatorBean}")
	private CalculatorBean calculatorBean;
	
//	@PostConstruct
//	public void init() {
//		calculatorBean.setOldValue("oldValue");
//		calculatorBean.setOperation("operation");
//		calculatorBean.setResult("result");
//	}
	
	public String print(String str) {
		calculatorBean.setResult(str);
		
		return "index";
	}
	
	
	public CalculatorBean getCalculatorBean() {
		return calculatorBean;
	}
	public void setCalculatorBean(CalculatorBean calculatorBean) {
		this.calculatorBean = calculatorBean;
	}
	
}
