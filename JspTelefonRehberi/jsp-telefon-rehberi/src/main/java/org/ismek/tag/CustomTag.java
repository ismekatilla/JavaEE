package org.ismek.tag;

import java.lang.reflect.Method;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class CustomTag extends TagSupport {

	private String className;
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public int doStartTag() throws JspException {
		
		try {
			Class<?> clazz = Class.forName(className);
			System.out.println(clazz.getName());
			
			ServletRequest request = pageContext.getRequest();
			String name = request.getParameter("name");
			String telefon = request.getParameter("telefon");
			
			Method[] methods = clazz.getMethods();
			for (Method method : methods) {
				String methodName = method.getName();
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.doStartTag();
	}
}