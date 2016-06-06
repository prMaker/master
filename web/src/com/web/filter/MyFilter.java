package com.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class MyFilter extends AbstractFilter {

	String encoding = "UTF-8";

	@Override
	public void init(FilterConfig config) throws ServletException {

		String value = config.getInitParameter("encoding");
		if (value != null && !"".equals(value.trim())) {
			encoding = value;

		}
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		request.setCharacterEncoding(encoding);
		filterChain.doFilter(req, resp);

	}

}
