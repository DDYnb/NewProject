package com.szy.event.entity;

public class Race {

	private Integer raceId;
	private String homeTeam;
	private String visitingTeam;
	private String date;
	private Integer values;
	
	public Race() {
		super();
	}

	public Race(String homeTeam, String visitingTeam, String date, Integer values) {
		super();
		this.homeTeam = homeTeam;
		this.visitingTeam = visitingTeam;
		this.date = date;
		this.values = values;
	}

	public Integer getRaceId() {
		return raceId;
	}

	public void setRaceId(Integer raceId) {
		this.raceId = raceId;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public String getVisitingTeam() {
		return visitingTeam;
	}

	public void setVisitingTeam(String visitingTeam) {
		this.visitingTeam = visitingTeam;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getValues() {
		return values;
	}

	public void setValues(Integer values) {
		this.values = values;
	}
	
	

}
