package com.internetdb.wepapp.Dto;

public class Like {
	private int post_idx;
	private int user_idx;
	
	public int getPost_idx() {
		return post_idx;
	}
	public void setPost_idx(int post_idx) {
		this.post_idx = post_idx;
	}
	public int getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}
	
	public Like(int post_idx, int user_idx) {
		this.post_idx = post_idx;
		this.user_idx = user_idx;
	}
}
