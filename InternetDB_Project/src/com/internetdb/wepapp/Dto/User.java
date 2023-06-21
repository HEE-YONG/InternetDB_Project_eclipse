package com.internetdb.wepapp.Dto;
public class User {
	private int user_idx;
	private String user_email;
	private String user_pw;
	private String profile_image;
	private String member_introduce;
	private String user_nickname;
	
	public int getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getProfile_image() {
		return profile_image;
	}
	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}
	public String getMember_introduce() {
		return member_introduce;
	}
	public void setMember_introduce(String member_introduce) {
		this.member_introduce = member_introduce;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
		
	public User(int user_idx, String user_email, String user_pw, String profile_image, String member_introduce, String user_nickname) {
		this.user_idx = user_idx;
		this.user_email = user_email;
		this.user_pw = user_pw;
		this.profile_image = profile_image;
		this.user_nickname = user_nickname;
	}
}
