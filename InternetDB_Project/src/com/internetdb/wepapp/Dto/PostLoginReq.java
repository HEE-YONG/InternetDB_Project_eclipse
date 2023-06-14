package com.internetdb.wepapp.Dto;

public class PostLoginReq {
    private String user_email;
    private String user_pw;
    
	public PostLoginReq(String user_email, String user_pw) {
        this.user_email = user_email;
        this.user_pw = user_pw;
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
}
