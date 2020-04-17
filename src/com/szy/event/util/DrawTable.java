package com.szy.event.util;

import java.util.List;
import com.szy.event.entity.Race;

public class DrawTable {
	
	private static GetDataTable getTable =  new GetDataTable();
	
	public Object[][] drowRaceTable(){
		List<Race> row = getTable.getRaceTable();
		Object[][] raceTable = new Object[row.size()][5];
		
		for (int i = 0;i < row.size();i++) {
			raceTable[i][0] = row.get(i).getRaceId();
			raceTable[i][1] = row.get(i).getHomeTeam();
			raceTable[i][2] = row.get(i).getVisitingTeam();
			raceTable[i][3] = row.get(i).getDate();
			raceTable[i][4] = row.get(i).getValues();
		}
		
		return raceTable;
		
	}

}
