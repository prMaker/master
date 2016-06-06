package com.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kaishengit.dao.UserDAO;
import com.kaishengit.entity.User;

public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 获取客户端cookie
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {

			String name = null;
			String pwd = null;
			
			for (Cookie cookie : cookies) {
				if ("username".equals(cookie.getName())) {
					name = cookie.getValue();
				} else if ("password".equals(cookie.getName())) {
					pwd = cookie.getValue();
				}
			}

			if (name != null && pwd != null) {

				User user = new UserDAO().findByUsername(name);
				if (user != null && pwd.equals(user.getPassword())) {

					HttpSession session = req.getSession();
					session.setAttribute("user", user);
					resp.sendRedirect("/home.do");
					return;
				}
			}
		}

		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/index.jsp");
		rd.forward(req, resp);
	}
}
