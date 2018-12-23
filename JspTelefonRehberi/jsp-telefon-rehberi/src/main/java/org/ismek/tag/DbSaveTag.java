package org.ismek.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class DbSaveTag extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		JspWriter jspWriter = pageContext.getOut();
		try {
			jspWriter.write("<form action=\"kaydet.jsp\" method=\"POST\"><input type='text' name='isim' value='asdas'></input><input type='submit' value='KAYDET'></input></form>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.doStartTag();
	}
}
