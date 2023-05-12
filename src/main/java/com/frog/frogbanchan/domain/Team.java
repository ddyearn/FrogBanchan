package com.frog.frogbanchan.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter @ToString
public class Team {
	@Id
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

}
