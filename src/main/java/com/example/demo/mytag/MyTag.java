/**
 * 
 */
package com.example.demo.mytag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author LOL
 * 获得当前的时间
 * 2017-2-20下午03:11:44
 */
public class MyTag extends SimpleTagSupport{
	public void doTag() throws JspException, IOException {
		PageContext pageContext= (PageContext)this.getJspContext();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(date);
		JspWriter out = pageContext.getOut();
		out.println(str);
	}
}
