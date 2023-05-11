package com.frog.frogbanchan.domain;

public class Team {
	private int teamId;
	private String name;
	private String creator;
	private String address;
	
	public Team() {}
	public Team(int teamId, String name, String creator, String address) {
		super();
		this.teamId = teamId;
		this.name = name;
		this.creator = creator;
		this.address = address;
	}
	
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
