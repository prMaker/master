package com.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaishengit.dao.ProductDAO;


public class DeleteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");

		if (id != null && id.matches("\\d+")) {

			ProductDAO productDao = new ProductDAO();
			productDao.delete(Integer.valueOf(id));

		}
		response.sendRedirect("/home.do");
	}

}
