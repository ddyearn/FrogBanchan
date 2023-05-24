package com.frog.frogbanchan.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter @Setter @ToString
@SuppressWarnings("serial")
public class Team implements Serializable {
	@Id
	private int teamId;
	private String name;
	private String creator;
	private String address;
	
	public Team() {}
	public Team(int teamId, String name, String address, String creator) {
		super();
		this.teamId = teamId;
		this.name = name;
		this.address = address;
		this.creator = creator;
	}

}
