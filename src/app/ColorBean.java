package app;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "colorBean", eager = true)
@SessionScoped
public class ColorBean {
	private String color;

	public ColorBean() {}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
