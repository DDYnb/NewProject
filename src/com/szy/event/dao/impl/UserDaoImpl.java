package com.szy.event.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.szy.event.dao.UserDao;
import com.szy.event.entity.User;
import com.szy.event.util.JdbcUtil;

public class UserDaoImpl implements UserDao {

	//用户登录
	@Override
	public User login(String name, String passWord) {
		//获取连接
		Connection con = JdbcUtil.getMysqlConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//预编译sql语句
			ps = con.prepareStatement("select * from usertable");
			rs = ps.executeQuery();
			//将数据封装进user对象
			User user = new User();
			while(rs.next()) {
				if(name.equals(rs.getString(2)) && passWord.equals(rs.getString(3))) {
					user.setUserId(rs.getInt(1));
					user.setUserName(rs.getString(2));
					user.setUserPassWord(rs.getString(3));
					user.setUserMoney(rs.getDouble(4));
					return user;
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

	//用户注册
	@Override
	public boolean resigter(String name, String passWord) {

		User user = new User();
		
		if (JdbcUtil.enableToRegister(user, name, passWord)) {
			Connection con = JdbcUtil.getMysqlConnection();
			PreparedStatement ps = null;
			
			try {
				//预编译sql语句
				ps = con.prepareStatement("insert into usertable (userName, userPassWord, userMoney) values (?, ?, ?)");
				//将用户信息添加至数据库
				ps.setObject(1, name);
				ps.setObject(2, passWord);
				ps.setObject(3, 100);
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
