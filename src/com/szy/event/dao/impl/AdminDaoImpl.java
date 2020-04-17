package com.szy.event.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.szy.event.dao.AdminDao;
import com.szy.event.entity.Admin;
import com.szy.event.util.JdbcUtil;

public class AdminDaoImpl implements AdminDao {

	//����Ա��¼
	@Override
	public Admin login(String name, String passWord) {
		//��ȡ����
		Connection con = JdbcUtil.getMysqlConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//Ԥ����sql���
			ps = con.prepareStatement("select * from admintable");
			rs = ps.executeQuery();
			//�����ݷ�װ��admin����
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
			//�ر�����
			JdbcUtil.closeMysqlConnection(rs, ps, con);
		}	
		
		return null;
	}

	//����Աע��
	@Override
	public boolean resigter(String name, String passWord) {

		Admin admin = new Admin();
		
		if (JdbcUtil.enableToRegister(admin, name, passWord)) {
			Connection con = JdbcUtil.getMysqlConnection();
			PreparedStatement ps = null;
			
			try {
				//Ԥ����sql���
				ps = con.prepareStatement("insert into admintable (adminName, adminPassWord) values (?, ?)");
				//������Ա��Ϣ��������ݿ�
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
