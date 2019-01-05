package org.ismek.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="msgBean", eager = true)
@RequestScoped
public class MessageBean {

	private String message = "ATİLLA";
	private String asd = "ASDF";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAsd() {
		return asd;
	}

	public void setAsd(String asd) {
		this.asd = asd;
	}
}