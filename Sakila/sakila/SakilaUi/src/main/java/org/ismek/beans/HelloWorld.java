package org.ismek.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="helloWorld", eager = true)
@RequestScoped
public class HelloWorld {

	@ManagedProperty(value = "#{msgBean}")
	private MessageBean messageBean;
	
	//private String degisken;

	public String getDegisken() {
		String degisken =" ";
		if (messageBean != null) {
			degisken = messageBean.getMessage();
		}
		return degisken;
	}

	public void setDegisken(String degisken) {
		//this.degisken = degisken;
	}

	public void setMessageBean(MessageBean messageBean) {
		this.messageBean = messageBean;
	}
}