package com.web.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidateFilter extends AbstractFilter {

	String staticPath = null;
	List<String> excludePathList = new ArrayList<>();

	@Override
	public void init(FilterConfig config) throws ServletException {
		staticPath = config.getInitParameter("staticPath");
		
		
		String excludePath = config.getInitParameter("excludePath");
		String[] paths = excludePath.split(",");
		excludePathList = Arrays.asList(paths);
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		// ��ȡ�û�����·��
		String url = request.getRequestURI();

		// ��̬��Դֱ��ͨ��
		if (url.startsWith(staticPath)) {
			filterChain.doFilter(request, response);

		} else {
			// // ����¼�йص���Դֱ��ͨ��
			if (excludePathList.contains(url)) {

				filterChain.doFilter(request, response);
			} else {
				HttpSession session = request.getSession();
				if (session.getAttribute("user") == null) {
					// ˵����ǰ�ͻ���δ��¼����Ҫ�ض��򵽵�¼ҳ��
					response.sendRedirect("/index.do?code=1002");
				} else {
					// �ѵ�¼�û�ֱ��ͨ��
					filterChain.doFilter(request, response);
				}
			}
		}
	}
}
