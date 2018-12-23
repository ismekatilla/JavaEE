package org.ismek.tag;

import java.lang.reflect.Field;
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
			Object instance = clazz.newInstance();
			
			ServletRequest request = pageContext.getRequest();
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				String fieldName = field.getName();
				String fieldValue = request.getParameter(fieldName);
				if (fieldValue != null && fieldValue != "") {
					Method[] methods = clazz.getMethods();
					for (Method method : methods) {
						String methodName = method.getName();
						if (methodName.equalsIgnoreCase("set" + fieldName)) {
							method.invoke(instance, fieldValue);
							break;
						}
					}
				}
			}
			
			Method[] methods = clazz.getMethods();
			for (Method method : methods) {
				String methodName = method.getName();
				if (methodName.startsWith("get")) {
					Object object = method.invoke(instance);
					if (object != null) {
						System.out.println(object.toString());
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return super.doStartTag();
	}
}