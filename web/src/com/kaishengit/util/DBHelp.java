package com.kaishengit.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.kaishengit.exception.DataAccessException;

public class DBHelp {

	// ����ִ��insert update delete ���
	public static void update(String sql, Object... params) {

		Connection conn = ConnectionManager.getConnection();
		QueryRunner qr = new QueryRunner();

		try {
			qr.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e, "��SQL�쳣��" + sql);
		} finally {
			closeConn(conn);
		}
	}

	// ����ִ�в�ѯ��select�����
	public static <T> T query(String sql, ResultSetHandler<T> handler, Object... params) {

		Connection conn = ConnectionManager.getConnection();
		QueryRunner qr = new QueryRunner();

		try {
			return qr.query(conn, sql, handler, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e, "��SQL�쳣��" + sql);
		} finally {
			closeConn(conn);
		}
	}

	// �ر�����
	private static void closeConn(Connection conn) {

		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e, "�ر����ݿ������쳣��");
		}
	}

}
