package app;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "calculatorController", eager = true)
@SessionScoped
public class CalculatorController {

	@ManagedProperty(value = "#{calculatorBean}")
	private CalculatorBean calculatorBean;
	private boolean newNumber = false;
	
	public String changeColor(String color) {
		
		if("dark".equals(color)) {
			calculatorBean.setCssColor("dark.css");
			calculatorBean.setCssError("errorDark.css");
		}
		if("bright".equals(color)) {
			calculatorBean.setCssColor("bright.css");
			calculatorBean.setCssError("errorBright.css");
		}
		
		return "index";
	}

	public String execute(String button) {
		if (button != null) {
			try { // jeśli niepoprawne działanie to ERROR
				try { // sprawdzenie czy została przesłana cyfra
					int number = Integer.parseInt(button);

					if (newNumber) {
						calculatorBean.setResult(String.valueOf(number));
						newNumber = false;
					} else {
						calculatorBean.setResult(calculatorBean.getResult() + String.valueOf(number));
					}
				} catch (Exception e) {

					switch (button) {
					case "C":
						calculatorBean.setResult("");
						calculatorBean.setOperation("");
						calculatorBean.setOldValue("");
						break;
					case ".":
						if (calculatorBean.getResult().equals("")) {
							calculatorBean.setResult("0.");
						} else if (!calculatorBean.getResult().contains(".")) {
							calculatorBean.setResult(calculatorBean.getResult() + ".");
						}
						break;
					case "%":
						calculatorBean.setResult(Operations.percent(calculatorBean.getResult()));
						break;
					case "+/-":
						calculatorBean.setResult(Operations.changeSign(calculatorBean.getResult()));
						break;
					case "sqrt":
						calculatorBean.setResult(Operations.sqrt(calculatorBean.getResult()));
						break;
					default:

						if ("+".equals(calculatorBean.getOperation())) {
							calculatorBean.setResult(
									Operations.addition(calculatorBean.getOldValue(), calculatorBean.getResult()));
						} else if ("-".equals(calculatorBean.getOperation())) {
							calculatorBean.setResult(
									Operations.subtraction(calculatorBean.getOldValue(), calculatorBean.getResult()));
						} else if ("*".equals(calculatorBean.getOperation())) {
							calculatorBean.setResult(Operations.multiplication(calculatorBean.getOldValue(),
									calculatorBean.getResult()));
						} else if ("/".equals(calculatorBean.getOperation())) {
							calculatorBean.setResult(
									Operations.division(calculatorBean.getOldValue(), calculatorBean.getResult()));
						}

						calculatorBean.setOldValue(calculatorBean.getResult());
						calculatorBean.setOperation(button);
						newNumber = true;
						break;
					}
				}
			} catch (Exception e) {
				calculatorBean.setResult("ERROR");
				return "error";
			}
		}

		return "index";
	}

	public CalculatorBean getCalculatorBean() {
		return calculatorBean;
	}
	public void setCalculatorBean(CalculatorBean calculatorBean) {
		this.calculatorBean = calculatorBean;
	}

}
