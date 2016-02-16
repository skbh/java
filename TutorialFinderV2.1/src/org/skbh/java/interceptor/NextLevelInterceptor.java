package org.skbh.java.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class NextLevelInterceptor extends AbstractInterceptor {

		private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		System.out.println("Pre - NextLevelInterceptor Called");
		String result=invocation.invoke();
		System.out.println("Post - NextLevelInterceptor Called");
		System.out.println("Value of Result (NextLevelInterceptor) : " + result);
		return result;
	}

}
