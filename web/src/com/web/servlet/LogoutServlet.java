package com.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ��session����
		req.getSession().invalidate();
		// ɾ��cookie
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("username".equals(cookie.getName()) || "password".equals(cookie.getName())) {

					cookie.setMaxAge(0);// �������� ��
					cookie.setPath("/");
					cookie.setHttpOnly(true);// ��cookieֵֻ���÷������˶�ȡ
					resp.addCookie(cookie);
				}
			}
		}
		
		resp.sendRedirect("/index.do");
		
	}
	
}
