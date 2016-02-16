package org.skbh.java.interceptor;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ClearCacheInterceptor extends AbstractInterceptor{
	
	
	   private static final long serialVersionUID = 1L;

		@Override

		public String intercept(ActionInvocation invocation) throws Exception {

		    ActionContext context=(ActionContext)invocation.getInvocationContext();

		    HttpServletResponse response=(HttpServletResponse)context.get(StrutsStatics.HTTP_RESPONSE);

		    response.setHeader("Cache-Control", "no-cache");

		    response.setHeader("Pragma", "no-cache");

		    response.setDateHeader("Expires", 0);

		    String result=invocation.invoke();

		    System.out.println("check result="+result);

		    return result;

		}

}
