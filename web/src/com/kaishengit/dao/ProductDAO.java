package com.kaishengit.dao;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.kaishengit.entity.Product;
import com.kaishengit.util.DBHelp;

public class ProductDAO {
	
	//��ѯ����
	public List<Product> findAll() {

		String sql = "select * from t_product";
		return DBHelp.query(sql, new BeanListHandler<Product>(Product.class));
//		Connection conn = ConnectionManager.getConnection();
//		QueryRunner qr = new QueryRunner();
//		try {
//			return qr.query(conn, sql, new BeanListHandler<Product>(Product.class));
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		} finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
	}
	
	//���������
	public void save(Product product) {
		String sql = "insert into t_product(prodname,prodprice,prodnum,prodaddress) values(?,?,?,?)";
		DBHelp.update(sql, product.getProdname(), product.getProdprice(), product.getProdnum(),
					product.getProdaddress());
//		Connection conn = ConnectionManager.getConnection();
//		QueryRunner qr = new QueryRunner();
//		try {
//			qr.update(conn, sql, product.getProdname(), product.getProdprice(), product.getProdnum(),
//					product.getProdaddress());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
	}

	//ɾ������
	public void delete(Integer id) {
		
		String sql = "delete from t_product where id=?";
		DBHelp.update(sql, id);
		/*String sql = "delete from t_product where id=?";
		Connection conn = ConnectionManager.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			qr.update(conn, sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}*/
	}

	//ͨ��ID��������
	public Product findById(Integer id) {

		String sql = "select * from t_product where id = ?";
		return DBHelp.query(sql, new BeanHandler<Product>(Product.class), id);
//		Connection conn = ConnectionManager.getConnection();
//		QueryRunner qr = new QueryRunner();
//		try {
//			return qr.query(conn, sql, new BeanHandler<Product>(Product.class), id);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		} finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
	}
	
	//�޸�����
	public void update(Product product){
		
		String sql = "update t_product set prodname=?,prodprice=?,prodnum=?,prodaddress=? where id =?";
		DBHelp.update(sql, product.getProdname(),product.getProdprice(),product.getProdnum(),product.getProdaddress(),product.getId());
		
//		Connection conn = ConnectionManager.getConnection();
//		QueryRunner qr = new QueryRunner();
//		try {
//			qr.update(conn, sql, product.getProdname(),product.getProdprice(),product.getProdnum(),product.getProdaddress(),product.getId());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
	}
}
