package com.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kaishengit.dao.UserDAO;
import com.kaishengit.entity.User;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		UserDAO userdao = new UserDAO();
		User user = userdao.findByUsername(username);

		if (user != null && password.equals(user.getPassword())) {

			HttpSession session = req.getSession();
			session.setAttribute("user", user);

			// �ж��û��Ƿ�ѡ���ˡ���ס�ҡ�
			String rememberme = req.getParameter("rememberme");
			if ("yes".equals(rememberme)) {
				Cookie usercookie = new Cookie("username", username);
				usercookie.setMaxAge(60 * 60 * 24);// �������� ��
				usercookie.setPath("/");
				usercookie.setHttpOnly(true);//��cookieֵֻ���÷������˶�ȡ
				
				Cookie pwdcookie = new Cookie("password", password);
				pwdcookie.setMaxAge(60 * 60 * 24);// �������� ��
				pwdcookie.setPath("/");
				pwdcookie.setHttpOnly(true);//��cookieֵֻ���÷������˶�ȡ
				
				//�������cookie���͵��ͻ���
				resp.addCookie(usercookie);
				resp.addCookie(pwdcookie);

			}

			resp.sendRedirect("/home.do");

		} else {
			resp.sendRedirect("/index.do?code=1001");
		}
	}
}
