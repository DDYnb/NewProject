package com.szy.event.util;
/*
 *JDBC工具类，包含打开连接和关闭连接的方法
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
	
	//获取数据库连接
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
	
	//关闭相应接口
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
	//重载该方法
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
	
	//判断是否可以进行注册
	public static boolean enableToRegister(Object obj, String name, String passWord) {
		
		Connection con = JdbcUtil.getMysqlConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//向用户表查询
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
			//向管理员表查询
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
