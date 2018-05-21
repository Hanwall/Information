package other.src.com.hafao.information.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHelper {
	public static final String url = "jdbc:mysql://127.0.0.1:3306/personal_information";
	public static final String name = "com.mysql.jdbc.Driver";
	public static final String user = "root";
	public static final String password = "haihua";

	public Connection conn = null;
	public PreparedStatement pst = null;

	public DBHelper(String sql) {
		try {
			Class.forName(name);// 指定连接类型
			conn = DriverManager.getConnection(url, user, password);// 获取连接
			pst = conn.prepareStatement(sql);// 准备执行语句
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			this.conn.close();
			this.pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
