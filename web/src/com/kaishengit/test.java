package com.kaishengit;

import java.sql.Connection;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import com.kaishengit.util.ConnectionManager;

public class test {

	public static void main(String[] args) throws Exception {

		Connection conn = ConnectionManager.getConnection();
		String sql = "select id,name from admin where id = 20";
		QueryRunner qr = new QueryRunner();

		Map<String, Object> map = qr.query(conn, sql, new MapHandler());

		System.out.println(map.get("id") + ":" + map.get("name"));

		conn.close();

		// String sql = "select id,name from admin";
		// QueryRunner qr = new QueryRunner();
		// List<Map<String,Object>> list = qr.query(conn, sql, new
		// MapListHandler());
		//
		// for (Map<String, Object> map : list) {
		// System.out.println(map.get("id")+":"+map.get("name"));
		// }
		// conn.close();

		// String sql = "select name from admin";
		// QueryRunner qr = new QueryRunner();
		// List<String> names = qr.query(conn, sql, new
		// ColumnListHandler<String>());
		// for (String name : names) {
		// System.out.println(name);
		// }
		// conn.close();

		// String sql = "select count(*) from admin";
		// QueryRunner qr = new QueryRunner();
		// long count = qr.query(conn, sql, new ScalarHandler<Long>());
		// System.out.println("count:"+count);
		// conn.close();
		//

		// String sql = "select * from admin where id =?";
		// QueryRunner qr = new QueryRunner();
		// Admin admin = qr.query(conn, sql, new
		// BeanHandler<Admin>(Admin.class),20);
		// System.out.println(admin.getName());
		// List<Admin> adminlist = qr.query(conn, sql, new
		// BeanListHandler<Admin>(Admin.class));
		// for (Admin admin : adminlist) {
		// System.out.println(admin.getId() + "->" + admin.getName() + "->" +
		// admin.getPwd());
		// }
		// conn.close();
		// List<Admin> adminlist = qr.query(conn, sql, new
		// ResultSetHandler<List<Admin>>() {
		//
		// @Override
		// public List<Admin> handle(ResultSet rs) throws SQLException {
		//
		// List<Admin> list = new ArrayList<Admin>();
		// while (rs.next()) {
		// Admin admin = new Admin();
		// admin.setId(rs.getInt("id"));
		// admin.setName(rs.getString("name"));
		// admin.setPwd(rs.getString("pwd"));
		// list.add(admin);
		// }
		// return list;
		// }
		// });
		//
		// for (Admin admin : adminlist) {
		// System.out.println(admin.getId() + "->" + admin.getName() + "->" +
		// admin.getPwd());
		// }
		// conn.close();
		//
		// QueryRunner qr = new QueryRunner();
		// //String sql = "insert into admin(`name`,pwd) values(?,?)";
		// //qr.update(conn, sql, "KK", "123");
		// String sql="delete from admin where id =?";
		// qr.update(conn, sql, 19);
		// conn.close();

	}
}
