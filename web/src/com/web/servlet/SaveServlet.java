package com.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaishengit.dao.ProductDAO;
import com.kaishengit.entity.Product;

public class SaveServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//��ȡ������
		String prodname = req.getParameter("productname");
		String prodprice = req.getParameter("productprice");
		String prodnum = req.getParameter("productnum");
		String prodaddress = req.getParameter("productaddress");

		//��������ӵ����ݿ���

		Product product = new Product();
		product.setProdaddress(prodaddress);
		product.setProdname(prodname);
		product.setProdnum(Integer.valueOf(prodnum));
		product.setProdprice(Float.valueOf(prodprice));

		ProductDAO pDao = new ProductDAO();
		pDao.save(product);

		//�ض���home.jsp

		resp.sendRedirect("/home.do");

		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/add.jsp").forward(req, resp);
	}
}
