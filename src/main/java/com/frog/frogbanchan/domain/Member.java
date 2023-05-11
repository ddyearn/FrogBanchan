package com.frog.frogbanchan.domain;

public class Member {
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
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setnickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getResidentNo() {
		return residentNo;
	}
	public void setResidentNo(String residentNo) {
		this.residentNo = residentNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Member [username=" + username + ", password=" + password + ", name=" + name + ", nickname=" + nickname
				+ ", phone=" + phone + ", email=" + email + ", residentNo=" + residentNo + ", address=" + address + "]";
	}
	
	
}
