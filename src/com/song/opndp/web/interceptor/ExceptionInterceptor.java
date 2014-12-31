package com.song.opndp.web.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ExceptionInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 577373797831800400L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String result = null;
		try {
			result = invocation.invoke();
		} catch (Exception e) {
			String previousRequestUrl = ServletActionContext.getRequest()
					.getHeader("Referer");
			ServletActionContext.getRequest().setAttribute(
					"previousRequestUrl", previousRequestUrl);
			throw e;
		}
		return result;
	}

}

