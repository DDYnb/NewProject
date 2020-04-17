package com.szy.event.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.szy.event.dao.AdminDao;
import com.szy.event.entity.Admin;
import com.szy.event.util.JdbcUtil;

public class AdminDaoImpl implements AdminDao {

	//管理员登录
	@Override
	public Admin login(String name, String passWord) {
		//获取连接
		Connection con = JdbcUtil.getMysqlConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//预编译sql语句
			ps = con.prepareStatement("select * from admintable");
			rs = ps.executeQuery();
			//将数据封装进admin对象
			Admin admin = new Admin();
			while(rs.next()) {
				if(name.equals(rs.getString(2)) && passWord.equals(rs.getString(3))){
					admin.setAdminId(rs.getInt(1));
					admin.setAdminName(rs.getString(2));
					admin.setAdminPassWord(rs.getString(3));
					return admin;
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//关闭连接
			JdbcUtil.closeMysqlConnection(rs, ps, con);
		}	
		
		return null;
	}

	//管理员注册
	@Override
	public boolean resigter(String name, String passWord) {

		Admin admin = new Admin();
		
		if (JdbcUtil.enableToRegister(admin, name, passWord)) {
			Connection con = JdbcUtil.getMysqlConnection();
			PreparedStatement ps = null;
			
			try {
				//预编译sql语句
				ps = con.prepareStatement("insert into admintable (adminName, adminPassWord) values (?, ?)");
				//将管理员信息添加至数据库
				ps.setObject(1, name);
				ps.setObject(2, passWord);
				ps.executeUpdate();
				
				return true;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JdbcUtil.closeMysqlConnection(ps, con);
			}
		}else {
			return false;
		}
		
		return false;		
		
	}

}
