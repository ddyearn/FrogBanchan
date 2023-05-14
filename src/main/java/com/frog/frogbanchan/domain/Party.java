package com.frog.frogbanchan.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

import java.sql.Timestamp;

@Entity
@Getter @Setter @ToString
@SuppressWarnings("serial")
public class Party implements Serializable {
	@Id
	private int partyId;
	private String creator;
	private Timestamp meetDate;
	private String placeId;
	private String content;
	
	public Party() {}
	public Party(int partyId, String creator, Timestamp meetDate, String placeId, String content) {
		super();
		this.partyId = partyId;
		this.creator = creator;
		this.meetDate = meetDate;
		this.placeId = placeId;
		this.content = content;
	}
}
