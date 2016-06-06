package com.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaishengit.dao.ProductDAO;
import com.kaishengit.entity.Product;

public class EditServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		if (id != null && id.matches("\\d+")) {
			
			ProductDAO productDao = new ProductDAO();
			Product product = productDao.findById(Integer.valueOf(id));

			if (product == null) {
				resp.sendError(404, "查找资源不存在！");
			} else {
				req.setAttribute("product", product);
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/show.jsp");
				rd.forward(req, resp);
			}
		} else {
			resp.sendRedirect("/home.do");
		}
	}

}
