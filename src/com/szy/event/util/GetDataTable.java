package com.szy.event.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.szy.event.entity.Race;

public class GetDataTable {

	public List<Race> getRaceTable() {
		
		Connection con = JdbcUtil.getMysqlConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Race> row = new ArrayList<Race>();
		
		try {
			ps = con.prepareStatement("select * from racetable");
			rs = ps.executeQuery();
			while(rs.next()) {
				Race race = new Race();
				race.setRaceId(rs.getInt(1));
				race.setHomeTeam(rs.getString(2));
				race.setVisitingTeam(rs.getString(3));
				race.setDate(rs.getString(4));
				race.setValues(rs.getInt(5));
				row.add(race);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.closeMysqlConnection(rs, ps, con);
		}
		
		return row;
		
	}
	
}
