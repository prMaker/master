package com.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaishengit.dao.ProductDAO;
import com.kaishengit.entity.Product;

public class UpdateServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//获取表单内用
		String id = req.getParameter("id");
		String prodname = req.getParameter("productname");
		String prodprice = req.getParameter("productprice");
		String prodnum = req.getParameter("productnum");
		String prodaddress = req.getParameter("productaddress");
		
		//修改产品
		Product product = new Product();
		product.setProdname(prodname);
		product.setProdprice(Float.valueOf(prodprice));
		product.setProdnum(Integer.valueOf(prodnum));
		product.setProdaddress(prodaddress);
		product.setId(Integer.valueOf(id));
		
		ProductDAO productDao = new ProductDAO();
		productDao.update(product);
		
		//回到home.jsp
		
		resp.sendRedirect("/home.do");
	}

}
