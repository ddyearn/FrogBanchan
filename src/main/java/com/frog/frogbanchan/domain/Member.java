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
public class Member implements Serializable {
	@Id
	private String username;
	private String password;
	private String name;
	private String nickname;
	private String phone;
	private String email;
	private String residentNo;
	private String address;
	
	public Member() {
	}
	public Member(String username, String password, String name, String nickname, String phone, String email, String residentNo, String address) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.phone = phone;
		this.email = email;
		this.residentNo = residentNo;
		this.address = address;
	}
	
	
}
