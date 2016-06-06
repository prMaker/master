package com.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaishengit.dao.ProductDAO;
import com.kaishengit.entity.Product;


public class HomeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductDAO productDAO = new ProductDAO();
		List<Product> productList = productDAO.findAll();
		
		request.setAttribute("productList", productList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/list.jsp");
		rd.forward(request, response);
		
	}

}
