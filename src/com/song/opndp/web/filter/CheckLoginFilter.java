package com.song.opndp.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.song.opndp.web.bean.ConstantVal;

public class CheckLoginFilter implements Filter {
	private String[] urlPaths;

	public void destroy() {
	}

	public void doFilter(ServletRequest sRequest, ServletResponse sResponse,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) sRequest;
		HttpServletResponse response = (HttpServletResponse) sResponse;

		String url = request.getServletPath();
		for (String urlPath : this.urlPaths) {
			if (url.equals(urlPath)) {
				chain.doFilter(request, response);
				return;
			}
		}

		Long adminId = (Long) request.getSession().getAttribute(
				ConstantVal.SESSION_ADMINID_KEY);

		if ((adminId == null) || (adminId.equals(Integer.valueOf(0)))) {
			response.sendRedirect("/login.html");
			return;
		}

		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		String noFilterUrl = filterConfig.getInitParameter("no_filter_url");
		this.urlPaths = noFilterUrl.split(",");
	}
}