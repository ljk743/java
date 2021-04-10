package cn.edu.ujn.dao;

import java.sql.*;

public class DBHelper {
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8";
	private static final String username = "root";
	private static final String password = "ljk123456";

	private static Connection conn = null;

//  ��̬����鸺���������
//  һ�������,�����Щ�����������Ŀ������ʱ���ִ�е�ʱ��,��Ҫʹ�þ�̬�����,���ִ���������ִ�еģ�����������������
	static {
		try {
			Class.forName(driver);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static Connection getConnection() throws Exception {
		if (conn == null || conn.isClosed()) {
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		}
		return conn;
	}

	public static void main(String[] args) {
		try {
			// ��ȡһ������
			Connection conn = DBHelper.getConnection();
			if (conn != null) {
				System.out.println("链接成功");
			} else {
				System.out.println("连接失败");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
