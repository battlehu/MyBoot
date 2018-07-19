/**
 * 
 */
package com.example.demo.mytag;

import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author LOL
 * 销毁session
 * 2017-2-20下午03:35:00
 */
public class Destroy extends SimpleTagSupport{
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext)this.getJspContext();
		HttpSession session = (HttpSession)pageContext.getSession();
		session.invalidate();
	}
}
