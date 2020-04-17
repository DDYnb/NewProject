package com.szy.event.util;
/*
 *JDBC�����࣬���������Ӻ͹ر����ӵķ���
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.szy.event.entity.Admin;
import com.szy.event.entity.User;

public class JdbcUtil {

	private static final String driver =  "com.mysql.jdbc.Driver";
	private static final String mysqlURL = "jdbc:mysql://localhost:3306/projectdatabase";
	private static final String name = "root";
	private static final String mysqlPassword = "123456";
	
	//��ȡ���ݿ�����
	public static Connection getMysqlConnection() {
		
		try {
			Class.forName(driver);
			return DriverManager.getConnection(mysqlURL, name, mysqlPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	//�ر���Ӧ�ӿ�
	public static void closeMysqlConnection(ResultSet rs, Statement stm, Connection conn) {
		
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(stm != null) {
				stm.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//���ظ÷���
	public static void closeMysqlConnection(Statement stm, Connection conn) {
		
		try {
			if(stm != null) {
				stm.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//�ж��Ƿ���Խ���ע��
	public static boolean enableToRegister(Object obj, String name, String passWord) {
		
		Connection con = JdbcUtil.getMysqlConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//���û����ѯ
			if (obj instanceof User) {
				ps = con.prepareStatement("select * from usertable");
				rs = ps.executeQuery();
				while (rs.next()) {
					if(name.equals(rs.getString(2)) && passWord.equals(rs.getString(3))) {
						return false;
					}
				}
				return true;
			}
			//�����Ա���ѯ
			else if (obj instanceof Admin) {
				ps = con.prepareStatement("select * from admintable");
				rs = ps.executeQuery();
				while (rs.next()) {
					if(name.equals(rs.getString(2)) && passWord.equals(rs.getString(3))) {
						return false;
					}
				}
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.closeMysqlConnection(rs, ps, con);
		}
		
		return false;
		
	} 
	
}
