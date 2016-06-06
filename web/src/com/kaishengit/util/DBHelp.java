package com.kaishengit.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.kaishengit.exception.DataAccessException;

public class DBHelp {

	// 用来执行insert update delete 语句
	public static void update(String sql, Object... params) {

		Connection conn = ConnectionManager.getConnection();
		QueryRunner qr = new QueryRunner();

		try {
			qr.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e, "该SQL异常：" + sql);
		} finally {
			closeConn(conn);
		}
	}

	// 用来执行查询（select）语句
	public static <T> T query(String sql, ResultSetHandler<T> handler, Object... params) {

		Connection conn = ConnectionManager.getConnection();
		QueryRunner qr = new QueryRunner();

		try {
			return qr.query(conn, sql, handler, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e, "该SQL异常：" + sql);
		} finally {
			closeConn(conn);
		}
	}

	// 关闭连接
	private static void closeConn(Connection conn) {

		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e, "关闭数据库连接异常！");
		}
	}

}
